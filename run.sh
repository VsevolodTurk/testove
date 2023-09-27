#!/bin/bash


mvn clean package
mvn install

docker build . --file Dockerfile --tag my-demo-app:latest
docker run -d -p 8080:8080 my-demo-app:latest