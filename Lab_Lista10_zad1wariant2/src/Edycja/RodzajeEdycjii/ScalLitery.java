package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

public class ScalLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        char[] letters = plik.getData().toCharArray();
        plik.setData("");
        for (char letter : letters) {
            if (!(' ' == letter))
                plik.setData(plik.getData() + letter);
        }
    }
}
