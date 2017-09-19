public class Balao {

	private static int marcador;
	private int iD;

	private double latitude;
	private double longitude;

	private ERB erb;
	private boolean upLink;

	private Balao vizinho;

	/**
	 * Cria um balão sem vizinho
	 * @param lat latitude em valor absoluto
	 * @param longi longitude em valor absoluto
	 */
	public Balao(double lat, double longi) {

		iD = marcador;
		latitude = lat;
		longitude = longi;
		marcador++;
	}

	/**
	 * Adiciona ao balão um vizinho
	 * @param vizinho vizinho correspondente
	 */
	public void setVizinho(Balao vizinho) {
		this.vizinho = vizinho;
	}

	/**
	 * Mostra todas informações de um balão bem com de seu viziho
	 * @return informações
	 */
	public String toString() {
		String info = "Balão(" + iD + ")_(" + latitude + ", " + longitude + ")";
		if (upLink) info = info + " conectado a " + erb.toString();
		if (iD >= 1) return info + " e vizinho Balão(" + vizinho.getiD() + ")";
		else
			return info;
	}

	/**
	 * Informa o falor da latitude
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Informa o valor da longitude
	 * @return Longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Movimenta de um ponto A ao um ponto B
	 * @param novaLongitude distância percorrida
	 */
	public void move(double novaLongitude) {

		longitude += novaLongitude;
	}

	/**
	 * Envia a uma rádio base uma mensagem e retorna o caminho por onde ela caminhou
	 * @return Balões por onde a mensagem passou
	 */
	public String sendMenssage() {
		if (upLink) {
			return "Balão("+iD+")";
		} else {
			System.out.println(toString());
			if (vizinho != null) return "Balão("+iD+") "+vizinho.sendMenssage();
			else return "Falha na conexão";
		}
	}

	/**
	 * Informa o ID do balçao
	 * @return ID
	 */
	public int getiD() {
		return iD;
	}

	/**
	 * Conecta o balão a uma estação de rádio base que está a menos de 40km de distância
	 * @param base Estação de Radio Base(ERB) a menos de 40km
	 */
	public void conectar(ERB base) {
		erb = base;
		upLink = true;
	}

	/**
	 * Informa se o balão estã conectado a uma ERB
	 * @return upLink
	 */
	public boolean conectado() {
		return upLink;
	}

	/**
	 * Obtem informações da ERB em que está conectada
	 * @return erb
	 */
	public ERB radioInfo(){
		return erb;
	}

	/**
	 * Rompe a conexão se o balão se distanciar de uma ERB por mais de 40km ou se a ERB for excluída
	 * @return informação do balão que perdeu a conexão
	 */
	public String desconectar(){
		upLink = false;
		return this.toString() + " perdeu conexão com " + erb.toString();
	}
}
