public class Balao {

	private static int marcador;
	private int iD;

	private  double latitude;
	private  double longitude;

	private ERB erb;
	private  boolean upLink;

	private Balao vizinho;

	public Balao(double lat, double longi){

		iD = marcador;
		latitude = lat;
		longitude = longi;
		marcador++;
	}

	public Balao(double lat, double longi, Balao b){
		iD = marcador;
		latitude = lat;
		longitude = longi;
		vizinho = b;
		marcador++;
	}

	public String toString() {
		String info = "Balão(" + iD + ")_(" + latitude +", "+ longitude +")";
		if(upLink) info = info + " conectado a ERB "+ erb.toString();
		if(iD >= 1) return info + " e vizinho Balão("+vizinho.getiD()+")";
		else
		return info;
	}

	public double getLatitude(){
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void move(double novaLongitude) {

		longitude += novaLongitude;
	}

	public String sendMenssage() {
		if(upLink){
			return this.toString();
		}
		else{
			//System.out.println(this.toString());
			if(vizinho != null) return " "+ vizinho.sendMenssage();
			else return "Sem rede";
		}
	}

	public int getiD(){
		return iD;
	}

	public void conectar(ERB base){
		erb = base;
		upLink = true;
	}

	public boolean coneccaoInfo(){return upLink;}
}
