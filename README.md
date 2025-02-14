# API REST para Gerenciamento de Clientes

Este projeto é uma API REST desenvolvida em Java utilizando Spring Boot. O objetivo principal é fornecer um serviço simples e intuitivo para gerenciar clientes por meio de operações CRUD (Criar, Ler, Atualizar e Deletar).

## 🛠 Tecnologias Utilizadas

- **Java 21**  
- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA**  
- **PostgreSQL Driver**  

## 🚀 Funcionalidades da API

A API disponibiliza os seguintes endpoints para a manipulação dos dados de clientes:

### 1️⃣ Criar Cliente (Create)

- **Endpoint:** `POST /clientes`  
- **Descrição:** Insere um novo cliente.  
- **Requisito:** O cliente deve ser enviado no corpo da requisição em formato JSON, sem a necessidade de informar o ID.  

📌 **Exemplo de Requisição:**  
```json
{
  "nome": "João da Silva",
  "email": "joao.silva@example.com"
}
```

---

### 2️⃣ Consultar Cliente por ID (Read)

- **Endpoint:** `GET /clientes/{id}`  
- **Descrição:** Retorna os detalhes de um cliente específico, onde `{id}` é o identificador do cliente.  

📌 **Exemplo de Requisição:**  
```
GET http://localhost:8080/clientes/1
```

---

### 3️⃣ Listar Todos os Clientes (Read)

- **Endpoint:** `GET /clientes`  
- **Descrição:** Retorna uma lista com todos os clientes cadastrados.  

📌 **Exemplo de Requisição:**  
```
GET http://localhost:8080/clientes
```

---

### 4️⃣ Atualizar Cliente (Update)

- **Endpoint:** `PUT /clientes/{id}`  
- **Descrição:** Atualiza as informações de um cliente existente.  
- **Requisito:** O ID do cliente deve ser informado na URL. O corpo da requisição deve conter apenas os atributos `nome` e `email`.  

📌 **Exemplo de Requisição:**  
```json
{
  "nome": "João da Silva Atualizado",
  "email": "joao.atualizado@example.com"
}
```

📌 **Requisição:**  
```
PUT http://localhost:8080/clientes/1
```

---

### 5️⃣ Deletar Cliente (Delete)

- **Endpoint:** `DELETE /clientes/{id}`  
- **Descrição:** Remove o cliente identificado pelo ID.  

📌 **Exemplo de Requisição:**  
```
DELETE http://localhost:8080/clientes/1
```

---

## 🐄 Configuração do Banco de Dados

Este projeto utiliza o PostgreSQL como banco de dados. Atenção:
A aplicação **não** cria a base de dados automaticamente. Portanto, é necessário:

1. Criar uma base de dados PostgreSQL manualmente.
2. Configurar as credenciais de conexão no arquivo `application.properties` ou `application.yml`.

📌 **Exemplo de configuração (`application.properties`)**:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ Como Executar o Projeto

1️⃣ Clone o repositório:
```
git clone https://github.com/gaius007/crud-clientes.git
```

2️⃣ Navegue até o diretório do projeto:
```
cd crud-clientes
```

3️⃣ Configure o arquivo de propriedades (`application.properties` ou `application.yml`) com as credenciais do seu banco de dados.

4️⃣ Compile e execute a aplicação:
```
./mvnw spring-boot:run
```
Ou, caso o Maven esteja instalado globalmente:
```
mvn spring-boot:run
```

A API estará disponível em:
```
http://localhost:8080
```

---

## 🐳 Executando com Docker

1. Certifique-se de que o Docker e o Docker Compose estejam instalados em sua máquina.
2. Construa a imagem da API:
```
docker build -t api .
```
3. Suba os containers utilizando o Docker Compose:
```
docker-compose up -d
```

A API estará disponível em: `http://localhost:8080`

---

## 🔎 Testando os Endpoints

Você pode testar os endpoints utilizando ferramentas como Postman ou cURL.

📌 **Exemplo com cURL para inserir um cliente:**
```
curl -X POST http://localhost:8080/clientes \
     -H "Content-Type: application/json" \
     -d '{
           "nome": "João da Silva",
           "email": "joao.silva@example.com"
         }'
```
