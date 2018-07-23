#!/bin/sh

mvn clean package

docker build -t dac/web .
docker run -p 8080:8080 --name web --link core:core -d dac/web
