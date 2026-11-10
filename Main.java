import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        boolean usuarioCadastrado = false;

        Scanner sc = new Scanner(System.in);

        if (usuarioCadastrado == false) {
            Login cadastro = new Login();
            cadastro.cadastrarUsuario(sc);
        }
    }
}
