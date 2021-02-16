# MVP Cliente - API REST

API REST Cliente

## Tecnologias
 - SpringBoot 2.4.2
 - Banco de dados Postgres
 - Swagger 2.9.2
 - Testes unitários com JUnit, Mockito e Powermock
 
## Estrutura
![](/src/main/resources/DER-cliente-api.png)

Script de criação: resources/postgres/script_create_database.sql

Foi criado uma imagem docker da base de dados com a estrutura do banco, bem como uma carga inicial de gênero, cidade e estado.

Imagem: michelmdes/cliente-api-db-pgsql

Para alteração da estrutura, executar o script build-db.sh para atualizar a imagem docker do banco.

## Iniciar aplicação

Na raiz do projeto, rodar o comando: 
`docker-compose up`

O Docker Compose (orquestrador de container) irá baixar as imagens e iniciá-las automaticamente.

## Deploy

Na raiz do projeto, rodar o comando:
`build.sh`

Esse comando irá criar uma nova imagem docker da api e atualizar no repositório Docker Hub.

## Documentação
A documentação dos endpoints é gerada automaticamente através do Swagger, com as seguintes vantagens:
 - Interface amigável e interativa;
 - Documentação sempre atualizada, pois é gerada automaticamente;
 - É possível testar os serviços, mostrando parametros e padrões de objetos requeridos
 
Link: [ApplicationPath]/swagger-ui.html

Link Heroku: https://bp-cliente.herokuapp.com/swagger-ui.html#/cliente-resource

![](/src/main/resources/Documentacao_swagger.png)

Arquivo postman com testes para todos os endpoints da API (v 2.1):  

## Processo criativo
 - Gerando aplicação com o spring initializr
 - Definindo o DER, criando a estrutura do banco de dados
 - Criando imagem docker do banco postgres, para ser usado pela aplicação
 - Criando as entidades JPA
 - Criando os Repositories
 - Criando uma camada genérica Services, que aproveita todos os métodos padrões da JpaReposytory, facilitando a criação dos endpoints
 - Criando os Resouces
 - Configurando o Swagger, plugin que gera documentação da API automaticamente
 - Testando os endpoints da API
 - Criando testes unitários
 - Criando imagem docker para a aplicação
 - Criando scripts para gerar e atualizar as imagens docker
 - Criando docker-compose para orquestrar os containers e iniciá-los simultaneamente
 - Criando documentação explicativa
 - Hospedando aplicação e banco na nuvem  

## Autor
Michel Mendes

E-mail: michelmdes@gmail.com

Linkedin: https://www.linkedin.com/in/michel-mendes-893a62a6/