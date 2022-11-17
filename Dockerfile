FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/classplus

# ADD .jar under target from host
# into this image
ADD target/classplus-store-docker.jar 			classplus-store-docker.jar
ADD target/classplus-store-docker-tests.jar 	classplus-store-docker-tests.jar
ADD target/libs							libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD TestNG.xml				TestNG.xml
ADD TestNG_Prod.xml					TestNG_Prod.xml

# ADD health check script
RUN wget https://s3.amazonaws.com/b2b-classplus-store-docker/healthcheck/healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
