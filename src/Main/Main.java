package Main;
import Data.UI.Map;
import Data.Point;
import Exceptions.OutOfMapException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        Main.test();
    }

    public static void test(){
        Map map = new Map(8, 8);

        try {
            map.insertBlockAtPoint(new Point(), 'S');
            map.insertBlockAtPoint(new Point(), 'S');
            map.insertBlockAtPoint(new Point(), 'S');
        } catch (OutOfMapException e) {
            throw new RuntimeException(e);
        }
        map.DisplayOnOut();
    }
}
