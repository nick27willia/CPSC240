import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RecipeInfoPanel extends JPanel {
    public RecipeInfoPanel(){
        super();
        this.setBackground(Color.decode("#DDE0FB"));
        this.setBorder(new EmptyBorder(12, 12, 12, 12));
        this.setPreferredSize(new Dimension(500, 600));
        this.setMaximumSize(new Dimension(500, 600));
        // Sets a vertical layout
        BoxLayout recipeInfoPanelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(recipeInfoPanelLayout);
        // Recipe title
        this.add(this.buildRecipeTitleLabel());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        // Creates a panel to align the ingredients and steps horizontally on the same line
        this.add(this.buildIngredientsAndStepsPanel());
        // Spacer
        this.add(Box.createVerticalGlue());
        // Creates a panel to horizontally align the edit and delete buttons
        this.add(this.buildRecipeInfoButtonsPanel());
    }
    // Recipe title
    private JLabel buildRecipeTitleLabel(){
        JLabel recipeTitleLabel = new JLabel("Chicken and Rice");
        recipeTitleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        return recipeTitleLabel;
    }
    // Creates a panel to align the ingredients and steps horizontally on the same line
    private JPanel buildIngredientsAndStepsPanel(){
        JPanel ingredientsAndStepsPanel = new JPanel();
        ingredientsAndStepsPanel.setAlignmentX(0);
        ingredientsAndStepsPanel.setPreferredSize(new Dimension(500, 300));
        ingredientsAndStepsPanel.setMaximumSize(new Dimension(500, 300));
        ingredientsAndStepsPanel.setBackground(Color.decode("#DDE0FB"));
        // Set horizontal layout
        BoxLayout ingredientsAndStepsPanelLayout = new BoxLayout(ingredientsAndStepsPanel, BoxLayout.X_AXIS);
        ingredientsAndStepsPanel.setLayout(ingredientsAndStepsPanelLayout);
        // Ingredients panel that holds the ingredients label and ingredients list
        ingredientsAndStepsPanel.add(this.buildIngredientsPanel());
        // Steps panel that holds the steps label and steps list
        ingredientsAndStepsPanel.add(this.buildStepsPanel());
        return ingredientsAndStepsPanel;
    }
    // Ingredients panel that holds the ingredients label and ingredients list
    private JPanel buildIngredientsPanel(){
        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setAlignmentX(0);
        ingredientsPanel.setPreferredSize(new Dimension(250, 300));
        ingredientsPanel.setMaximumSize(new Dimension(250, 300));
        ingredientsPanel.setBackground(Color.decode("#DDE0FB"));
        // Sets vertical layout
        BoxLayout ingredientsPanelLayout = new BoxLayout(ingredientsPanel, BoxLayout.Y_AXIS);
        ingredientsPanel.setLayout(ingredientsPanelLayout);
        // Ingredients label
        ingredientsPanel.add(this.buildIngredientsLabel());
        ingredientsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Ingredients list
        ingredientsPanel.add(this.buildIngredientsList());
        return ingredientsPanel;
    }
    // Ingredients label
    private JLabel buildIngredientsLabel(){
        JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        return ingredientsLabel;
    }
    // Ingredients list
    private JEditorPane buildIngredientsList(){
        JEditorPane ingredientsList = new JEditorPane();
        ingredientsList.setBackground(Color.decode("#DDE0FB"));
        ingredientsList.setContentType("text/html");
        ingredientsList.setEditable(false);
        ingredientsList.setText("<html><ul style='margin:0px 20px'><li>Chicken</li><li>Rice</li></ul></html>");
        ingredientsList.setAlignmentX(0);
        return ingredientsList;
    }
    // Steps panel that holds the steps label and steps list
    private JPanel buildStepsPanel(){
        JPanel stepsPanel = new JPanel();
        stepsPanel.setAlignmentX(0);
        stepsPanel.setPreferredSize(new Dimension(250, 300));
        stepsPanel.setMaximumSize(new Dimension(250, 300));
        stepsPanel.setBackground(Color.decode("#DDE0FB"));
        // Sets vertical layout
        BoxLayout stepsPanelLayout = new BoxLayout(stepsPanel, BoxLayout.Y_AXIS);
        stepsPanel.setLayout(stepsPanelLayout);
        // Steps label
        stepsPanel.add(this.buildStepsLabel());
        stepsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Steps list
        stepsPanel.add(this.buildStepsList());
        return stepsPanel;
    }
    // Steps label
    private JLabel buildStepsLabel(){
        JLabel stepsLabel = new JLabel("Steps");
        stepsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        return stepsLabel;
    }
    // Steps list
    private JEditorPane buildStepsList(){
        JEditorPane stepsList = new JEditorPane();
        stepsList.setBackground(Color.decode("#DDE0FB"));
        stepsList.setContentType("text/html");
        stepsList.setEditable(false);
        stepsList.setText("<html><ol style='margin:0px 20px'><li>Cook chicken</li><li>Cook rice</li></ol></html>");
        stepsList.setAlignmentX(0);
        return stepsList;
    }
    // Creates a panel to horizontally align the edit and delete buttons
    private JPanel buildRecipeInfoButtonsPanel(){
        JPanel recipeInfoButtonsPanel = new JPanel();
        recipeInfoButtonsPanel.setAlignmentX(0);
        recipeInfoButtonsPanel.setPreferredSize(new Dimension(500, 50));
        recipeInfoButtonsPanel.setMaximumSize(new Dimension(500, 50));
        recipeInfoButtonsPanel.setBackground(Color.decode("#DDE0FB"));
        // Sets horizontal layout
        BoxLayout recipeInfoButtonsPanelLayout = new BoxLayout(recipeInfoButtonsPanel, BoxLayout.X_AXIS);
        recipeInfoButtonsPanel.setLayout(recipeInfoButtonsPanelLayout);
        // Edit recipe button
        recipeInfoButtonsPanel.add(this.buildEditRecipeButton());
        // Spacer
        recipeInfoButtonsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        // Delete recipe button
        recipeInfoButtonsPanel.add(this.buildDeleteRecipeButton());
        return recipeInfoButtonsPanel;
    }
    // Edit recipe button
    private JButton buildEditRecipeButton(){
        JButton editRecipeButton = new Button("Edit Recipe");
        return editRecipeButton;
    }
    // Delete recipe button
    private JButton buildDeleteRecipeButton(){
        JButton deleteRecipeButton = new Button("Delete Recipe");
        return deleteRecipeButton;
    }
}
