package training;

public class Training {

		private String name;
		private String subject;
		private Address address;
		private Datum date;
		
		
		//dit is voor erna wanneer de klasse boek af is
		//private Book book;
		
		public Training(String name , String subject , Address address , Datum date) {
			
			this.name = name;
			this.subject = subject;
			this.address = address;
			this.date = date;
			
			
		}

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public Address getAddress() {
			return address;
		}


		public void setAddress(Address address) {
			this.address = address;
		}


		public Datum getDate() {
			return date;
		}


		public void setDate(Datum date) {
			this.date = date;
		}
		

		//om te zien of het werkt 
		
		@Override
		public String toString() {
			return "Training [name=" + name + ", subject=" + subject + ", address=" + address + ", date=" + date + "]";
		}
		/*
		public static void main(String[] args) {
			Address javaA = new Address("Belgie","Ruisbroek","1601","Fabriekstraat",18);
			Datum javaD = new Datum(8,11,17,"16:00:00");
			Training javaT = new Training("java the beginning" , "java",javaA, javaD);
			
			System.out.println(javaT.toString());
		}
	*/
		
		
}
