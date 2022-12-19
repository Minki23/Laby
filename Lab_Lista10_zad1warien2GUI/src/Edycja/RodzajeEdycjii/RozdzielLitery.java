package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

public class RozdzielLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        StringBuilder temp= new StringBuilder();
        char[] letters = plik.getData().toCharArray();
        for (char letter : letters) temp.append(letter).append(" ");
        plik.setData(temp.toString());
            //plik.setData(plik.getData() + letter + " ");
    }
}
