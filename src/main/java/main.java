import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        List<ERB> r = new ArrayList<ERB>();
        List<Balao> b = new ArrayList<Balao>();


        Usuario usuario = new Usuario(0,0);
        Menu menu = new Menu(r, b);

        Scanner ler = new Scanner(System.in);

        boolean loop = true;
        int opc;
        while (loop){

            menu.mostrar();
            opc = ler.nextInt();
            switch (opc){
                case 0:
                    loop = false;
                    break;

                case 1:
                    System.out.print("Latitude: ");
                    double lat = ler.nextDouble();
                    System.out.print("Longitude: ");
                    double lon = ler.nextDouble();

                    if(menu.cadastrarERB(lat, lon)){
                        System.out.println("Cadastrado!");
                    }else{
                        System.out.println("Erro!");
                    }
                    break;

                case 2:
                    System.out.print("ID: ");
                    int id = ler.nextInt();
                    if (menu.removerERB(id)){
                        System.out.println("removido com sucesso!");
                    }else{
                        System.out.println("Erro!");
                    }
                    break;

                case 3:
                    menu.imprimirERB();
                    break;

                case 4:
                    System.out.print("Latitude: ");
                    double lat1 = ler.nextDouble();
                    System.out.print("Longitude: ");
                    double lon1 = ler.nextDouble();

                    if(menu.lancarBalao(lat1, lon1)){
                        System.out.println("Cadastrado!");
                    }else{
                        System.out.println("Error!");
                    }
                    break;

                case 5:
                    System.out.print("ID do Balão: ");
                    int id1 = ler.nextInt();
                    System.out.println(menu.dadoBalao(id1));
                    break;

                case 6:
                    System.out.print("Distância: ");
                    double d = ler.nextDouble();
                    menu.moverBalao(d);
                    break;

                case 7:
                    menu.dadoBaloes();
                    break;

                case 8:
                    System.out.println(menu.enviarMensagem(usuario));
                    break;

                case 9:
                    System.out.println(menu.atualizar());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }




    }
}
