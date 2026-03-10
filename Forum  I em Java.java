package com.forumhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class ForumHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumHubApplication.class, args);
    }

}

/* ================================
   ENTITY
================================ */

@Entity
class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String status;
    private String autor;
    private String curso;

    public Topico(){}

    public Long getId() { return id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensagem() { return mensagem; }

    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getCurso() { return curso; }

    public void setCurso(String curso) { this.curso = curso; }

}

/* ================================
   REPOSITORY
================================ */

interface TopicoRepository extends JpaRepository<Topico, Long> {}

/* ================================
   SERVICE
================================ */

@Service
class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public List<Topico> listar() {
        return repository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Topico salvar(Topico topico) {
        return repository.save(topico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}

/* ================================
   CONTROLLER
================================ */

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @Autowired
    private TopicoService service;

    // LISTAR TODOS
    @GetMapping
    public List<Topico> listar() {
        return service.listar();
    }

    // DETALHAR
    @GetMapping("/{id}")
    public Optional<Topico> detalhar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // CRIAR
    @PostMapping
    public Topico criar(@RequestBody Topico topico) {
        return service.salvar(topico);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody Topico dados) {

        Optional<Topico> topico = service.buscarPorId(id);

        if (topico.isPresent()) {

            Topico t = topico.get();

            t.setTitulo(dados.getTitulo());
            t.setMensagem(dados.getMensagem());
            t.setAutor(dados.getAutor());
            t.setCurso(dados.getCurso());
            t.setStatus(dados.getStatus());

            return service.salvar(t);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}