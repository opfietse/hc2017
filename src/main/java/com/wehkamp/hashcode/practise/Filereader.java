package com.wehkamp.hashcode.practise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Filereader {
    public Model read(String filename) {
        int lineCounter = 0;
        int numberOfVideos = 0;
        int numberOfEndpoints = 0;
        int numberOfRequests = 0;
        int numberOfCaches = 0;
        int cacheSize = 0;

        Video[] videos = new Video[numberOfVideos];
        CacheServer[] caches = new CacheServer[numberOfCaches];
        Request[] requests = new Request[numberOfRequests];
        Endpoint[] endpoints = new Endpoint[numberOfEndpoints];

        List<String> lines = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] firstLineParts = lines.get(0).split(" ");
        numberOfVideos = Integer.parseInt(firstLineParts[0]);
        numberOfEndpoints = Integer.parseInt(firstLineParts[1]);
        numberOfRequests = Integer.parseInt(firstLineParts[2]);
        numberOfCaches = Integer.parseInt(firstLineParts[3]);
        cacheSize = Integer.parseInt(firstLineParts[4]);

        String[] videoSizes = lines.get(1).split(" ");
        videos = new Video[numberOfVideos];

        for (int i = 0; i < numberOfVideos; i++) {
            videos[i] = new Video(Integer.parseInt(videoSizes[i]));
        }

        lineCounter = 2;
        int currEndpoit = 0;

        for (int endpoint = 0; endpoint < numberOfEndpoints; endpoint++) {
            String[] parts = lines.get(lineCounter).split(" ");
            int dcLatency = Integer.parseInt(parts[0]);
            int numCaches = Integer.parseInt(parts[1]);

            Endpoint ep = new Endpoint();
            ep.latencyDc = dcLatency;

            LatencyToCache[] ltcs = new LatencyToCache[numCaches];

            lineCounter++;
            for (int j = 0; j < numCaches; j++) {
                String[] s1 = lines.get(lineCounter).split(" ");
                LatencyToCache ltc = new LatencyToCache(Integer.parseInt(s1[0], Integer.parseInt(s1[1]));
                ltcs[j] = ltc;
                lineCounter++;
            }

            ep.latencyCs = ltcs;
            endpoints[endpoint] = ep;
        }

        // try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        // String line;
        // while ((line = br.readLine()) != null) {
        // if (lineCounter == 0) {
        // String[] firstLineParts = line.split(" ");
        // numberOfVideos = Integer.parseInt(firstLineParts[0]);
        // numberOfEndpoints = Integer.parseInt(firstLineParts[1]);
        // numberOfRequests = Integer.parseInt(firstLineParts[2]);
        // numberOfCaches = Integer.parseInt(firstLineParts[3]);
        // cacheSize = Integer.parseInt(firstLineParts[4]);
        // } else {
        // // System.out.println(line);
        //
        // if (lineCounter == 1) {
        // String[] videoSizes = line.split(" ");
        // videos = new Video[numberOfVideos];
        //
        // for (int i = 0;i < numberOfVideos; i++) {
        // videos[i] = new Video(Integer.parseInt(videoSizes[i]));
        // }
        // }
        //
        //
        // }
        //
        // ++lineCounter;
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        return new Model();
    }
}
