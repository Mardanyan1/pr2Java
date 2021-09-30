import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * ЭТО ПРОГРАММА-СЕРВЕР, которая будет настраивать и запускать наш серверный класс-калькулятор.
 */
public class ServerMain {
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final RemoteCalculationServer server = new RemoteCalculationServer();

        // Cоздали реестр удаленных объектов
        final Registry registry = LocateRegistry.createRegistry(1234);

        // Создали заглушку stub, которая инкапсулирует внутри себя весь процесс удаленного вызова
        Remote stub = UnicastRemoteObject.exportObject(server, 0);
        // зарегистрировали нашу заглушку в реестре удаленных объектов
        registry.bind(UNIQUE_BINDING_NAME, stub);

        Thread.sleep(Integer.MAX_VALUE);
    }
}