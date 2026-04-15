# Coding Standards

## 1. Class & Method Design
- Spring components are explicitly named if needed (e.g., `@Component("mapReduceTestProcessor")`).
- Methods use lowerCamelCase formatting.
- `logger` declarations are configured manually where `@Slf4j` is not utilized: `private static final Logger logger = LoggerFactory.getLogger("openjob");`

## 2. API Responses
- Non-standardized responses: Functions return `String` directly or simple view objects (`WebhookVO`).
- Real-world production apps should consider a unified global response wrapper (`Result<T>`).

## 3. Worker Processors
- Implementing classes (like `MapReduceProcessor`) usually have structured conditions targeting different steps via `context.isRoot()`, `context.isTask(NAME)`, etc.
- Results are pushed back to the Openjob framework using `ProcessResult.success()` or custom instantiated `ProcessResult` instances.

## 4. Exceptional Logic
- Error tracking mostly logged linearly using `logger.error()`. Uses `throw new RuntimeException(e);` for unchecked failure propagation.

## 5. Request Handling
- Mapping annotations like `@GetMapping` and `@PostMapping` are used appropriately. `WebhookRequest` utilizes `@RequestBody`.
