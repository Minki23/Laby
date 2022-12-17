package Edycja;

public class EdytorStringa {
        private EdytujDane edycja;

    public EdytorStringa(EdytujDane edycja) {
            this.edycja = edycja;
        }

        public void setRodzajEdycji(EdytujDane edycja) {
            this.edycja = edycja;
        }

        public void edytuj(Data plik) {
            edycja.edytuj(plik);
        }
    }
