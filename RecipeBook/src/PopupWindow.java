import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PopupWindow {
    private JFrame baseFrame;
    private JPanel baseLayoutPanel;

    public PopupWindow(){
        this.baseFrame = new JFrame("Recipe");
        this.baseFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.baseLayoutPanel = new JPanel();
        BoxLayout baseLayout = new BoxLayout(this.baseLayoutPanel, BoxLayout.X_AXIS);
        this.baseLayoutPanel.setLayout(baseLayout);
        this.baseLayoutPanel.setBackground(Color.decode("#DDE0FB"));

        this.buildLeftFormPanel();
        this.buildRightFormPanel();

        this.baseFrame.getContentPane().add(this.baseLayoutPanel);
        this.baseFrame.setPreferredSize(new Dimension(600, 500));
        this.baseFrame.pack();
        this.baseFrame.setResizable(false);
        this.baseFrame.setVisible(false);
    }
    // Creates the left side of the form
    public void buildLeftFormPanel(){
        JPanel leftFormPanel = new JPanel();
        Dimension leftFormPanelDimensions = new Dimension(300,500);
        leftFormPanel.setPreferredSize(leftFormPanelDimensions);
        leftFormPanel.setMaximumSize(leftFormPanelDimensions);
        leftFormPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        leftFormPanel.setBackground(Color.decode("#DDE0FB"));

        // Sets a vertical layout
        BoxLayout leftFormPanelLayout = new BoxLayout(leftFormPanel, BoxLayout.Y_AXIS);
        leftFormPanel.setLayout(leftFormPanelLayout);

        JLabel recipeNameLabel = new JLabel("Recipe Name");
        leftFormPanel.add(recipeNameLabel);
        leftFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField recipeNameInput = new JTextField();
        recipeNameInput.setAlignmentX(0);
        Dimension recipeNameInputDimensions = new Dimension(300,24);
        recipeNameInput.setPreferredSize(recipeNameInputDimensions);
        recipeNameInput.setMaximumSize(recipeNameInputDimensions);
        leftFormPanel.add(recipeNameInput);
        leftFormPanel.add(Box.createRigidArea(new Dimension(0, 16)));

        JLabel ingredientsLabel = new JLabel("Ingredients");
        leftFormPanel.add(ingredientsLabel);
        leftFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        DefaultListModel<String> ingredientsModel = new DefaultListModel<>();
        ingredientsModel.addElement("Bacon");
        ingredientsModel.addElement("Egg");
        ingredientsModel.addElement("Cheese");

        JList<String> ingredientsList = new JList<>(ingredientsModel);
        ingredientsList.setAlignmentX(0);
        Dimension ingredientsListDimensions = new Dimension(300,250);
        ingredientsList.setPreferredSize(ingredientsListDimensions);
        ingredientsList.setMaximumSize(ingredientsListDimensions);
        leftFormPanel.add(ingredientsList);

        JPanel ingredientButtonsPanel = new JPanel();
        ingredientButtonsPanel.setBorder(new EmptyBorder(12, 0, 12, 0));
        ingredientButtonsPanel.setBackground(Color.decode("#DDE0FB"));
        ingredientButtonsPanel.setAlignmentX(0);
        // Sets a horizontal layout
        BoxLayout ingredientButtonsPanelLayout = new BoxLayout(ingredientButtonsPanel, BoxLayout.X_AXIS);
        ingredientButtonsPanel.setLayout(ingredientButtonsPanelLayout);

        Dimension buttonDimensions = new Dimension(140, 25);

        JButton addNewIngredientButton = new Button("Add");
        addNewIngredientButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        addNewIngredientButton.setPreferredSize(buttonDimensions);
        addNewIngredientButton.setMaximumSize(buttonDimensions);
        ingredientButtonsPanel.add(addNewIngredientButton);

        ingredientButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        JButton deleteIngredientButton = new Button("Delete");
        deleteIngredientButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        deleteIngredientButton.setPreferredSize(buttonDimensions);
        deleteIngredientButton.setMaximumSize(buttonDimensions);
        ingredientButtonsPanel.add(deleteIngredientButton);

        leftFormPanel.add(ingredientButtonsPanel);

        // Aligns button at bottom
        leftFormPanel.add(Box.createVerticalGlue());
        JButton addNewRecipeButton = new Button("Add New Recipe");
        leftFormPanel.add(addNewRecipeButton);


        this.baseLayoutPanel.add(leftFormPanel);
    }
    // Creates the right side of the form
    public void buildRightFormPanel(){
        JPanel rightFormPanel = new JPanel();
        Dimension rightFormPanelDimensions = new Dimension(300, 500);
        rightFormPanel.setPreferredSize(rightFormPanelDimensions);
        rightFormPanel.setMaximumSize(rightFormPanelDimensions);
        rightFormPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        rightFormPanel.setBackground(Color.decode("#DDE0FB"));

        // Sets a vertical layout
        BoxLayout rightFormPanelLayout = new BoxLayout(rightFormPanel, BoxLayout.Y_AXIS);
        rightFormPanel.setLayout(rightFormPanelLayout);

        rightFormPanel.add(Box.createRigidArea(new Dimension(0, 67)));

        JLabel stepsLabel = new JLabel("Steps");
        rightFormPanel.add(stepsLabel);
        rightFormPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        DefaultListModel<String> stepsModel = new DefaultListModel<>();
        stepsModel.addElement("Add customer to grill");

        JList<String> stepsList = new JList<>(stepsModel);
        Dimension stepsListDimensions = new Dimension(300,250);
        stepsList.setPreferredSize(stepsListDimensions);
        stepsList.setMaximumSize(stepsListDimensions);
        stepsList.setAlignmentX(0);
        rightFormPanel.add(stepsList);

        JPanel stepsButtonsPanel = new JPanel();
        stepsButtonsPanel.setBorder(new EmptyBorder(12, 0, 12, 0));
        stepsButtonsPanel.setBackground(Color.decode("#DDE0FB"));
        stepsButtonsPanel.setAlignmentX(0);
        // Sets a horizontal layout
        BoxLayout stepsButtonsPanelLayout = new BoxLayout(stepsButtonsPanel, BoxLayout.X_AXIS);
        stepsButtonsPanel.setLayout(stepsButtonsPanelLayout);

        Dimension buttonDimensions = new Dimension(140, 25);

        JButton addNewStepButton = new Button("Add");
        addNewStepButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        addNewStepButton.setPreferredSize(buttonDimensions);
        addNewStepButton.setMaximumSize(buttonDimensions);
        stepsButtonsPanel.add(addNewStepButton);

        stepsButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        JButton deleteStepButton = new Button("Delete");
        deleteStepButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        deleteStepButton.setPreferredSize(buttonDimensions);
        deleteStepButton.setMaximumSize(buttonDimensions);
        stepsButtonsPanel.add(deleteStepButton);

        rightFormPanel.add(stepsButtonsPanel);
        rightFormPanel.add(Box.createVerticalGlue());

        this.baseLayoutPanel.add(rightFormPanel);
    }
    public void show(boolean shouldShow){
        this.baseFrame.setVisible(shouldShow);
    }
}
