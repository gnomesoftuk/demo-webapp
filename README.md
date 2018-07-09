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

Send a request to it.

```sh
curl -v -H 'Content-Type: text/plain' --data 'i like kittens' http://localhost:8080/message/1
```

### How to check the database

First install mongoDB shell, then:

```sh
mongo

> db.message.find();
```

If everything worked you will see your message.