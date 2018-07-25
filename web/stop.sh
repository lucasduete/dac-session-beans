#!/bin/sh

docker kill web
docker stop web
docker rm web

docker rmi dac/web

