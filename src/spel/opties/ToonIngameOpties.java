package spel.opties;

import utils.Task;

import javax.swing.*;

/**
 * Created by Bart on 17-4-2014.
 */
public class ToonIngameOpties extends Task {

    private JFrame spelFrame;

    private String strSpeler1;
    private String strSpeler2;
    private String strTypeSpeler1;
    private String strTypeSpeler2;
    private String strSpelerZet;
    private String strTypeSpelerZet;
    private int selected;
    int[] spelData;

    public ToonIngameOpties(JFrame spelFrame, String strSpeler1, String strSpeler2, String strTypeSpeler1, String strTypeSpeler2, int[] spelData, String strSpelerZet, String strTypeSpelerZet, int selected){

        this.spelFrame = spelFrame;
        this.strSpeler1 = strSpeler1;
        this.strSpeler2 = strSpeler2;
        this.strTypeSpeler1 = strTypeSpeler1;
        this.strTypeSpeler2 = strTypeSpeler2;
        this.spelData = spelData;
        this.strSpelerZet = strSpelerZet;
        this.strTypeSpelerZet = strTypeSpelerZet;
        this.selected = selected;
    }

    //Deze code wordt uitgevoerd als in het SpelBord.java gevalideert is dat er een true uitkomt.
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

        spelFrame.setContentPane(new IngameOpties(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected));
        spelFrame.validate();
    }

}