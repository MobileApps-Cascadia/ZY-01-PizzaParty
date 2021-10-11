package com.zybooks.pizzaparty;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }

    public enum  PizzaSize {
        SMALL, MEDIUM, LARGE
    }

    // public final static int SLICES_PER_PIZZA = 8;

    private HungerLevel mHungerLevel;
    private int mPartySize;
    private PizzaSize mPizzaSize;

    public PizzaCalculator(int partySize, HungerLevel level, PizzaSize size) {
        setHungerLevel(level);
        setPartySize(partySize);
        setSlicesPerPizza(size);
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
        if (partySize >= 0) {
            mPartySize = partySize;
        }
    }
/// * continue here to assign the slices per pizza selection using get and set method * ///
    public PizzaSize getPizzaSize() { return mPizzaSize; }
    public void setSlicesPerPizza(PizzaSize size) {
        mPizzaSize = size;
    }
///

    public int getTotalPizzas() {
        int slicesPerPerson;
        int pizzaSlices;
        if (mHungerLevel == HungerLevel.LIGHT) {
            slicesPerPerson = 2;
        }
        else if (mHungerLevel == HungerLevel.MEDIUM) {
            slicesPerPerson = 3;
        }
        else {
            slicesPerPerson = 4;
        }

        if (mPizzaSize == PizzaSize.SMALL) {
            pizzaSlices = 6;
        }
        else if (mPizzaSize == PizzaSize.MEDIUM) {
            pizzaSlices = 8;
        }
        else {
            pizzaSlices = 12;
        }

        return (int) Math.ceil(mPartySize * slicesPerPerson / (double) pizzaSlices);
//      return (int) Math.ceil(mPartySize * slicesPerPerson / (double) SLICES_PER_PIZZA);
    }
}
