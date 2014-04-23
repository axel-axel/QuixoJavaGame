package hoofdmenu.nieuwprofiel;

import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 10-4-2014.
 */
public class ToonNieuwProfiel extends Task {

    private JFrame jfSpelFrame;

    public ToonNieuwProfiel(JFrame jfSpelFrame) {

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

        jfSpelFrame.setContentPane(new NieuwProfiel(jfSpelFrame));
        jfSpelFrame.validate();
    }

}
