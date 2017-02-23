package com.wehkamp.hashcode.practise;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {

	public int identifier;
	public int totalCapacity;
	public int usedCapacity;
	public int unUsedCapacity;
	public List<Video> videos = new ArrayList<Video>();

	public CacheServer(int identifier, int totalcapacity) {
		this.identifier = identifier;
		this.totalCapacity = totalcapacity;
		this.unUsedCapacity = this.totalCapacity;		
	}
}
