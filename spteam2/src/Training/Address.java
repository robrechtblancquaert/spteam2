package Training;

public class Address {

	private String land;
	private String stad;
	private String postcode;
	private String straat;
	private int nummer;
	
	//een Address mag niet leeg aangemaakt worden
	public Address(String land , String stad, String postcode , String straat , int nummer) {
		
		this.land = land;
		this.stad = stad;
		this.postcode = postcode;
		this.straat = straat;
		this.nummer = nummer;
	}
	
	
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}


	@Override
	public String toString() {
		return "Address [land=" + land + ", stad=" + stad + ", postcode=" + postcode + ", straat=" + straat
				+ ", nummer=" + nummer + "]";
	}
	
	
	
	
}
