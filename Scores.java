import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scores {
  File file = new File("scores.txt");
    String[][] getScores() {
        try {
            Scanner myReader = new Scanner(file);
            int count = 0;
            while (myReader.hasNextLine()) {
              myReader.nextLine();
              count++;
            }
            myReader.close();

            String[][] scores = new String[count][2];
            count = 0;
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              scores[count] = data.split(";");
              count++;
            }
            myReader.close();
            return scores;

          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new String[0][0];
          }
    }

    void addScore(String[] arr) {
      try {
        FileWriter myWriter = new FileWriter(file, true);
        myWriter.write(arr[0] + ';' + arr[1] + '\n');
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
