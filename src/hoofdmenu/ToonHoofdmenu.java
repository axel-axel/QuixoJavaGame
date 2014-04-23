package hoofdmenu;

import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 9-4-2014.
 */
public class ToonHoofdmenu extends Task {

    private JFrame jfSpelFrame;
    private boolean blValidate;

    public ToonHoofdmenu(JFrame jfSpelFrame, boolean blValidate){

        this.jfSpelFrame = jfSpelFrame;
        this.blValidate = blValidate;
    }

    //Code die wordt uitgevoerd als er is voldaan aan de validate voorwaarden
    public void run() {

        boolean validate = validate();
        if(validate == true)
        {
            execute();
        }
    }

    private boolean validate() {

        //controleer of het splashscreen true retourneerde
        if(blValidate == true) {
            return true;
        } else {
            return true;
        }
    }

    private void execute() {

        //het hoofdmenu wordt aangeroepen.
        jfSpelFrame.setContentPane(new Hoofdmenu(jfSpelFrame));
        jfSpelFrame.validate();
    }

}