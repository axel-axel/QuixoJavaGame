package hoofdmenu.opties;

import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 10-4-2014.
 */
public class ToonOpties extends Task {

    private JFrame jfSpelFrame;

    public ToonOpties(JFrame jfSpelFrame) {

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

        //roep het optie scherm aan
        jfSpelFrame.setContentPane(new Opties(jfSpelFrame));
        jfSpelFrame.validate();
    }
}
