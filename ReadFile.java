import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  static String [] dataArr;
  static String[] questions;
  static String[][] options;
  static String[] answers;
  
  public String[] getQuestions() {
    read("questions.txt");
    return questions;
  }

  public String[][] getOptions() {
    read("questions.txt");
    return options;
  }
  
  public String[] getAnswers() {
    read("questions.txt");
    return answers;
  }
  
  void read(String filename) {
    try {
      File myObj = new File("questions.txt");
      int count =  0;
      
      Scanner reader = new Scanner(myObj);
      while (reader.hasNextLine()) {
        reader.nextLine();
        count++;
      }
      reader.close();

      questions = new String[count];
      options = new String[count][4];
      answers = new String[count];

      int index = 0;
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        dataArr = data.split(";");

        questions[index] = dataArr[0];
        options[index][0] = dataArr[1];
        options[index][1] = dataArr[2];
        options[index][2] = dataArr[3];
        options[index][3] = dataArr[4];
        answers[index] = dataArr[5];
        index++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


}