package Edycja;

import Edycja.RodzajeEdycjii.DuzeLitery;

public class EdytorStringa {
        private EdytujDane edycja;

    public EdytorStringa(EdytujDane edycja) {
            this.edycja = edycja;
        }

    public EdytorStringa() {
        this.edycja= new DuzeLitery();
    }

    public void setRodzajEdycji(EdytujDane edycja) {
            this.edycja = edycja;
        }

        public void edytuj(Data plik) {
            edycja.edytuj(plik);
        }
    }

