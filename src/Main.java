import javax.swing.*;

/**
 * Created by Bart on 1-4-2014.
 */
public class Main extends JFrame {

    private static ImageIcon img = new ImageIcon("src/resources/logo.png");

    public static void main (String[] args) {

        /**

            JAVA PROGRAMMEREN - IPSEN1 - Groep 4 - INF1G
            ============================================

            Bart Mauritz (projectleider)
            Axel Boesenach
            Joey Rentenaar
            Youri Kool

            © Alle rechten voorbehouden - HSLeiden - 2014

         */

        //frame wordt aangemaakt en meegegeven aan alle klassen
        JFrame jfSpelFrame = new JFrame();

        //frame instellingen aanmaken
        jfSpelFrame.setTitle("Quixo - IPSEN1 - INF1G Groep 4");
        jfSpelFrame.setSize(550, 550);
        jfSpelFrame.setIconImage(img.getImage());
        jfSpelFrame.setResizable(false);
        jfSpelFrame.setLocationRelativeTo(null);
        jfSpelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfSpelFrame.setLayout(null);

        //start het spel -> Task wordt aangeroepen
        Start start = new Start(jfSpelFrame);
        start.run(); 

        //frame zichtbaar maken
        jfSpelFrame.setVisible(true);
    }
}
