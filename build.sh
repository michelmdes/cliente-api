echo "Compilando o projeto, baixando as dependências e executando os testes unitários:" ; echo
mvn clean install -U

echo "Criando imagem docker da api:" ; echo
docker build -t michelmdes/cliente-api:latest .

echo "Enviando para o repositório Docker Hub:" ; echo
docker push michelmdes/cliente-api:latest
