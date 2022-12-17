import Edycja.*;
import Edycja.RodzajeEdycjii.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data wyraz = new Data("Hello java");
        EdytorStringa edytor = new EdytorStringa(new DuzeLitery());

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Wyswietl dane");
            System.out.println("2. Zmien dane");
            System.out.println("3. Wybierz sposob wyswietlania danych");
            System.out.println("4. Zakoncz program");
            System.out.print("Wybierz opcje: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    wyraz.display();
                    break;
                case 2:
                    System.out.print("Wpisz nowy wyraz:");
                    String nowyWyraz = (new Scanner(System.in)).nextLine();
                    wyraz.setData(nowyWyraz);
                    break;
                case 3:
                    boolean wyjdz=true;
                    while (wyjdz){
                        System.out.println("Menu wyswietlania:");
                        System.out.println("1. Tylko male litery");
                        System.out.println("2. Tylko duze litery");
                        System.out.println("3. Podziel");
                        System.out.println("4. Scal");
                        System.out.println("5. Wstaw wybrany znak miedzy litery");
                        System.out.print("Wybierz opcje: ");
                        int opcja2 = scanner.nextInt();
                    switch (opcja2) {
                        case 1 -> {
                            edytor.setRodzajEdycji(new MaleLitery());
                            edytor.edytuj(wyraz);
                            wyjdz = false;
                        }
                        case 2 -> {
                            edytor.setRodzajEdycji(new DuzeLitery());
                            edytor.edytuj(wyraz);
                            wyjdz = false;
                        }
                        case 3 -> {
                            edytor.setRodzajEdycji(new RozdzielLitery());
                            edytor.edytuj(wyraz);
                            wyjdz = false;
                        }
                        case 4 -> {
                            edytor.setRodzajEdycji(new ScalLitery());
                            edytor.edytuj(wyraz);
                            wyjdz=false;
                        }
                        case 5 -> {
                            edytor.setRodzajEdycji(new WstawMiedzyLitery());
                            edytor.edytuj(wyraz);
                            wyjdz = false;
                        }
                        default -> System.out.println("Nieprawidlowa opcja.");
                    }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nieprawidlowa opcja.");
            }
        }
    }
}
