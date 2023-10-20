# Use a imagem oficial do MariaDB como ponto de partida
FROM mariadb:latest

# Defina as variáveis de ambiente para configurar o MariaDB
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=lanchonetedb
ENV MYSQL_USER=mariadb
ENV MYSQL_PASSWORD=root

# Exponha a porta padrão do MariaDB (3306)
EXPOSE 3306

# Crie um diretório para armazenar dados do MariaDB
#RUN mkdir -p /var/lib/mysql

# Defina o diretório como um volume para persistir os dados
#VOLUME /var/lib/mysql

# Copie quaisquer scripts SQL de inicialização para a pasta /docker-entrypoint-initdb.d/
# Eles serão executados automaticamente quando o contêiner for iniciado
# COPY ./scripts/ /docker-entrypoint-initdb.d/

# docker build -t mariadb_lanchonete .
# docker run -d --name lanchonete_db -p 3306:3306  mariadb_lanchonete