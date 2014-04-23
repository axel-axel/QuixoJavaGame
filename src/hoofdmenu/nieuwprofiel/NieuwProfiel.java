package hoofdmenu.nieuwprofiel;

import hoofdmenu.ToonHoofdmenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Bart on 10-4-2014.
 */
public class NieuwProfiel extends JPanel implements ActionListener {

    private JFrame jfSpelFrame;
    private JTextField jtxNaamEen, jtxNaamTwee;
    private JButton jbtOK, jbtCancel, jbtRoodEen, jbtZwartEen, jbtRoodTwee, jbtZwartTwee;
    private JLabel jlAchtergrond;
    private JRadioButton jrbKruisjeEen, jrbRondjeEen, jrbKruisjeTwee, jrbRondjeTwee;
    private JLabel jlKruisjeLinks, jlKruisjeRechts, jlRondjeLinks, jlRondjeRechts;
    private ButtonGroup bgGroepEen, bgGroepTwee;

    public NieuwProfiel(JFrame jfSpelFrame) {

        this.jfSpelFrame = jfSpelFrame;

        maakAchtergrond();
        maakButtons();
        maakInput();
        maakRadio();
        maakAfbeeldingen();

        add(jtxNaamEen);
        add(jtxNaamTwee);
        add(jbtOK);
        add(jbtCancel);
        add(jrbRondjeEen);
        add(jrbKruisjeEen);
        add(jrbRondjeTwee);
        add(jrbKruisjeTwee);
        add(jlKruisjeLinks);
        add(jlKruisjeRechts);
        add(jlRondjeLinks);
        add(jlRondjeRechts);

        setLayout(new BorderLayout());
        add(jlAchtergrond);
    }

    private void maakAchtergrond() {
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/profiel_n_bg.png"));
    }

    private void maakButtons() {

        /*
            Buttons worden aangemaakt.
            Deze krijgen een vaste X / Y as waarde mee.
            De buttons krijgen een mouse over afbeelding
         */

        jbtCancel = new JButton(new ImageIcon("src/resources/buttons/cancel.png"));
        jbtCancel.setRolloverIcon(new ImageIcon("src/resources/buttons/cancel_h.png"));
        jbtCancel.setBorder(null);
        jbtCancel.setBounds(100, 415, 150, 51);
        jbtCancel.addActionListener(this);

        jbtOK = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        jbtOK.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        jbtOK.setBorder(null);
        jbtOK.setBounds(300, 415, 150, 51);
        jbtOK.addActionListener(this);

        jbtZwartEen = new JButton(new ImageIcon("src/resources/buttons/kruiszwart.png"));
        jbtZwartEen.setRolloverIcon(new ImageIcon("src/resources/buttons/kruiszwart.png"));
        jbtZwartEen.setBorder(null);
        jbtZwartEen.setBounds(75, 150, 40, 40);
        jbtZwartEen.addActionListener(this);

        jbtRoodEen = new JButton(new ImageIcon("src/resources/buttons/rondjerood.png"));
        jbtRoodEen.setRolloverIcon(new ImageIcon("src/resources/buttons/rondjerood.png"));
        jbtRoodEen.setBorder(null);
        jbtRoodEen.setBounds(125, 150, 40, 40);
        jbtRoodEen.addActionListener(this);

        jbtRoodTwee = new JButton(new ImageIcon("src/resources/buttons/kruisjerood.png"));
        jbtRoodTwee.setRolloverIcon(new ImageIcon("src/resources/buttons/kruisjerood.png"));
        jbtRoodTwee.setBorder(null);
        jbtRoodTwee.setBounds(330, 150, 45, 45);
        jbtRoodTwee.addActionListener(this);

        jbtZwartTwee = new JButton(new ImageIcon("src/resources/buttons/rondjezwart.png"));
        jbtZwartTwee.setRolloverIcon(new ImageIcon("src/resources/buttons/rondjezwart.png"));
        jbtZwartTwee.setBorder(null);
        jbtZwartTwee.setBounds(380, 150, 45, 45);
        jbtZwartTwee.addActionListener(this);
    }

