import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    int opcMenu2;
    int opcMenu1;
    boolean menu1 = true;
    boolean menu2 = false;


    void menuEntrada(Scanner sc, Usuario user, Impressora impressora) {
        while (menu1) {
            System.out.println("=== IMPRESSORA ELGIN ===");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar-se");
            System.out.println("3 - Sair");



            try {
                opcMenu1 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números!");
                sc.nextLine();
                continue;
            }
            switch (opcMenu1) {

                case 1:
                    if (user.usuarioCadastrado) {
                        user.loginUsuario(sc);
                        break;
                    } else {
                        System.out.println("Ainda não há nenhum Usuário cadastrado");
                    }
                    break;

                case 2:
                    if (user.usuarioCadastrado) {
                        System.out.println("Já há um usuário cadastrado, quer cadastrar outro?");
                        String querCadastrarOutro = sc.next();
                        if (querCadastrarOutro.equalsIgnoreCase("sim")) {
                            user.cadastrarUsuario(sc);
                        }
                    } else {
                        user.cadastrarUsuario(sc);
                    }
                    break;
                case 3:
                    System.out.println("Encerrando Sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Digite um valor válido");
            }

            if (user.usuarioLogado) {
                menu2 = true;
                menuImpressora(sc, user, impressora);
                menu1 = false;
            }



        }
    }


    void menuImpressora(Scanner sc, Usuario user, Impressora impressora) {
        while (menu2) {
            System.out.println("=== MENU === \n");

            System.out.println("1 - Configurar Conexão");
            System.out.println("2 - Abrir Conexão");
            System.out.println("3 - Fechar Conexão");
            System.out.println("4 - Imprimir Texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir Código de Barras");
            System.out.println("7 - Imprimir XML Sat");
            System.out.println("8 - Imprimir XML de Cancelamento SAT");
            System.out.println("9 - Abrir Gaveta");
            System.out.println("10 - Sinal Sonoro (BIP)");
            System.out.println("Extra(11) - Avançar papel, ver status do papel...");
            System.out.println("12 - Sair");

            try {
                opcMenu2 = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números!");
                sc.nextLine();
                continue;
            }

            switch (opcMenu2) {

                case 1:
                    try {

                        System.out.println("=== CONFIGURAR IMPRESSORA ===");

                        System.out.print("Tipo: " +
                                "\n 1 = USB" +
                                "\n 2 = Serial" +
                                "\n 3 = Rede" +
                                "\n 4 = Bluetooth");
                        int tipo = sc.nextInt();
                        sc.nextLine();
                        if (tipo > 4 || tipo < 1) {
                            System.out.println("Digite um número válido!");
                            break;
                        }

                        System.out.print("Modelo (ex: i8 ou i9): ");
                        String modelo = sc.nextLine();

                        System.out.println("Conexão (ex: USB, COM2 ou IP 192.168.0.20): ");
                        String conexao = sc.nextLine();

                        System.out.println("Parâmetro (0 para USB, velocidade ou porta): ");
                        int parametro = sc.nextInt();

                        impressora.configurarImpressora(tipo, modelo, conexao, parametro);

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Tipo e Parâmetro devem ser NÚMEROS INTEIROS!");
                        continue;
                    } break;

                case 2:
                    impressora.abrirConexao();
                    break;
                case 3:
                    impressora.fecharConexao();
                    break;
                case 4:

                    if (!impressora.conexaoAberta){
                        System.out.println("Alerta: Antes de imprimir, abra conexao (opção 2)");
                        break;
                    }

                    try {
                        sc.nextLine();

                        System.out.println("=== IMPRIMIR TEXTO ===");

                        System.out.println("Digite o texto: ");
                        String dados = sc.nextLine();

                        System.out.println("Digite a posição: " +
                                "\n 0 - Esquerda" +
                                "\n 1 - Centro" +
                                "\n 2 - Direita");
                        int posicao = sc.nextInt();
                        if (posicao < 0 || posicao > 2){
                            System.out.println("Posição inválida! Digite um valor entre 0 e 2");
                            break;
                        }

                        System.out.println("Digite o estilo: " +
                                "\n 0 - Fonte A" +
                                "\n 1 - Fonte B" +
                                "\n 2 - Sublinhado" +
                                "\n 4 - Invertido" +
                                "\n 8 - Negrito (Podem ser somados)");
                        int estilo = sc.nextInt();
                        if (estilo < 0 || estilo > 15){
                            System.out.println("Estilo inválido! Digite um valor entre 0 e 15");
                            break;
                        }

                        System.out.println("Digite o tamanho:" +
                                "\n 0 - Normal" +
                                "\n 1-7 - Altura maior ");
                        int tamanho = sc.nextInt();
                        if (tamanho < 0 || tamanho > 7) {
                            System.out.println("Tamanho inválido! Digite um valor entre 0 e 7");
                            break;
                        }

                        impressora.imprimirTexto(dados, posicao, estilo, tamanho);

                    } catch(InputMismatchException e) {
                        System.out.println("Erro: Posição, estilho e tamanho precisam ser números inteiros!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 5:
                    if (!impressora.conexaoAberta){
                        System.out.println("Alerta: Antes de imprimir, abra conexao (opção 2)");
                        break;
                    }

                    try {
                        sc.nextLine();

                        System.out.println("=== IMPRIMIR QR CODE ===");

                        System.out.println("Digite o conteúdo ou o Link do QR Code: ");
                        String dados = sc.nextLine();

                        System.out.println("Digite o tamanho (1 a 6): ");
                        int tamanho = sc.nextInt();
                        if (tamanho < 1 || tamanho > 6) {
                            System.out.println("Digite um tamanho válido!");
                            break;
                        }

                        System.out.println("Digite o nível de correção (1 a 4):");
                        int nivelCorrecao = sc.nextInt();
                        if (nivelCorrecao < 1 || nivelCorrecao > 4) {
                            System.out.println("Digite um nível válido!");
                            break;
                        }
                        impressora.imprimirQRCode(dados, tamanho, nivelCorrecao);

                    } catch (InputMismatchException e){
                        System.out.println("Erro: O Tamanho e o Nível de Correção precisam ser números inteiros!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    System.out.println("Encerrando Programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite um valor válido");
            }
        }
    }
}
