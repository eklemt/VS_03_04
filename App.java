
/**
 * class App as an example.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class App
{
    public static void main(String[] args)
    {
        UseCase uc= new UseCase(16, InputCase.RANDOM, SortAlgo.QUICK);
        System.out.println(uc); // ruft toString-methode auf UseCase-Objekt auf!
    }
}
