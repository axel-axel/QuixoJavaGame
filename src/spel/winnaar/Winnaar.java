package spel.winnaar;

import hoofdmenu.ToonHoofdmenu;
import hoofdmenu.nieuwprofiel.ToonNieuwProfiel;
import spel.ToonSpelbord;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by joey on 19-4-2014.
 */
public class Winnaar extends JPanel implements ActionListener {

    private JFrame jfSpelFrame;
    private JButton jlOK, jlOpnieuw;
    private JLabel background, jlTitel, jlSpeler1, jlTypeSpeler1, jlTypeSpeler2;

    private String strSpelerNaam1;
    private String strSpelerNaam2;
    private String strTypeNaam1;
    private String strTypeNaam2;
    private String strSpelerWinnaar;
    private int [] spelData = {
            0, 0, 0, 0, 0,                   //het speelveld
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
    };

    public Winnaar(JFrame jfSpelFrame, String strSpelerNaam1, String strSpelerNaam2, String strTypeNaam1, String strTypeNaam2, String strSpelerWinnaar){

        this.jfSpelFrame = jfSpelFrame;
        this.strSpelerNaam1 = strSpelerNaam1;
        this.strSpelerNaam2 = strSpelerNaam2;
        this.strTypeNaam1 = strTypeNaam1;
        this.strTypeNaam2 = strTypeNaam2;
        this.strSpelerWinnaar = strSpelerWinnaar;

        maakAchtergrond();
        maakButton();
        maakLabels();
        runGeluid();

        add(jlOK);
        add(jlOpnieuw);
        add(jlTitel);
        add(jlSpeler1);
        add(jlTypeSpeler1);
        add(jlTypeSpeler2);

        setLayout(new BorderLayout());
        add(background);
    }

    private void maakAchtergrond(){
        background = new JLabel(new ImageIcon("src/resources/achtergrond/Winnaar.png"));                                //achtergrond van de frame
    }

    private void runGeluid() {                                                                                          //geluid word afgespeeld als iemand heb gewonnen
        try
        {
            InputStream in = new FileInputStream("src/resources/geluiden/winnaar.wav" );
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
        }
        catch ( Exception b )
        {
            b.printStackTrace();
        }
    }

    private void maakButton(){                                                                                          //maak de buttons om terug te gaan
                                                                                                                        //en om op nieuw een spel te starten
        jlOK = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        jlOK.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        jlOK.setBorder(null);
        jlOK.setBounds(300, 415, 150, 51);
        jlOK.addActionListener(this);

        jlOpnieuw = new JButton(new ImageIcon("src/resources/buttons/speelopnieuw.png"));
        jlOpnieuw.setRolloverIcon(new ImageIcon("src/resources/buttons/speelopnieuw_h.png"));
        jlOpnieuw.setBorder(null);
        jlOpnieuw.setBounds(100, 415, 150, 51);
        jlOpnieuw.addActionListener(this);
    }

    private void maakLabels() {
                                                                                        /*  Met deze strings komen de namen van de spelers en winnaar op het scherm */
        jlTitel = new JLabel("De winnaar is " + strSpelerWinnaar + "! Gefeliciteerd met de overwinning.");
        jlTitel.setBounds(100, 240, 400, 15);

        jlSpeler1 = new JLabel("De strijd ging tussen: " + strSpelerNaam1 + " vs " + strSpelerNaam2 + ".");
        jlSpeler1.setBounds(100, 255, 400, 15);


        jlTypeSpeler1 = new JLabel(strSpelerNaam1 + " speelde met: " + strTypeNaam1 + ".");
        jlTypeSpeler1.setBounds(100, 270, 400, 15);

        jlTypeSpeler2 = new JLabel(strSpelerNaam2 + " speelde met: " + strTypeNaam2 + ".");
        jlTypeSpeler2.setBounds(100, 285, 400, 15);


        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == jlOpnieuw){                                                               //bij opnieuw ga terug naar profiel
                                                                                                           //Keuzen om met leeg profiel te spelen of de zelfde gegeens
                String message = "Wilt u uw profiel instellingen wijzigen?";
                String title = "Opnieuw spelen Quixo - Wijzigen instellingen?";

                int bevestiging = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

                if(bevestiging == JOptionPane.YES_OPTION) {
                    ToonNieuwProfiel toonNieuwProfiel = new ToonNieuwProfiel(jfSpelFrame);
                    toonNieuwProfiel.run();
                } else {
                    ToonSpelbord toonSpelbord = new ToonSpelbord(jfSpelFrame, strSpelerNaam1, strSpelerNaam2, strTypeNaam1, strTypeNaam2, spelData, strSpelerNaam1, strTypeNaam1, 0);
                    toonSpelbord.run();
                }
            }

            if(e.getSource() == jlOK){
                ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, true);                                         // bij ok keert terug
                toonHoofdmenu.run();
            }
        }

}





