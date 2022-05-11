package machine.model;

public enum CoffeeMachineState {
    WAITING_ACTION("Write action (buy, fill, take):"),
    WAITING_WATER("Write how many ml of water you want to add:"),
    WAITING_MILK("Write how many ml of milk you want to add:"),
    WAITING_BEAN("Write how many grams of coffee beans you want to add:"),
    WAITING_CUPS("Write how many disposable cups of coffee you want to add:"),
    WAITING_END(""),
    WAITING_CHOOSE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
    private final String _message;

    CoffeeMachineState(String msg) {
        _message = msg;
    }

    public String getMessage() {
        return _message;
    }
}
