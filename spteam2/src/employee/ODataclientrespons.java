package employee;

import javax.ws.rs.core.MultivaluedMap;

public interface ODataclientrespons {
	
void close();
MultivaluedMap<String, String> getHeaders();
}
