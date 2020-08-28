
import java.util.Scanner;

// java.lang (carregado por padrão)

public class IMC {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.println("Peso (Kg): ");
        Double peso = s.nextDouble();

        System.out.println("Altura (m): ");
        Double altura = s.nextDouble();

        Double imc = peso / (Math.pow(altura, 2));

        final Double faixa1 = 18.5; // Constante
        final Double faixa2 = 24.9; // Constante
        final Double faixa3 = 29.9; // Constante

        if (imc <= faixa1){

            System.out.println("Abaixo do peso. ");

        } else if (imc > faixa1 && imc <= faixa2){

            System.out.println("Peso normal. ");

        } else if (imc > faixa2 && imc <= faixa3){

            System.out.println("Acima do peso. ");

        } else {

            System.out.println("Obesidade. ");
        }
    }
}