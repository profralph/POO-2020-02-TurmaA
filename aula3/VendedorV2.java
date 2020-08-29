
public class VendedorV2 {

    // Atributos (pertence a toda a classe)
    // aquilo que você precisa saber sobre a classe
    String nome; // objeto não incializado é nulo
    Double salarioBase = 0d;
    String endereco = "";
    Double valorVenda = 0d;
    
    // Métodos: ações que a classe executa
    // Assinatura do método: modificador de acesso; tipo de retorno; nome do método; parâmetros
    public void vender(Double valor){

        valorVenda += valor;
    }

    public Double calcularSalario(){

        Double salarioLiquido = salarioBase * 1.1;

        if (valorVenda > 10000 && valorVenda < 20000){

            salarioLiquido = salarioBase * 1.15;
        
        } else if (valorVenda > 20000){

            salarioLiquido = salarioBase * 1.2;
        }

        return salarioLiquido;
    }    

}