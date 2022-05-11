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
        System.out.println("The coffee machine has:\n" +
                getWater() +" ml of water\n" +
                getMilk() + " ml of milk\n" +
                getBeans() + " g of coffee beans\n" +
                getCups() + " disposable cups\n$" +
                getMoney() +" of money");
    }
    public void prepareCoffee(int n) {
        int cnt = 0;

        int w = getWater();
        int m = getMilk();
        int b = getBeans();

        do {
            w -= 1;
            b -= 1;
            m -= 1;
            if (w >= 0 && m >= 0 && b >= 0) {
                cnt++;
            }
        } while (w > 0 && m > 0 && b > 0);
        if (n == cnt) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (n > cnt) {
            System.out.println("No, I can make only " + cnt + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cnt - n) + " more than that)");
        }


    }

    public void processCommand(String command) {
        switch (command) {
            case "buy":
                state = CoffeeMachineState.WAITING_CHOOSE;
                sayMessageFromState();
                break;

            case "fill":
                state = CoffeeMachineState.WAITING_WATER;
                sayMessageFromState();
                break;

            case "take":
                state = CoffeeMachineState.WAITING_END;
                commandTakeMoney();
                break;

            default:
                processSubAction(Integer.parseInt(command));
        }
    }

    private void processSubAction(int data){
        switch (state) {
            case WAITING_CHOOSE:
                if (data == 1) {
                    commandBuyCoffee(Receipt.ESPRESSO);
                } else if (data == 2) {
                    commandBuyCoffee(Receipt.LATTE);
                } else if (data == 3) {
                    commandBuyCoffee(Receipt.CAPPUCCINO);
                }
                state = CoffeeMachineState.WAITING_END;
                break;
            case WAITING_WATER:
                setWater(getWater() + data);
                state = CoffeeMachineState.WAITING_MILK;
                sayMessageFromState();
                break;
            case WAITING_MILK:
                setMilk(getMilk() + data);
                state = CoffeeMachineState.WAITING_BEAN;
                sayMessageFromState();
                break;
            case WAITING_BEAN:
                setBeans(getBeans() + data);
                state = CoffeeMachineState.WAITING_CUPS;
                sayMessageFromState();
                break;
            case WAITING_CUPS:
                setCups(getCups() + data);
                state = CoffeeMachineState.WAITING_END;
                break;
            default:
                state = CoffeeMachineState.WAITING_END;
        }
    }
    public CoffeeMachineState getState() {
        return state;
    }

    private void commandTakeMoney() {
        System.out.println("I gave you $" + getMoney());
        setMoney(0);
    }

    private void commandBuyCoffee(Receipt receipt){
        water -= receipt.getWater();
        milk -= receipt.getMilk();
        beans -= receipt.getBeans();
        cups -= receipt.getCups();

        money += receipt.getCosts();
    }

    public void sayMessageFromState(){
        System.out.println(state.getMessage());
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
