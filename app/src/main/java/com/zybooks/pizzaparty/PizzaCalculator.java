package com.zybooks.pizzaparty;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }
    public enum PizzaSize {
        SMALL, MEDIUM, LARGE
    }

    public final static int SMALL_SLICES_PER_PIZZA = 6;
    public final static int MEDIUM_SLICES_PER_PIZZA = 8;
    public final static int LARGE_SLICES_PER_PIZZA = 12;

    private HungerLevel mHungerLevel;
    private int mPartySize;
    private PizzaSize mPizzaSize;

    public PizzaCalculator(int partySize, HungerLevel level, PizzaSize size) {
        setHungerLevel(level);
        setPartySize(partySize);
        setPizzaSize(size);
    }

    public HungerLevel getHungerLevel() {
        return mHungerLevel;
    }

    public void setHungerLevel(HungerLevel level) {
        mHungerLevel = level;
    }

    public int getPartySize() {
        return mPartySize;
    }

    public void setPartySize(int partySize) {
        if (partySize >= 0) { mPartySize = partySize; }
    }
    public PizzaSize getPizzaSize() { return mPizzaSize; }

    public void setPizzaSize(PizzaSize pizzasize) { mPizzaSize = pizzasize; }

    public int getTotalPizzas() {
        int slicesPerPerson;
        int slicesPerPizza;

        if (mHungerLevel == HungerLevel.LIGHT) { slicesPerPerson = 2; }
        else if (mHungerLevel == HungerLevel.MEDIUM) { slicesPerPerson = 3; }
        else { slicesPerPerson = 4; }

        if (mPizzaSize == PizzaSize.SMALL)  slicesPerPizza = SMALL_SLICES_PER_PIZZA;
        else if (mPizzaSize == PizzaSize.MEDIUM)  slicesPerPizza = MEDIUM_SLICES_PER_PIZZA;
        else slicesPerPizza = LARGE_SLICES_PER_PIZZA;

        return (int) Math.ceil(mPartySize * slicesPerPerson / (double) slicesPerPizza);
    }

}
