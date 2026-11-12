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
            System.out.println("11 - Avançar papel (Extra)");
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
                                "\n 4 = Bluetooth\n");
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
                        sc.nextLine();
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

                        impressora.imprimirTexto(dados);

                    } catch(InputMismatchException e) {
                        System.out.println("Erro: Você fez miraculosidades parabéns!");
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

                        impressora.imprimirQRCode(dados);

                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você fez miraculosidades parabéns!");
                        sc.nextLine();
                        continue;
                    }
                    break;

                case 6:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Conexão fechada! Abra conexão (opção 2)");
                        break;
                    }
                    try {
                        System.out.println("=== IMPRIMIR CÓDIGO DE BARRAS ===");

                        sc.nextLine();
                        System.out.print("Digite os dados do código de barras: ");
                        String dados = sc.nextLine();

                        impressora.imprimirCodigoBarras(tipo,dados, altura, largura, hri);

                    }catch (InputMismatchException e) {
                        System.out.println("Erro: Tipo, altura, largura e HRI precisam ser números inteiros!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 7:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
                        break;
                    }
                    try {
                        sc.nextLine(); // Limpa o ENTER deixado pela escolha do menu

                        System.out.println("=== IMPRIMIR XML SAT ===");

                        impressora.imprimirXMLSAT();

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: O parâmetro precisa ser um número inteiro!");
                        sc.nextLine();
                        continue;
                    }

                    break;
                case 8:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Antes de imprimir, abra a conexão (opção 2).");
                        break;
                    }

                    try {
                        sc.nextLine(); // Limpa o ENTER deixado pela escolha do menu

                        System.out.println("=== IMPRIMIR XML DE CANCELAMENTO SAT ===");

                        System.out.print("Digite o conteúdo XML de cancelamento: ");
                        String dados = sc.nextLine();

                        System.out.print("Digite a assinatura do QR Code do cupom original: ");
                        String assQRCode = sc.nextLine();

                        System.out.print("Digite o parâmetro de impressão (0 - Padrão): ");
                        int param = sc.nextInt();
                        if (param < 0) {
                            System.out.println("Parâmetro inválido! Digite um valor maior ou igual a 0.");
                            break;
                        }

                        impressora.imprimirXMLCancelamentoSAT(dados, assQRCode, param);

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: O parâmetro precisa ser um número inteiro!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 9:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Antes de abrir a gaveta, abra a conexão (opção 2).");
                        break;
                    }

                    try {
                        System.out.println("=== ABRIR GAVETA === ");

                        System.out.println("Digite o pino (0 ou 1): ");
                        int pino = sc.nextInt();
                        if (pino < 0 || pino > 1) {
                            System.out.println("Digite um pino válido!");
                            break;
                        }

                        System.out.println("Digite o ti (1 a 255): ");
                        int ti = sc.nextInt();

                        if (ti < 1 || ti > 255) {
                            System.out.println("Digite um ti válido!");
                            break;
                        }

                        System.out.println("Digite o tf (1 a 255): ");
                        int tf = sc.nextInt();

                        if (tf < 1 || tf > 255) {
                            System.out.println("Digite um tf válido!");
                            break;
                        }

                        impressora.abrirGaveta(pino, ti, tf);
                    }catch(InputMismatchException e) {
                        System.out.println("Erro: TODOS PRECISAM SER NÚMEROS INTEIROS!!!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 10:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Antes de emitir sinal sonoro, abra a conexão (opção 2).");
                        break;
                    }
                    try {
                        System.out.println("=== EMITIR SINAL SONORO (BIP) ===");

                        System.out.print("Quantidade de bipes (ex: 1 a 10): ");
                        int qtd = sc.nextInt();
                        if (qtd < 1 || qtd > 63) {
                            System.out.println("Quantidade inválida! Digite um valor entre 1 e 63.");
                            break;
                        }
                        impressora.sinalSonoro(qtd);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: A quantidade deve ser um número inteiro");
                        sc.nextLine();
                        continue;

                }
                    break;
                case 11:
                    if (!impressora.conexaoAberta) {
                        System.out.println("Alerta: Antes de avançar o papel, abra a conexão (opção 2).");
                        break;
                    }
                    try {
                        System.out.println("=== AVANÇAR PAPEL ===");

                        System.out.print("Digite a quantidade de linhas para avançar (1 a 255): ");
                        int linhas = sc.nextInt();
                        if (linhas < 1 || linhas > 255) {
                            System.out.println("Quantidade inválida! Digite um valor entre 1 e 255.");
                            break;
                        }

                        impressora.avancarPapel(linhas);

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: A quantidade de linhas precisa ser um número inteiro!");
                        sc.nextLine();
                        continue;
                    }
                    break;
                case 12:
                    if (impressora.conexaoAberta) {
                        impressora.fecharConexao();
                    }
                    System.out.println("Encerrando Programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite um valor válido");
            }
        }
    }
}
