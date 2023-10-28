# Use a imagem oficial do MariaDB como ponto de partida
FROM mariadb:latest

# Defina as variáveis de ambiente para configurar o MariaDB
ENV MARIADB_ROOT_PASSWORD=root
ENV MARIADB_DATABASE=lanchonetedb
ENV MARIADB_USER=mariadb
ENV MARIADB_PASSWORD=root

# Exponha a porta padrão do MariaDB (3306)
EXPOSE 3306

# docker build -t mariadb-lanchonete .
# docker run -d --name mariadb-lanchonete-db -p 3306:3306 mariadb-lanchonete