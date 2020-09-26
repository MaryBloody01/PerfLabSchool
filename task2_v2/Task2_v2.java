package homework_2;

import ru.pflb.mq.dummy.exception.DummyException;
import ru.pflb.mq.dummy.interfaces.Destination;

import java.io.*;
import java.util.stream.Stream;

public class Task2_v2 {
    public static void main(String[] args) throws DummyException {
        boolean autoAck = true;

        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(args[0])));
             MyConnectionImpl ci = new MyConnectionImpl();
             MySessionImpl session =  ci.createSession(autoAck); ) {
            Destination dest = session.createDestination("Queue");
            MyProducerImpl producer = session.createProducer(dest);
            ci.start();

            br.mark(1000);
            while (true) {
                Stream<String> strings = br.lines();
                strings.forEach(s -> producer.send(s));
                br.reset();
            }

        } catch (IOException io) {
            System.out.println("Ошибка при чтении файла!");
        }
    }
}

