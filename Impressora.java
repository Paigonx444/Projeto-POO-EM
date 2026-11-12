import java.util.Scanner;

public class Impressora {

    static int tipo;
    static String modelo;
    static String conexao;
    static int parametro;
    static boolean conexaoAberta = false;
    static boolean impressoraConfigurada = false;

    void configurarImpressora(int tipo, String modelo, String conexao, int parametro) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.conexao = conexao;
        this.parametro = parametro;
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

    void imprimirCodigoBarras(int tipo, String dados, int altura, int largura, int hri) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(tipo, dados, altura, largura, hri);

            if (retorno == 0) {
                System.out.println("Código de barras impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir código de barras. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    void imprimirXMLSAT(String dados, int param) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(dados, param);

            if (retorno == 0) {
                System.out.println("XML SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML SAT. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    void imprimirXMLCancelamentoSAT(String dados, String assQRCode, int param) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(dados, assQRCode, param);

            if (retorno == 0) {
                System.out.println("XML de Cancelamento SAT impresso com sucesso!");
            } else {
                System.out.println("Erro ao imprimir XML de Cancelamento SAT. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    void abrirGaveta(int pino, int ti, int tf) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de abrir a gaveta, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreGavetaElgin(pino, ti, tf);

            if (retorno == 0) {
                System.out.println("Comando de abrir gaveta enviado com sucesso!");
            } else {
                System.out.println("Erro ao abrir gaveta. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    void sinalSonoro(int qtd) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de abrir a gaveta, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(qtd, 50, 5);
            if (retorno == 0) {
                System.out.println("Bip!");
            } else {
                System.out.println("Erro no sinal sonoro. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }

    }
    void avancarPapel(int linhas) {
        if (!conexaoAberta) {
            System.out.println("Alerta: Antes de avançar o papel, abra a conexão (opção 2).");
            return;
        }

        try {
            int retorno = ImpressoraDLL.INSTANCE.AvancaPapel(linhas);

            if (retorno == 0) {
                System.out.println("Papel avançado com sucesso!");
            } else {
                System.out.println("Erro ao avançar o papel. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }



}
