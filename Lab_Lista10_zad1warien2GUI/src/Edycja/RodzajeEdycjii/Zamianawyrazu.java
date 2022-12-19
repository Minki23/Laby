package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

import java.util.Scanner;

public class Zamianawyrazu implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        char[] litery = plik.getData().toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i= litery.length-1;i>=0;i--) temp.append(litery[i]);
        plik.setData(temp.toString());
    }
}
