package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

import java.util.Scanner;

public class WstawMiedzyLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        char[] litery = plik.getData().toCharArray();
        plik.setData("");
        System.out.print("Wybierz znak ktory dodac pomiedzy litery:");
        String znak = (new Scanner(System.in)).nextLine();
        for (char letter : litery) plik.setData(plik.getData() + letter + znak);
    }
}
