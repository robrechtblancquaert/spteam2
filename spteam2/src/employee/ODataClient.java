package employee;

import org.odata4j.consumer.ODataClientRequest;
import org.odata4j.exceptions.ODataProducerException;

public interface ODataClient {

	ODataclientrespons callfunction(ODataClientRequest request) 
		throws ODataProducerException;
	
}
