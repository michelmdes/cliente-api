echo "Criando imagem docker da do banco de dados com a carga do script: script_create_database.sql" ; echo
docker build -t cliente-api-db-pgsql:latest .

echo "Enviando para o repositório Docker Hub:" ; echo
docker push michelmdes/cliente-api-db-pgsql:latest
