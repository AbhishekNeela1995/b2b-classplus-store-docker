FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/classplus/store

# ADD .jar under target from host
# into this image
ADD target/classplus-store-docker.jar 			classplus-store-docker.jar
ADD target/classplus-store-docker-tests.jar 	classplus-store-docker-tests.jar
ADD target/libs							libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well
#ADD src/main/resources/lang/en/expectedassertions_en         src/main/resources/lang/en/expectedassertions_en
#ADD src/main/resources/lang/en/testdata_en         src/main/resources/lang/en/testdata_en
#ADD src/main/resources/lang/en/xpaths_en         src/main/resources/lang/en/xpaths_en
#ADD src/main/resources/lang/fr/expectedassertions_fr         src/main/resources/lang/fr/expectedassertions_fr
#ADD src/main/resources/lang/fr/testdata_fr         src/main/resources/lang/fr/testdata_fr
#ADD src/main/resources/lang/fr/xpaths_fr         src/main/resources/lang/fr/xpaths_fr
COPY src/main/resources         src/main/resources
ADD extension_2_3_164.crx    extension_2_3_164.crx

# ADD suite files
ADD TestNG.xml				TestNG.xml
ADD TestNG_Prod.xml					TestNG_Prod.xml

# ADD health check script
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
