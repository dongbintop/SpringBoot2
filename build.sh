#!/bin/bash

mvn clean package -Dmaven.test.skip=true

docker build -t bindong.top/db-test/springboot2:master .
docker push bindong.top/db-test/springboot2:master