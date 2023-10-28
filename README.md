## Lanchonete-app
### Tech Challenge - FASE 1
- Aplicação para controle de pedidos, produtos e clientes de uma lanchonete.

**Sobre o projeto**
* Spring-boot 3 com Java 17
* Banco de dados MariaDD
* Path: /lanchonete-app
* Porta: 8080

**Requisitos para executar**


- Criação do banco de dados

```
$ docker run --detach --name mariadb-lanchonete-db -p 3306:3306 --env MARIADB_DATABASE=lanchonetedb --env  MARIADB_USER=mariadb --env MARIADB_PASSWORD=root --env MARIADB_ROOT_PASSWORD=root mariadb:latest
```

**Executar**

```
$ mvn clean install
```

```
$ spring-boot:run
```


**Executar utilizando o docker**

- Existem um arquivo docker compose na raiz do projeto com as configurações necessária para executar a aplicação e o banco de dados.

```
$ docker-compose up --build
```

**Swagger**

*[ http://localhost:8080/lanchonete-app/swagger-ui/index.html]( http://localhost:8080/lanchonete-app/swagger-ui/index.html " http://localhost:8080/lanchonete-app/swagger-ui/index.html")


------------



***Banco de dados***

- A base de dados já possui alguns produtos e clientes cadastrados

##### Categorias de Produtos

| Código  |  Nome |
| ------------ | ------------ |
| 1  | Lanche  |
| 2  | Acompanhamento  |
| 3  | Bebida  |
| 4  | Sobremesa  |




##### Status do Produtos

| Código  |  Descrição |
| ------------ | ------------ |
| 1  | Recebido  |
| 2  | Em preparação  |
| 3  | Pronto  |
| 4  | Finalizado  |

##### Clientes

| Código  |  Nome | CPF |
| ------------ | ------------ |  ------------ |
| 1  | Home Simpson  | 12345678901 |
| 2  | Bart Simpson  | 12345678920 |


