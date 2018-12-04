import java.util.Arrays;

public class Assert {
    public static void assertTrue(boolean condition) throws Throwable {
        if (!condition) {
            System.out.println("Expected true");
            throw new Throwable();
        }
    }

    public static void assertFalse(boolean condition) throws Throwable {
        if (condition) {
            System.out.println("Expected false");
            throw new Throwable();
        }
    }

    public static void assertEquals(int exp, int act) throws Throwable {
        if (exp != act) {
            System.out.println("Expected: " + exp + ", but saw: " + act);
            throw new Throwable();
        }
    }

    public static void assertArrayEquals(int[] exp, int[] act) throws Throwable {
        if (!Arrays.equals(exp, act)) {
            System.out.println("Expected: " + ArrayUtil.toString(exp) +
                               ", but saw: " + ArrayUtil.toString(act));
            throw new Throwable();
        }
    }
}
