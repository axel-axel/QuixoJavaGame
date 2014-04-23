package hoofdmenu.afsluiten;

import hoofdmenu.ToonHoofdmenu;
import utils.*;

import javax.swing.*;

/**
 * Created by Bart on 10-4-2014.
 */
public class SluitSpel extends Task {

    private JFrame spelFrame;

    public SluitSpel(JFrame spelFrame){

        this.spelFrame = spelFrame;
    }

    public void run() {

        boolean validate = validate();

        if(validate == true) {
            execute();
        }

        ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(spelFrame, validate);
        toonHoofdmenu.run();
    }

    private boolean validate() {

        String message = "Weet u zeker dat u Quixo wilt Afsluiten?";
        String title = "Afsluiten Quixo";

        int bevestiging = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        if(bevestiging == JOptionPane.YES_OPTION) {
            return true;
        }

        return false;
    }

    private void execute() {

        System.exit(0);
    }

}
