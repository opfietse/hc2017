package com.wehkamp.hashcode.practise;

import java.util.Arrays;
import java.util.List;

public class Model {
    public List<Endpoint> endpoints;
    public List<Video> videos;
    public List<CacheServer> cachServers;
    public List<Request> requests;

    public Model() {

    }

    public Model(List<Endpoint> endpoints, List<Video> videos, List<CacheServer> cachServers, List<Request> requests) {
        this.endpoints = endpoints;
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "e9 " + endpoints.get(9).latencyDc + ", " + endpoints.get(9).latencyCs.size() + ", " + endpoints.get(9).latencyCs.get(2).latency + ", "
            + requests.get(9).numberOfViews;
    }
    // @Override
    // public String toString() {
    // return "Model{" +
    // "endpoints=" + Arrays.toString(endpoints) +
    // ", videos=" + Arrays.toString(videos) +
    // ", cachServers=" + Arrays.toString(cachServers) +
    // ", requests=" + Arrays.toString(requests) +
    // '}';
    // }
}
