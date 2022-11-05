import com.yangxuan.stack.ArrayStack;
import com.yangxuan.stack.Stack;
import org.junit.Test;

public class TestArrayStack {

    @Test
    public void testPush() {

        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
