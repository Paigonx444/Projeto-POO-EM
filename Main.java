import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Usuario user = new Usuario();
        Impressora impressora = new Impressora();
        Menu menu = new Menu();
        menu.menuEntrada(sc, user, impressora);


    }
}
