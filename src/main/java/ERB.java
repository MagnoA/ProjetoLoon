public class ERB {

	private static int identificador;
	private int iD;
	private double latitude;
	private	double longitude;

	public ERB(double lat, double longi) {
		iD = identificador;
		identificador++;
		latitude = lat;
		longitude = longi;
	}

	public String toString() {
		return "ERB"+ iD +" (" +latitude + ","+ longitude+")";
	}
}
