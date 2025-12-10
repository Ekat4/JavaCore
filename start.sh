#!/bin/bash
# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

docker build -t spring-boot-app-example:0.1 .
mvn spring-boot:build-image

# Add environment variables

# Start new deployment
docker-compose up --build -d
