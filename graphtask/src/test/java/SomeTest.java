import org.junit.Test;

import java.util.Scanner;

public class SomeTest {
    @Test
    public void calc1() {
        System.out.println((0 + 15) / 2);
        System.out.println((1 + 2.236) / 2);
    }

    @Test
    public void calc2() {
        Scanner scanner = new Scanner("1 2 3");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        boolean numbersAreEqual = (n1 == n2) && (n2 == n3);

        System.out.println(numbersAreEqual ? "numbers are equal" : "numbers are not equal");
    }

    @Test
    public void calc3() {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        System.out.printf("%.5f\n", t);
    }
}
