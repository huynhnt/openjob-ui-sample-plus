# Code Templates

## 1. Spring Boot Openjob Processor
```java
package io.openjob.samples.spring.boot.processor;

import io.openjob.worker.context.JobContext;
import io.openjob.worker.processor.JavaProcessor;
import io.openjob.worker.processor.ProcessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("customJavaProcessor")
public class CustomJavaProcessor implements JavaProcessor {

    @Override
    public ProcessResult process(JobContext context) throws Exception {
        log.info("Processing job: {}", context.getJobId());
        // Add business implementation here
        
        return ProcessResult.success();
    }
}
```

## 2. Map-Reduce Openjob Processor
```java
package io.openjob.samples.spring.boot.processor;

import io.openjob.worker.context.JobContext;
import io.openjob.worker.processor.MapReduceProcessor;
import io.openjob.worker.processor.ProcessResult;
import io.openjob.worker.processor.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("customMapReduceProcessor")
public class CustomMapReduceProcessor implements MapReduceProcessor {

    private static final String STEP_MAP = "STEP_MAP";

    @Override
    public ProcessResult process(JobContext context) throws Exception {
        if (context.isRoot()) {
            List<Object> tasks = generateTasks(); // Replace with actual task division
            return this.map(tasks, STEP_MAP);
        }

        if (context.isTask(STEP_MAP)) {
            Object task = context.getTask();
            // Process task...
            return new ProcessResult(true, "Result Of This Map");
        }

        return ProcessResult.success();
    }

    @Override
    public ProcessResult reduce(JobContext context) throws Exception {
        List<String> results = context.getTaskResultList().stream()
                .map(TaskResult::getResult)
                .collect(Collectors.toList());
        log.info("Reduced results: {}", results);
        return ProcessResult.success();
    }
}
```

## 3. Delay Task Dispatch Service
```java
package io.openjob.samples.spring.boot.service.impl;

import io.openjob.common.util.DateUtil;
import io.openjob.worker.delay.DelayMessage;
import io.openjob.worker.delay.OpenjobDelayTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomDelayServiceImpl {

    private final OpenjobDelayTemplate openjobDelayTemplate;

    public String sendDelayedTask(String topic, String payload, int delaySeconds) {
        DelayMessage delayMessage = new DelayMessage();
        delayMessage.setTopic(topic);
        delayMessage.setParams(payload);
        delayMessage.setExecuteTime(DateUtil.timestamp() + delaySeconds);
        
        String taskId = this.openjobDelayTemplate.send(delayMessage);
        log.info("Dispatched delayed task, ID: {}", taskId);
        return taskId;
    }
}
```
