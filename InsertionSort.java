/**
 * class InsertionSort from Sedgewick.
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class InsertionSort extends SortAndCount
{
    public void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0; j--){
                if (less(a[j], a[j-1])){ // input dependent
                    exch(a, j, j-1);
                }
                else{
                    break; 
                }
            }
        }
    }
}
