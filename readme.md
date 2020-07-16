To build:
docker build --build-arg JAR_FILE="build/libs/*.jar" -t social_network_isalive .

To run: 
docker run -d -p 8080:8080 --name=isAlive social_network_isalive

To Debug: 
$ docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t springio/gs-spring-boot-docker
(limitations on mac)


Docker-Compose
docker-compose build  --build-arg JAR_FILE="build/libs/*.jar"
docker-compose up