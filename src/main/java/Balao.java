import sun.reflect.annotation.TypeAnnotation;

import javax.xml.stream.Location;
import java.util.LinkedList;
import java.util.List;

public class Balao {

	private static int identificador;
	private int iD;

	private  double latitude;
	private  double longitidue;

	private LinkedList<ERB> list;

	private boolean upLink;

	private int vizinho;

	public Balao(double lat, double longi, LinkedList<ERB> l){
		iD = identificador;
		identificador++;
		if(identificador>1) vizinho = identificador -1;
		latitude = lat;
		longitidue = longi;

		list = l;



	}

	public String toString() {
		return  list.get(0).toString();
	}

	public void movimentacao(String novaPosicao) {

	}

	public boolean sendMenssage(String posicao) {
		return false;
	}

}
