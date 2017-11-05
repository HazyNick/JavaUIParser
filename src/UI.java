import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;

public class UI {
    private JFrame frame;
    private JPanel mainPane;
    private JButton loadJSON;
    private JSONStuff getFile;

    public UI() {
        // Initialize the variables
        frame = new JFrame("Java UI Parser");
        mainPane = new JPanel();
        frame.setContentPane(mainPane);
        getFile = new JSONStuff();

        loadJSON = new JButton("Load JSON");
        loadJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        getFile.extractData(selectedFile);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        File selectedFile = fileChooser.getSelectedFile();

        ArrayList<Element> elements = JSON.extractData(getFile.extractData(selectedFile));

        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(loadJSON);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1366, 768));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UI u = new UI();

    }
}
