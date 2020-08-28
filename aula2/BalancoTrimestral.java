

public class BalancoTrimestral {

    public static void main(String[] args) {
        
        // Declaração (primitivo)
        double meses[];

        // Instaciação (criação)
        meses = new double[3];

        meses[0] = 17000.0; // literal
        meses[1] = 23500.23;
        meses[2] = 15234.15;

        double total = 0;

        // System.out.print("Tam "+meses.length);

        // Loop tradicional (três blocos)
        for (int i=0; i<meses.length; i++){
            
            total += meses[i];
        }

        total = 0;

        // System.out.print("Total "+total);

        // For each
        for (double val : meses){

            total += val;
        }

        System.out.print("Total "+total);
    }
}