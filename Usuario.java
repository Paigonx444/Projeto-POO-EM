import java.util.Scanner;

public class Usuario {

    String nomeUsuario;
    String senhaUsuario;

    boolean usuarioCadastrado = false;
    boolean usuarioLogado = false;

    void cadastrarUsuario (Scanner sc) {

        System.out.println("Digite o nome de Usuário desejado: ");
        sc.nextLine();
        nomeUsuario = sc.next();
        System.out.println("Digite a senha desejada: ");
        senhaUsuario = sc.next();

        System.out.println("Usuário cadastrado com sucesso!");

        usuarioCadastrado = true;
    }

    void loginUsuario (Scanner sc) {

        int Tentativas = 3;
        while (Tentativas > 0) {

            System.out.println("Digite o nome de usuário: ");
            sc.nextLine();
            String nomeLoginUsuario = sc.next();
            System.out.println("Digite a senha desejada: ");
            String senhaLoginUsuario = sc.next();

            if (nomeLoginUsuario.equals(nomeUsuario)  && senhaLoginUsuario.equals(senhaUsuario)) {

                System.out.println("Login efetuado com sucesso!");

                usuarioLogado = true;
                break;
            }
            else {
                System.out.println("Credenciais incorretas! Restam "+ (Tentativas-1) +" tentativas !");
            }
            if (Tentativas == 1) {
                System.out.println("Limite de tentativas atingido! Encerrando Programa...");
                System.exit(0);
            }
            Tentativas--;
        }

    }
}
