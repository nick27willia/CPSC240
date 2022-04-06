import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates the main window of the application
public class MainWindow {
    public static PopupWindow popupWindow;
    private JFrame baseFrame;
    private JPanel baseLayoutPanel;

    public MainWindow(PopupWindow pw){
        popupWindow = pw;
        this.baseFrame = new JFrame("Recipe Book");
        this.baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creates an invisible panel that has a horizontal layout.
           This will hold the recipe list panel and the recipe info panel
         */
        this.baseLayoutPanel = new JPanel();
        BoxLayout baseLayout = new BoxLayout(this.baseLayoutPanel, BoxLayout.X_AXIS);
        this.baseLayoutPanel.setLayout(baseLayout);

        this.buildRecipeListPanel();
        this.buildRecipeInfoPanel();

        this.baseFrame.getContentPane().add(this.baseLayoutPanel);
        this.baseFrame.setPreferredSize(new Dimension(1000, 600));
        this.baseFrame.pack();
        this.baseFrame.setResizable(false);
        this.baseFrame.setVisible(true);
    }

    // This creates the recipe list panel
    public void buildRecipeListPanel(){
        JPanel recipeListPanel = new JPanel();
        recipeListPanel.setBackground(Color.decode("#98A2FF"));
        recipeListPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
        Dimension recipeListPanelDimensions = new Dimension(300, 600);
        recipeListPanel.setPreferredSize(recipeListPanelDimensions);
        recipeListPanel.setMaximumSize(recipeListPanelDimensions);

        // Sets a vertical layout
        BoxLayout recipeListPanelLayout = new BoxLayout(recipeListPanel, BoxLayout.Y_AXIS);
        recipeListPanel.setLayout(recipeListPanelLayout);

        JLabel header = new JLabel("Recipes");
        header.setFont(new Font("Dialog", Font.BOLD, 20));
        recipeListPanel.add(header);

        // Aligns button at bottom
        recipeListPanel.add(Box.createVerticalGlue());
        JButton addNewRecipeButton = new Button("Add New Recipe");
        addNewRecipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                popupWindow.show(true);
            }
        });
        recipeListPanel.add(addNewRecipeButton);

        this.baseLayoutPanel.add(recipeListPanel);
    }
    // This creates the recipe info panel
    public void buildRecipeInfoPanel(){
        JPanel recipeInfoPanel = new JPanel();
        recipeInfoPanel.setBackground(Color.decode("#DDE0FB"));
        recipeInfoPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        Dimension recipeInfoPanelDimensions = new Dimension(700, 600);
        recipeInfoPanel.setPreferredSize(recipeInfoPanelDimensions);
        recipeInfoPanel.setMaximumSize(recipeInfoPanelDimensions);

        // Sets a vertical layout
        BoxLayout recipeInfoPanelLayout = new BoxLayout(recipeInfoPanel, BoxLayout.Y_AXIS);
        recipeInfoPanel.setLayout(recipeInfoPanelLayout);

        JLabel header = new JLabel("Chicken and Rice");
        header.setFont(new Font("Dialog", Font.BOLD, 24));
        recipeInfoPanel.add(header);

        this.baseLayoutPanel.add(recipeInfoPanel);
    }
}
