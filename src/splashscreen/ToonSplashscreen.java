package splashscreen;

import hoofdmenu.ToonHoofdmenu;
import utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bart on 9-4-2014.
 */
public class ToonSplashscreen extends Task {

    private JFrame jfSpelFrame;
    private Timer timer;
    private boolean validate = true;

    public ToonSplashscreen(JFrame jfSpelFrame){

        this.jfSpelFrame = jfSpelFrame;
    }

    //Code die uitgevoerd wordt als aan de voorwaarden is voldaan
    public void run() {

        boolean validate = validate();

        if(validate == true)
        {
            execute();
        }
    }

    private boolean validate() {

        new Computer();
        return true;
    }

    private void execute() {

        jfSpelFrame.setContentPane(new Splashscreen(jfSpelFrame));

        /*
            Maak een timer aan voor 3 seconde.
            Deze wordt later opgevangen door de actionListener.
            Die roept vervolgens het splaschscreen aan.
         */
        TimeListener tlTimer = new TimeListener();
        timer = new Timer(3000, tlTimer);
        timer.start();

        validate = true;
    }

    class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /*
                Het hoofdmenu wordt hier aangeroepen.
                Dit is pas nadat het splashscreen 3 seconde is getoond.
             */
            ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, validate);
            toonHoofdmenu.run();
            timer.stop();
        }
    }
}