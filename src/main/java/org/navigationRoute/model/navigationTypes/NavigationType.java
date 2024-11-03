package org.navigationRoute.model.navigationTypes;

import org.navigationRoute.model.Location;

import java.util.List;

public interface NavigationType {

	List<Location> waitPoints(List<Location> pointList);

	String navigationName();
	//public abstract Double fullDistance();
}
