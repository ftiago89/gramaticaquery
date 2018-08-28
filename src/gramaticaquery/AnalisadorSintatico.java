package gramaticaquery;

import java.util.ArrayList;


public class AnalisadorSintatico {
    
    private ArrayList<Token> tokens;
    private int indice;
    private Token atual;

    public AnalisadorSintatico(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.indice = 0;
    }
    
    
    public void Analisar() throws Exception{
        nextToken();
        query();
    }
    
    private void query() throws Exception{
        if (atual.getType().equalsIgnoreCase("Variavel")){
            nextToken();
            comparador();
            numero();
            query2();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void query2() throws Exception{
        if (atual.getType().equalsIgnoreCase("Logico")){
            nextToken();
            query();
        }else{
            if (indice < tokens.size()){
                throw new Exception("Erro sintatico.");
            }
        }
    }
    
    private void comparador() throws Exception{
        if (atual.getContent().equalsIgnoreCase("=")){
            nextToken();
        }else{
            if (atual.getContent().equalsIgnoreCase("<")){
                nextToken();
                if (atual.getContent().equalsIgnoreCase("=")){
                    nextToken();
                }
            }else{
                if (atual.getContent().equalsIgnoreCase(">")){
                    nextToken();
                    if (atual.getContent().equalsIgnoreCase("=")){
                        nextToken();
                    }
                }else{
                    if (atual.getContent().equalsIgnoreCase("!")){
                        nextToken();
                        if (atual.getContent().equalsIgnoreCase("=")){
                            nextToken();
                        }else{
                            throw new Exception("Erro sintatico.");
                        }
                    }else{
                        throw new Exception("Erro sintatico.");
                    }
                }
            }
        }
    }
    
    private void numero() throws Exception{
        if ((atual.getType().equalsIgnoreCase("Inteiro")) || (atual.getType().equalsIgnoreCase("Real"))){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    
    
    
    private void nextToken(){
        if (indice < tokens.size()){
            atual = tokens.get(indice);
        }
        ++indice;
    }
    
}
