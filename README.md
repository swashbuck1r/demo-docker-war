# Sample App using Java SpringBoot
Check out the [Tutuorial](https://guide-rails.calculi.io/help/tutorials/java/java.html)

=======
## SpringBoot Server

Sample SpringBoot API Server

## Requirements
* Gradle 5
* OpenJDK 12

## Running the Application

```sh
gradle bootRun
```

## Partial List of Endpoints

See the controller for the full list

```sh
curl -v http://localhost:8080/
curl -v http://localhost:8080/add/3/2
```

## Running Tests

```sh
gradle build
gradle integrationTest
```
