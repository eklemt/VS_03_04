import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a description of class UseCaseTable here.
 *
 * @author Wolfgang Renz
 * @version Nov. 2024
 */
public class UseCaseTable {
    private InputCase start;
    private SortAlgo algo;
    private int from, to;
    private IntStream stream;

    public UseCaseTable(InputCase start, SortAlgo algo, Streaming how) {
        // initialise instance variables
        this(start, algo, 3, 16, how);
    }

    /**
     * Base Constructor for objects of class UseCaseTable
     */
    public UseCaseTable(InputCase start, SortAlgo algo, int from, int to, Streaming how) {
        this.start = start;
        this.algo = algo;
        this.from = from;
        this.to = to;
        // generates stream of ascending int-s:
        IntStream stream = IntStream.rangeClosed(from, to); // default SEQ
        // InputCase.AVERAGE has to use parallel streaming for sampling random fields!
        this.stream = (how == Streaming.SEQ || start == InputCase.AVERAGE) ? stream.parallel() : stream; // FIX: changed this condition
    }

    public String generateTable() {
        long startTime = System.currentTimeMillis();
        String result = stream
                .map(k -> (int) (Math.pow(2, k) + 1e-15)) // size n = integer powers of 2
                .mapToObj(n -> UseCaseInterface.generate(n, start, algo)) // generates UseCase of size n
                .map(uc -> uc.toString())
                .collect(Collectors.joining("\n"));

        // End timing
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("Zeit in Millisekunden: " + elapsedTime);

        return result;
    }

    @Override
    public String toString() {
        return generateTable();
    }
}
