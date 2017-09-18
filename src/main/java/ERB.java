public class ERB {

	private static int marcador;
	private int iD;
	private double latitude;
	private	double longitude;


	public ERB(double lat, double longi) {
		iD = marcador;
		marcador++;
		latitude = lat;
		longitude = longi;
	}

	public String toString() {
		return "ERB("+ iD +")_(" +latitude + ", "+ longitude+")";
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public int getID(){
		return iD;
	}
}
