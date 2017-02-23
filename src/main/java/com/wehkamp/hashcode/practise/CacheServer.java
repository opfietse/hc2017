package com.wehkamp.hashcode.practise;

public class CacheServer {

	public int identifier;
	public int totalCapacity;
	public int usedCapacity;
	public int unUsedCapacity;

	public CacheServer(int identifier, int totalcapacity) {
		this.identifier = identifier;
		this.totalCapacity = totalcapacity;
	}
}
