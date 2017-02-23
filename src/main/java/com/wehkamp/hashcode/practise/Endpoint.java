package com.wehkamp.hashcode.practise;

import java.util.Arrays;

public class Endpoint {
    public int latencyDc;
    public LatencyToCache[] latencyCs;

    @Override
    public String toString() {
        return "Endpoint{" +
                "latencyDc=" + latencyDc +
                ", latencyCs=" + Arrays.toString(latencyCs) +
                '}';
    }
}
