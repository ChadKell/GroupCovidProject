package prj5;
/**
 * input the stuff
 * @author ckell
 *
 */
public class Input {
    
    public static void main(String[] s)
    {
        CFRReader scan = null;
        if (s.length == 1)
        {
            scan = new CFRReader(s[0]);
        }
        else {
            scan = new CFRReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        new CovidWindow(scan);
        
    }
}
