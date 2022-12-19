package Edycja.RodzajeEdycjii;
import java.lang.*;
import Edycja.Data;
import Edycja.EdytujDane;

import javax.swing.*;
import java.util.Scanner;

public class UsunWybraneZnaki implements EdytujDane {
    String znak;

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public void edytuj(Data plik) {

        boolean dlugosc = false;
        char[] litery = plik.getData().toCharArray();
        StringBuilder temp= new StringBuilder();
        while(!dlugosc) {
            if(znak.length()!=1){
                znak = (new Scanner(System.in)).nextLine();
            }
            else {
                dlugosc=true;
            }
        }
        char[] literyznaku = znak.toCharArray();
        for (char letter : litery) {
            for (char litera : literyznaku) {
                if (!((Character.toUpperCase(litera) == letter) || (Character.toLowerCase(litera) == letter))) {
                    temp.append(letter);
                }
            }
        }
        plik.setData(temp.toString());
    }
}
