import java.util.Scanner;

public class Usuario {

    String nomeUsuario;
    String senhaUsuario;
    String nomeLoginUsuario;
    String senhaLoginUsuario;

    boolean usuarioCadastrado = false;
    boolean usuarioLogado = false;

    void cadastrarUsuario (Scanner sc) {

        System.out.println("Digite o nome de Usuário desejado: ");
        sc.nextLine();
        nomeUsuario = sc.nextLine();
        System.out.println("Digite a senha desejada: ");
        senhaUsuario = sc.nextLine();

        System.out.println("Usuário cadastrado com sucesso!");

        usuarioCadastrado = true;
    }

    void loginUsuario (Scanner sc) {

        int Tentativas = 0;
        while (Tentativas < 3) {

            System.out.println("Digite o nome de usuário: ");
            sc.nextLine();
            nomeLoginUsuario = sc.nextLine();
            System.out.println("Digite a senha desejada: ");
            senhaLoginUsuario = sc.nextLine();

            if (nomeLoginUsuario.equals(nomeUsuario)  && senhaLoginUsuario.equals(senhaUsuario)) {

                System.out.println("Login efetuado com sucesso!");

                usuarioLogado = true;
                break;
            }
            Tentativas++;
        }
    }
}
