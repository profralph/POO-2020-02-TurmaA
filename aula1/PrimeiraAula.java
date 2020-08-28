

/* 
    Comentário de bloco
*/

// Nome do arquivo: PrimeiraAula.java
public class PrimeiraAula {

    public static void main(String args[]){

        //System.out.print("Primeira Aula !");

        // Todo tipo de variável que começa com letra minúscula é uma primitva

        // Declaração e atribuição
        int abc = 0;

        int x = abc + 2;

        double y = 1.3; // valor literal sempre é double (8 bytes na memória)
        float z = 1.9f; // float (4 bytes na memória)

        boolean ab = true; //1 byte em memória

        System.out.print("Valor: "+y);

        if (x > 0){

            System.out.print("É maior que zero");

        } else if (x > -2) {

            System.out.print("É maior que -2");

        } else {
            
            System.out.print("Fim.");
        }
    }
}