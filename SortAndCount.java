 /**
 * Abstract class Sort is responsible for operations and their counting.
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public abstract class SortAndCount
{
    private static int cmp;
    private static int cpy;
    
    public SortAndCount(){
        cmp = 0;
        cpy = 0;
    }
    
    protected void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        cpy+=3;
    }
    
    public abstract void  sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w)
    {
        cmp++;
        return (v.compareTo(w) < 0);
        
    }
     protected void exchAux(Comparable[] source,Comparable[] desti, int i, int j){
        desti[i] = source[j];
        cpy++;
        
    }
    
    public int getCmp(){
        return cmp;
    }
    
    public int getCpy(){
        return cpy;
    }
    
    
}
