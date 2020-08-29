
public class SistemaVendasV3 {

    public static void main(String args[]){

        // Instância: tipo; nome do objeto; classe a ser instanciada;
        // uma instância é a materialização de uma classe
        VendedorV3 vendedor1 = new VendedorV3();
        vendedor1.nome = "Ana Maria";
        vendedor1.salarioBase = 1000d;
        // Invocação do método
        vendedor1.vender(100d);
        vendedor1.vender(10000d);

        vendedor1.calcularSalario();

        vendedor1.vender(20000d);

        //System.out.println(vendedor1.consultarSalarioAtual());

        vendedor1.calcularSalario();

        vendedor1.calcularSalario();
        
        //System.out.println(vendedor1.consultarSalarioAtual());

        vendedor1.listarSalarios();

        System.out.println(vendedor1.projetarSalario());
    }
}
