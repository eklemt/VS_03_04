/**
 * UseCaseInterface abstracts UseCase classes,<br>
 * and also provides UseCase instances like a factory.
 *
 * @author Wolfgang Renz
 * @version Nov. 26, 2024
 */
public interface UseCaseInterface {
    // if required here methods apart from Object.toString()

    static UseCaseInterface generate(int size, InputCase start, SortAlgo algo) {
        if (start == InputCase.AVERAGE) {
            return new AvgUseCase(size, start, algo, 1000);
        } else {
            return new UseCase(size, start, algo);
        }
    }
}
