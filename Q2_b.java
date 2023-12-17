import java.io.*;

public class Q2_b {
    public static void main(String[] args) {
        String fileRead = "input.txt";
        String fileWrite = "output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileRead));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite));

            String line;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                result += Integer.parseInt(line);
            }

            writer.write(Integer.toString(result));

            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found or couldn't be read");
        }
    }
}
