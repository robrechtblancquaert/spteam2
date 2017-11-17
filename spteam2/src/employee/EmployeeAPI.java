package employee;

import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.ODataConsumers;
import org.odata4j.core.OEntity;

public class EmployeeAPI{

	   
	public static void main(String[] args) {
	
		String serviceUrl = "http://services.odata.org/V4/(S(ykcab0l02qbs3euppy5louci))/TripPinServiceRW/People\r\n" + 
				"";
		ODataConsumer consumer = ODataConsumers.create(serviceUrl);

		// list category names
		for (OEntity category : consumer.getEntities("Categories").execute()) {
		  String categoryName = category.getProperty("Name", String.class).getValue();
		  System.out.println("Category name: " + categoryName);
		}
		// TODO Auto-generated method stub
		// Test conection
		// Haal een employee uit de DB
	}
}
