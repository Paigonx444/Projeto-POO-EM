import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean menu1 = true;
        boolean menu2 = false;
        Usuario user = new Usuario();

        while(menu1) {

            System.out.println("=== IMPRESSORA ELGIN ===");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar-se");

            int opcMenu1 = sc.nextInt();

            switch (opcMenu1) {

                case 1:
                    if (user.usuarioCadastrado) {
                        user.loginUsuario(sc);
                        break;
                    }
                    else {
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
                    }
                    else {
                        user.cadastrarUsuario(sc);
                    }
                    break;

                default:
                    System.out.println("Digite um valor válido");
            }

            if (user.usuarioLogado) {
                menu2 = true;
                menu1 = false;
            }

        }

        if (menu2) {
            Menu menu = new Menu();
            menu.menuImpressora(sc);
        }


    }
}
