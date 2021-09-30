import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        //создание реестра расшареных объектов
        final Registry registry = LocateRegistry.getRegistry(1234);


        //получаем объект (на самом деле это proxy-объект)
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);

        // Вызываем удаленные методы
        String result = calculator.quadraticEquation(1, -8, 100);
        String result1 = calculator.quadraticEquation(1, -4, 4);
        String result2 = calculator.quadraticEquation(1, 3, -4);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);

    }
}