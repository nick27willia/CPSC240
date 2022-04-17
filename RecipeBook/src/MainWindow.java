package RecipeBook.src;

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
        this.baseFrame.setPreferredSize(new Dimension(800, 600));
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
        recipeListPanel.add(Box.createRigidArea(new Dimension(0, 16)));

        JLabel sortLabel = new JLabel("Sort");
        sortLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        recipeListPanel.add(sortLabel);
        recipeListPanel.add(Box.createRigidArea(new Dimension(0, 4)));

        // Creates the sorting options combobox
        String[] sortOptions = new String[]{"Alphabetically, A-Z"};
        JComboBox<String> sortOptionsList = new JComboBox<>(sortOptions);
        Dimension sortOptionsListDimensions = new Dimension(300, 36);
        sortOptionsList.setPreferredSize(sortOptionsListDimensions);
        sortOptionsList.setMaximumSize(sortOptionsListDimensions);
        sortOptionsList.setAlignmentX(0);
        recipeListPanel.add(sortOptionsList);
        recipeListPanel.add(Box.createRigidArea(new Dimension(0, 4)));

        // Creates the array for the recipes list component
        DefaultListModel<String> recipesModel = new DefaultListModel<>();
        recipesModel.addElement("Bacon Egg & Cheese");
        recipesModel.addElement("Spaghetti");
        recipesModel.addElement("BBQ Sandwich");

        // Creates the recipes list component
        JList<String> recipesList = new JList<>(recipesModel);
        recipesList.setAlignmentX(0);
        Dimension recipesListDimensions = new Dimension(300, 250);
        recipesList.setPreferredSize(recipesListDimensions);
        recipesList.setMaximumSize(recipesListDimensions);
        recipeListPanel.add(recipesList);

        // Aligns button at bottom
        recipeListPanel.add(Box.createVerticalGlue());
        JButton addNewRecipeButton = new Button("Add New Recipe");
        // Opens the popup window on click
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
        Dimension recipeInfoPanelDimensions = new Dimension(500, 600);
        recipeInfoPanel.setPreferredSize(recipeInfoPanelDimensions);
        recipeInfoPanel.setMaximumSize(recipeInfoPanelDimensions);

        // Sets a vertical layout
        BoxLayout recipeInfoPanelLayout = new BoxLayout(recipeInfoPanel, BoxLayout.Y_AXIS);
        recipeInfoPanel.setLayout(recipeInfoPanelLayout);

        JLabel recipeTitleLabel = new JLabel("Chicken and Rice");
        recipeTitleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        recipeInfoPanel.add(recipeTitleLabel);
        recipeInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Creates a panel to align the ingredients and steps horizontally on the same line
        JPanel ingredientsAndStepsPanel = new JPanel();
        ingredientsAndStepsPanel.setAlignmentX(0);
        Dimension ingredientsAndStepsPanelDimensions = new Dimension(500, 300);
        ingredientsAndStepsPanel.setPreferredSize(ingredientsAndStepsPanelDimensions);
        ingredientsAndStepsPanel.setMaximumSize(ingredientsAndStepsPanelDimensions);
        ingredientsAndStepsPanel.setBackground(Color.decode("#DDE0FB"));

        BoxLayout ingredientsAndStepsPanelLayout = new BoxLayout(ingredientsAndStepsPanel, BoxLayout.X_AXIS);
        ingredientsAndStepsPanel.setLayout(ingredientsAndStepsPanelLayout);

        // Creates the ingredients panel that holds the heading and list
        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setAlignmentX(0);
        Dimension ingredientsPanelDimensions = new Dimension(250, 300);
        ingredientsPanel.setPreferredSize(ingredientsPanelDimensions);
        ingredientsPanel.setMaximumSize(ingredientsPanelDimensions);
        ingredientsPanel.setBackground(Color.decode("#DDE0FB"));

        BoxLayout ingredientsPanelLayout = new BoxLayout(ingredientsPanel, BoxLayout.Y_AXIS);
        ingredientsPanel.setLayout(ingredientsPanelLayout);

        JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        ingredientsPanel.add(ingredientsLabel);
        ingredientsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JEditorPane ingredientsList = new JEditorPane();
        ingredientsList.setBackground(Color.decode("#DDE0FB"));
        ingredientsList.setContentType("text/html");
        ingredientsList.setEditable(false);
        ingredientsList.setText("<html><ul style='margin:0px 20px'><li>Chicken</li><li>Rice</li></ul></html>");
        ingredientsList.setAlignmentX(0);
        ingredientsPanel.add(ingredientsList);

        ingredientsAndStepsPanel.add(ingredientsPanel);

        // Creates the steps panel that holds the heading and list
        JPanel stepsPanel = new JPanel();
        stepsPanel.setAlignmentX(0);
        Dimension stepsPanelDimensions = new Dimension(250, 300);
        stepsPanel.setPreferredSize(stepsPanelDimensions);
        stepsPanel.setMaximumSize(stepsPanelDimensions);
        stepsPanel.setBackground(Color.decode("#DDE0FB"));

        BoxLayout stepsPanelLayout = new BoxLayout(stepsPanel, BoxLayout.Y_AXIS);
        stepsPanel.setLayout(stepsPanelLayout);

        JLabel stepsLabel = new JLabel("Steps");
        stepsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        stepsPanel.add(stepsLabel);
        stepsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JEditorPane stepsList = new JEditorPane();
        stepsList.setBackground(Color.decode("#DDE0FB"));
        stepsList.setContentType("text/html");
        stepsList.setEditable(false);
        stepsList.setText("<html><ol style='margin:0px 20px'><li>Cook chicken</li><li>Cook rice</li></ol></html>");
        stepsList.setAlignmentX(0);
        stepsPanel.add(stepsList);

        ingredientsAndStepsPanel.add(stepsPanel);

        recipeInfoPanel.add(ingredientsAndStepsPanel);

        recipeInfoPanel.add(Box.createVerticalGlue());

        // Creates a panel to horizontally align the edit and delete buttons
        JPanel recipeInfoButtonsPanel = new JPanel();
        recipeInfoButtonsPanel.setAlignmentX(0);
        Dimension recipeInfoButtonsPanelDimensions = new Dimension(500, 50);
        recipeInfoButtonsPanel.setPreferredSize(recipeInfoButtonsPanelDimensions);
        recipeInfoButtonsPanel.setMaximumSize(recipeInfoButtonsPanelDimensions);
        recipeInfoButtonsPanel.setBackground(Color.decode("#DDE0FB"));

        BoxLayout recipeInfoButtonsPanelLayout = new BoxLayout(recipeInfoButtonsPanel, BoxLayout.X_AXIS);
        recipeInfoButtonsPanel.setLayout(recipeInfoButtonsPanelLayout);

        JButton editRecipeButton = new Button("Edit Recipe");
        recipeInfoButtonsPanel.add(editRecipeButton);
        recipeInfoButtonsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        JButton deleteRecipeButton = new Button("Delete Recipe");
        recipeInfoButtonsPanel.add(deleteRecipeButton);

        recipeInfoPanel.add(recipeInfoButtonsPanel);

        this.baseLayoutPanel.add(recipeInfoPanel);
    }
}
