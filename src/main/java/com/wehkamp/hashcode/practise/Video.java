package com.wehkamp.hashcode.practise;

public class Video implements Comparable<Video> {

	public int size;
	public int identifier;
	public int uses = 0;

	public Video(int identifier, int size) {
		this.identifier = identifier;
		this.size = size;
	}

	@Override
	public int compareTo(Video o) {
		if (this.uses > o.uses) {
			return 1;
		} else if (this.uses == o.uses) {
			return 0;
		} else {
			return -1;
		}
	}
}
