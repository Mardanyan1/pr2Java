import java.rmi.RemoteException;

/**
 * ЭТО КЛАСС-СЕРВЕР, который будет реализовывать наш интерфейс Calculator
 */

public class RemoteCalculationServer implements Calculator {

    @Override
    public String quadraticEquation(float a, float b, float c) throws RemoteException {

        float discriminant = b * b - 4 * a * c;

        if (discriminant < 0)
            return "При a = " + a + ", b= " + b + " и с= " + c + ": Уравнение не имеет действительных корней";
        else if (discriminant == 0) {
            float x = (float) (-b / (2 * a));
            return "При a = " + a + ", b= " + b + " и с= " + c + ": Уравнение имеет единственный корень: x = " + x;
        } else {
            float x1, x2;
            x1 = (float) ((-b - Math.sqrt(discriminant)) / (2 * a));
            x2 = (float) ((-b + Math.sqrt(discriminant)) / (2 * a));
            return "При a = " + a + ", b= " + b + " и с= " + c + ": Корни уравнения: x1 = " + x1 + ", x2 = " + x2;
        }
    }
}