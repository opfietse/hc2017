package com.wehkamp.hashcode.practise;

import java.util.Arrays;

public class Model {
    public int numberOfRows;
    public int numberOfColumns;
    public int minimalIngredient;
    public int maxSize;
    public PizzaPart[][] pizzaParts;

    public Model(int numberOfRows, int numberOfColumns, int minimalIngredient, int maxSize, PizzaPart[][] pizzaParts) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.minimalIngredient = minimalIngredient;
        this.maxSize = maxSize;
        this.pizzaParts = pizzaParts;
    }

    @Override
    public String toString() {
        return "Model{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", minimalIngredient=" + minimalIngredient +
                ", maxSize=" + maxSize +
                ", pizzaParts=" + printParts(pizzaParts) + //Arrays.toString(pizzaParts) +
                '}';
    }

    private String printParts(PizzaPart[][] pp) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < pp.length; i++) {
            for (int j = 0; j < pp[i].length; j++) {
              sb.append(pp[i][j] == PizzaPart.TOMATO ? "t" : "m");
            }

            sb.append(":");
        }

        return sb.toString();
    }
}
