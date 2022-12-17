package Edycja;

public class Data {
    String data;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Data(String data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data);
    }

    public void performPrint() {
        // Wywołanie metody print() obiektu printBehavior
        System.out.println(data);
    }
    }
