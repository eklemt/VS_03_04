import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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
        /*
        ArrayList<String> data = new ArrayList<>();

        for(int i = 3; i < 17; i++) {
            int size = (int) Math.pow(2, i);
            UseCase uc = new UseCase(size, InputCase.RANDOM, SortAlgo.QUICK);
            data.add(uc.toString());
            System.out.println(uc); // ruft toString-methode auf UseCase-Objekt auf!
        }

        // Write to a CSV file
        String filePath = "5b_output.csv"; // Specify the file name
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ALGO;START;SIZE;COMPARE;COPY\n");
            for (String line : data) {
                writer.write(line + "\n"); // Write each string followed by a newline
            }
            System.out.println("Data written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        */

        UseCaseTable ucs= new UseCaseTable(
                InputCase.RANDOM,
                SortAlgo.SELECT,
                3,
                16,
                Streaming.PAR
        );

        System.out.println(ucs); // ruft toString-methode auf UseCase-Objekt auf!
    }
}
