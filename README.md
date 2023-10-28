### Tech Challenge - FASE 1
<p align="center">
Sistema desenvolvido como forma de avalição da primeira fase do curso de Pós graduação de Arquitetura de Software. Se trata de controle de pedidos para uma lanchonete, a fim de otimizar a eficiência no atendimento aos clientes e gerenciar o estoque de maneira adequada
</p>



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


