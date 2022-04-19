import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

// Creates the main window of the application
public class MainWindow {
    private JFrame baseFrame;
    private JPanel baseLayoutPanel;

    public MainWindow(){
        this.baseFrame = new JFrame("Recipe Book");
        this.baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creates an invisible panel that has a horizontal layout.
           This will hold the recipe list panel and the recipe info panel
         */
        this.baseLayoutPanel = new JPanel();
        BoxLayout baseLayout = new BoxLayout(this.baseLayoutPanel, BoxLayout.X_AXIS);
        this.baseLayoutPanel.setLayout(baseLayout);

        // Add the recipe list panel
        this.baseLayoutPanel.add(new RecipeListPanel());
        this.baseLayoutPanel.add(RecipeInfoPanel.getInstance());

        this.baseFrame.getContentPane().add(this.baseLayoutPanel);
        this.baseFrame.setPreferredSize(new Dimension(800, 600));
        this.baseFrame.pack();
        this.baseFrame.setResizable(false);
        this.baseFrame.setVisible(true);
    }
}
