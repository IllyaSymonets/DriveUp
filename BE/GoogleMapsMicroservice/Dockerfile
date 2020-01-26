FROM openjdk:8
ADD /target/trip-service.jar trip-service.jar
EXPOSE 8082
## Add the wait script to the image
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
RUN chmod +x /wait

## Launch the wait tool and then your application
CMD /wait && /target/trip-service.jar

ENTRYPOINT ["java", "-jar", "trip-service.jar"]