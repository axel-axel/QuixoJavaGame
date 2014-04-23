package spel.opties;

import hoofdmenu.ToonHoofdmenu;
import spel.ToonSpelbord;
import utils.Computer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Bart on 17-4-2014.
 */
public class IngameOpties extends JPanel implements ActionListener {

    private JFrame spelFrame;
    private JButton opslaan, afsluiten, cancel;
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

    public IngameOpties(JFrame spelFrame, String strSpeler1, String strSpeler2, String strTypeSpeler1, String strTypeSpeler2, int[] spelData, String strSpelerZet, String strTypeSpelerZet, int selected) {

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
        maakButtons();

        setLayout(null);
        add(opslaan);
        add(afsluiten);
        add(cancel);

        setLayout(new BorderLayout());
        add(background);
    }

    //Hiermee wordt de achtergrond toegevoegd
    private void maakAchtergrond(){
        background = new JLabel(new ImageIcon("src/resources/achtergrond/ingame_opties_bg.png"));
    }

    //Hiermee worden de knoppen gemaakt voor de ingame opties.
    public void maakButtons() {

        opslaan = new JButton(new ImageIcon("src/resources/buttons/opslaan.png"));
        opslaan.setRolloverIcon(new ImageIcon("src/resources/buttons/opslaan_h.png"));
        opslaan.setBorder(null);
        opslaan.setBounds(200, 125, 150, 51);
        opslaan.addActionListener(this);

        afsluiten = new JButton(new ImageIcon("src/resources/buttons/afsluiten.png"));
        afsluiten.setRolloverIcon(new ImageIcon("src/resources/buttons/afsluiten_h.png"));
        afsluiten.setBorder(null);
        afsluiten.setBounds(200, 200, 150, 51);
        afsluiten.addActionListener(this);

        cancel = new JButton(new ImageIcon("src/resources/buttons/cancel.png"));
        cancel.setRolloverIcon(new ImageIcon("src/resources/buttons/cancel_h.png"));
        cancel.setBorder(null);
        cancel.setBounds(200, 275, 150, 51);
        cancel.addActionListener(this);
    }

    //Deze code beschrijft de acties die worden uitgevoerd bij het opslaan, afsluiten en annuleren in het menu.
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == opslaan){

            Computer c = new Computer();
            String filePath = c.getFILEPATH() + "profiel.bin";

            try {
                PrintWriter output = new PrintWriter(filePath);
                output.println(strSpeler1);
                output.println(strSpeler2);
                output.println(strTypeSpeler1);
                output.println(strTypeSpeler2);
                output.println(strSpelerZet);
                output.println(strTypeSpelerZet);
                output.println(selected);

                for(int i = 0; i < spelData.length; i++){
                    output.println(spelData[i]);
                }

                output.close();

                JOptionPane.showMessageDialog(null, "Het spel is met succes opgeslagen!.", "Spel opslaan gelukt!", JOptionPane.INFORMATION_MESSAGE);

            } catch (FileNotFoundException a) {
                a.printStackTrace();

                JOptionPane.showMessageDialog(null, "Het spel kan niet worden opgeslagen.", "Spel opslaan mislukt!", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if(e.getSource() == afsluiten){

            String message = "Weet u zeker dat deze Quixo pot wilt Afsluiten?";
            String title = "Afsluiten pot Quixo";

            int bevestiging = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

            if(bevestiging == JOptionPane.YES_OPTION) {
                ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(spelFrame, true);
                toonHoofdmenu.run();
            }

        } else if(e.getSource() == cancel){
            ToonSpelbord toonSpelbord = new ToonSpelbord(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
            toonSpelbord.run();
        }
    }

}
