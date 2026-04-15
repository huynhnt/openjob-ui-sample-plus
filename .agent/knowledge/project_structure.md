# Project Structure

## Multi-module Architecture
The project contains multiple modules:
1. `openjob-java-samples`: Native Java usage of Openjob worker core components (suitable for legacy or non-Spring environments).
2. `openjob-spring-boot-samples`: Spring Boot wrapped execution context using `openjob-worker-spring-boot-starter`.

## Spring Boot Samples Directories
```text
src/main/java/io/openjob/samples/spring/boot/
├── controller/        # REST APIs (e.g., TestController) for triggering tasks or receiving webhooks
├── delay/             # Specialized processors for Delayed tasks
├── processor/         # Various implementations of Job Processors (MapReduce, Broadcast, Sharding, Standalone)
├── request/           # DTOs for incoming API requests
├── service/           # Internal business logic and interfaces
│   └── impl/          # Service implementations (e.g., DelayServiceImpl)
└── vo/                # View Objects for API responses
```

## Java Samples Directories
```text
src/main/java/io/openjob/samples/java/
├── processor/         # Lightweight processors (Delay, Java, MapReduce) without Spring Annotations
└── service/           # Core Java service layers
    └── impl/ 
```
