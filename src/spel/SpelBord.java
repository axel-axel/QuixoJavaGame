package spel;

import spel.ingamehelp.ToonIngameHelp;
import spel.opties.ToonIngameOpties;
import spel.winnaar.ToonWinnaar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Bart on 15-4-2014.
 */
public class SpelBord extends JPanel implements MouseListener {

    private JFrame spelFrame;
    private JLabel background, help, menu, jlSpeler1, jlSpeler2, jlTypeSpeler1, jlTypeSpeler2, jlSpelerZet;
    private JButton[] blokken = new JButton[25];
    private Timer timer;

    private String strSpelerZet;
    private String strTypeSpelerZet;

    private String strSpeler1;
    private String winnaar = "Geen Winnaar";
    private String strSpeler2;
    private String strTypeSpeler1;
    private String strTypeSpeler2;
    private String strSpelerWinnaar;
    private int [] spelData = {
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
    };

    private int selected;

    public SpelBord (JFrame spelFrame, String strSpeler1, String strSpeler2, String strTypeSpeler1, String strTypeSpeler2, int[] spelData, String strSpelerZet, String strTypeSpelerZet, int selected) {

        this.spelFrame = spelFrame;
        this.strSpeler1 = strSpeler1;
        this.strSpeler2 = strSpeler2;
        this.strTypeSpeler1 = strTypeSpeler1;
        this.strTypeSpeler2 = strTypeSpeler2;
        this.spelData = spelData;
        this.strSpelerZet = strSpelerZet;
        this.strTypeSpelerZet = strTypeSpelerZet;
        this.selected = selected;

        if(checkWinnaar() == true){
            TimeListener tlTimer = new TimeListener();
            timer = new Timer(1, tlTimer);
            timer.start();
        }

        maakAchtergrond();
        maakButtons();
        maakHelp();
        maakMenu();
        toevoegenButtons();
        maakLabels();
        checkWinnaar();


        add(help);
        add(menu);
        add(jlSpeler1);
        add(jlSpeler2);
        add(jlTypeSpeler1);
        add(jlTypeSpeler2);
        add(jlSpelerZet);

        setLayout(new BorderLayout());
        add(background);
    }

    //Achtergrond wordt hiermee aangemaakt.
    private void maakAchtergrond(){
        background = new JLabel(new ImageIcon("src/resources/achtergrond/spelveld_bg.png"));
    }

    //Ingame helpknop wordt hiermee aangemaakt.
    private void maakHelp() {
        help = new JLabel(new ImageIcon("src/resources/buttons/help.png"));
        help.setBounds(495, 10, 40, 40);
        help.setBorder(null);
        help.addMouseListener(this);
    }

    //Ingame menuknop wordt hiermee aangemaakt.
    private void maakMenu() {
        menu = new JLabel(new ImageIcon("src/resources/buttons/menu.png"));
        menu.setBounds(15, 468, 121, 48);
        menu.setBorder(null);
        menu.addMouseListener(this);

    }

    //Labels worden aangemaakt met de naam van de spelers, het type blokje waar ze mee spelen en wie er aan zet is.
    private void maakLabels() {

        jlSpeler1 = new JLabel("Naam 1: " + strSpeler1);
        jlSpeler1.setBounds(15, 15, 400, 15);

        jlSpeler2 = new JLabel("Naam 2: " + strSpeler2);
        jlSpeler2.setBounds(15, 35, 400, 15);

        jlTypeSpeler1 = new JLabel(strSpeler1 + " speelt met: " + strTypeSpeler1);
        jlTypeSpeler1.setBounds(15, 55, 400, 15);

        jlTypeSpeler2 = new JLabel(strSpeler2 + " speelt met: " + strTypeSpeler2);
        jlTypeSpeler2.setBounds(15, 75, 400, 15);

        jlSpelerZet = new JLabel(strSpelerZet + " is aan zet");
        jlSpelerZet.setBounds(15, 95, 400, 15);
    }

