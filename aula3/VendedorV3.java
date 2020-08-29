
public class VendedorV3 {

    // Atributos (pertence a toda a classe)
    // aquilo que você precisa saber sobre a classe
    String nome; // objeto não incializado é nulo
    Double salarioBase = 0d;
    String endereco = "";
    Double valorVenda = 0d;
    Double salarioLiquido;
    Double salarios[] = new Double[2];
    int indiceAtual = 0;
    
    // Métodos: ações que a classe executa
    // Assinatura do método: modificador de acesso; tipo de retorno; nome do método; parâmetros
    public void vender(Double valor){

        valorVenda += valor;
    }

    public void calcularSalario(){

        salarioLiquido = salarioBase * 1.1;

        if (valorVenda > 10000 && valorVenda < 20000){

            salarioLiquido = salarioBase * 1.15;
        
        } else if (valorVenda > 20000){

            salarioLiquido = salarioBase * 1.2;
        }

        Double novoVetorSalario[] = new Double[salarios.length+1];

        if (indiceAtual == salarios.length){

            for (int i=0; i<salarios.length; i++){

                novoVetorSalario[i] = salarios[i];
            }

            // Vetor é recriado para aumentar de tamanho
            salarios = novoVetorSalario;
        }

        salarios[indiceAtual] = salarioLiquido;

        indiceAtual++;
    }

    public Double consultarSalarioAtual(){       

        return salarios[indiceAtual-1];
    }

    public void listarSalarios(){

        for (Double salarioCorrente : salarios){

            System.out.println(salarioCorrente);
        }
    }

    public Double projetarSalario(){

        Double salarioProjetado = 0d;

        for (Double salarioCorrente : salarios){

            salarioProjetado += salarioCorrente;
        }

        return salarioProjetado / salarios.length;
    }

}