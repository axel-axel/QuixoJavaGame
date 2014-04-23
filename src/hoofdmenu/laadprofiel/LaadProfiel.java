package hoofdmenu.laadprofiel;

import hoofdmenu.ToonHoofdmenu;
import spel.ToonSpelbord;
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
public class LaadProfiel extends JPanel implements ActionListener {

    private JFrame jfSpelFrame;
    private JButton jlOK, jlCancel;
    private JLabel jlAchtergrond, jlTitel, jlSpeler1, jlSpeler2, jlTypeSpeler1, jlTypeSpeler2, jlSpelerZet;

    private String strSpeler1;
    private String strSpeler2;
    private String strTypeSpeler1;
    private String strTypeSpeler2;
    private String strSpelerZet;
    private String strTypeSpelerZet;
    private int selected;
    private int [] spelData = new int[25];

    public LaadProfiel(JFrame jfSpelFrame) {

        this.jfSpelFrame = jfSpelFrame;

        maakAchtergrond();
        maakButtons();
        leesBestand();
        maakLabels();

        add(jlTitel);
        add(jlSpeler1);
        add(jlSpeler2);
        add(jlTypeSpeler1);
        add(jlTypeSpeler2);

        add(jlOK);
        add(jlCancel);

        setLayout(new BorderLayout());
        add(jlAchtergrond);
    }

    private void maakAchtergrond() {
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/profiel_bg.png"));
    }

    private void maakButtons() {

        jlCancel = new JButton(new ImageIcon("src/resources/buttons/cancel.png"));
        jlCancel.setRolloverIcon(new ImageIcon("src/resources/buttons/cancel_h.png"));
        jlCancel.setBorder(null);
        jlCancel.setBounds(100, 415, 150, 51);
        jlCancel.addActionListener(this);

        jlOK = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        jlOK.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        jlOK.setBorder(null);
        jlOK.setBounds(300, 415, 150, 51);
        jlOK.addActionListener(this);
    }

    private void maakLabels() {

        jlTitel = new JLabel("De volgende instellingen zijn gevonden. Controleer deze.");
        jlTitel.setBounds(50, 100, 400, 15);

        jlSpeler1 = new JLabel("Naam speler 1: " + strSpeler1);
        jlSpeler1.setBounds(50, 200, 400, 15);

        jlSpeler2 = new JLabel("Naam speler 2: " + strSpeler2);
        jlSpeler2.setBounds(50, 225, 400, 15);

        jlTypeSpeler1 = new JLabel(strSpeler1 + " speelt met: " + strTypeSpeler1);
        jlTypeSpeler1.setBounds(50, 250, 400, 15);

        jlTypeSpeler2 = new JLabel(strSpeler2 + " speelt met: " + strTypeSpeler2);
        jlTypeSpeler2.setBounds(50, 275, 400, 15);

        jlSpelerZet = new JLabel(strSpelerZet + " is aan zet");
        jlSpelerZet.setBounds(50, 300, 400, 15);
    }

    private void leesBestand() {

        Computer c = new Computer();

        //De utils klassen is nodig om te kijken of het op een Linux of op een Windows computer draait.
        String filePath = c.getFILEPATH() + "profiel.bin";

        //Het bestasnd wordt opgezocht.
        File file = new File(filePath);
        Scanner input = null;

        try {

            /*
                Gegevens worden uit het bestand gelezen.
                Deze worden daarna opgeslagen in de variabelen.
             */

            input = new Scanner(file);
            strSpeler1 = input.next();
            strSpeler2 = input.next();
            strTypeSpeler1 = input.next();
            strTypeSpeler2 = input.next();
            strSpelerZet = input.next();
            strTypeSpelerZet = input.next();
            selected = input.nextInt();

            /*
                Deze loop is nodig om de speldata Array te vullen.
             */

            for(int i = 0; i < 25; i++){
                spelData[i] = input.nextInt();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jlCancel){

            //Cancel gekozen. Terug naar het hoofdmenu
            ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, true);
            toonHoofdmenu.run();

        } else if(e.getSource() == jlOK){

            //Het spel kan worden geladen. Het spelbord wordt aangeroepen met alle informatie erbij die nodig is.
            ToonSpelbord toonSpelbord = new ToonSpelbord(jfSpelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpeler1, strTypeSpeler1, selected);
            toonSpelbord.run();
        }
    }
}
