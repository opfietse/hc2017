package com.wehkamp.hashcode.practise;

import java.io.*;

public class Filereader {
    public Model read(String filename) {
        int lineCounter = 0;
        int numberOfVideos = 0;
        int numberOfEndpoints = 0;
        int numberOfRequests = 0;
        int numberOfCaches = 0;
        int cacheSize = 0;
//        PizzaPart[][] pizzaParts = new PizzaPart[0][0];

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (lineCounter == 0) {
                    String[] firstLineParts = line.split(" ");
                    numberOfVideos = Integer.parseInt(firstLineParts[0]);
                    numberOfEndpoints = Integer.parseInt(firstLineParts[1]);
                    numberOfRequests = Integer.parseInt(firstLineParts[2]);
                    numberOfCaches = Integer.parseInt(firstLineParts[3]);
                    cacheSize = Integer.parseInt(firstLineParts[4]);
                } else {
                    //System.out.println(line);

//                    if (lineCounter == 1) {
//                        pizzaParts = new PizzaPart[rows][cols];
//                    }
//
//                    for (int i = 0; i < cols; i++) {
//                        pizzaParts[lineCounter - 1][i] = line.charAt(i) == 'T' ? PizzaPart.TOMATO : PizzaPart.MUSHROOM;
//                    }
                }

                ++lineCounter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Model();
    }
}
