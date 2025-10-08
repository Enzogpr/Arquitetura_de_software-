package github.lucasmartins.classes.exemploconsumidorsqs.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(SqsMessageListener.class);

    @SqsListener(value = "${sqs.queue.name}", acknowledgementMode = SqsListenerAcknowledgementMode.ON_SUCCESS)
    public void processMessage(@Payload String messageBody) {
        logger.info(">>> MENSAGEM RECEBIDA (Spring Boot 3)! <<<");
        logger.info("Conteúdo: {}", messageBody);
    }
}