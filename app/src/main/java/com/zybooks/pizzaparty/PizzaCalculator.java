package com.zybooks.pizzaparty;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }
    public enum PizzaSize {
        SMALL, MEDIUM, LARGE
    }

    public int SLICES_PER_PIZZA = 8;

    private HungerLevel mHungerLevel;
    private PizzaSize mPizzaSize;
    private int mPartySize;

    public PizzaCalculator(int partySize, HungerLevel level, PizzaSize pizzaSize) {
        setHungerLevel(level);
        setPartySize(partySize);
        setPizzaSize(pizzaSize);
    }

    public HungerLevel getHungerLevel() {
        return mHungerLevel;
    }

    public void setPizzaSize(PizzaSize pizzaSize) { mPizzaSize = pizzaSize;}

    public void setHungerLevel(HungerLevel level) {
        mHungerLevel = level;
    }

    public int getPartySize() {
        return mPartySize;
    }

    public void setPartySize(int partySize) {
        if (partySize >= 0) {
            mPartySize = partySize;
        }
    }

    public int getTotalPizzas() {
        int slicesPerPerson;
        CalcPerPizzaSlices();
        if (mHungerLevel == HungerLevel.LIGHT) {
            slicesPerPerson = 2;
        }
        else if (mHungerLevel == HungerLevel.MEDIUM) {
            slicesPerPerson = 3;
        }
        else {
            slicesPerPerson = 4;
        }
        return (int) Math.ceil(mPartySize * slicesPerPerson / (double) SLICES_PER_PIZZA);
    }
    public void CalcPerPizzaSlices()
    {
        if (mPizzaSize == PizzaSize.SMALL) {
            SLICES_PER_PIZZA = 6;
        }
        else if (mPizzaSize == PizzaSize.MEDIUM) {
            SLICES_PER_PIZZA = 8;
        }
        else {
            SLICES_PER_PIZZA = 12;
        }
    }
}
