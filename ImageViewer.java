import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageViewer {
   
   //fields
   private static final String COPYRIGHT = 
      "ImageViewer by Craig Tuschhoff";
   private static final int WINDOW_HIEGHT = 600;
   private static final int WINDOW_WIDTH = 500;
   
   private JPanel bottomPanel;
   private JPanel centerPanel;
   private JButton chooseButton;
   private JLabel copyrightLabel;
   private JFileChooser fileChooser;
   private JFrame frame;
   private JLabel imageLabel;
   private JPanel topPanel;
   private JButton close;
   
   //constructor
   public ImageViewer() {
      
      //create frame for ImageViewer
      frame = new JFrame();
      
      //set size for frame
      frame.setSize(WINDOW_HIEGHT, WINDOW_WIDTH);
      
      //set title for frame
      frame.setTitle("Imageviewer");
      
      //specify an action for the close button
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //create a layout manager
      frame.setLayout(new BorderLayout());
      
      //create the panels
      buildBottomPanel();
      buildCenterPanel();
      buildTopPanel();
      
      //add the components to the frame
      frame.add(bottomPanel, BorderLayout.SOUTH);
      frame.add(centerPanel, BorderLayout.CENTER);
      frame.add(topPanel, BorderLayout.NORTH);
      
      //set some defaults
      frame.getRootPane().setDefaultButton(chooseButton);
      frame.setLocationRelativeTo(null);
      
      //make window visible
      frame.setVisible(true);
   }
   
   //buildBottomPanel
   private void buildBottomPanel() {
      
      //create panel
      bottomPanel = new JPanel();
      
      //create copyright label
      copyrightLabel = new JLabel(COPYRIGHT);
      
      //add the label to the panel
      bottomPanel.add(copyrightLabel);
   }
   
   //buildCenterPanel
   private void buildCenterPanel() {
      
      //create panel
      centerPanel = new JPanel();

      //create new label for image
      imageLabel = new JLabel();
      
      //add label to panel
      centerPanel.add(imageLabel);
   }
   
   //buildTopPanel
   private void buildTopPanel() {
      
      //create panel
      topPanel = new JPanel();
      
      //create button
      chooseButton = new JButton("Choose Image");
      
      //create close button
      close = new JButton("Close");
      
      //add action listener to button
      chooseButton.addActionListener(new chooseButtonListener());

      //add action listener to button
      close.addActionListener(new closeButtonListener());      

      //add to panel
      topPanel.add(chooseButton);
      topPanel.add(close);
   }
   
   private class chooseButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         //open file chooser to get file from user
         JFileChooser chooser = new JFileChooser();
         chooser.showOpenDialog(frame);
         imageLabel.setIcon(new ImageIcon(chooser.getSelectedFile().getName())); 
      }
   }
   
   private class closeButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         //close the program
         System.exit(1); 
      }
   }
   
   public static void main(String[] args) {
      new ImageViewer();
   }
}