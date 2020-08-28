public class SistemaVendas {

    public static void main(String args[]){

        // Instância: tipo; nome do objeto; classe a ser instanciada;
        // uma instância é a materialização de uma classe
        Vendedor vendedor1 = new Vendedor();
        vendedor1.salario = 1000d;
        // Invocação do método
        vendedor1.vender(100d);
        // Acesso a um atributo da classe (objeto)
        System.out.println(vendedor1.valorVenda);

        Double salario = vendedor1.calcularSalario();
        System.out.println(salario);

        // Nova instância
        Vendedor vendedor2 = new Vendedor();

        vendedor2.vender(250d);
        vendedor2.vender(320d);

        System.out.println(vendedor2.valorVenda);
    }
}
