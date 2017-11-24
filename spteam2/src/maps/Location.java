package maps;

import org.json.JSONArray;
import org.json.JSONObject;

public class Location {
	public static enum Addresskey {STREET_NUMBER, ROUTE, LOCALITY, COUNTRY, POSTAL_CODE};
	private String address;
	private JSONObject jsonAddress;
	
	public void formatAddress() {
		if (address == null) return;
		this.address = LocationApi.getJsonAddress(address).getJSONArray("results").getJSONObject(0).getString("formatted_address");
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String get(Addresskey key) {
		if(address == null) return null;
		if(jsonAddress == null) jsonAddress = LocationApi.getJsonAddress(address);
		
		JSONObject result = jsonAddress.getJSONArray("results").getJSONObject(0);
		JSONArray components = result.getJSONArray("address_components");
		for(int i = 0; i < components.length(); i++) {
			JSONObject o = components.getJSONObject(i);
			JSONArray types = o.getJSONArray("types");
			for(int j = 0; j < types.length(); j++) {
				if(types.getString(j).equals(key.toString().toLowerCase())) {
					return o.getString("long_name");
				}
			}
		}
		return null;
	}
	
	public void set(Addresskey key, String value) {
		if(address == null) return;
		if(jsonAddress == null) jsonAddress = LocationApi.getJsonAddress(address);
		
		String toReplace = null;
		
		JSONObject result = jsonAddress.getJSONArray("results").getJSONObject(0);
		JSONArray components = result.getJSONArray("address_components");
		for(int i = 0; i < components.length(); i++) {
			JSONObject o = components.getJSONObject(i);
			JSONArray types = o.getJSONArray("types");
			for(int j = 0; j < types.length(); j++) {
				if(types.getString(j).equals(key.toString().toLowerCase())) {
					toReplace = o.getString("long_name");
				} 
			}
		}
		if(toReplace != null) {
			if(address.contains(" " + toReplace + " ") || address.contains(" " + toReplace + ",")) {
				toReplace = " " + toReplace + ",";
				address = address.replaceFirst(toReplace, value);
				toReplace = toReplace.substring(0, toReplace.length() - 2);
				toReplace = " " + toReplace + " ";
				address = address.replaceFirst(toReplace, value);
			}
			else {
				address += " " + key.toString().toLowerCase() + " " + value;
			}
		}
	}
	
	public static void main(String[] args0) {
		String address = "Laarbeeklaan 119 Jette";
		System.out.println(LocationApi.getJsonAddress(address).toString());
		Location l = new Location();
		l.address = address;
		l.formatAddress();
		System.out.println(l.address);
		System.out.println(l.get(Addresskey.STREET_NUMBER));
		l.set(Addresskey.STREET_NUMBER, "15");
		l.formatAddress();
		System.out.println(l.address);
	}

	@Override
	public String toString() {
		return address;
	}
}
