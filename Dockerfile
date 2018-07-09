FROM anapsix/alpine-java:8

ADD entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ADD target/demo-webapp.jar /app.jar
RUN chmod +x app.jar

EXPOSE 8080

CMD ["/entrypoint.sh"]