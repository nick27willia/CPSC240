import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class RecipeInfoPanel extends JPanel {
    private static RecipeInfoPanel instance;
    private JLabel recipeTitleLabel;
    private JEditorPane ingredientsList;
    private JEditorPane stepsList;
    // Make the RecipeInfoPanel class singleton
    public static RecipeInfoPanel getInstance(){
        if(instance == null){
            instance = new RecipeInfoPanel();
        }
        return instance;
    }
    private RecipeInfoPanel(){
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
        // Delete recipe button
        this.add(this.buildDeleteRecipeButton());
    }
    // Recipe title
    private JLabel buildRecipeTitleLabel(){
        this.recipeTitleLabel = new JLabel("Select a recipe");
        this.recipeTitleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        return this.recipeTitleLabel;
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
        this.ingredientsList = new JEditorPane();
        this.ingredientsList.setBackground(Color.decode("#DDE0FB"));
        this.ingredientsList.setContentType("text/html");
        this.ingredientsList.setEditable(false);
        this.ingredientsList.setText("<html><ul style='margin:0px 20px'></ul></html>");
        this.ingredientsList.setAlignmentX(0);
        return this.ingredientsList;
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
        this.stepsList = new JEditorPane();
        this.stepsList.setBackground(Color.decode("#DDE0FB"));
        this.stepsList.setContentType("text/html");
        this.stepsList.setEditable(false);
        this.stepsList.setText("<html><ol style='margin:0px 20px'></ol></html>");
        this.stepsList.setAlignmentX(0);
        return this.stepsList;
    }
    // Delete recipe button
    private JButton buildDeleteRecipeButton(){
        JButton deleteRecipeButton = new Button("Delete Recipe");
        deleteRecipeButton.addActionListener(ae -> {
            RecipeManager recipeManager = RecipeManager.getInstance();
            // Dont allow delete button click if a recipe isnt selected
            if(!recipeManager.getSelectedRecipeId().equals("")) {
                // Prompt the user for confirmation that they want to delete the recipe
                int selection = JOptionPane.showConfirmDialog(deleteRecipeButton, "Are you sure you want to delete the recipe?");
                // 0 means that the user wants to delete
                if (selection == 0) {
                    recipeManager.deleteRecipe(recipeManager.getSelectedRecipeId());
                    recipeManager.setSelectedRecipeId("");
                    this.clearRecipeInfo();
                    RecipeListPanel.getInstance().refreshRecipesListContents();
                }
            }
        });
        return deleteRecipeButton;
    }
    // Updates recipe info
    public void updateRecipeInfo(Recipe recipe){
        this.recipeTitleLabel.setText(recipe.getTitle());
        this.ingredientsList.setText("<html><ul style='margin:0px 20px'>"+arrayListToLi(recipe.getIngredients())+"</ul></html>");
        this.stepsList.setText("<html><ol style='margin:0px 20px'>"+arrayListToLi(recipe.getSteps())+"</ol></html>");
    }
    // Clears recipe info
    private void clearRecipeInfo(){
        this.recipeTitleLabel.setText("");
        this.ingredientsList.setText("<html><ul style='margin:0px 20px'></ul></html>");
        this.stepsList.setText("<html><ol style='margin:0px 20px'></ol></html>");
    }
    // Generates html li string from array list
    private String arrayListToLi(ArrayList<String> arrayList){
        StringBuilder liString= new StringBuilder();
        for (String el : arrayList) {
            liString.append("<li>").append(el).append("</li>");
        }
        return liString.toString();
    }
}
