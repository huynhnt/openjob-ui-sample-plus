# Anti-patterns Detected

## 1. Hardcoded Secrets
- **Observation:** `TestController.java` contains `String secret = "SyE7w&@!6bcOupy@";` directly hardcoded inside the `webhook()` method.
- **Fix:** Move sensitive webhook secrets and keys to `application.properties`/Environment variables and inject them via `@Value("${openjob.webhook.secret}")`.

## 2. Weak Exception Handling
- **Observation:** Basic try-catch blocks fall back to `throw new RuntimeException(e);` instead of specific business exceptions.
- **Fix:** Introduce global exception handling (`@RestControllerAdvice`) and create standard custom project exceptions (e.g., `OpenjobSampleException`).

## 3. Inconsistent Logging Styles
- **Observation:** Some classes use `private static final Logger logger = LoggerFactory...`, while others use Lombok's `@Slf4j`.
- **Fix:** Standardize completely to `@Slf4j` to maintain cleaner boilerplate class headers.

## 4. Hardcoded Task Constants
- **Observation:** Hardcoded task definitions inside map-reduce classes (e.g., `"TASK_TWO"`).
- **Fix:** Extract these constants to an interface or ENUM class storing job steps collectively.
