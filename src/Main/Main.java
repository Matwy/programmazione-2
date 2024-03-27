package Main;
import Data.Map;
import Data.Point;
import Exceptions.OutOfMapException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        Main.test();
    }

    public static void test(){
        Map map = new Map(16, 16);

        try {
            map.insertBlockAtPoint(new Point(), 'A');
        } catch (OutOfMapException e) {
            throw new RuntimeException(e);
        }
        map.DisplayOnOut();
    }
}
