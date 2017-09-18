public class ERB {

	private static int marcador;
	private int iD;
	private double latitude;
	private	double longitude;


	/**
	 * Cria Estação de Rádio Base
	 * @param lat insere sua latitude
	 * @param longi insere sua longitude
	 */
	public ERB(double lat, double longi) {
		iD = marcador;
		marcador++;
		latitude = lat;
		longitude = longi;
	}

	/**
	 * Obtém informações da ERB
	 * @return (ID)(Latitude, Longitude)
	 */
	public String toString() {
		return "ERB("+ iD +")_(" +latitude + ", "+ longitude+")";
	}

	/**
	 * Obtém a latitude
	 * @return Latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Obtém a longitude
	 * @return Longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Obtém o ID
	 * @return ID
	 */
	public int getID(){
		return iD;
	}
}
