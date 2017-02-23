package com.wehkamp.hashcode.practise;

import java.io.*;

public class Filereader {
    public Model read(String filename) {
        int lineCounter = 0;
        int rows = 0;
        int cols = 0;
        int minIngredients = 0;
        int maxSize = 0;
        PizzaPart[][] pizzaParts = new PizzaPart[0][0];

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (lineCounter == 0) {
                    String[] firstLineParts = line.split(" ");
                    rows = Integer.parseInt(firstLineParts[0]);
                    cols = Integer.parseInt(firstLineParts[1]);
                    minIngredients = Integer.parseInt(firstLineParts[2]);
                    maxSize = Integer.parseInt(firstLineParts[3]);
                } else {
                    //System.out.println(line);

                    if (lineCounter == 1) {
                        pizzaParts = new PizzaPart[rows][cols];
                    }

                    for (int i = 0; i < cols; i++) {
                        pizzaParts[lineCounter - 1][i] = line.charAt(i) == 'T' ? PizzaPart.TOMATO : PizzaPart.MUSHROOM;
                    }
                }

                ++lineCounter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Model(rows, cols, minIngredients, maxSize, pizzaParts);
    }
}
