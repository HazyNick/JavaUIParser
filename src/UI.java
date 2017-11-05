import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
    private ArrayList<Element> element;

    public UI() {
        // Initialize the variables
        frame = new JFrame("Java UI Parser");
        mainPane = new JPanel();
        element = new ArrayList();
        frame.setContentPane(mainPane);
        getFile = new JSONStuff();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnLoadJSON = new JMenu("File");
        menuBar.add(mnLoadJSON);

        JMenuItem mntmLoad = new JMenuItem("Load JSON");
        mntmLoad.setMnemonic(KeyEvent.VK_O);
        mntmLoad.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setMnemonic(KeyEvent.VK_E);
        mntmExit.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

        mnLoadJSON.add(mntmLoad);
        mnLoadJSON.add(mntmExit);

        // loadJSON = new JButton("Load JSON");
        mntmLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPane.removeAll();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        element = getFile.extractData(selectedFile);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                if(element.isEmpty()) {
                    // add statement to say na oh my, sorry to say, wala kang laman
                }
                else {
                    for(int i = 0; i < element.size(); i++) {
                        switch(element.get(i).getInputType()) {
                            case "text": JTextField tf = new JTextField(element.get(i).getPlaceholder());
                                         tf.setFont(new Font("Serif", Font.PLAIN, Integer.parseInt(element.get(i).getFontSize())));
                                         tf.setSize(Integer.parseInt(element.get(i).getWidth()),Integer.parseInt(element.get(i).getHeight()));
                                         tf.setLocation(Integer.parseInt(element.get(i).getLeftPosition()), Integer.parseInt(element.get(i).getTopPosition()));
                                         frame.add(tf);
                                break;
                            case "label": JLabel l = new JLabel(element.get(i).getPlaceholder());
                                          l.setFont(new Font("Serif", Font.PLAIN, Integer.parseInt(element.get(i).getFontSize())));
                                          l.setSize(Integer.parseInt(element.get(i).getWidth()),Integer.parseInt(element.get(i).getHeight()));
                                          l.setLocation(Integer.parseInt(element.get(i).getLeftPosition()), Integer.parseInt(element.get(i).getTopPosition()));
                                          frame.add(l);
                                break;
                            case "button": JButton b = new JButton(element.get(i).getPlaceholder());
                                           b.setFont(new Font("Serif", Font.PLAIN, Integer.parseInt(element.get(i).getFontSize())));
                                           b.setSize(Integer.parseInt(element.get(i).getWidth()),Integer.parseInt(element.get(i).getHeight()));
                                           b.setLocation(Integer.parseInt(element.get(i).getLeftPosition()), Integer.parseInt(element.get(i).getTopPosition()));
                                           frame.add(b);
                                break;
                        }
                    }
                    frame.repaint();
                }
            }

        });

        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1366, 768));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UI u = new UI();

    }
}
