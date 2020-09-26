package homework_2;

import ru.pflb.mq.dummy.exception.DummyException;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;

public class MySessionImpl implements Session {
    public MySessionImpl() {
    }

    public Destination createDestination(String queueName) throws DummyException {
        return new DestinationImpl(queueName);
    }

    public MyProducerImpl createProducer(Destination destination) throws DummyException {
        return new MyProducerImpl(destination);
    }
}
