
### Tech Challenge - FASE 3
<p align="center">
Sistema desenvolvido como forma de avalição da terceira fase do curso de Pós graduação de Arquitetura de Software. Se trata de um sistema para controle de pedidos para uma lanchonete, a fim de otimizar a eficiência no atendimento aos clientes e gerenciar o estoque de maneira adequada.
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

**Função Lambda para autenticação**

```
curl --request GET \
  --url 'https://985mplkctd.execute-api.us-east-1.amazonaws.com/Prod/auth?password=<password>&username=<cpf>' \
  --header 'User-Agent:: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36'
```

**Cadastro de usuário no Cognito**

[SignIn/SignUp - Cognito](https://lanchonete-app-dev.auth.us-east-1.amazoncognito.com/login?client_id=7kefq0oq2dslf9gdcfomrepp0q&response_type=token&scope=email+openid+phone&redirect_uri=https%3A%2F%2Fwww.example.com%2F "SignIn/SignUp - Cognito")



