package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
/**
 * window for the project/
 * @author ckell
 *
 */
public class CovidWindow {
    private Window window;
    private Button sortAlpha;
    private Button quit;
    private Button sortCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private LinkedList<Race> graph;
    private CFRReader covidReader;
    
    /**
     * window constructor
     * @param cList
     */
    public CovidWindow(CFRReader state) {
        covidReader = state;
        window = new Window();
        window.setSize(1000, 650);
        sortAlpha = new Button("Sort by Alpha");
        sortCFR = new Button("Sort by CFR");
        representDC = new Button("DC");
        representGA = new Button("GA");
        representMD = new Button("MD");
        representNC = new Button("NC");
        representTN = new Button("TN");
        representVA = new Button("VA");
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);
        quit.onClick(this, "quit");
        representDC.onClick(this, "representCovidDC");
        representGA.onClick(this, "representCovidGA");
        representMD.onClick(this, "representCovidMD");
        representNC.onClick(this, "representCovidNC");
        representTN.onClick(this, "representCovidTN");
        representVA.onClick(this, "representCovidVA");
        window.setTitle("Covid Data");
        
    }


    /**
     * quit button
     * 
     * @param button
     */
    public void quit(Button button) {
        System.exit(0);
    }

}
