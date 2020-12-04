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
 * 
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
    private String sorted;
    private String curr;
    private State currentState;
    private State[] states;
    /**
     * window constructor
     * 
     * @param cList
     */
    public CovidWindow(CFRReader state) {
        covidReader = state;
        states = covidReader.getState();
        graph = state.getState()[0].getRace();
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
        currentState = state.getState()[0];
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
        representDC.onClick(this, "clickedState");
        representGA.onClick(this, "clickedState");
        representMD.onClick(this, "clickedState");
        representNC.onClick(this, "clickedState");
        representTN.onClick(this, "clickedState");
        representVA.onClick(this, "clickedState");
        sortCFR.onClick(this, "clickedSort");
        sortAlpha.onClick(this, "clickedSort");
        window.setTitle("Covid Data");
        helpSort();
    }


    /**
     * quit button
     * 
     * @param button
     */
    public void quit(Button button) {
        System.exit(0);
    }


    /**
     * sorting the states
     * 
     * @param button
     */
    public void clickedState(Button button) {
        curr = button.getTitle();
        if (button.getTitle().equals("DC")) {
            currentState = states[0];
            curr = currentState.getName();
            System.out.println(curr);
        }
        else if (button.getTitle().equals("MD")) {
            currentState = states[2];
            curr = currentState.getName();
        }
        else if (button.getTitle().equals("GA")) {
            currentState = states[1];
            curr = currentState.getName();
        }
        else if (button.getTitle().equals("NC")) {
            currentState = states[3];
            curr = currentState.getName();
        }
        else if (button.getTitle().equals("TN")) {
            currentState = states[4];
            curr = currentState.getName();
        }
        else if (button.getTitle().equals("VA")) {
            currentState = states[5];
            curr = currentState.getName();

        }
        if (sorted == "CFR")
        {
            currentState.sortCFR();
        }
        else
        {
            currentState.sortAlpha();
        }
        helpSort();

    }


    /**
     * sorting buttons
     * 
     * @param button
     */
    public void clickedSort(Button button) {
        System.out.println(button.getTitle());
        if (button.getTitle().equals("Sort by CFR")) {

            sorted = "CFR";

            currentState.sortCFR();
            
            graph = currentState.getRace();
        }
        if (button.getTitle().equals("Sort by Alpha")) {
            /**
             * this doesnt work rn
             */
            sorted = "Alpha";

            currentState.sortAlpha();
            
            graph = currentState.getRace();
        }

        System.out.println(sorted);
        helpSort();

    }


    private void helpSort() {
        window.removeAllShapes();

        int shapeSpacing = 75;
        double heightChanger = 150;
        System.out.println(graph.getLength());
        for (int i = 0; i < 5; i++) {

            if (graph.get(i).getCFR() <= 0) {
                TextShape nA = new TextShape(100 + i * shapeSpacing, 225, "NA");
                window.addShape(nA);
            }
            else {
                System.out.println(graph.get(i).getCFR());
                Shape bars = new Shape(100 + i * shapeSpacing, 225
                    - (int)((heightChanger / 10) * graph.get(i).getCFR()), 50,
                    (int)((heightChanger / 10) * graph.get(i).getCFR()));
                TextShape numb = new TextShape(100 + i * shapeSpacing, 225,
                    Double.toString(Math.round(graph.get(i).getCFR() * 10)
                        / 10.0));
                window.addShape(bars);
                window.addShape(numb);
            }
        }
    }

}
