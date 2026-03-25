import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static ArrayList<String> readLines(String filePath) {
        ArrayList<String> lines = new ArrayList();

        File file = new File(filePath);
        if(!file.exists()) {
            return lines;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        }
        catch (IOException e) {
            System.out.println("something went wrong");
        }
        return lines;
    }
    public static void writeLines(String filePath, ArrayList<String> lines) {
        new File("data").mkdirs();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e ) {
            System.out.println("something went wrong");
        }
    }
}
