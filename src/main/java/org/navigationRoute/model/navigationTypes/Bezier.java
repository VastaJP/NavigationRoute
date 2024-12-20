package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class Bezier implements NavigationType {

	protected int level;

	//Calculate the mid-point between two points
	protected Location midPoint(Location location1, Location location2){
		int xAxis = (location1.getXAxis() + location2.getXAxis()) / 2;
		int yAxis = (location1.getYAxis() + location2.getYAxis()) / 2;
		return new Location(xAxis, yAxis);
	}

	//Returns the list of mid-points
	protected List<Location> getPoints(List<Location> pointsList, int actualLevel){
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
