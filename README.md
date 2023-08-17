
# poc_spring_kafka

## Description
POC made in Java to learn how to setup a project using [Kafka](https://kafka.apache.org/), [Zookeeper](https://zookeeper.apache.org/) and [Spring](https://spring.io/).

In this project, there are two endpoints, but they are very similar.

One of the endpoints have the purpose to send string in Kafka messages by making the following GET Request:

```shell
localhost:8080/kafka/producer
```
Where in the body a String is sent.

The other endpoint, as I said before, it's very similar. It as the purpose of send classes in Json in Kafka messages.
You can using it by making the following POST request:

```shell
localhost:8080/kafka/producer/user
```

I'll leave an example of the body the user should use:
```json
{
    "name":"John Smith",
    "dateOfBirth":"2000-01-01T10:30:00.000Z",
    "email":"john_smith@mail.com",
    "phoneNumber":911111111
}
```

The way the messages are consumed by the Kafka Consumer is the same for both since it receives just a string and depending
if it can to serialize it to a structure of type **UserDTO**, it will say that received a User, otherwise it will say that
received a simple message.

## How to run it:

In order to run it you can make:
```shell
docker compose up
```
