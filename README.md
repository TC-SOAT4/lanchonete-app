
### Tech Challenge - FASE 3
<p align="center">
Sistema desenvolvido como forma de avalição da segunda fase do curso de Pós graduação de Arquitetura de Software. Se trata de um sistema para controle de pedidos para uma lanchonete, a fim de otimizar a eficiência no atendimento aos clientes e gerenciar o estoque de maneira adequada.
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

##### Status do Pagamento

| Código  |  Descrição |
| ------------ | ------------ |
| 1  | Aguardando  |
| 2  | Aprovado  |
| 3  | Não Aprovado  |
| 4  | Cancelado  |

##### Clientes

| Código  |  Nome | CPF |
| ------------ | ------------ |  ------------ |
| 1  | Home Simpson  | 12345678901 |
| 2  | Bart Simpson  | 12345678920 |

##### Produtos

| Código  |  Descrição | Categoria |
| ------------ | ------------ | ------------ |
| 1  | Cheddar McMelt  |  Lanche  |
| 2  | McChicken  |  Lanche  |
| 3  | Big Mac  |  Lanche  |
| 4  | Batata Frita Pequena  | Acompanhamento  |
| 5  | Batata Frita Grande  | Acompanhamento  |
| 6  | Chicken McNuggets  | Acompanhamento  |
| 7  | Refrigerante pequeno  | Bebida  |
| 8  | Refrigerante Grande  | Bebida  |
| 9  | Garrafa Água 200ml  | Bebida  |
| 10  | Torta de Maçã  | Sobremesa  |
| 11 | Casquinha Mista  | Sobremesa  |

------------

**Kubernetes**

- Os arquivos de manifesto(.ymal) se encontra na raiz do projeto na pasta k8s.
	- A ordem de execução dos manifestos de preferência deve ser seguida.
```
k8s
```
- Para a aplicação serão criados:
	-	1 Configmap 
	-	1 Deployment com 2 replicas 
	- 	1 Service
	-	1 ServiceAccount
	- 	HorizontalPodAutoscaler

------------


 ![*App com database](/assets/app_database_without_volume.png)

