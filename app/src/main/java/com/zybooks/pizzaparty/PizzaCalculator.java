package com.zybooks.pizzaparty;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }

// Pizza size options
    public enum SizePizza {
        SMALL, MEDIUM, LARGE
    }

// No longer a constant
//    public final static int SLICES_PER_PIZZA = 8;

    private HungerLevel mHungerLevel;
    private SizePizza mSizePizza;
    private int mPartySize;

    public PizzaCalculator(int partySize, HungerLevel level, SizePizza size) {
        setHungerLevel(level);
        setSizePizza(size);
        setPartySize(partySize);
    }

    public HungerLevel getHungerLevel() {
        return mHungerLevel;
    }

    public SizePizza getSizePizza() {
        return mSizePizza;
    }

    public void setHungerLevel(HungerLevel level) {
        mHungerLevel = level;
    }

    public void setSizePizza(SizePizza size) {
        mSizePizza = size;
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
        int sizeOfPizza;
        if (mHungerLevel == HungerLevel.LIGHT) {
            slicesPerPerson = 2;
        }
        else if (mHungerLevel == HungerLevel.MEDIUM) {
            slicesPerPerson = 3;
        }
        else {
            slicesPerPerson = 4;
        }

// Set slices per size pizza
        if (mSizePizza == SizePizza.SMALL) {
            sizeOfPizza = 6;
        }
        else if (mSizePizza == SizePizza.MEDIUM) {
            sizeOfPizza = 8;
        }
        else {
            sizeOfPizza = 12;
        }

// Calculates number of pizzas needed with updated pizza size
        return (int) Math.ceil(mPartySize * slicesPerPerson / (double) sizeOfPizza);
    }
}
