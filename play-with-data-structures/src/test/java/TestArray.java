import com.yangxuan.array.Array;
import org.junit.Test;

public class TestArray {

    @Test
    public void test() {
        Array<Integer> array = new Array<>();
        array.addLast(1);
        array.addLast(3);
        array.addLast(5);
        array.addLast(7);
        array.addLast(9);
        array.add(1, 2);
        array.addFirst(-10232);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        System.out.println(array.get(4));

        System.out.println(array.find(7));
        array.set(2, 2323);
        System.out.println(array);

        array.removeElement(9);
        System.out.println(array);

        System.out.println(void.class.isPrimitive());
        System.out.println(int.class.isPrimitive());
    }
}
