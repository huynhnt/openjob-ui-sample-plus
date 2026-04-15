# Architecture

## Classification
- **Type:** Distributed System (Master-Worker pattern)
- **Role:** The project primarily acts as an **Openjob Worker** node, connecting to an external Openjob server for task scheduling and assignment.

## System Patterns
1. **Master-Worker Pattern:** The `openjob` framework manages job definitions in the Server/Master component, while this project handles execution and processing.
2. **Event-driven & Scheduled Jobs:** Jobs can be invoked via fixed delays (`DelayService`), Cron jobs, or specific map-reduce splitting mechanisms over the network.
3. **Map-Reduce Distributed Processing:** The `MapReduceProcessor` instances can split a big task into sub-tasks (mapping) and then aggregate results (reducing) across different worker nodes.
4. **Standalone, Broadcast, Sharding:** Processors support multiple distribution modes.

## Interaction
- Communication with Openjob Server happens over HTTP/RPC (configured via properties like `spring.openjob.server.address`).
