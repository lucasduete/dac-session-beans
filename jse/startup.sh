#!/bin/sh
mvn clean package
docker build -t dac/jse .
docker run --link core:core --name jse -it dac/jse
