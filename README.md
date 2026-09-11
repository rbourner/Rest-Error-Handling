# BAMOE 9 REST error handling example

This example showcases a business process calling a REST services with error handling.

Usage:
- $ mvn clean compile spring-boot:run

To start a process instance, user either:
- SpringBoot Swagger UI: http://localhost:8080/swagger-ui/index.html#
- curl -X POST http://localhost:8080/main_process -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{ "strategy": "RETRY", "key": "2" }'
- The Management Console (deployed separately)

To complete the Repair user task:
- first retrieve the task instanceID:
  either in the management console or using the following
  $ curl -X 'GET' 'http://localhost:8080/usertasks/instance?user=jdoe' -H 'accept: application/json'
- then complete this task instance