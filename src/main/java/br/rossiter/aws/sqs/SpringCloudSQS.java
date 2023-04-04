package br.rossiter.aws.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Lazy
public class SpringCloudSQS {

    private static final Logger logger = LoggerFactory.getLogger(SpringCloudSQS.class);

    @SqsListener(value = "queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(String message, @Headers Map<String, String> headers) {
        logger.info("Received message: {}, having SenderId: {}", message, headers);
    }

    @SqsListener(value = "queue1", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage1(String message, @Headers Map<String, String> headers) {
        logger.info("Received message: {}, having SenderId: {}", message, headers);
    }

    @SqsListener(value = "queue2", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage2(String message, @Headers Map<String, String> headers) {
        logger.info("Received message: {}, having SenderId: {}", message, headers);
    }

    @SqsListener(value = "spring-cloud-test-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage3(String message, @Headers Map<String, String> headers) {
        logger.info("Received message: {}, having SenderId: {}", message, headers);
    }

}
