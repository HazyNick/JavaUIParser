import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UI {
    private JFrame frame;
    private JPanel mainPane;
    private JButton loadJSON;

    public UI() {
        frame = new JFrame("Java UI Parser");
        mainPane = new JPanel();
        frame.setContentPane(mainPane);

        loadJSON = new JButton("Load JSON");
        loadJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            }
        });

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
