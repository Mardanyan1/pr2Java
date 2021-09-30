import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Calculator extends Remote {
    String quadraticEquation(float a, float b, float c) throws RemoteException;
}