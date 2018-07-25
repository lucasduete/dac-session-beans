#!/bin/sh

cd banco
docker build -t dac/banco .
docker run -p 5432:5432 --name banco -d dac/banco

cd ..

mvn clean package
docker build -t dac/core .
docker run -p 8081:8080 -p 3700:3700 --link banco:banco --name core -d dac/core
