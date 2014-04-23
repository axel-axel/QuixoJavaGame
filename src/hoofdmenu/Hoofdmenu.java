package hoofdmenu;

import hoofdmenu.afsluiten.SluitSpel;
import hoofdmenu.help.ToonHelp;
import hoofdmenu.laadprofiel.ToonLaadProfiel;
import hoofdmenu.nieuwprofiel.ToonNieuwProfiel;
import hoofdmenu.opties.ToonOpties;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Bart on 7-4-2014.
 */
public class Hoofdmenu extends JPanel implements ActionListener{

    private JFrame jfSpelFrame;
    private JButton jbtNieuwSpel, jbtSpelLaden, jbtOpties, jbtHelp, jbtAfsluiten;
    private JLabel jlAchtergrond;

    public Hoofdmenu(JFrame jfSpelFrame) {

        this.jfSpelFrame = jfSpelFrame;

        setLayout(null);

        maakJButtons();

        add(jbtNieuwSpel);
        add(jbtSpelLaden);
        add(jbtOpties);
        add(jbtHelp);
        add(jbtAfsluiten);

        maakAchtergrond();

        setLayout(new BorderLayout());
        add(jlAchtergrond);
    }

    //Knoppen die worden aangemaakt voor het bedienen van het hoofdmenu
    private void maakJButtons(){

        /*
            Maak alle buttons aan en geef deze een afbeelding.
            Geef ook alle buttons een vaste positie waarde.
         */

        jbtNieuwSpel = new JButton(new ImageIcon("src/resources/hoofdmenu/nieuw_spel.png"));
        jbtNieuwSpel.setRolloverIcon(new ImageIcon("src/resources/hoofdmenu/nieuw_spel_h.png"));
        jbtNieuwSpel.setBorder(null);
        jbtNieuwSpel.setBounds(125, 100, 300, 63);
        jbtNieuwSpel.addActionListener(this);

        jbtSpelLaden = new JButton(new ImageIcon("src/resources/hoofdmenu/spel_laden.png"));
        jbtSpelLaden.setRolloverIcon(new ImageIcon("src/resources/hoofdmenu/spel_laden_h.png"));
        jbtSpelLaden.setBorder(null);
        jbtSpelLaden.setBounds(125, 175, 300, 63);
        jbtSpelLaden.addActionListener(this);

        jbtOpties = new JButton(new ImageIcon("src/resources/hoofdmenu/opties.png"));
        jbtOpties.setRolloverIcon(new ImageIcon("src/resources/hoofdmenu/opties_h.png"));
        jbtOpties.setBorder(null);
        jbtOpties.setBounds(125, 250, 300, 63);
        jbtOpties.addActionListener(this);

        jbtHelp = new JButton(new ImageIcon("src/resources/hoofdmenu/Help.png"));
        jbtHelp.setRolloverIcon(new ImageIcon("src/resources/hoofdmenu/help_h.png"));
        jbtHelp.setBorder(null);
        jbtHelp.setBounds(125, 325, 300, 63);
        jbtHelp.addActionListener(this);

        jbtAfsluiten = new JButton(new ImageIcon("src/resources/hoofdmenu/exit.png"));
        jbtAfsluiten.setRolloverIcon(new ImageIcon("src/resources/hoofdmenu/exit_h.png"));
        jbtAfsluiten.setBorder(null);
        jbtAfsluiten.setBounds(125, 400, 300, 63);
        jbtAfsluiten.addActionListener(this);
    }

    //Hiermee wordt de spelachtergrond toegevoegd.
    private void maakAchtergrond(){
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/menu_bg.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*
            probeer een geluidje af te spelen in het hoofdmenu.
         */

        try
        {
            InputStream in = new FileInputStream("src/resources/geluiden/klik.wav" );
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
        }
        catch ( Exception b )
        {
            b.printStackTrace();
        }

        if(e.getSource() == jbtNieuwSpel){

            ToonNieuwProfiel toonNieuwProfiel = new ToonNieuwProfiel(jfSpelFrame);
            toonNieuwProfiel.run();

        } else if (e.getSource() == jbtSpelLaden){

            ToonLaadProfiel toonLaadProfiel = new ToonLaadProfiel(jfSpelFrame);
            toonLaadProfiel.run();

        } else if (e.getSource() == jbtOpties){

            ToonOpties toonOpties = new ToonOpties(jfSpelFrame);
            toonOpties.run();

        } else if (e.getSource() == jbtHelp) {

            ToonHelp toonHelp = new ToonHelp(jfSpelFrame);
            toonHelp.run();

        } else if (e.getSource() == jbtAfsluiten) {

            SluitSpel sluitSpel = new SluitSpel(jfSpelFrame);
            sluitSpel.run();
        }
    }
}
