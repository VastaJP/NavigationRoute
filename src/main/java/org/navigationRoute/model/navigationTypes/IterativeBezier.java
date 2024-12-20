package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.List;

public class IterativeBezier extends Bezier {
	private final int level;

	public IterativeBezier(int level) {
		this.level = level;
	}

	@Override
	public String navigationName() {
		return "ITERATIVE BEZIER";
	}

	@Override
	public List<Location> waitPoints(List<Location> pointsList) {
		return getPoints(pointsList, 0);
	}

}
