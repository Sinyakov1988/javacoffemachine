package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int b = scanner.nextInt();
        System.out.println("For "+b+" cups of coffee you will need:\n" +
                ""+ b * 200+" ml of water\n" +
                ""+ b * 50+" ml of milk\n" +
                ""+ b * 15+" g of coffee beans");

    }
}
