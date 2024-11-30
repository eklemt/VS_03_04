/**
 * UseCaseInterface abstracts UseCase classes,<br>
 * and also provides UseCase instances like a factory.
 *
 * @author Wolfgang Renz
 * @version Nov. 26, 2024
 */
public interface UseCaseInterface
{
    // if required here methods apart from Object.toString()

    static UseCaseInterface generate(int size, InputCase start, SortAlgo algo)
    {
        if(start==InputCase.AVERAGE){
            // return new AvgUseCase (size, start, algo, 1000); // sampleSIZE
            // sample realized by parallel java8 stream
            System.err.println(start + " not yet implemented");
            assert(start!=InputCase.AVERAGE);
            return null; // unreachable statement, for compilation only
        }
        else {
            return new UseCase (size, start, algo);
        }
    }
}
