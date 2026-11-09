import java.util.Scanner;

public class Impressora {

    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;

    void configurarImpressora(int tipo, String modelo, String conexao, int parametro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo: ");
        tipo = sc.nextInt();
        System.out.println("Digite o modelo: ");
        modelo = sc.next();
        System.out.println("Digite a conexão: ");
        conexao = sc.next();
        System.out.println("Digite o parametro: ");
        parametro = sc.nextInt();

    }

    void abrirConexao(){
        int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);

        if(retorno == 0){
            System.out.println("Conexão com impressora OK. Retorno: " +retorno);


        }
        else{
            System.out.println("Erro ao conectar com a impressora. Retorno: " +retorno);
        }
    }
}