    //Blokjes worden aangemaakt met bijbehorende afbeeldingen.
    private void maakButtons() {

        int c = 0;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

                if(spelData[c] == 0) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/1.png"));
                } else if(spelData[c] == 1) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/3.png"));
                } else if(spelData[c] == 2) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/4.png"));
                } else if(spelData[c] == 3) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/2.png"));
                } else if(spelData[c] == 4) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/5.png"));
                } else if(spelData[c] == 5) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/6.png"));
                } else if(spelData[c] == 6) {
                    blokken[c] = new JButton(new ImageIcon("src/resources/spel/7.png"));
                }

                blokken[c].setBounds(130 + (j*57), 148 + (i*57), 57, 57);
                blokken[c].setBorder(null);
                blokken[c].addMouseListener(this);

                String naam = "" + c;

                blokken[c].setName(naam);
                c++;
            }
        }
    }

    //Blokjes worden toegevoegd aan het spelbord.
    private void toevoegenButtons() {

        for(int i = 0; i < 25; i++){
            add(blokken[i]);
        }
    }

    //Hiermee wordt berekent waar een blokje mag worden neergezet.
    private void berekenOptie(int i, int j) {

        if(j == 0) {
            int[][] veldArrData = {
                    {0, 4, 20},
                    {0, 4, 21},
                    {0, 4, 22},
                    {0, 4, 23},
                    {0, 4, 24},
                    {0, 9, 20},
                    {},
                    {},
                    {},
                    {4, 5, 24},
                    {0, 14, 20},
                    {},
                    {},
                    {},
                    {4, 10, 24},
                    {0, 19, 20},
                    {},
                    {},
                    {},
                    {4, 15, 24},
                    {0, 20, 24},
                    {1, 20, 24},
                    {2, 20, 24},
                    {3, 20, 24},
                    {4, 20, 24}
            };

            for (int k = 0; k < veldArrData.length; k++) {

                if (i == k) {

                    for (int l = 0; l < veldArrData[i].length; l++) {
                        if (spelData[veldArrData[i][l]] == 0) {

                            spelData[veldArrData[i][l]] = 3;

                        } else if (spelData[veldArrData[i][l]] == 1) {

                            spelData[veldArrData[i][l]] = 5;

                        } else if (spelData[veldArrData[i][l]] == 2) {

                            spelData[veldArrData[i][l]] = 6;

                        }
                    }
                }
            }
        }

        if(j == 1){

            int rijOude 	= selected / 5;                 //Oude rij van blokje.
            int kolomOude 	= selected % 5;                 //Oude kolom van blokje.
            int rijNieuwe	= i / 5;                        //Nieuwe rij na het verzetten van blokje
            int kolomNieuwe = i % 5;                        //Nieuwe kolom na het verzetten van blokje

            if ( rijOude == rijNieuwe ) {                   // VERSCHUIF HORIZONTAAL

                if (kolomOude < kolomNieuwe) {              // LINKS...

                    if(i >= 0 && i <= 4){
                        spelData[0] = spelData[1];
                        spelData[1] = spelData[2];
                        spelData[2] = spelData[3];
                        spelData[3] = spelData[4];
                    } else if(i >= 5 && i <= 9){
                        spelData[5] = spelData[6];
                        spelData[6] = spelData[7];
                        spelData[7] = spelData[8];
                        spelData[8] = spelData[9];
                    } else if(i >= 10 && i <= 14){
                        spelData[10] = spelData[11];
                        spelData[11] = spelData[12];
                        spelData[12] = spelData[13];
                        spelData[13] = spelData[14];
                    } else if(i >= 15 && i <= 19){
                        spelData[15] = spelData[16];
                        spelData[16] = spelData[17];
                        spelData[17] = spelData[18];
                        spelData[18] = spelData[19];
                    } else {
                        spelData[20] = spelData[21];
                        spelData[21] = spelData[22];
                        spelData[22] = spelData[23];
                        spelData[23] = spelData[24];
                    }

                } else if (kolomOude > kolomNieuwe) {       // RECHTS

                    if(i >= 0 && i <= 4){
                        spelData[4] = spelData[3];
                        spelData[3] = spelData[2];
                        spelData[2] = spelData[1];
                        spelData[1] = spelData[0];
                    } else if(i >= 5 && i <= 9){
                        spelData[9] = spelData[8];
                        spelData[8] = spelData[7];
                        spelData[7] = spelData[6];
                        spelData[6] = spelData[5];
                    } else if(i >= 10 && i <= 14){
                        spelData[14] = spelData[13];
                        spelData[13] = spelData[12];
                        spelData[12] = spelData[11];
                        spelData[11] = spelData[10];
                    } else if(i >= 15 && i <= 19){
                        spelData[19] = spelData[18];
                        spelData[18] = spelData[17];
                        spelData[17] = spelData[16];
                        spelData[16] = spelData[15];
                    } else {
                        spelData[24] = spelData[23];
                        spelData[23] = spelData[22];
                        spelData[22] = spelData[21];
                        spelData[21] = spelData[20];
                    }

                } else {
                    /* GEEN BLOKJE GEKOZEN */
                }
            } else if (kolomOude == kolomNieuwe ) {         // VERSCHUIF VERTIKAAL

                if (rijOude < rijNieuwe) {                  // OMHOOG

                    if(kolomNieuwe == 0){
                        spelData[0] = spelData[5];
                        spelData[5] = spelData[10];
                        spelData[10] = spelData[15];
                        spelData[15] = spelData[20];
                    } else if(kolomNieuwe == 1){
                        spelData[1] = spelData[6];
                        spelData[6] = spelData[11];
                        spelData[11] = spelData[16];
                        spelData[16] = spelData[21];
                    } else if(kolomNieuwe == 2){
                        spelData[2] = spelData[7];
                        spelData[7] = spelData[12];
                        spelData[12] = spelData[17];
                        spelData[17] = spelData[22];
                    } else if(kolomNieuwe == 3){
                        spelData[3] = spelData[8];
                        spelData[8] = spelData[13];
                        spelData[13] = spelData[18];
                        spelData[18] = spelData[23];
                    } else {
                        spelData[4] = spelData[9];
                        spelData[9] = spelData[14];
                        spelData[14] = spelData[19];
                        spelData[19] = spelData[24];
                    }

                } else if (rijOude > rijNieuwe) {           // OMLAAG

                    if(kolomNieuwe == 0){
                        spelData[20] = spelData[15];
                        spelData[15] = spelData[10];
                        spelData[10] = spelData[5];
                        spelData[5] = spelData[0];
                    } else if(kolomNieuwe == 1){
                        spelData[21] = spelData[16];
                        spelData[16] = spelData[11];
                        spelData[11] = spelData[6];
                        spelData[6] = spelData[1];
                    } else if(kolomNieuwe == 2){
                        spelData[22] = spelData[17];
                        spelData[17] = spelData[12];
                        spelData[12] = spelData[7];
                        spelData[7] = spelData[2];
                    } else if(kolomNieuwe == 3){
                        spelData[23] = spelData[18];
                        spelData[18] = spelData[13];
                        spelData[13] = spelData[8];
                        spelData[8] = spelData[3];
                    } else {
                        spelData[24] = spelData[19];
                        spelData[19] = spelData[14];
                        spelData[14] = spelData[9];
                        spelData[9] = spelData[4];
                    }

                } else {
                    /* GEEN BLOKJE GEKOZEN */
                }
            }
        }
    }

    //Hiermee wordt de winnaar berekent.
    private boolean checkWinnaar() {


            int winCount = 0, i, j, k, l;
            int n = 5;


            for (i = 0; i < (n * n) ; i = i + n) {          //checkt rijen of er 5 op een rij liggen (kruisje)
                    for (j = i; j < (i + n -1); j++) {
                        if (spelData[j] == spelData[j + 1]) {
                            if(spelData[j] == 1)    {
                                winCount++;
                            }
                        }
                    }
                    if (winCount == (n - 1)) {
                        winnaar = "kruis";

                        if(strTypeSpeler1 == winnaar){
                            strSpelerWinnaar = strSpeler1;
                        } else {
                            strSpelerWinnaar = strSpeler2;
                        }

                        return true;
                    }
                winCount = 0;
            }

        for (i = 0; i < (n * n) ; i = i + n) {          //checkt rijen of er 5 op een rij liggen (rondje))
            for (j = i; j < (i + n -1); j++) {
                if (spelData[j] == spelData[j + 1]) {
                    if(spelData[j] == 2)    {
                        winCount++;
                    }
                }
            }
            if (winCount == (n - 1)) {
                winnaar = "rond";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }

                return true;
            }
            winCount = 0;
        }

            for(k = 0; k < n; k++)  {                       //Checkt kolommen of er 5 op een rij liggen (kruisje))
            for(l = k; l < (n * (n-1)); l = l + n) {
                if(spelData[l] == spelData[l + 5]) {
                    if(spelData[l] == 1)    {
                        winCount++;
                    }
                }
            }
            if(winCount == (n-1))   {
                winnaar = "kruis";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }

                return true;
            }
            winCount = 0;
        }

        for(k = 0; k < n; k++)  {                       //Checkt kolommen of er 5 op een rij liggen (rondje))
            for(l = k; l < (n * (n-1)); l = l + n) {
                if(spelData[l] == spelData[l + 5]) {
                    if(spelData[l] == 2)    {
                        winCount++;
                    }
                }
            }
            if(winCount == (n-1))   {
                winnaar = "rond";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }

                return true;
            }
            winCount = 0;
        }

        if(     (spelData[0] == spelData[6]) &&
                    (spelData[0] == spelData[12]) &&
                    (spelData[0] == spelData[18]) &&
                    (spelData[0] == spelData[24]) &&
                (spelData[0] == 1 || spelData[0] == 2)){               //checkt voor diagonaal van linksboven naar rechtsonder
            if(spelData[12] == 3)   {
                winnaar = "kruis";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }
            }
            if(spelData[12] == 4)   {
                winnaar = "rond";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }
            }
            return true;
        }

        if(     (spelData[20] == spelData[16]) &&
                (spelData[20] == spelData[12]) &&
                (spelData[20] == spelData[8]) &&
                (spelData[20] == spelData[4]) &&
                (spelData[20] == 1 || spelData[20] == 2)){               //checkt voor diagonaal van linksonder naar rechtsboven
            if(spelData[12] == 3)   {
                winnaar = "kruis";

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }
            }
            if(spelData[12] == 4)   {                                  // deze checkt alleen blokje 12 dit is de middelste
                winnaar = "rond";                                     // want alleen deze verandert bij diagnaal

                if(strTypeSpeler1 == winnaar){
                    strSpelerWinnaar = strSpeler1;
                } else {
                    strSpelerWinnaar = strSpeler2;
                }
            }
            return true;
        }
        return false;
    }

    public void schoonVelden() {

        for(int k = 0; k < spelData.length; k++){
            if(spelData[k] == 3 || spelData[k] == 4){
                spelData[k] = 0;
            } else if(spelData[k] == 5){
                spelData[k] = 1;
            } else if(spelData[k] == 6){
                spelData[k] = 2;
            }
        }
    }

    //Acties die ondernomen moeten worden als er wordt geklikt op de ingame help- of menuknop, wie er aan de beurt is en waar het blokje mag worden neergezet.
    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == help){
            ToonIngameHelp toonIngameHelp = new ToonIngameHelp(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
            toonIngameHelp.run();
        }

        if(e.getSource() == menu){
            ToonIngameOpties toonIngameOpties = new ToonIngameOpties(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
            toonIngameOpties.run();
        }

        for(int i = 0; i < 25; i++){

            if(e.getSource() == blokken[i]){

                String buttonNaam = ((JComponent) e.getSource()).getName();
                int nr = Integer.parseInt(buttonNaam);

                if(spelData[i] == 0) {
                    if(i == 6 || i == 7 || i == 8 || i == 11 || i == 12 || i == 13 || i == 16 || i == 17 || i == 18){

                    } else {

                        schoonVelden();

                        berekenOptie(i, 0);

                        //blauwe balk wordt aangemaakt.
                        spelData[i] = 4;

                        //selected wordt toegewezen aan de int.
                        selected = i;

                        ToonSpelbord toonSpelbord = new ToonSpelbord(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
                        toonSpelbord.run();

                    }
                } else if(spelData[i] == 3) {

                    int temp;

                    if (strTypeSpelerZet == "kruis") {
                        temp = 1;
                    } else {
                        temp = 2;
                    }

                    schoonVelden();
                    spelData[i] = temp;

                    if (strSpelerZet.equals(strSpeler1)) {
                        strSpelerZet = strSpeler2;
                    } else {
                        strSpelerZet = strSpeler1;
                    }

                    if (strTypeSpelerZet == "kruis") {
                        strTypeSpelerZet = "rond";
                    } else {
                        strTypeSpelerZet = "kruis";
                    }

                    ToonSpelbord toonSpelbord = new ToonSpelbord(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
                    toonSpelbord.run();
                } else if(spelData[i] == 5 || spelData[i] == 6) {

                    int temp;

                    if (strTypeSpelerZet == "kruis") {
                        temp = 1;
                    } else {
                        temp = 2;
                    }

                    schoonVelden();

                    berekenOptie(i, 1);

                    spelData[i] = temp;

                    if (strSpelerZet.equals(strSpeler1)) {
                        strSpelerZet = strSpeler2;
                    } else {
                        strSpelerZet = strSpeler1;
                    }

                    if (strTypeSpelerZet == "kruis") {
                        strTypeSpelerZet = "rond";
                    } else {
                        strTypeSpelerZet = "kruis";
                    }

                    ToonSpelbord toonSpelbord = new ToonSpelbord(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2, spelData, strSpelerZet, strTypeSpelerZet, selected);
                    toonSpelbord.run();

                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    //Hier worden de acties beschreven die ondernomen moeten worden als de muis over het spelbord beweegt.
    @Override
    public void mouseEntered(MouseEvent e) {

        for(int i = 0; i < 25; i++){

            if(e.getSource() == blokken[i]){

                String buttonNaam = ((JComponent) e.getSource()).getName();
                int nr = Integer.parseInt(buttonNaam);

                if(spelData[i] == 0) {
                    if(i == 6 || i == 7 || i == 8 || i == 11 || i == 12 || i == 13 || i == 16 || i == 17 || i == 18){
                        blokken[nr].setRolloverIcon(new ImageIcon("src/resources/spel/1.png"));
                    } else {
                        blokken[nr].setRolloverIcon(new ImageIcon("src/resources/spel/5.png"));
                    }
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /*
                Het hoofdmenu wordt hier aangeroepen.
                Dit is pas nadat het splashscreen 3 seconde is getoond.
            */

            if(checkWinnaar() == true){
                ToonWinnaar toonWinnaar = new ToonWinnaar(spelFrame, strSpeler1, strSpeler2, strTypeSpeler1, strTypeSpeler2,  strSpelerWinnaar);
                toonWinnaar.run();
            }

            timer.stop();
        }
    }
}