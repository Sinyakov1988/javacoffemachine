package machine;

import machine.model.CoffeeMachineState;
import machine.model.Machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine(400, 540, 120, 9, 550);
        machine.sayMessageFromState(false);

        while (machine.getState() != CoffeeMachineState.WAITING_END) {
            machine.processCommand(scanner.next());
        }
    }
}
