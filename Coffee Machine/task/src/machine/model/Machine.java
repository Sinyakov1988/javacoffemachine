package machine.model;

public class Machine {
    private final int _ONE_CUP_WATER;
    private int water;
    private final int _ONE_CUP_MILK;
    private int milk;
    private final int _ONE_CUP_BEANS;
    private int beans;


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

    public Machine(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;

        _ONE_CUP_WATER = 200;
        _ONE_CUP_MILK = 50;
        _ONE_CUP_BEANS = 15;
    }
    public void prepareCoffee(int n) {
        int cnt = 0;

        int w = getWater();
        int m = getMilk();
        int b = getBeans();

        do {
            w -= _ONE_CUP_WATER;
            b -= _ONE_CUP_BEANS;
            m -= _ONE_CUP_MILK;
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
}
