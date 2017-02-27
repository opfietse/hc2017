package com.wehkamp.hashcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filereader fr = new Filereader();
        Model m = fr.read(args[0]);
        List<CacheServer> usedCS = new ArrayList<CacheServer>();

        // m.videos = filterUnused(m.videos, m.requests);
        // m.videos = filterTooBig(m.videos, m.cachServers);

        sort(m.videos, m.requests, m.endpoints, m.cachServers);

        for (CacheServer cs: m.cachServers) {
            for (Video video: m.videos) {
                if (cs.unUsedCapacity >= video.size) {
                    cs.videos.add(video);
                    cs.unUsedCapacity -= video.size;
                }
            }

            usedCS.add(cs);
        }

        System.out.println(usedCS.size());

        for (CacheServer cs: usedCS) {
            StringBuffer sb = new StringBuffer();
            sb.append(cs.identifier);
            for (Video v: cs.videos) {
                sb.append(" " + v.identifier);
            }

            System.out.println(sb.toString());
        }
    }

    public static List<Video> filterUnused(List<Video> videos, List<Request> requests) {
        List<Video> newVids = new ArrayList<Video>();
        for (Video video: videos) {
            if (isVideoUsed(video, requests)) {
                newVids.add(video);
            }
        }

        return newVids;
    }

    public static List<Video> filterTooBig(List<Video> videos, List<CacheServer> caches) {
        List<Video> newVids = new ArrayList<Video>();
        if (caches.size() == 0)
            return videos;

        for (Video video: videos) {
            if (video.size < caches.get(0).totalCapacity) {
                newVids.add(video);
            }
        }

        return newVids;
    }

    public static boolean isVideoUsedFromEndpointWithCacheAndFits(Video v, List<Request> requests, List<Endpoint> endpoints, List<CacheServer> caches) {
        for (Request request: requests) {
            Endpoint endpoint = request.endpoint;

            if (endpoint.latencyCs.size() > 0) {
                if (request.video.identifier == v.identifier) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isVideoUsed(Video v, List<Request> requests) {
        for (Request request: requests) {
            if (request.video.identifier == v.identifier) {
                return true;
            }
        }

        return false;
    }

    public static void sort(List<Video> videos, List<Request> requests, List<Endpoint> endpoints, List<CacheServer> caches) {
        for (Request request: requests) {
            Video video = videos.get(request.video.identifier);

            if (isVideoUsedFromEndpointWithCacheAndFits(video, requests, endpoints, caches)) {
                video.uses = video.uses + request.numberOfViews;
            }
        }

        Collections.sort(videos);

//        for (Video video: videos) {
//            System.out.println(video.uses);
//        }

        // for (int count = 0; count < videos.length; count++) {
        // for (int i = 0; i < videos.length; i++) {
        // if (i < videos.length - 1) {
        // if (videos[i].uses < videos[i + 1].uses) {
        // Video vt = videos[i];
        // videos[i] = videos[i + 1];
        // videos[i + 1] = vt;
        // }
        // }
        // }
        // }
    }
}
