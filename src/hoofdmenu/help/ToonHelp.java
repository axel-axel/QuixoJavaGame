package hoofdmenu.help;

import utils.*;

import javax.swing.*;

/**
 * Created by Bart on 10-4-2014.
 */
public class ToonHelp extends Task {

    private JFrame jfSpelFrame;

    public ToonHelp(JFrame jfSpelFrame){

        this.jfSpelFrame = jfSpelFrame;
    }

    public void run() {

        boolean validate = validate();

        if(validate == true)
        {
            execute();
        }
    }

    private boolean validate() {

        return true;
    }

    private void execute() {

        jfSpelFrame.setContentPane(new Help(jfSpelFrame));
        jfSpelFrame.validate();
    }

}
