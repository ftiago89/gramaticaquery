package gramaticaquery;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    
    public static void main(String[] args){
        ArrayList<Token> tokens = new ArrayList<>();
        AnalisadorSintatico analisador;
        
        //A entrada para o analisador sintatico é a query: Velocidade > 20 & Temperatura < 30.5
        
        tokens.add(new Token("Velocidade", "Variavel"));
        tokens.add(new Token(">", ""));
        tokens.add(new Token("20", "Inteiro"));
        tokens.add(new Token("&", "Logico"));
        tokens.add(new Token("Temperatura", "Variavel"));
        
        tokens.add(new Token("<", ""));
        tokens.add(new Token("30.5", "Real"));
        
        analisador = new AnalisadorSintatico(tokens);
        
        try {
            analisador.Analisar();
        } catch (Exception ex) {
            System.err.println("Erro Sintatico.");
        }
    }
    
}
