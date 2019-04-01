FROM maven:3.6.0-jdk-8-alpine

COPY ./target/jedis*.jar jedis.jar

CMD java -jar jedis.jar
