package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.Arrays;
import java.util.List;

public class Dummy implements NavigationType {

	@Override
	public List<Location> waitPoints(List<Location> pointList) {
		return Arrays.asList(pointList.get(0), pointList.get(pointList.size()-1));
	}

	@Override
	public String navigationName() {
		return "DUMMY";
	}
}
