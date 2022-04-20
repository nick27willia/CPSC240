import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

// Left side of PopupWindow
public class LeftFormPanel extends JPanel {
    private static LeftFormPanel instance;
    private JTextField recipeNameInput;
    private DefaultListModel<String> ingredientsModel;
    private JList<String> ingredientsList;
    // Make singleton
    public static LeftFormPanel getInstance(){
        if(instance == null){
            instance = new LeftFormPanel();
        }
        return instance;
    }
    private LeftFormPanel(){
        super();
        this.setPreferredSize(new Dimension(300,500));
        this.setMaximumSize(new Dimension(300,500));
        this.setBorder(new EmptyBorder(12, 12, 12, 12));
        this.setBackground(Color.decode("#DDE0FB"));

        // Sets a vertical layout
        BoxLayout thisLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(thisLayout);
        // Recipe name label for input
        this.add(this.buildRecipeNameLabel());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        // Recipe name input
        this.add(this.buildRecipeNameInput());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 16)));
        // Ingredients list label
        this.add(this.buildIngredientsLabel());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        // Ingredients list
        this.add(this.buildIngredientsList());
        // Panel that holds add and delete ingredients buttons
        this.add(this.buildIngredientsButtonsPanel());

        // Aligns button at bottom
        this.add(Box.createVerticalGlue());
        // Add new recipe button
        this.add(this.buildAddNewRecipeButton());
    }
    // Recipe name label for input
    private JLabel buildRecipeNameLabel(){
        return new JLabel("Recipe Name");
    }
    // Recipe name input
    private JTextField buildRecipeNameInput(){
        this.recipeNameInput = new JTextField();
        this.recipeNameInput.setAlignmentX(0);
        this.recipeNameInput.setPreferredSize(new Dimension(300,24));
        this.recipeNameInput.setMaximumSize(new Dimension(300,24));
        return this.recipeNameInput;
    }
    // Ingredients list label
    private JLabel buildIngredientsLabel(){
        return new JLabel("Ingredients");
    }
    // Ingredients list
    private JList<String> buildIngredientsList(){
        this.ingredientsModel = new DefaultListModel<>();
        this.ingredientsList = new JList<>(ingredientsModel);
        this.ingredientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ingredientsList.setAlignmentX(0);
        this.ingredientsList.setPreferredSize(new Dimension(300,250));
        this.ingredientsList.setMaximumSize(new Dimension(300,250));
        return this.ingredientsList;
    }
    // Panel that holds add and delete ingredients buttons
    private JPanel buildIngredientsButtonsPanel(){
        JPanel ingredientButtonsPanel = new JPanel();
        ingredientButtonsPanel.setBorder(new EmptyBorder(12, 0, 12, 0));
        ingredientButtonsPanel.setBackground(Color.decode("#DDE0FB"));
        ingredientButtonsPanel.setAlignmentX(0);
        // Sets a horizontal layout
        BoxLayout ingredientButtonsPanelLayout = new BoxLayout(ingredientButtonsPanel, BoxLayout.X_AXIS);
        ingredientButtonsPanel.setLayout(ingredientButtonsPanelLayout);
        // Add new ingredient button
        ingredientButtonsPanel.add(this.buildAddNewIngredientButton());
        // Spacer
        ingredientButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        // Delete ingredient button
        ingredientButtonsPanel.add(this.buildDeleteIngredientButton());
        return ingredientButtonsPanel;
    }
    // Add new ingredient button
    private JButton buildAddNewIngredientButton(){
        JButton addNewIngredientButton = new Button("Add");
        addNewIngredientButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        addNewIngredientButton.setPreferredSize(new Dimension(140, 25));
        addNewIngredientButton.setMaximumSize(new Dimension(140, 25));
        addNewIngredientButton.addActionListener(ae -> {
            String ingredient = (String)JOptionPane.showInputDialog(addNewIngredientButton, "Enter an ingredient",
                    "", JOptionPane.PLAIN_MESSAGE, null, null, "");
            if(ingredient != null && !ingredient.equals("")){
                this.ingredientsModel.addElement(ingredient);
                this.refreshIngredientsListContents();
            }
        });
        return addNewIngredientButton;
    }
    // Delete ingredient button
    private JButton buildDeleteIngredientButton(){
        JButton deleteIngredientButton = new Button("Delete");
        deleteIngredientButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        deleteIngredientButton.setPreferredSize(new Dimension(140, 25));
        deleteIngredientButton.setMaximumSize(new Dimension(140, 25));
        deleteIngredientButton.addActionListener(ae -> {
            String ingredient = this.ingredientsList.getSelectedValue();
            this.ingredientsModel.removeElement(ingredient);
            this.refreshIngredientsListContents();
        });
        return deleteIngredientButton;
    }
    // Add new recipe button
    private JButton buildAddNewRecipeButton(){
        JButton addNewRecipeButton = new Button("Add New Recipe");
        addNewRecipeButton.addActionListener(ae -> this.onAddNewRecipeButtonClick());
        return addNewRecipeButton;
    }
    private void onAddNewRecipeButtonClick(){
        RightFormPanel rightFormPanel = RightFormPanel.getInstance();
        // Get recipe info
        String recipeId = UUID.randomUUID().toString();
        String recipeName = getRecipeName();
        // Recipe name validation
        if(recipeName.equals("")){
            showInputErrorDialog("Missing a recipe name");
            return;
        }
        ArrayList<String> recipeSteps = rightFormPanel.getSteps();
        // Recipe steps validation
        if(recipeSteps.size() == 0){
            showInputErrorDialog("Missing steps");
            return;
        }
        ArrayList<String> recipeIngredients = getIngredients();
        // Recipe ingredients validation
        if(recipeIngredients.size() == 0){
            showInputErrorDialog("Missing ingredients");
            return;
        }
        // Add & save recipe
        RecipeManager.getInstance().addRecipe(new Recipe(recipeId, recipeName, recipeSteps, recipeIngredients));
        RecipeListPanel.getInstance().refreshRecipesListContents();
        // Clear user inputs
        this.clearInputs();
        rightFormPanel.clearInputs();
    }
    private void showInputErrorDialog(String errorMsg){
        JOptionPane.showMessageDialog(this, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Updates the contents in the ingredients list
    private void refreshIngredientsListContents(){
        this.ingredientsList.setModel(this.ingredientsModel);
    }
    // Clears all user input
    public void clearInputs(){
        this.recipeNameInput.setText("");
        this.ingredientsModel = new DefaultListModel<>();
        this.refreshIngredientsListContents();
    }
    public String getRecipeName(){
        return this.recipeNameInput.getText();
    }
    // Returns ingredients arraylist
    public ArrayList<String> getIngredients(){
        ArrayList<String> ingredients = new ArrayList<>();
        for(int i = 0; i < this.ingredientsModel.getSize(); i++){
            ingredients.add(this.ingredientsModel.get(i));
        }
        return ingredients;
    }
}
