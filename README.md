
# Quarkus Project - Dashboard Items
This Quarkus-based application consist of Rest-API (Cars Package), SOAP-API(Fruits Package)
and an authentication API. This project connects to a PostgreSQL database.
The database connection details can be configured using environment variables.

## Prerequisites
- Java 21 or higher: Ensure you have JDK 21 or higher installed.
- Gradle latest: This project uses Maven for building.
- Docker: If you want to run the application in a Docker container.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

To start your application, run this command in terminal:

```shell/terminal script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/dashboard-items-1.0.0-SNAPSHOT-runner`


## Environment Variables
- DB_USERNAME: The username for the PostgreSQL database. Default is `postgres_user`.
- DB_PASSWORD: The password for the PostgreSQL database. Default is `somesecurepassword`.
- DB_KIND: The type of database. For PostgreSQL, this should be postgresql. Default is `postgresql`.
- JDBC_URL: The JDBC URL for connecting to the PostgreSQL database. Default is `jdbc:postgresql://localhost:5432/test_db`.


## RUN APPLICATION IN DOCKER

build the application with this command in terminal
```shell script
./gradlew build 
```
Build the Docker Image
```shell script
Docker build -f <your-build-java-file> -t <docker_container_name> . 
```

## Docker-Compose File
In your docker-compose file, change the environment variables of postgres and dashboard_container service
to your specified database username, password, and database_name.
run docker-compose file
```shell script
docker-compose up -d 
```

## Provided Code
    To first request resources from fruits and cars, User must create and account
    To Create An Account
    URL - "http://localhost:8080/secured/sign-up"
    path - "/sign-up", "/sign-in",
    Content-Type: APPLICATION/JSON
    attributes: email,username, password

    To access resource, get access token when logged In.
    path - "/cars", "/soap/fruits"


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
