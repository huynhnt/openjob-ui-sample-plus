package io.openjob.samples.spring.boot.delay;

import io.openjob.worker.context.JobContext;
import io.openjob.worker.processor.JavaProcessor;
import io.openjob.worker.processor.ProcessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author stelin swoft@qq.com
 * @since 1.0.0
 */
@Component
public class DelayProcessor implements JavaProcessor {
    private static final Logger logger = LoggerFactory.getLogger("openjob");
    @Override
    public ProcessResult process(JobContext context) throws Exception {
        logger.info("Delay run {} {} {}", context.getDelayTaskId(), context.getDelayParams(), context.getDelayExtra());
        return ProcessResult.success();
    }
}
