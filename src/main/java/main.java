import java.util.LinkedList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        ERB erb1 = new ERB(1.22222, -1.22344);
        ERB erb2 = new ERB(123, 122.122);
        ERB erb3 = new ERB(-111122, 22131);

        LinkedList<ERB> l1 = new LinkedList<ERB>();
        l1.add(erb1);
        l1.add(erb2);
        l1.add(erb3);
        Balao b1 = new Balao(12222, -22122, l1);

        System.out.println(l1.get(2).toString());

        System.out.println(b1.toString());
    }
}
