package splashscreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bart on 7-4-2014.
 */
public class Splashscreen extends JPanel {

    private JFrame jfSpelFrame;
    private JLabel jlAchtergrond;

    public Splashscreen(JFrame jfSpelFrame){

        this.jfSpelFrame = jfSpelFrame;

        maakAchtergrond();
        setLayout(new GridLayout(0, 1));
        add(jlAchtergrond);
    }

    //Hiermee wordt de spelachtergrond toegevoegd.
    private void maakAchtergrond(){
        jlAchtergrond = new JLabel(new ImageIcon("src/resources/achtergrond/splashscreen_bg.png"));
    }

}
