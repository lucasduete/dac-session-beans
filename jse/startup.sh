#!/bin/sh
mvn clean package
docker build -t dac/jse .
docker run --link core:core -it dac/jse
