package hoofdmenu.help;

import hoofdmenu.ToonHoofdmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bart on 10-4-2014.
 */
public class Help extends JPanel implements ActionListener {

    private JFrame jfSpelFrame;
    private JButton jbnTerug;
    private JLabel jlAchtergrond;

    public Help(JFrame jfSpelFrame){

        this.jfSpelFrame = jfSpelFrame;

        maakAchtergrond();
        maakButton();

        setLayout(null);
        add(jbnTerug);

        setLayout(new BorderLayout());
        add(jlAchtergrond);
    }

    private void maakAchtergrond(){
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/help_bg.png"));
    }

    private void maakButton(){

        /*
            Maak de button aan.
            Deze heeft een vaste X / Y as waarde.
         */

        jbnTerug = new JButton(new ImageIcon("src/resources/buttons/ok.png"));
        jbnTerug.setRolloverIcon(new ImageIcon("src/resources/buttons/ok_h.png"));
        jbnTerug.setBorder(null);
        jbnTerug.setBounds(200, 400, 150, 51);
        jbnTerug.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, true);
        toonHoofdmenu.run();
    }
}
