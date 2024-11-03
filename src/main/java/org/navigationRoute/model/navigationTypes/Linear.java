package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.List;

public class Linear implements NavigationType {

	@Override
	public String navigationName() {
		return "LINEAR";
	}

	@Override
	public List<Location> waitPoints(List<Location> pointList) {
		return pointList;
	}

}
