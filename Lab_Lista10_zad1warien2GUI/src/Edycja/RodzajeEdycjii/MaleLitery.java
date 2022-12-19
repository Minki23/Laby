package Edycja.RodzajeEdycjii;

import Edycja.Data;
import Edycja.EdytujDane;

import java.util.Locale;
public class MaleLitery implements EdytujDane {
    @Override
    public void edytuj(Data plik) {
        plik.setData(plik.getData().toLowerCase(Locale.ROOT));
    }
}