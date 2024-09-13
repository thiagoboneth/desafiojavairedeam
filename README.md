# Desafio back-end irede Amazônia

[DOCKER HUB PROJECT](https://hub.docker.com/repositories/thiagoboneth)

### Projeto de gerenciamento de produtos
#### Java, Mysql8, Docker


#### Após clone projeto, verificar se as variaveis de ambiente de application.yml estão configuradas corretamente
```
spring:

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/teste_db
    username: root
    password: teste1234
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### Configuração Docker-img

#### Caso queira gerar imagem para subir aplicação, basta executar o seguinte comando

<u>mvn package</u>

#### Caso não funcione, você pode seguir em maven>demo>lifecycle>package para gerar os jars da aplicação

#### Com os jars gerados, executar o seguinte comando para gerar a imagem docker

<u>docker build -t aplicacao-spring .</u>

#### Usando o comando " docker images" para ver as imagens geradas
#### Então use o comando " docker run -p 8080:8080 id-imagem" para subir o container com a imagem gerada

### Configuração Docker-compose

#### Para rodar o projeto em compose, basta executar o seguinte comando

<u>docker-compose -f mysql-docker-compose.yml up -d</u>

#### Observação, verifique se você entra na pasta docker no terminal para rodar o arquivo


### Import to Postman

````declarative
{
	"info": {
		"_postman_id": "ea6b24af-f3bd-4297-ae6e-37f22ec84e76",
		"name": "TesteJavaIredeAmazonia",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "17577533"
	},
	"item": [
		{
			"name": "Categoria end-point",
			"item": [
				{
					"name": "Cria Categoria",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\":\"frios\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/categorias",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"categorias"
							]
						}
					},
					"response": []
				},
				{
					"name": "Consulta Categoria",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/categorias",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"categorias"
							]
						}
					},
					"response": []
				},
				{
					"name": "Consulta Categoria ID",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8080/api/categorias/4",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"categorias",
								"4"
							]
						}
					},
					"response": []
				},
				{
					"name": "Atualiza Categoria",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "    {\r\n        \"nome\": \"limpeza\"\r\n    }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/categorias/2",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"categorias",
								"2"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Categoria",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "localhost:8080/api/categorias/1",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"categorias",
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Produtos end-point",
			"item": [
				{
					"name": "Cria Produto",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"nome\": \"Sabonete Líquido\",\r\n  \"descricao\": \"Sabonete líquido para as mãos com fragrância suave.\",\r\n  \"preco\": 12.99,\r\n  \"dataValidade\": \"2025-12-31\",\r\n  \"imagem\": \"sabonete.jpg\",\r\n  \"categoria\": {\r\n    \"id\": 2,\r\n    \"nome\": \"Limpeza\"\r\n  }\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/produtos",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos"
							]
						}
					},
					"response": []
				},
				{
					"name": "Consulta Produtos",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/produtos",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos"
							]
						}
					},
					"response": []
				},
				{
					"name": "Consulta Produtos nome/descricao",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/produtos/buscar?nome=Sabonete%20Líquido&descricao=Sabonete%20líquido%20para%20as%20mãos%20com%20fragrância%20suave.",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos",
								"buscar"
							],
							"query": [
								{
									"key": "nome",
									"value": "Sabonete%20Líquido"
								},
								{
									"key": "descricao",
									"value": "Sabonete%20líquido%20para%20as%20mãos%20com%20fragrância%20suave."
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "Consulta Produtos ID",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8080/api/produtos/1",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "Atualiza Produto",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n  \"nome\": \"Sabonete Líquido Importado\",\r\n  \"descricao\": \"Sabonete líquido para as mãos com fragrância suave.\",\r\n  \"preco\": 12.99,\r\n  \"dataValidade\": \"2025-12-31\",\r\n  \"imagem\": \"sabonete.jpg\",\r\n  \"categoria\": {\r\n    \"id\": 2,\r\n    \"nome\": \"Limpeza\"\r\n  }\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/api/produtos/1",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Produto",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "localhost:8080/api/produtos/1",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"produtos",
								"1"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}
````
