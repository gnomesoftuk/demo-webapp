### Demo webapp

Contains a Spring Boot 2 powered Web service, a RabbitMQ service and a MongoDb service.

#### How to start it

Compile, build and start docker images.

```sh
./mvnw clean install

docker-compose up --build
```

Confirm it worked

```sh
docker-compose ps
```

### How to use it

Send a message to it.

```sh
curl -v -H 'Content-Type: text/plain' --data 'i like kittens' http://localhost:8080/message/1
```

Get your message back.

```sh
curl -i http://localhost:8080/message/1
```

If everything worked you will see your message.