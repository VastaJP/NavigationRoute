package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.List;

public class PartialBezier implements NavigationType{

	private final int level;

	public PartialBezier(int level) {
		this.level = level;
	}

	@Override
	public List<Location> waitPoints(List<Location> pointList) {
		return null;
	}

	@Override
	public String navigationName() {
		return "PARTIAL BEZIER";
	}
}
