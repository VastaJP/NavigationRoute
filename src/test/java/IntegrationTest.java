import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.navigationRoute.model.Location;
import org.navigationRoute.model.Route;
import org.navigationRoute.model.navigationTypes.IterativeBezier;
import org.navigationRoute.model.navigationTypes.Dummy;
import org.navigationRoute.model.navigationTypes.Linear;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

	//Locations
	private Location location1;
	private Location location2;
	private Location location3;
	private Location location4;
	private Location location5;

	//PointsList
	private List<Location> pointsList;


	@BeforeEach
	void creatingScenario(){
		//Creating general testing scenario
		location1 = new Location(110,100);
		location2 = new Location(920,470);
		location3 = new Location(1180,1050);
		location4 = new Location(850,1560);
		location5 = new Location(200,1890);

		pointsList = Arrays.asList(location1, location2, location3, location4, location5);
	}

	@Test
	@DisplayName("Should throw exception creating 1 point route")
	void shouldNotAllowToCreateRoute(){
		List<Location> errorWaitPoints = List.of(location1);
		assertThrows(RuntimeException.class, () -> new Route(errorWaitPoints, null));
	}

	@Test
	@DisplayName("Should switch between different navigation types")
	void switchNavigationTypes() {
		Route genericRoute = new Route(pointsList);

		Linear linearNavigation = new Linear();
		genericRoute.setNavigationType(linearNavigation);
		assertEquals("LINEAR", genericRoute.navigationName());

		IterativeBezier iterativeBezierNavigation = new IterativeBezier(0);
		genericRoute.setNavigationType(iterativeBezierNavigation);
		assertEquals("BEZIER", genericRoute.navigationName());

		Dummy dummyNavigation = new Dummy();
		genericRoute.setNavigationType(dummyNavigation);
		assertEquals("DUMMY", genericRoute.navigationName());
	}

	@Test
	@DisplayName("Should successfully create 5 level Bezier navigation route")
	void bezierRouteTests() {
		IterativeBezier iterativeBezierNavigation = new IterativeBezier(5);
		Route bezierRoute = new Route(pointsList, iterativeBezierNavigation);

		assertEquals(11, bezierRoute.waitPoints().size());

		double fullDistance = bezierRoute.fullDistance();
		assertEquals("2317.199", fixedDistance(fullDistance));
		assertEquals(bezierRoute.waitPoints().get(1), bezierRoute.next());

		double remainingDistance = bezierRoute.remainingDistance();
		assertEquals("2304.199", fixedDistance(remainingDistance));

		double traveledDistance = bezierRoute.traveledDistance();
		assertEquals("13.0", fixedDistance(traveledDistance));
	}

	@Test
	@DisplayName("Should successfully create 5 points Linear navigation route")
	void linearRouteTests() {
		Linear linearNavigation = new Linear();
		Route linearRoute = new Route(pointsList, linearNavigation);

		assertEquals(5, linearRoute.waitPoints().size());
	}

	private String fixedDistance(double distance){
		DecimalFormat df = new DecimalFormat("#.###");
		double formattedDistance = Double.parseDouble(df.format(distance));
		return String.valueOf(formattedDistance);
	}

}
