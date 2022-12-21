import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Main {
    static double strzelone=0.0;
    static long timer=System.currentTimeMillis();
    static double wartosc;
    static double trafione=0.0;
    static double procenttrafien=0.0;

    static JFrame frame = new JFrame();//creating instance of JFrame
    static JButton a = new JButton("a");
    static JButton b = new JButton("b");
    static JButton c = new JButton("c");
    static JButton d = new JButton("d");
    static JButton e = new JButton("e");
    static JButton f = new JButton("f");
    static JButton g = new JButton("g");
    static JLabel strzaly = new JLabel("Ilosc strzalow:"+strzelone);
    static JLabel czas = new JLabel("Czas:"+0);
    static JLabel srednia = new JLabel();
    static JLabel trafienie = new JLabel("Ilosc trafionych:"+trafione);
    static Random r=new Random();
    static JButton[] tab={a,b,c,d,e,f,g};
    static Component[] components = new Component[tab.length];
    static JPanel staty = new JPanel();
    static JPanel gra = new JPanel();

    public static void main(String[] args) throws InterruptedException {
        frame.setBounds(0,0,980,656);
        gra.setBounds(0,60,980,556);
        staty.setBounds(0,0,980,60);
        staty.add(strzaly);
        staty.add(trafienie);
        staty.add(srednia);
        staty.add(czas);
        czas.setBounds(300,0,200,20);
        srednia.setBounds(0,40,200,20);
        trafienie.setBounds(0,20,200,20);
        strzaly.setBounds(0,0,200,20);
        frame.add(staty);
        frame.add(gra);
        gra.setLayout(null);
        for (JButton jButton : tab) {
            jButton.setBounds((Math.max(r.nextInt(gra.getWidth()-jButton.getWidth()-100),0)), (Math.max(r.nextInt(gra.getHeight()-jButton.getHeight()-100),60)), 100, 100);
            gra.add(jButton);
            jButton.setBackground(Color.red);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jButton.setBounds((Math.max(r.nextInt(gra.getWidth()-jButton.getWidth()),0)), (Math.max(r.nextInt(gra.getHeight()-jButton.getHeight()),60)),jButton.getWidth()-10,jButton.getHeight()-10);
                    strzelone++;
                    strzaly.setText("Ilosc strzalow:"+strzelone);
                    trafione++;
                    trafienie.setText("Ilosc trafionych:"+trafione);
                    if(jButton.getHeight()<20) {
                        gra.remove(jButton);
                    }
                    Component[] components = gra.getComponents();
                    if(components.length==0){
                        System.exit(0);
                    }
                    if(trafione!=0){
                        procenttrafien= (int) Math.round((strzelone/trafione)*100);
                        srednia.setText("Procent trafien:"+procenttrafien+"%");
                    }
                }
            });
        }
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                    if(e.getButton()==MouseEvent.BUTTON1){
                        trafione++;
                        trafienie.setText("Ilosc trafionych:"+trafione);
                        if(trafione!=0){
                            procenttrafien= (int) ((strzelone/trafione)*100);
                            srednia.setText("Procent trafien:"+procenttrafien+"%");
                        }
                    }
                System.out.println("x"+e.getX()+"y"+e.getY());
                }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                if(!(components.length==0)) {
                    wartosc = ((System.currentTimeMillis() - timer) / 1000.0);
                    czas.setText("Czas:" + wartosc);
                }
            }
        });
        staty.setLayout(null);
        staty.setVisible(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}