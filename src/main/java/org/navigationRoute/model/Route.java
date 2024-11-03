package org.navigationRoute.model;

import org.navigationRoute.model.navigationTypes.NavigationType;

import java.util.List;

public class Route {

	private int actualPoint;
	private List<Location> waitPoints;
	private NavigationType navigationType;

	public void setNavigationType(NavigationType navigationType) {
		this.navigationType = navigationType;
	}

	public String navigationName() {
		return navigationType.navigationName();
	}

	public Route(List<Location> waitPoints) {
		this.waitPoints = waitPoints;
	}

	public Route(List<Location> pointList, NavigationType navigationTypeType) throws RuntimeException{
		if (pointList.size() >= 2) {
			this.navigationType = navigationTypeType;
			waitPoints = calculateWaitPoints(pointList);
			actualPoint = 0;
		}
		else
			throw new RuntimeException("La ruta debe estar compuesta por al menos dos coordenadas");
	}

	private double distanceBetween(Location location1, Location location2){
		return Math.sqrt(
				Math.pow(location2.getXAxis() - location1.getXAxis(),2) +
						Math.pow(location2.getYAxis() - location1.getYAxis(),2)
		);
	}

	private double distance(List<Location> waitPoints) {
		double totalDistance = 0;
		for (int i = 0; i < waitPoints.size()-1; i++) {
			totalDistance += distanceBetween(waitPoints.get(i),waitPoints.get(i+1));
		}
		return totalDistance;
	}

	private List<Location> calculateWaitPoints(List<Location> pointList){
		return navigationType.waitPoints(pointList);
	}

	public List<Location> waitPoints(){
		return waitPoints;
	}

	public double fullDistance(){
		return this.distance(waitPoints);
	}

	public Location next() throws RuntimeException{
		if (actualPoint == waitPoints.size()-1)
			throw new RuntimeException("Se encuentra en la ultima ubicación de la ruta");
		actualPoint ++;
		return waitPoints.get(actualPoint);
	}

	public double remainingDistance(){
		List<Location> remainingPoints = waitPoints.subList(actualPoint,waitPoints.size());
		return distance(remainingPoints);
	}

	public double traveledDistance(){
		List<Location> traveledPoints = waitPoints.subList(0,actualPoint+1);
		return distance(traveledPoints);
	}

}
