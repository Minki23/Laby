package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

public class ScalLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        char[] letters = plik.getData().toCharArray();
        StringBuilder temp=new StringBuilder();
        for (char letter : letters) {
            if (!(' ' == letter)) {
                temp.append(letter);
            }
        }
        plik.setData(temp.toString());
    }
}
