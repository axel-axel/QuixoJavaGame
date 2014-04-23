package hoofdmenu.laadprofiel;

import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 10-4-2014.
 */
public class ToonLaadProfiel extends Task {

    private JFrame jfSpelFrame;

    public ToonLaadProfiel(JFrame jfSpelFrame) {

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

        //Laadprofiel klassen wordt aangeroepen.
        jfSpelFrame.setContentPane(new LaadProfiel(jfSpelFrame));
        jfSpelFrame.validate();
    }

}
