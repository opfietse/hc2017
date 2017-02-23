package com.wehkamp.hashcode.practise;

import java.util.Arrays;

public class Model {
    public Endpoint[] endpoints;
    public Video[] videos;
    public CacheServer[] cachServers;
    public Request[] requests;

    public Model() {

    }


    public Model(Endpoint[] endpoints, Video[] videos, CacheServer[] cachServers, Request[] requests) {
        this.endpoints = endpoints;
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "e9 " + endpoints[9].latencyDc +  ", " + endpoints[9].latencyCs.length + ", " + endpoints[9].latencyCs[2].latency + ", " + requests[9].numberOfViews;
    }
//    @Override
//    public String toString() {
//        return "Model{" +
//                "endpoints=" + Arrays.toString(endpoints) +
//                ", videos=" + Arrays.toString(videos) +
//                ", cachServers=" + Arrays.toString(cachServers) +
//                ", requests=" + Arrays.toString(requests) +
//                '}';
//    }
}
