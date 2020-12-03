package prj5;
/**
 * interface class that provides funcionallity to the list
 * @author ckell
 *
 * @param <T>
 */
public interface DLLInterface<T> {
    /**
     * Gets size of list
     * 
     * @return size
     */
    public int size();


    /**
     * Clears the list 
     */
    public void clear();


    /**
     * Checks to see if an object is contained in the DLL
     * 
     * @param object
     *            the object being looked for
     * @return true if contained
     */
    public boolean contains(T object);


    /**
     * Gets the node that contains a certain string. 
     * 
     * @param object
     *            the object that the user is looking for
     * @return the object that has the string
     */
    public T get(String object);


    /**
     * Adds a new entry to the list
     * 
     * @param newEntry
     *            the new entry to be added
     */
    public void add(T newEntry);
}
