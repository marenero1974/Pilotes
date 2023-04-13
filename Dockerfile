FROM openjdk:17-alpine
EXPOSE 8080
RUN mkdir -p /application/
COPY target/pilotes-management-1.0.0-SNAPSHOT.jar /application/
ENTRYPOINT ["java"]
CMD [ "-jar", \
    "/application/pilotes-management-1.0.0-SNAPSHOT.jar" \
]