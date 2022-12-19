import Edycja.*;
import Edycja.RodzajeEdycjii.*;
import java.util.Objects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    //Zmienne
    static EdytorStringa edytor = new EdytorStringa();
    static Data wyraz = new Data("Hello java");
    //Frame
    public static JFrame frame = new JFrame("Menu");
    //Panele
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();
    static JPanel panel5 = new JPanel();
    //Przyciski
    static JButton button1 = new JButton("2. Zmien dane");
    static JButton button2 = new JButton("3. Wybierz rodzaj edycji wyrazu");
    static JButton button3 = new JButton("4. Cofnij");
    static JButton button4 = new JButton("5. Zakoncz program");
    //Etykiety
    static JLabel wyswietlanieWyrazu = new JLabel(wyraz.getData(),JLabel.CENTER);
    static JLabel OpisZmiany =new JLabel("Wybierz litere do wstawienia");
    //Pola tekstowe
    static JTextField ZmianaWyrazu = new JTextField();
    static JTextField UstawienieDodaniaZnaku =new JTextField();
    static JTextField UstawienieUsunieciaZnaku =new JTextField();

    public static void main(String[] args) {
        //Panele
        panel1.setLayout(new GridLayout(5, 1));
        panel2.setLayout(new GridLayout(5, 1));
        panel3.setLayout(new GridLayout(8, 1));
        panel4.setLayout(new GridLayout(5,1));
        panel5.setLayout(new GridLayout(5,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Elementy ktore nie musza byc statyczne
        //Etykiety
        JLabel wpisz = new JLabel("Wpisz nowy wyraz");
        JLabel menuEdycji=new JLabel("Menu wyswietlania:",JLabel.CENTER);
        //Przyciski
        JButton przycisk3_1=new JButton("1. Zmien na male litery");
        JButton przycisk3_2=new JButton("2. Zmien na duze litery");
        JButton przycisk3_3=new JButton("3. Podziel");
        JButton przycisk3_4=new JButton("4. Scal");
        JButton przycisk3_6=new JButton("5. Wstaw wybrany znak miedzy litery");
        JButton przycisk3_5=new JButton("6. Odwroc wyraz");
        JButton przycisk3_7=new JButton("7. Usun wybrane znaki");
        //Panel1
        panel1.add(wyswietlanieWyrazu);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        //Panel2
        panel2.add(wpisz);
        panel2.add(ZmianaWyrazu);
        //Panel3
        panel3.add(menuEdycji);
        panel3.add(przycisk3_1);
        panel3.add(przycisk3_2);
        panel3.add(przycisk3_3);
        panel3.add(przycisk3_4);
        panel3.add(przycisk3_5);
        panel3.add(przycisk3_6);
        panel3.add(przycisk3_7);
        //panel4
        panel4.add(OpisZmiany);
        panel4.add(UstawienieUsunieciaZnaku);
        //Panel5
        panel5.add(OpisZmiany);
        panel5.add(UstawienieDodaniaZnaku);
        //Ustawianie frame'a
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setContentPane(panel1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZmienPlansze(panel2);
                frame.revalidate();
                frame.repaint();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZmienPlansze(panel3);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cofnij();
            }
        });
            przycisk3_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edytor.setRodzajEdycji(new MaleLitery());
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
            przycisk3_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edytor.setRodzajEdycji(new DuzeLitery());
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
            przycisk3_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edytor.setRodzajEdycji(new RozdzielLitery());
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
            przycisk3_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edytor.setRodzajEdycji(new ScalLitery());
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
            przycisk3_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZmienPlansze(panel5);
            }
        });
            przycisk3_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edytor.setRodzajEdycji(new Zamianawyrazu());
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
            przycisk3_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZmienPlansze(panel4);
            }
        });
                ZmianaWyrazu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeData();
                ZmienPlansze(panel1);
            }
        });
                UstawienieDodaniaZnaku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WstawMiedzyLitery znak = new WstawMiedzyLitery();
                znak.setZnak(UstawienieDodaniaZnaku.getText());
                edytor.setRodzajEdycji(znak);
                edytor.edytuj(wyraz);
                wyswietlanieWyrazu.setText(wyraz.getData());
                ZmienPlansze(panel1);
            }
        });
                UstawienieUsunieciaZnaku.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UsunWybraneZnaki znak = new UsunWybraneZnaki();
                        znak.setZnak(UstawienieUsunieciaZnaku.getText());
                        edytor.setRodzajEdycji(znak);
                        edytor.edytuj(wyraz);
                        wyswietlanieWyrazu.setText(wyraz.getData());
                        ZmienPlansze(panel1);
                    }
                });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    //Zmiana wartosci wyrazu(uzyte w 2 przycisku)
    public static void ChangeData() {
        String nowyWyraz = ZmianaWyrazu.getText();
        wyraz.setData(nowyWyraz);
        wyswietlanieWyrazu.setText(wyraz.getData());
        System.out.println(nowyWyraz);
    }
    //Zmiana na inna plansze
    public static void ZmienPlansze(JPanel panel){
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }
    //Cofniecie do poprzednego stanu wyrazu (uzyte w 4 przycisku)
    public static void Cofnij() {
        // Your code here
        for (int i = 9; i > 0; i--) {
            if (!(Objects.equals(wyraz.getData(), wyraz.getPoprzedni(i))) && (wyraz.getPoprzedni(i) != null)) {
                wyraz.cofniecie(wyraz.getPoprzedni(i));
                wyraz.setPoprzedni(null, i);
                break;
            }
        }
        wyswietlanieWyrazu.setText(wyraz.getData());
    }
}
