package spel.ingamehelp;

import spel.ToonSpelbord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bart on 17-4-2014 .
 */
public class IngameHelp extends JPanel implements ActionListener {

    private JFrame spelFrame;
    private JButton terug;
    private JLabel background;

    private String strSpeler1;
    private String strSpeler2;
    private String strTypeSpeler1;
    private String strTypeSpeler2;
    private String strSpelerZet;
    private String strTypeSpelerZet;
    private int selected;
    private int [] spelData = {
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
    };

    public IngameHelp(JFrame spelFrame, String strSpeler1, String strSpeler2, String strTypeSpeler1, String strTypeSpeler2, int[] spelData, String strSpelerZet, String strTypeSpelerZet, int selected){

        this.spelFrame = spelFrame;
        this.strSpeler1 = strSpeler1;
        this.strSpeler2 = strSpeler2;
        this.strTypeSpeler1 = strTypeSpeler1;
        this.strTypeSpeler2 = strTypeSpeler2;
        this.spelData = spelData;
        this.strSpelerZet = strSpelerZet;
        this.strTypeSpelerZet = strTypeSpelerZet;
        this.selected = selected;

        maakAchtergrond();
        maakButton();

        setLayout(null);
        add(terug);

        setLayout(new BorderLayout());
        add(background);
    }

    //Hiermee wordt de achtergrond toegevoegd.
    private void maakAchtergrond(){
        background = new JLabel(new ImageIcon("src/resources/achtergrond/help_bg.png"));
    }

    //Hiermee worden de knoppen in het ingame helpmenu aangemaakt.
    private void maakButton(){

        terug = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        terug.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        terug.setBorder(null);
        terug.setBounds(200, 400, 150, 51);
        terug.addActionListener(this);
    }

    //Actie die ondernomen wordt, toonSpelBord.java wordt hiermee uitgevoerd
    @Override
    public void actionPerformed(ActionEvent e) {

        ToonSpelbord toonSpelbord = new ToonSpelbord(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
        toonSpelbord.run();
    }
}

