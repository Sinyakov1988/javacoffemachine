package machine.model;

public enum Receipt {
    ESPRESSO(250,0,16, 4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6);

    Receipt(int water, int milk, int beans, int costs) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.costs = costs;
        this.cups = 1;
    }

    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;
    private final int costs;

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getCosts() {
        return costs;
    }
}
