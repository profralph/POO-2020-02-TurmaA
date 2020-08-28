import java.util.Scanner;
import java.text.DecimalFormat;

public class SaqueAniversario {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.println("Saldo FGTS: ");

        double saldo = s.nextDouble();
        double valorSaque;

        if (saldo <= 500){
            
            valorSaque = saldo * 0.5;

        } else if (saldo > 500.01 && saldo <= 1000){

            valorSaque = saldo * 0.4 + 50;

        } else if (saldo >= 1000.01 && saldo <= 5000){

            valorSaque = saldo * 0.3 + 150;

        } else if (saldo >= 5000.01 && saldo <= 10000){

            valorSaque = saldo * 0.2 + 650;

        } else if (saldo >= 10000.01 && saldo <= 15000){

            valorSaque = saldo * 0.15 + 1150;

        } else if (saldo >= 15000.01 && saldo <= 20000){

            valorSaque = saldo * 0.1 + 1900;

        } else {

            valorSaque = saldo * 0.05 + 2900;
        }

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Valor do saque: "+df.format(valorSaque));
    }
}