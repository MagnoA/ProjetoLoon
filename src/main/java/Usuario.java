public class Usuario {

	private double latitude;

	private double longitude;

	private boolean conexao;

	Balao balao;

	/**
	 * Informações sobre o usuário no momento em que o programa é executado
	 * @param lat latitude
	 * @param lon longitude
	 */
	public Usuario(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	/**
	 * Conecta o usuário a um balão próximo
	 * @param balao bação a ser conectado
	 */
	public void setConexao(Balao balao) {
		conexao = true;
		this.balao = balao;
	}

	/**
	 * Verifica se o usuário está conectado na rede
	 * @return conexão
	 */
	public boolean isConexao() {
		return conexao;
	}

	public Balao getBalao() {
		return balao;
	}
}