    private void maakInput() {

        /*
            Er worden twee input velden aangemaakt.
            Deze hebben ook beide vaste waarden.
         */

        jtxNaamEen = new JTextField();
        jtxNaamEen.setBounds(75, 170, 150, 25);

        jtxNaamTwee = new JTextField();
        jtxNaamTwee.setBounds(330, 170, 150, 25);
    }

    private void maakAfbeeldingen() {

        /*
            De afbeeldingen van kruisje en rondje worden ingeladen.
            Deze komen onder de radio select buttons te staan.
         */

        BufferedImage imgKruisje = null;
        try {
            imgKruisje = ImageIO.read(new File("src/resources/buttons/Kruisje.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage imgRondje = null;
        try {
            imgRondje = ImageIO.read(new File("src/resources/buttons/Rondje.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        jlKruisjeLinks = new JLabel(new ImageIcon(imgKruisje));
        jlKruisjeLinks.setBounds(80, 235, 56, 54);

        jlRondjeLinks = new JLabel(new ImageIcon(imgRondje));
        jlRondjeLinks.setBounds(160, 235, 56, 54);

        jlKruisjeRechts = new JLabel(new ImageIcon(imgKruisje));
        jlKruisjeRechts.setBounds(335, 235, 56, 54);

        jlRondjeRechts = new JLabel(new ImageIcon(imgRondje));
        jlRondjeRechts.setBounds(415, 235, 56, 54);
    }

    private void maakRadio() {

        /* Jradio buttons deze geven de keuzen voor jrbRondjeEen of jrbKruisjeEen */
        jrbKruisjeEen = new JRadioButton();
        jrbKruisjeEen.setText("Kruisje");
        jrbKruisjeEen.setBackground(new Color(166, 166, 166));
        jrbKruisjeEen.setBounds(75, 200, 65, 35);

        jrbRondjeEen = new JRadioButton();
        jrbRondjeEen.setText("Rondje");
        jrbRondjeEen.setBackground(new Color(166, 166, 166));
        jrbRondjeEen.setBounds(155, 200, 65, 35);

        jrbKruisjeTwee = new JRadioButton();
        jrbKruisjeTwee.setText("Kruisje");
        jrbKruisjeTwee.setBackground(new Color(166, 166, 166));
        jrbKruisjeTwee.setBounds(330, 200, 65, 35);

        jrbRondjeTwee = new JRadioButton();
        jrbRondjeTwee.setText("Rondje");
        jrbRondjeTwee.setBackground(new Color(166, 166, 166));
        jrbRondjeTwee.setBounds(410, 200, 65, 35);

        bgGroepEen = new ButtonGroup();
        bgGroepEen.add(jrbKruisjeEen);
        bgGroepEen.add(jrbRondjeEen);

        bgGroepTwee = new ButtonGroup();
        bgGroepTwee.add(jrbKruisjeTwee);
        bgGroepTwee.add(jrbRondjeTwee);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jbtCancel){

            //Wanneer er op cancel wordt geklikt gaan we terug naar het hoofdmenu
            ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, true);
            toonHoofdmenu.run();

        } else {
            if (e.getSource() == jbtOK) {

                //Textveld input wordt opgeslagen als string en meegegeven aan de constructor controleerNieuwProfiel.
                String strSpelerNaam1 = jtxNaamEen.getText();
                String strSpelerNaam2 = jtxNaamTwee.getText();
                String strTypeNaam1 = null;
                String strTypeNaam2 = null;

                if (jrbKruisjeEen.isSelected()) {
                    strTypeNaam1 = "kruis";
                } else if (jrbRondjeEen.isSelected()) {
                    strTypeNaam1 = "rond";
                }

                if (jrbKruisjeTwee.isSelected()) {
                    strTypeNaam2 = "kruis";
                } else if (jrbRondjeTwee.isSelected()) {
                    strTypeNaam2 = "rond";
                }

                //nieuw profiel wordt doorgestuurd om te worden gecontroleerd.
                ControleerNieuwProfiel controleerNieuwProfiel = new ControleerNieuwProfiel(jfSpelFrame, strSpelerNaam1, strSpelerNaam2, strTypeNaam1, strTypeNaam2);
                controleerNieuwProfiel.run();
            }
        }
    }

}