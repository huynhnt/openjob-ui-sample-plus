# Infrastructure

## Services & Middleware
1. **Openjob Server**
   - Central coordinator for jobs.
   - Connected via `spring.openjob.server.address` (Default locally: `http://localhost:8088`).
2. **Databases / Cache**
   - None explicitly configured in the client samples. Persistence is delegated to the Openjob Server.
3. **Application Protocol**
   - Application exposes port `8888` via embedded Tomcat (`spring-boot-starter-web`) for API webhook interactions and test triggers.

## Configuration Profiles
Configurations are kept simple in `application.properties`:
- `spring.openjob.enable=true`
- `spring.openjob.worker.app-name=openjob`
- `spring.openjob.delay.enable=true`
