# 📚 Library API

API para gerenciamento de livros, autores e empréstimos.

## Integrantes da equipe

- Giovanna Vasques Alexandre - RM 99884
- Rick Alves Domingues - RM 552438
- Wemilli Nataly Lima de Oliveira - RM 552301


## Como executar a aplicação
### 1️⃣ Executando via Docker Hub

- Primeiro vamos subir o container do banco de dados MySQL:
```
	docker run -d \
	--name mysql \
	--rm \
	-e MYSQL_ROOT_PASSWORD=root_pwd \
	-e MYSQL_USER=new_user \
	-e MYSQL_PASSWORD=my_pwd \
	-p 3306:3306 \
	mysql
```

- Então vamos subir o container da Api:
```
	docker run -d \
	--name api \
	--rm \
	--link mysql:mysql \
	-p 8080:8080 \
	-e DB_SERVER=mysql \
	-e DB_PORT=3306 \
	-e DB_DATABASE=api \
	-e DB_USER=root \
	-e DB_PASSWORD=root_pwd \
	givasques1101/checkpoint1-microservices:0.0.1
```

A aplicação ficará disponível em:
👉 http://localhost:8080

### 2️⃣ Executando via Docker Compose

- Rodando localmente com docker-compose:

```
	docker compose up 
```
*OBS: O código para executar o docker compose não necessitou do --build pois temos imagens do dockerhub sendo utilizadas em todos os serviços.*

- Para rodar os serviços separadamente:

```
	docker compose up db
	docker compose up api
```

A aplicação ficará disponível em:
👉 http://localhost:8080

3️⃣ Acesso ao Swagger

A documentação interativa da API estará disponível em:

👉 http://localhost:8080/ ou http://localhost:8080/swagger-ui/index.html