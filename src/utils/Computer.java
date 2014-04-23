package utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bart on 4-4-2014.
 */
public class Computer {

    private String HOMEDIR;
    private String SP = "/";
    private String DISTRUBUTION = "Linux";

    public String getFILEPATH() {
        return HOMEDIR + SP + "src" + SP + "file" + SP;
    }

    /**
        Linux => /
        Windows => \
     */

    public Computer(){

        File currentDirectory = new File(new File(".").getAbsolutePath());

        try {
            HOMEDIR = currentDirectory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (HOMEDIR.indexOf(SP) < 0)
        {
            //Windows applicatie
            SP = "\\";
            DISTRUBUTION = "Windows";
        }

    }

}
