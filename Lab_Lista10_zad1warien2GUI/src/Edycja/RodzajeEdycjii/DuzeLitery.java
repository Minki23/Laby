package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

import java.util.Locale;

public class DuzeLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        plik.setData(plik.getData().toUpperCase(Locale.ROOT));
    }
}
