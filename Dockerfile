FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD=gabreil123
COPY ./database_cats.sql /docker-entrypoint-initdb.d/