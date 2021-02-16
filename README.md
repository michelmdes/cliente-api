# API REST Cliente

API REST Cliente com Endereço

## Tecnologias
 - SpringBoot 2.4.2
 - Banco de dados Postgres
 - Swagger 2.9.2
 - Testes unitários com JUnit, Mockito e Powermock
 
## Estrutura de dados
![](/src/main/resources/DER-cliente-api.png)

(DER gerado por app.dbdesigner.net) 

Script de criação: [script_create_database.sql](https://github.com/michelmdes/cliente-api/blob/master/src/main/resources/docker-postgres/script_create_database.sql)

Foi criado uma imagem docker da base de dados com a estrutura do banco, bem como uma carga inicial das tabelas auxiliares (gênero, cidade e estado).

Imagem docker da base de dados no Docker Hub: `michelmdes/cliente-api-db-pgsql`

Para alteração da estrutura da base dentro da imagem docker, executar o script [build-db.sh](https://github.com/michelmdes/cliente-api/blob/master/src/main/resources/docker-postgres/build-db.sh).

## Iniciar aplicação

Na raiz do projeto, rodar o comando: 
`docker-compose up`

O Docker Compose (orquestrador de container) irá baixar as imagens (api e banco) e iniciá-las automaticamente.

Essa aplicação também está hospedada no Heroku, através do link: Link Heroku: https://cliente-ws-api.herokuapp.com/swagger-ui.html

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

Link Heroku: https://cliente-ws-api.herokuapp.com/swagger-ui.html#/cliente-resource

![](/src/main/resources/Documentacao_swagger.png)

Arquivo postman (v 2.1) com testes para todos os endpoints da API: [cliente-api.postman_collection.json](https://github.com/michelmdes/cliente-api/blob/master/src/main/resources/cliente-api.postman_collection_prod.json)

Arquivo postman (v 2.1) com testes para todos os endpoints da API (localhost): [cliente-api.postman_collection.json](https://github.com/michelmdes/cliente-api/blob/master/src/main/resources/cliente-api.postman_collection_localhost.json)

## Processo criativo
 - Gerando aplicação Spring Boot com o spring initializr
 - Definindo os domínios da api (Cliente, Genero, Endereço, Cidade e Estado)
 - Criando imagem docker do banco postgres, para ser usado pela aplicação
 - Definindo o DER, criando a estrutura do banco de dados (Ver tópico **Estrutura de dados**)
 - Mapeando as entidades JPA
 - Criando os Repositories
 - Criando uma camada genérica Services, que aproveita todos os métodos padrões da JpaReposytory, facilitando a criação dos endpoints. (Repare a simplicidade de implementação e abstração dos recursos de Gênero e Estado, por exemplo)
 - Criando os Resouces
 - Configurando o Swagger, plugin que gera documentação da API automaticamente
 - Testando os endpoints da API (via Swagger e via Postman, ambos disponíveis no tópico acima **Documentação**)
 - Criando testes unitários (utilizando mokito e PowerMock, esse para testar um método privado via reflexão)
 - Criando imagem docker para a aplicação
 - Criando scripts para gerar e atualizar a imagem docker da aplicação (Ver tópico **Deploy**)
 - Criando scripts para gerar e atualizar a imagem docker da base de dados (Ver tópico **Estrutura de dados**)
 - Criando docker-compose para orquestrar os containers e iniciá-los simultaneamente
 - Criando documentação explicativa
 - Hospedando aplicação e banco na nuvem (Heroku)

## Autor
Michel Mendes

E-mail: michelmdes@gmail.com

Linkedin: https://www.linkedin.com/in/michel-mendes-893a62a6/