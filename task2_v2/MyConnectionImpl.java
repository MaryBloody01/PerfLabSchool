package homework_2;

import ru.pflb.mq.dummy.interfaces.Connection;

public class MyConnectionImpl implements Connection {
    public void start() {
        System.out.println("Здесь мы притворяемся, что установили соединение с брокером очередей");
    }

    public MySessionImpl createSession(boolean autoAck) {
        if (autoAck) {
            return new MySessionImpl();
        } else {
            throw new IllegalArgumentException("В документации же написано, что нельзя передавать null");
        }
    }
}
