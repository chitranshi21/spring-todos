# spring-todos

We have a contract in resource/todos.yaml

## Run MongoDB 
cd dev folder - `docker compose -f mongo-db-docker-compose.yaml up`

## Run Keyclock
`docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8080:8080 jboss/keycloak`
import the `realm-export.json` file in the keyclock and create a user with todos_roles
admin
Reading - https://auth0.com/blog/spring-boot-authorization-tutorial-secure-an-api-java/
