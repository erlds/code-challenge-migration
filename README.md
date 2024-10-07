
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto

Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 17 e Spring Boot 3.2.5.

## Funcionalidades

- **Consulta de Produtos**: Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
- **Integração com `Webclient`**: Utiliza `Webclient` para realizar chamadas HTTP.
- **Validação de Dados**: Validação de dados de entrada usando Bean Validation (`javax.validation`).
- **Gestão de Dependências**: Configurado para utilizar @Autowired.
- **Testes Unitários**: Inclui testes unitários e de integração desenvolvidos com JUnit 5.

## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── WebClientConfig.java
│   │   │       ├── controller
│   │   │       │   └── ProductController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       │   └── ProductList.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │   │   └── application.yaml
        │   └── application-dev.yaml
        │   └── application-prod.yaml
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── config
│       │       │   └── WebClientConfigTest.java
│       │       └── controller
│       │       │   └── ProductControllerTest.java
        │       │   └── SpringActuatorHealthTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
        │       │   └── ProductListTest.java
│       │       └── service
│       │           └── ProductServiceTest.java
│       └── resources
└── pom.xml
```
## Pacotes da aplicação

- **config**: Contém a configuração do objeto Webclient.Builder
- **controller**: Possui os endpoints para acesso da API.
- **DTO**: Contém os objetos que serão usados na resposta da API.
- **service**: Contém regra de negócio do projeto, no caso, a chamada para API DummyJSON;

## Endpoints do projeto

### Verificador de saúde:

**URL** : `/actuator/health`

**Method** : `GET`

**Resposta com sucesso**:
``` json
{
    "status": "UP"
}
```

### Buscar todos os produtos:

**URL** : `/api/products`

**Method** : `GET`

**Resposta com sucesso**:
``` json
[
    {...},
    {
      "id": 1,
      "title": "Essence Mascara Lash Princess",
      "description": "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.",
      "price": 9.99
    },
    {...}
]
```

### Buscar produto pelo id:

**URL** : `/api/products/{id}`

**Method** : `GET`

**Parâmetros de Caminho** :
- *{id}* -> id do produto.

**Resposta com sucesso**:
``` json
{
    "id": 1,
    "title": "Essence Mascara Lash Princess",
    "description": "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.",
    "price": 9.99
}
```

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven 3.8.x**
- **Docker (Opcional)**

### Executar a Aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/erlds/code-challenge-migration.git
    cd code-challenge-migration
    ```

2. Compile e execute o projeto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Acesse o serviço:
   
    O serviço estará disponível em `http://localhost:8080`.

### Executar a Aplicação via Docker
1. O projeto também pode ser executado utilizando container docker, para isso instale o docker e o docker-compose.

2. Compile o projeto

    ```bash
    mvn clean package
    ```
3. Rode o docker-compose
    ```bash
    docker-compose up
    ```
4. O projeto estará disponível em `http://localhost:8080`.

### Executar Testes

Para executar os testes unitários:

```bash
mvn clean test
```