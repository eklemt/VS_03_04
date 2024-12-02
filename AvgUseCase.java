import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvgUseCase implements UseCaseInterface {
    private int size;
    private int sampleSize;   // Number of UseCase instances for sampling
    private InputCase start;  // For InputCase.RANDOM
    private SortAlgo algo;    // The sorting algorithm
    private List<Long> compareCounts; // List to hold compareTo counts

    public AvgUseCase(int size, InputCase inputCase, SortAlgo algo, int sampleSize) {
        this.sampleSize = sampleSize;
        this.start = inputCase;
        this.algo = algo;
        this.compareCounts = IntStream.range(0, sampleSize)
                .parallel() // Ensure parallel processing
                .mapToObj(j -> {
                    System.out.println("Processing sample " + (j + 1) + " of " + sampleSize);
                    return UseCaseInterface.generate(size, InputCase.RANDOM, algo);
                })
                .mapToLong(uc -> {
                    return ((UseCase) uc).getComp(); // Cast to UseCase to access getComp
                })
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Sample generation complete.");
    }

    private int randomSize() {
        return (int) Math.pow(2, (int) (Math.random() * 10 + 1)); // Random power of 2
    }

    /*
    @Override
    public String toString()
    {
        // to be improved to return formatted output
        return  algo + ";" + start + ";" + size + ";" + compareCounts + ";";
    }*/

    @Override
    public String toString() {
        double mean = compareCounts.stream().mapToLong(Long::longValue).average().orElse(0);
        long upperLimit = compareCounts.stream().mapToLong(Long::longValue).max().orElse(0);
        long lowerLimit = compareCounts.stream().mapToLong(Long::longValue).min().orElse(0);
        long range = compareCounts.stream().mapToLong(Long::longValue).max().orElse(0)
                - compareCounts.stream().mapToLong(Long::longValue).min().orElse(0);

        return "AVERAGE; " + mean + ";" + lowerLimit + ";" + upperLimit + ";" + range;
    }
}
