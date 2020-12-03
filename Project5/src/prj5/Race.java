package prj5;

public class Race {
    private String race;
    private int deathCase;
    private int cases;
    private double CFR;

    public Race(String name) {
        this.race = name;
        this.cases = 0;
        this.CFR = 0;
    }


    /**
     * get the race name
     * 
     * @return
     *         the race name
     */
    public String getRace() {
        return race;
    }



    /**
     * get the death case
     * 
     * @return
     *         the death case field
     */
    public int getDeathCase() {
        return deathCase;
    }


    /**
     * set up the death case
     * 
     * @param deathCase
     *            the given death case
     */
    public void setDeathCase(int deathCase) {
        this.deathCase = deathCase;
    }


    /**
     * get the total cases
     * 
     * @return
     *         the total case
     */
    public int getCases() {
        return cases;
    }


    /**
     * set up the cases field
     * 
     * @param totalCase
     *            the given totalCase
     */
    public void setCases(int totalCase) {
        this.cases = totalCase;
    }


    /**
     * get the CFR
     * 
     * @return
     *         the CFR
     */
    public double getCFR() {
        return CFR;
    }


    /**
     * set up the CFR field
     * 
     * @param CFR
     *            the given CFR
     */
    public void setCFR() {
        if (cases == -1 || deathCase == -1) {
            this.CFR = -1;
        }
        else {
            this.CFR = (double)deathCase * 100 / cases;
        }
    }
    
    public int compareTo(Race otherRace) {
       double a = this.getCFR();
       double b = otherRace.getCFR();
       if (a > b) {
           return -1;
       }
       else if (a == b) {
           return 0;
       }
       return 1;
       
    }

   
    
}