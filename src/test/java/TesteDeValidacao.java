import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TesteDeValidacao {

    Usuario usuario = new Usuario(0,0);
    List<Balao> rede = new ArrayList<Balao>();
    List<ERB> base = new ArrayList<ERB>();

    Menu menu = new Menu(base,rede,usuario);

    @Test
    public void teste(){

        //Condições verdadeiras
        assertTrue(menu.lancarBalao(0,160000));
        assertTrue(menu.lancarBalao(0, 120000));
        assertTrue(menu.lancarBalao(0, 80000));
        assertTrue(menu.lancarBalao(0,40000));
        assertTrue(menu.cadastrarERB(0,120000));
        assertTrue(menu.cadastrarERB(0,200000));
        assertTrue(menu.removerERB(1));

        //Condições Falsas
        assertFalse(menu.cadastrarERB(0,90000));
        assertFalse(menu.lancarBalao(-50000,70000));
        assertFalse(menu.lancarBalao(140000,0));
        assertFalse(menu.lancarBalao(0, 100000));

        //Mensagem
        assertEquals("Balão(0)_(0.0, 160000.0) conectado a ERB(0)_(0.0, 120000.0)",menu.dadoBalao(0));
        assertEquals("Balão(3)_(0.0, 40000.0) e vizinho Balão(2)",menu.dadoBalao(3));
        assertEquals("Balão(3) Balão(2)", menu.enviarMensagem());
    }
}
