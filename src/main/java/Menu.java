import java.util.List;
import java.util.Scanner;

public class Menu {

	private Usuario usuario;
	private List<Balao> rede;
	private List<ERB> base;

	private Calculo calc;

	/**
	 * Obtém todas informaçẽs necessárias para a conexão do usuário
	 * @param radios Lista de todas as rádios contida na rede, denominada base
	 * @param baloes Lista de todos os balões lançados, denominada rede
	 * @param user usuário final
	 */
	public Menu(List<ERB> radios, List<Balao> baloes, Usuario user) {

		rede = baloes;
		base = radios;
		usuario = user;
		calc = new Calculo();
	}

	/**
	 * Dispõe, de maneira organizada, todas opções possíveis para acessar o menu
	 */
	public void mostrar() {
		System.out.println(
				"(1) Cadastrar Estação de Rádio Base\n" +
						"(2) Remover Estação de Rádio Base\n" +
						"(3) Dados de todas Estação de Rádio Base\n" +
						"(4) Lançar Balão\n" +
						"(5) Informação sobre Balão\n" +
						"(6) Mover Balões\n" +
						"(7) Dados de todos Balões\n" +
						"(8) Enviar mensagem\n" +
						"(0) Sair"
		);

	}

	public boolean cadastrarERB(double lat, double lon) {

		ERB radio = new ERB(lat, lon);

		int tamanhoAnterior = base.size();

		if (tamanhoAnterior > 0 && calc.calcular(radio, base.get(tamanhoAnterior - 1)) < 40000) {
			System.out.println("Distância entre seu vizinho deve ser maior que 40km");
			return false;
		}

		base.add(radio);
		System.out.println(this.atualizar());

		return base.size() > tamanhoAnterior;
	}

	public boolean removerERB(int iD) {
		if (iD >= base.size()) return false;

		int r = 0;
		if (base.size() == 0) return false;
		while (base.get(r).getID() != iD && r < base.size()) {
			r++;
		}

		int cont = 0;
		while (cont < rede.size()) {
			if (rede.get(r).conectado()) {
				if (rede.get(r).radioInfo().getID() == iD) {
					System.out.println(rede.get(r).desconectar());
				}
			}

			cont++;
		}

		System.out.println(base.remove(r).toString()+ " Excluída");
		this.atualizar();
		return r == base.size();

	}

	public void imprimirERB() {

		System.out.println(base.toString());
	}

	public boolean lancarBalao(double lat, double lon) {

		int tamanhoAnterior = rede.size();

		if (tamanhoAnterior == 0) {
			Balao balao = new Balao(lat, lon);
			rede.add(balao);

		} else{
			Balao balao = new Balao(lat, lon);
			if (calc.calcular(balao, rede.get(tamanhoAnterior-1)) > 40000) {
				System.out.println("Distância entre seu vizinho é maior que 40km");
				return false;
			}
			balao.setVizinho(rede.get(tamanhoAnterior-1));
			rede.add(balao);

		}

		System.out.println(this.atualizar());

		return rede.size() > tamanhoAnterior;
	}

	public String dadoBalao(int id) {
		if (id > rede.size() + 1 || rede.size() == 0) return "Inválido";

		return rede.get(id).toString();
	}

	public void moverBalao(double lon) {

		for (int cont = 0; cont < rede.size(); cont++) {
			rede.get(cont).move(lon);
		}

		this.atualizar();
	}

	public void dadoBaloes() {
		System.out.println(rede.toString());
	}

	public String enviarMensagem() {
		if (rede.size() == 0 || !usuario.isConexao()) return "Rede indisponível";

		return rede.get(usuario.getBalao().getiD()).sendMenssage();
	}

	/**
	 * A cada alteração feita pelo usuário, as informações sobre a rede são atualizadas
	 * @return atualização
	 */
	public String atualizar() {
		int contBalao = 0;
		int contRadio = 0;

		/*Verifica em todos os balões e em todas ERBs se há alguma conexão possível de fazer
		*Em seguida, virifica se foi perdida alguma conexão
		*/
		while (contBalao < rede.size()) {
			while (contRadio < base.size()) {
				if (calc.calcular(rede.get(contBalao), base.get(contRadio)) <= 40000) {
					if(rede.get(contBalao).conectado()) break;
					rede.get(contBalao).conectar(base.get(contRadio));
					System.out.println("Conexão estabelicida entre o Balão(" +
							rede.get(contBalao).getiD() + ") e ERB(" + base.get(contRadio).getID()+")");
				}else{
					if(rede.get(contBalao).conectado() && rede.get(contBalao).radioInfo().getID() == contRadio){
						System.out.println(rede.get(contBalao).desconectar());
					}
				}

				contRadio++;
			}
			contRadio = 0;
			contBalao++;
		}

		contBalao = 0;

		double comp;
		if(rede.size() > 0) {
			comp = calc.calcular(usuario, rede.get(contBalao));

			//Conecta o usuário ao balão mais proximo
			while (contBalao < rede.size()) {
				if (comp > calc.calcular(usuario, rede.get(contBalao)) && calc.calcular(usuario, rede.get(contBalao)) <= 40000) {
					usuario.setConexao(rede.get(contBalao));
				}
				contBalao++;
			}
		}
		return "Rede atualizada";
	}

}