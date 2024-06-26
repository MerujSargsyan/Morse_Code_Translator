import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        inputWindow();
    }

    public static void printHelp() {
        System.out.println("To translate from text to morse: " + 
             "-m <Text>");
         System.out.println("To translate from morse to text: " + 
             "-t <MorseCode>");
         System.out.println("To see a visual representation of text in " +
            "morse code: -d <Text>");
    }

    public static void inputWindow() {
        JFrame window = new JFrame("Morse Input");
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setLayout(new BorderLayout());

        JComboBox jcb = new JComboBox(new String[]{"from morse", "from text"});

        JTextArea jta = new JTextArea(5, 20);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);

        JTextArea jtaOut = new JTextArea(5, 20);
        jtaOut.setLineWrap(true);
        jtaOut.setWrapStyleWord(true);

        JButton jb = new JButton("Translate");

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] output = new String[2];
                output[0] = (String)jcb.getSelectedItem();
                output[1] = jta.getText();
                parseInput(output, jtaOut);
            }
        });

        window.add(jcb, BorderLayout.NORTH);
        window.add(jta, BorderLayout.WEST);
        window.add(jb, BorderLayout.SOUTH);
        window.add(jtaOut, BorderLayout.EAST);
        window.setVisible(true);
    }

    public static void parseInput(String[] input, JTextArea field) {
        Parser p = new Parser();
        switch(input[0]) {
            //TODO: figure out how to specify type of conversion
            case "from morse":
                field.setText(p.convertMorseToText(input[1]));
                break;
            case "from text":
                field.setText(p.convertTextToMorse(input[1]));
                break;
        }
    }
}

