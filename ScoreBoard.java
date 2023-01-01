import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;  
 
public class ScoreBoard {
    // frame
    JFrame f;
    //bktoquiz
    JButton bktoquiz,reset;
    // Table
    JTable j;
    

    // Constructor
    ScoreBoard()
    {
        // Frame initialization
        f = new JFrame();

        //bktoquiz 
        bktoquiz = new JButton("Back to Quiz");
        bktoquiz.setBounds(150,5, 100  , 15);
        //action on button that takes the program back to the login page
        bktoquiz.addActionListener(e ->{
            new LoginPage();
            f.dispose();
        });
        reset =new JButton(
            "Reset Score");
        reset.setBounds(250,5,100,15);
        reset.addActionListener(e -> {File file = new File("scores.txt");//action that takes the program to the scoreboard
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        new ScoreBoard();
        f.dispose();
        }
        
        );
        // Frame Title
        f.setTitle("ScoreBoard");
 
        // Data to be displayed in the JTable
        Scores scoresObj = new Scores();
        String[][] data = scoresObj.getScores();
 
        // Column Names
        String[] columnNames = { "Name", "Score" };
 
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setSize( 200, 300);
        
        
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.add(bktoquiz);
        f.add(reset);
        
        // Packing the windows around the components 
        f.setSize(500,500);

        f.setLayout(new FlowLayout());

        f.setLocationRelativeTo(null);
        // Frame Visible = true
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    // Driver  method
    public static void main(String[] args)
    {
        new ScoreBoard();
    }
}