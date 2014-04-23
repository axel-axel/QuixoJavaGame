import splashscreen.ToonSplashscreen;
import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 16-4-2014.
 */
public class Start extends Task {

    private JFrame jfSpelFrame;

    public Start(JFrame jfSpelFrame) {

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

        //laat het splashscreen zien
        ToonSplashscreen toonSplashscreen = new ToonSplashscreen(jfSpelFrame);
        toonSplashscreen.run();
    }
}
