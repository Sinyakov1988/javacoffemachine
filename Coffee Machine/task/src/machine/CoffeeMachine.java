package machine;

import machine.model.CoffeeMachineState;
import machine.model.Machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Write how many ml of water the coffee machine has:");
//        int water = scanner.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = scanner.nextInt();
//
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beans = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//
//        int cups = scanner.nextInt();

        Machine machine = new Machine(400, 540, 120, 9, 550);
        machine.print();

        machine.sayMessageFromState();

        while (machine.getState() != CoffeeMachineState.WAITING_END) {
            machine.processCommand(scanner.next());
            //scanner.nextLine();
        }

        machine.print();

    }
}
