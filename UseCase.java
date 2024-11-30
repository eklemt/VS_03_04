import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * UseCase class shall prepare startArray with size given 
 * according to InputCase for sorting,
 * then call the sorting algorithm required, then collects no. of operations,
 * and finally is able to return results via toString method.
 *
 * @author Wolfgang Renz, student name
 * @version Nov. 24, 2024, finalization date
 */
public class UseCase
{
    private int size;
    private InputCase start;
    private SortAlgo algo;
    private int cmp, cpy; // No. of operations
    private Integer[] array;
    private List<Integer> list;
    private SortAndCount sortAlgo;

    /**
     * Constructor for objects of class UseCase
     */
    public UseCase(int size, InputCase start, SortAlgo algo)
    {
        this.size = size;
        this.start= start;
        this.algo= algo;
        init();
        shuffle();
        algo();
        getCmpCpy();

        
        
    }

    private void init(){
        array = new Integer[size];
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        list = Arrays.asList(array);
    }

    private void shuffle(){

        switch(start){
            case SORTED:
                break;

            case REVERSE:
                Collections.reverse(list);
                break;

            case RANDOM:
                Collections.shuffle(list, new Random(System.currentTimeMillis()));
                break;

            case AVERAGE:
                break;
        }

        
    }

    private void algo(){

        switch(algo){
            case SELECT:
                sortAlgo = new SelectionSort();
                break;
            case INSERT:
                sortAlgo = new InsertionSort();
                break;
            case MERGE:
                sortAlgo = new MergeSort();
                break;

            case QUICK:
                sortAlgo = new Quick();
                break;

        }
        sortAlgo.sort(array);
    }

    private void getCmpCpy(){
        cmp = sortAlgo.getCmp();
        cpy = sortAlgo.getCpy();

    }

    @Override
    public String toString()
    {
        // to be improved to return formatted output
        return  algo + ";" + start + ";" + size + ";" + cmp + ";" + cpy;
    }
}
