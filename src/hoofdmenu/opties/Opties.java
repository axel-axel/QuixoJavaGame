package hoofdmenu.opties;

import utils.Computer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Bart on 10-4-2014.
 */
public class Opties extends JPanel implements ActionListener{

    private String[] strArrKeuze = {"ja", "nee"};
    private String[] strArrKeuzeMuis = {"linkshandig", "rechtshandig"};

    private JFrame jfSpelFrame;
    private JComboBox jcAchtergrondMenu, jcAchtergrondSpel, jcGeluidMenu, jcGeluidSpel, jcMuis;
    private JButton jbTerug;
    private JLabel jlAchtergrond;

    public Opties(JFrame jfSpelFrame) {

        this.jfSpelFrame = jfSpelFrame;

        maakAchtergrond();
        maakCombo();
        maakComboMuis();
        maakComboFile();
        maakButton();

        setLayout(null);
        add(jcAchtergrondMenu);
        add(jcAchtergrondSpel);
        add(jcGeluidMenu);
        add(jcGeluidSpel);
        add(jcMuis);
        add(jbTerug);

        setLayout(new BorderLayout());
        add(jlAchtergrond);
    }

    private void maakAchtergrond(){
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/opties_bg.png"));
    }

    private void maakButton(){

        /*
            Button wordt aangemaakt;
            Deze krijgt een vaste X / Y as waarde mee.
            Mouseover wordt toegevoegd.
         */

        jbTerug = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        jbTerug.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        jbTerug.setBorder(null);
        jbTerug.setBounds(200, 420, 150, 51);
        jbTerug.addActionListener(this);
    }

    private void maakCombo(){

        /*
            RadioButtons worden aangemaakt.
            Deze krijgen ook een vaste X / Y as waarde mee.
         */

        jcAchtergrondMenu = new JComboBox(strArrKeuze);
        jcAchtergrondMenu.setBorder(null);
        jcAchtergrondMenu.setBounds(380, 130, 75, 25);
        jcAchtergrondMenu.setBackground(new Color(130, 128, 122));
        jcAchtergrondMenu.setForeground(new Color(107, 54, 31));

        jcAchtergrondSpel = new JComboBox(strArrKeuze);
        jcAchtergrondSpel.setBorder(null);
        jcAchtergrondSpel.setBounds(380, 170, 75, 25);
        jcAchtergrondSpel.setBackground(new Color(130, 128, 122));
        jcAchtergrondSpel.setForeground(new Color(107, 54, 31));

        jcGeluidMenu = new JComboBox(strArrKeuze);
        jcGeluidMenu.setBorder(null);
        jcGeluidMenu.setBounds(380, 210, 75, 25);
        jcGeluidMenu.setBackground(new Color(130, 128, 122));
        jcGeluidMenu.setForeground(new Color(107, 54, 31));

        jcGeluidSpel = new JComboBox(strArrKeuze);
        jcGeluidSpel.setBorder(null);
        jcGeluidSpel.setBounds(380, 250, 75, 25);
        jcGeluidSpel.setBackground(new Color(130, 128, 122));
        jcGeluidSpel.setForeground(new Color(107, 54, 31));
    }

    private void maakComboMuis(){

        /*
            RadioButton wordt aangemaakt.
            Deze krijgen ook een vaste X / Y as waarde mee.
         */

        jcMuis = new JComboBox(strArrKeuzeMuis);
        jcMuis.setBorder(null);
        jcMuis.setBounds(340, 320, 115, 25);
        jcMuis.setBackground(new Color(130, 128, 122));
        jcMuis.setForeground(new Color(107, 54, 31));
    }

    private void maakComboFile() {

        //Filepath wordt opgehaald uit de Utils klasse.
        Computer c = new Computer();
        String filePath = c.getFILEPATH() + "opties.bin";

        File file = new File(filePath);
        Scanner input = null;

        try {

            /*
                Gegevens worden gelezen vanuit een bestand.
             */

            input = new Scanner(file);
            jcAchtergrondMenu.setSelectedItem(input.next());
            jcAchtergrondSpel.setSelectedItem(input.next());
            jcGeluidMenu.setSelectedItem(input.next());
            jcGeluidSpel.setSelectedItem(input.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //textield input wordt gecast naar een String en meegegeven aan de constructor.
        String strGeluidAchtergrondMenu = (String) jcAchtergrondMenu.getSelectedItem();
        String strGeluidAchtergrondSpel = (String) jcAchtergrondSpel.getSelectedItem();
        String strGeluidMenu = (String) jcGeluidMenu.getSelectedItem();
        String strGeluidSpel = (String) jcGeluidSpel.getSelectedItem();

        //Opslaan opties wordt aangeroepen.
        OpslaanOpties opslaanOpties = new OpslaanOpties(jfSpelFrame, strGeluidAchtergrondMenu, strGeluidAchtergrondSpel, strGeluidMenu, strGeluidSpel);
        opslaanOpties.run();
    }
}
