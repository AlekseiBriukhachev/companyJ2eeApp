FROM mysql:latest
LABEL authors="abriukhachev"

ENV MYSQL_ROOT_PASSWORD=ROOT
ENV MYSQL_DATABASE=companydb
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=mypass

COPY init.sql /docker-entrypoint-initdb.d/
