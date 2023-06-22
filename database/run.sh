#!/usr/bin/env sh

docker stop company_db
docker rm company_db

docker build -t companydb .
docker run -d --name company_db -p 3306:3306 companydb
