package machine.model;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachineState state;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;

        state = CoffeeMachineState.WAITING_ACTION;
    }
    public void print(){
        System.out.print("\nThe coffee machine has:\n" +
                getWater() +" ml of water\n" +
                getMilk() + " ml of milk\n" +
                getBeans() + " g of coffee beans\n" +
                getCups() + " disposable cups\n$" +
                getMoney() +" of money\n");
    }

    public void processCommand(String command) {
        switch (command) {
            case "buy":
                state = CoffeeMachineState.WAITING_CHOOSE;
                sayMessageFromState(true);
                break;

            case "fill":
                state = CoffeeMachineState.WAITING_WATER;
                sayMessageFromState(true);
                break;

            case "take":
                state = CoffeeMachineState.WAITING_ACTION;
                commandTakeMoney();
                sayMessageFromState(true);
                break;

            case "exit":
                state = CoffeeMachineState.WAITING_END;
                break;

            case "remaining":
                print();
                sayMessageFromState(true);
                break;

            default:
                processSubCommand(command);
        }
    }

    private void processSubCommand(String command){

        switch (state) {
            case WAITING_CHOOSE:
                if ("1".equals(command) || "2".equals(command) || "3".equals(command)) {
                    if (Integer.parseInt(command) == 1) {
                        System.out.println(commandBuyCoffee(Receipt.ESPRESSO));
                    } else if (Integer.parseInt(command) == 2) {
                        System.out.println(commandBuyCoffee(Receipt.LATTE));
                    } else if (Integer.parseInt(command) == 3) {
                        System.out.println(commandBuyCoffee(Receipt.CAPPUCCINO));
                    }
                }
                state = CoffeeMachineState.WAITING_ACTION;
                sayMessageFromState(true);
                break;
            case WAITING_WATER:
                setWater(getWater() + Integer.parseInt(command));
                state = CoffeeMachineState.WAITING_MILK;
                sayMessageFromState(false);
                break;
            case WAITING_MILK:
                setMilk(getMilk() + Integer.parseInt(command));
                state = CoffeeMachineState.WAITING_BEAN;
                sayMessageFromState(false);
                break;
            case WAITING_BEAN:
                setBeans(getBeans() + Integer.parseInt(command));
                state = CoffeeMachineState.WAITING_CUPS;
                sayMessageFromState(false);
                break;
            case WAITING_CUPS:
                setCups(getCups() + Integer.parseInt(command));
                state = CoffeeMachineState.WAITING_ACTION;
                sayMessageFromState(true);
                break;
            default:
                state = CoffeeMachineState.WAITING_END;
        }
    }
    public CoffeeMachineState getState() {
        return state;
    }

    private void commandTakeMoney() {
        System.out.println("\nI gave you $" + getMoney());
        setMoney(0);
    }

    private String commandBuyCoffee(Receipt receipt){

        if (water - receipt.getWater() >= 0 )
        {
            water -= receipt.getWater();
            milk -= receipt.getMilk();
            beans -= receipt.getBeans();
            cups -= receipt.getCups();

            money += receipt.getCosts();
            return  "I have enough resources, making you a coffee!";
        }

        return "Sorry, not enough water!";
    }

    public void sayMessageFromState(boolean withEmptyLine){
        if (withEmptyLine) {
            System.out.println();
        }
        System.out.println(state.getMessage());
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
