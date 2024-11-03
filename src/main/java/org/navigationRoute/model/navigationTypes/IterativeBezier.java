package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.ArrayList;
import java.util.List;

public class IterativeBezier implements NavigationType {
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

	//Calculate the mid-point between two points
	private Location midPoint(Location location1, Location location2){
		int xAxis = (location1.getXAxis() + location2.getXAxis()) / 2;
		int yAxis = (location1.getYAxis() + location2.getYAxis()) / 2;
		return new Location(xAxis, yAxis);
	}

	//Returns the list of mid-points
	private List<Location> getPoints(List<Location> pointsList, int actualLevel){
		if (actualLevel <= level) {
			List<Location> points = new ArrayList<>();
			points.add(pointsList.get(0));
			for (int i = 0; i < pointsList.size() - 1; i++) {
				points.add(midPoint(pointsList.get(i), pointsList.get(i + 1)));
			}
			points.add(pointsList.get(pointsList.size() - 1));
			return getPoints(points,actualLevel + 1);
		}
		else return pointsList;
	}

}
