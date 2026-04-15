# Domain Model

## Core Focus
This project demonstrates scheduling logic. It lacks traditional database persistence entities (e.g., `@Entity`, `@Table`) because its specific context relies purely on transient scheduled tasks.

## Key Models
1. **Request DTOs:** 
   - `WebhookRequest`: Contains `timestamp`, `sign`, `data` representing third-party webhook payloads.
2. **Response VOs:**
   - `WebhookVO`: Contains `status` and `msg`. Simple wrapper for API responses.
3. **Task Sub-models (Internal):**
   - Typically inner classes inside processors (e.g., `MapChildTaskTest`) to represent shards of a MapReduce job execution. Contains identifiers or minimal payload to be distributed natively by Openjob.

## Interactions
Domain models are serialized mapped back-and-forth by the Openjob framework implicitly. There are no DTO mappers (like MapStruct) used explicitly in the samples.
