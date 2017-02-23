package com.wehkamp.hashcode.practise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filereader fr = new Filereader();
        Model m = fr.read(args[0]);
        List<CacheServer> usedCS = new ArrayList<CacheServer>();
        
        
        
        
        for(int i = 0 ; i < m.cachServers.length ; i++){
        	CacheServer cs = m.cachServers[i];
        	for(int j = 0 ; j < m.videos.length ; j++){        		
        		if(cs.unUsedCapacity >= m.videos[j].size && isVideoUsed(m.videos[j], m.requests)){
        			cs.videos.add(m.videos[j]);
        			cs.unUsedCapacity -= m.videos[j].size;
        		}
        	}
        	
        	usedCS.add(cs);
        }
        
        System.out.println(usedCS.size());
        
        for(CacheServer cs : usedCS){
        	StringBuffer sb = new StringBuffer();
        	sb.append(cs.identifier);
        	for(Video v : cs.videos){
        		sb.append(" " + v.identifier);
        	}
        	
        	System.out.println(sb.toString());
        }
    }
    
    public static boolean isVideoUsed(Video v, Request[] requests){
    	
    	for(int i = 0; i < requests.length ; i++){
    		if(requests[i].video.identifier == v.identifier){
    			return true;
    		}
    	}
    	
    	return false;
    }
}
