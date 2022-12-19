package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;
import javax.swing.*;


public class WstawMiedzyLitery implements EdytujDane {
    private String znak;

    public void setZnak(String znak) {
        this.znak = znak;
    }

    @Override
    public void edytuj(Data plik) {
        char[] litery = plik.getData().toCharArray();
        StringBuilder temp= new StringBuilder();
        for (char letter : litery) temp.append(letter).append(znak);
        plik.setData(temp.toString());
    }
}
