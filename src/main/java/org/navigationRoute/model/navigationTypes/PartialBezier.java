package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.ArrayList;
import java.util.List;

public class PartialBezier extends Bezier{

	public PartialBezier(int level) {
		this.level = level;
	}

	private List<List<Location>> generatePointsPerLevel (List<Location> originalPointList) {
		List<List<Location>> pointsPerLevel = new ArrayList<>();
		pointsPerLevel.add(0,originalPointList);
		for (int i = 0; i <= this.level; i++) {
			List<Location> previousPointList = pointsPerLevel.get(i);
			pointsPerLevel.add(i+1, getPoints(previousPointList,0) );
		}
		return pointsPerLevel;
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
