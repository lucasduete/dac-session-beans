#!/bin/sh

docker kill jse
docker stop jse
docker rm jse

docker rmi dac/jse
