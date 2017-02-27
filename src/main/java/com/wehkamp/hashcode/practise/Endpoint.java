package com.wehkamp.hashcode.practise;

import java.util.Arrays;
import java.util.List;

public class Endpoint {
    public int latencyDc;
    public List<LatencyToCache> latencyCs;

    @Override
    public String toString() {
        return "Endpoint{" +
                "latencyDc=" + latencyDc +
                ", latencyCs=" + latencyCs +
                '}';
    }
}
