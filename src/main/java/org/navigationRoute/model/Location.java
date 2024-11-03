package org.navigationRoute.model;

public class Location {
	private int xAxis;
	private int yAxis;

	public int getXAxis() {
		return xAxis;
	}

	public void setXAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getYAxis() {
		return yAxis;
	}

	public void setYAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public Location(int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
}
