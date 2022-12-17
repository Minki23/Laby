package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

public class RozdzielLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        char[] letters = plik.getData().toCharArray();
        plik.setData("");
        for (char letter : letters) plik.setData(plik.getData() + letter + " ");
    }
}
