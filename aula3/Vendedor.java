
public class Vendedor {

    // Atributos (pertence a toda a classe)
    // aquilo que você precisa saber sobre a classe
    String nome; // objeto não incializado é nulo
    Double salario = 0d;
    String endereco = "";
    Double valorVenda = 0d;
    
    // Métodos: ações que a classe executa
    // Assinatura do método: modificador de acesso; tipo de retorno; nome do método; parâmetros
    public void vender(Double valor){

        valorVenda += valor;
    }

    public Double calcularSalario(){

        return salario;
    }    

}