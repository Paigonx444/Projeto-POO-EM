import java.util.Scanner;

public class Impressora {

    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    static boolean conexaoAberta = false;
    static boolean impressoraConfigurada = false;

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
        System.out.println("Configuração da Impressora realizada com sucesso!");

        impressoraConfigurada = true;
    }

    void abrirConexao() {
        if (!impressoraConfigurada){
            System.out.println("Antes de Abrir Conexão configure a conexão (opção 1)");
            return;
        }
        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);

            if (retorno == 0) {
                conexaoAberta = true;
            } else {
                System.out.println("Erro ao abrir. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    void fecharConexao(){
        if(!conexaoAberta){
            System.out.println("Alerta: A conexão já está fechada.");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

            if (retorno == 0){
                conexaoAberta = false;
                System.out.println("Conexão fechada com sucesso!");
            }
            else {
                System.out.println("Erro ao fechar conexão. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }
    void imprimirTexto(String dados, int posicao, int estilo, int tamanho){
        if (!conexaoAberta){
            System.out.println("Alerta: Antes de imprimir, abra conexao (opção 2)");
            return;
        }
        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(dados, posicao, estilo, tamanho);

            if (retorno >= 0){
                System.out.println("Texto impresso com sucesso! ( Bytes: "+ retorno +" )");
            }
            else{
                System.out.println("Erro ao imprimir o texto. Código: " + retorno);
            }
        }catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: "+ e.getMessage());
        }

    }

    void imprimirQRCode(String dados, int tamanho, int nivelCorrecao) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(dados, tamanho, nivelCorrecao);

            if (retorno == 0) {
                System.out.println("Impressão de QR Code realizada com sucesso!");
            } else {
                System.out.println("Falha ao imprimir QR Code . Código: "+ retorno);
            }
        }catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: "+ e.getMessage());
        }
    }

    void sinalSonoro(int quantidade) {
        int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(quantidade, 50, 5);  if (retorno == 0) {
            System.out.println("Bip!");
        } else {
            System.out.println("Erro no sinal sonoro. Código: " + retorno);  }
    }



}
