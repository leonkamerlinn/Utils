package com.kamerlin.leon.utils.data_structures;

public class Pair<T, U> {
    private T mFirstValue;
    private U mSecondValue;

    public Pair(T firstValue, U secondValue) {
        mFirstValue = firstValue;
        mSecondValue = secondValue;
    }

    public T getFirstValue() {
        return mFirstValue;
    }

    public U getSecondValue() {
        return mSecondValue;
    }

    public void setFirstValue(T firstValue) {
        mFirstValue = firstValue;
    }

    public void setSecondValue(U secondValue) {
        mSecondValue = secondValue;
    }
}
