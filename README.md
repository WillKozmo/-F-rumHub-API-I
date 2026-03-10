# 🚀 ForumHub API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de tópicos de um fórum.
O projeto implementa um **CRUD completo** permitindo criar, listar, consultar, atualizar e excluir tópicos através de endpoints HTTP.

A aplicação foi construída seguindo boas práticas de **arquitetura em camadas**, separando responsabilidades entre Controller, Service e Repository.

---

# 🧰 Tecnologias Utilizadas

* ☕ Java 17
* 🌱 Spring Boot
* 🔗 Spring Web
* 🗄 Spring Data JPA
* 💾 H2 Database
* 📦 Maven
* 🔎 Postman / Insomnia (testes da API)

---

# 🏗 Arquitetura da Aplicação

O projeto segue uma arquitetura simples e organizada:

```text
Controller → Service → Repository → Database
```

Estrutura do projeto:

```text
forumhub-api
│
├── src/main/java/com/forumhub
│
├── controller
│   └── TopicoController.java
│
├── service
│   └── TopicoService.java
│
├── repository
│   └── TopicoRepository.java
│
├── model
│   └── Topico.java
│
└── ForumHubApplication.java
```

Essa organização facilita manutenção, testes e escalabilidade do sistema.

---

# ⚙️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/SEU-USUARIO/forumhub-api.git
```

---

## 2️⃣ Entrar na pasta do projeto

```bash
cd forumhub-api
```

---

## 3️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

Ou executar diretamente pela IDE:

* VSCode
* IntelliJ IDEA

A aplicação iniciará em:

```
http://localhost:8080
```

---

# 🗄 Banco de Dados

A aplicação utiliza **H2 Database em memória**, ideal para desenvolvimento e testes.

Acesse o console do banco:

```
http://localhost:8080/h2-console
```

Configuração:

```
JDBC URL: jdbc:h2:mem:forumhub
User: sa
Password: (vazio)
```

---

# 🔗 Endpoints da API

## 📄 Listar todos os tópicos

```
GET /topicos
```

---

## 🔍 Buscar tópico por ID

```
GET /topicos/{id}
```

Exemplo:

```
GET /topicos/1
```

---

## ➕ Criar um novo tópico

```
POST /topicos
```

Exemplo de requisição:

```json
{
 "titulo": "Erro no Spring",
 "mensagem": "
```
