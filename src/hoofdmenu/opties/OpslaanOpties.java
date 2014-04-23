package hoofdmenu.opties;

import hoofdmenu.ToonHoofdmenu;
import utils.Computer;
import utils.Task;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Bart on 16-4-2014.
 */
public class OpslaanOpties extends Task {

    private JFrame jfSpelFrame;
    private String strAchtergrondMenu, strAchtergrondSpel, strGeluidMenu, strGeluidSpel;

    private String[] optiesData = {strAchtergrondMenu, strAchtergrondSpel, strGeluidMenu, strGeluidSpel};

    public OpslaanOpties(JFrame jfSpelFrame, String strAchtergrondMenu, String strAchtergrondSpel, String strGeluidMenu, String strGeluidSpel) {

        this.strAchtergrondMenu = strAchtergrondMenu;
        this.strAchtergrondSpel = strAchtergrondSpel;
        this.strGeluidMenu = strGeluidMenu;
        this.strGeluidSpel = strGeluidSpel;
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

        boolean validate = true;

        //filepash wordt geladen vanuit de utils klasse.
        Computer c = new Computer();
        String filePath = c.getFILEPATH() + "opties.bin";

        try {

            /*
                Gegevens worden opgeslagen in het bestand.
             */

            PrintWriter output = new PrintWriter(filePath);
            output.println(strAchtergrondMenu);
            output.println(strAchtergrondSpel);
            output.println(strGeluidMenu);
            output.println(strGeluidSpel);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return validate;
    }

    private void execute() {

        //hoofdmenu wordt aangeroepen.
        ToonHoofdmenu toonHoofdmenu = new ToonHoofdmenu(jfSpelFrame, true);
        toonHoofdmenu.run();

    }
}
