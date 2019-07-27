package com.example.limitsservice;

public class LimitsConfiguration {
	private int max;
	private int min;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	public LimitsConfiguration() {
		super();
	}
	public LimitsConfiguration(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	@Override
	public String toString() {
		return "LimitsConfiguration [max=" + max + ", min=" + min + "]";
	}
	
	
}
