package Edycja;

public class Data {
    private String data;
    private String temp1;
    private String temp2;
    private final String[] poprzednie= new String[10];

    public String[] getPoprzednie() {
        return poprzednie;
    }

    public String getPoprzedni(int i) {
        return poprzednie[i];
    }

    public void setPoprzedni(String poprzedni, int i) {
        this.poprzednie[i] = poprzedni;
    }

    public void setData(String data) {
        poprzednie[9]=getData();
                for (int k = poprzednie.length-1; k >0; k--) {
                    temp2=poprzednie[k];
                    poprzednie[k]=temp1;
                    temp1=temp2;
                }

        this.data = data;
    }
    public void cofniecie(String data){this.data = data;}

    public String getData() {
        return data;
    }

    public Data(String data) {
        this.data = data;
    }

    public void display() {
        System.out.println("------------------------------------------");
        System.out.println(data);
        System.out.println("------------------------------------------");
    }
}
