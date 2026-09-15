# BAMOE 9 REST error handling example

This example showcases several business processes calling a REST services with error handling.

## Sample 1 - error-handling.bpmn

### Usage

- `$ mvn clean compile spring-boot:run`

### To start a process instance, user either

- SpringBoot Swagger UI: http://localhost:8080/swagger-ui/index.html#
- `$ curl -X POST http://localhost:8080/main_process -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{ "strategy": "RETRY", "key": "2" }'`
- The Management Console (deployed separately)

### To complete the Repair user task

- first retrieve the task instanceID:
  either in the management console or using the following
  `$ curl -X 'GET' 'http://localhost:8080/usertasks/instance?user=jdoe' -H 'accept: application/json'`
- then complete this task instance


## Sample 2 - error-handling2.bpmn

It is not using the BAMOE specific exception to spawn a sub-process instance to handle error, but instead catches the exception directly in the process.

### Build and start
`$ mvn clean compile spring-boot:run`

### Start a process instance
`$ curl -X POST http://localhost:8080/main_process2 -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{ "maxTries": "2", "key": "1" }'`

### Complete the human task
Either using the Task service REST API, or using the management console.

Unless the REST service is fixed, it will be retried as many times as defined in the input data.