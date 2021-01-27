package tictactoe.helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper implements IHelper {
    private Scanner sc;
    private IColor color;

    public Helper() {
        sc = null;
        color = new Color();
    }

    public int enterNumber(int max, String message) {
        sc = null;
        int number = 0;
        do {
            try {
                sc = new Scanner(System.in);
                number = sc.nextInt();
                while (number < 1 || number > max) {
                    System.out.println(color.red() + "*** " + message + " not valid, enter another" + color.reset());
                    System.out.print("- enter the " + message + ": ");
                    number = sc.nextInt();
                }
            } catch (InputMismatchException ime) {
                System.out.println(color.red() + "***Watch out! You can only insert numbers" + color.reset());
                System.out.print("- enter the " + message + ": ");
                assert sc != null;
                sc.next();
            } finally {
                if (sc == null) {
                    assert false;
                    sc.close();
                }
            }
        } while (number < 1 || number > max);
        return number;
    }
}
