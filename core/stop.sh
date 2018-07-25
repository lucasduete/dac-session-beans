#!/bin/sh

docker kill banco
docker stop banco
docker rm banco


docker kill core
docker stop core
docker rm core

docker rmi dac/banco
docker rmi dac/core
