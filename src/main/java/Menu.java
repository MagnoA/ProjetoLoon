import java.util.List;
import java.util.Scanner;

public class Menu {

	private static int marcadorBalao;
	private static int marcadorERB;

	private List<Balao> rede;
	private List<ERB> base;

	private Calculo calc;

	public Menu(List<ERB> radios, List<Balao> baloes) {

		rede = baloes;
		base = radios;
		calc = new Calculo();
	}

	public void mostrar(){
		System.out.println(
				"(1) Cadastrar Estação de Rádio Base\n" +
				"(2) Remover Estação de Rádio Base\n"+
				"(3) Dados de todas Estação de Rádio Base\n"+
				"(4) Lançar Balão\n"+
				"(5) Informação sobre Balão\n"+
				"(6) Mover Balões\n"+
				"(7) Dados de todos Balões\n"+
				"(8) Enviar mensagem\n"+
				"(9) Atualizar\n" +
				"(0) Sair"
		);

	}

	public boolean cadastrarERB(double lat, double lon){

		ERB radio = new ERB(lat, lon);

		int tamanhoAnterior = base.size();

		if(tamanhoAnterior > 0 && calc.calcular(radio, base.get(tamanhoAnterior-1)) < 40000){
			System.out.println("Distância entre seu vizinho é maior que 40km");
			return false;
		}

		base.add(radio);

		if(base.size() > tamanhoAnterior){
			System.out.println(radio.toString());
			return true;
		}
		else {return false;}
	}

	public boolean removerERB(int iD) {
		if(iD > base.size() + 1) return false;

		int r=0;
		if(base.size() == 0) return false;
		while(base.get(r).getID() != iD && r < base.size()-1){
			r++;
		}

		if(r < base.size()-1){
			System.out.println(base.remove(r).toString());
			return true;
		}
		else{ return false;}
	}

	public void imprimirERB() {

		System.out.println(base.toString());
	}

	public boolean lancarBalao(double lat, double lon){

		int tamanhoAnterior = rede.size();

		if(tamanhoAnterior == 0) {
			Balao balao = new Balao(lat, lon);
			rede.add(balao);

		}else{
			Balao balao = new Balao(lat, lon, rede.get(tamanhoAnterior - 1));
			rede.add(balao);

			if (calc.calcular(balao, rede.get(tamanhoAnterior)) > 40000) {
				System.out.println("Distância entre seu vizinho é maior que 40km");
				return false;
			}
		}

		int contador = 0;
		while (contador < base.size()) {
			if (calc.calcular(rede.get(tamanhoAnterior), base.get(contador)) <= 40000){
				rede.get(tamanhoAnterior).conectar(base.get(contador));
			}
			contador++;
		}


		if(rede.size() > tamanhoAnterior){
			System.out.println(rede.get(tamanhoAnterior).toString());
			return  true;
		}
		else{return false;}
	}

	public String dadoBalao(int id){
		if(id > rede.size()+1 || rede.size() == 0) return "Inválido";

		return rede.get(id).toString();
	}

	public void moverBalao(double lon) {

		for(int cont=0; cont < rede.size(); cont++){
			rede.get(cont).move(lon);
		}
	}

	public void  dadoBaloes(){
		System.out.println(rede.toString());
	}

	public String enviarMensagem(Usuario user) {
		if(rede.size() == 0) return "Rede indisponível";

		int contador = 0;
		double distancia = calc.calcular(user, rede.get(contador));
		double comp;


		while(contador < rede.size()){
			comp = calc.calcular(user, rede.get(contador));
			if(distancia > comp){
				distancia = comp;
			}
			contador++;
		}

		if(distancia > 40000) return "Rede indisponível";

		return rede.get(0).sendMenssage();
	}

	public String atualizar(){
		int contBalao = 0;
		int contRadio = 0;

		while (contBalao < rede.size()){
			while(contRadio < base.size()){
				if(calc.calcular(rede.get(contBalao), base.get(contRadio)) < 40000){
					rede.get(contBalao).conectar(base.get(contRadio));
				}
				contRadio++;
			}
			contBalao++;
		}

		return "Rede atualizada!";
	}

	public int sair() {
		return 0;
	}

}
