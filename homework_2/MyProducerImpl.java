package homework_2;

import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;

import java.time.Instant;

public class MyProducerImpl implements Producer {
    private final String queueName;

    public MyProducerImpl(Destination destination) {
        this.queueName = destination.getQueueName();
        System.out.printf("Создан продюсер для очереди %s!%n", this.queueName);
    }

    public void send(String message) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s - Отправляю сообщение:%n%s%n", Instant.now().toString(), message);
    }
}
