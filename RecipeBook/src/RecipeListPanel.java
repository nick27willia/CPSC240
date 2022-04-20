import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

// The recipe list panel is the panel on the left of MainWindow
public class RecipeListPanel extends JPanel {
    private static RecipeListPanel instance;
    private JList<String> recipesList;
    private RecipesSortType recipesSortType = RecipesSortType.ALPHABETICAL;
    // Make the RecipeListPanel class singleton
    public static RecipeListPanel getInstance(){
        if(instance == null){
            instance = new RecipeListPanel();
        }
        return instance;
    }
    private RecipeListPanel(){
        super();
        this.setBackground(Color.decode("#98A2FF"));
        this.setBorder(new EmptyBorder(16, 16, 16, 16));
        this.setPreferredSize(new Dimension(300, 600));
        this.setMaximumSize(new Dimension(300, 600));
        // Sets a vertical layout
        BoxLayout recipeListPanelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(recipeListPanelLayout);
        // Recipe header
        this.add(this.buildRecipesHeader());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 16)));
        // Sort combobox label
        this.add(this.buildSortLabel());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 4)));
        // Sort combobox
        this.add(this.buildSortOptionsComboBox());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 4)));
        // Recipes list
        this.add(this.buildRecipesList());
        // Spacer
        this.add(Box.createVerticalGlue());
        // Add recipe button that shows the PopupWindow
        this.add(this.buildAddRecipeButton());
    }
    // Recipe header
    private JLabel buildRecipesHeader(){
        JLabel recipesHeader = new JLabel("Recipes");
        recipesHeader.setFont(new Font("Dialog", Font.BOLD, 20));
        return recipesHeader;
    }
    // Sort combobox label
    private JLabel buildSortLabel(){
        JLabel sortLabel = new JLabel("Sort");
        sortLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        return sortLabel;
    }
    // Creates the sorting options combobox
    private JComboBox<String> buildSortOptionsComboBox(){
        String[] sortOptions = new String[]{"Alphabetically, A-Z", "Alphabetically, Z-A"};
        JComboBox<String> sortOptionsComboBox = new JComboBox<>(sortOptions);
        sortOptionsComboBox.setPreferredSize(new Dimension(300, 36));
        sortOptionsComboBox.setMaximumSize(new Dimension(300, 36));
        sortOptionsComboBox.setAlignmentX(0);
        sortOptionsComboBox.addActionListener (e -> {
            if(sortOptionsComboBox.getSelectedIndex() == 0){
                this.recipesSortType = RecipesSortType.ALPHABETICAL;
            }else{
                this.recipesSortType = RecipesSortType.REVERSE_ALPHABETICAL;
            }
            this.refreshRecipesListContents(this.recipesSortType);
        });
        return sortOptionsComboBox;
    }
    // Creates the recipes list component
    private JList<String> buildRecipesList(){
        // Creates the recipes list component
        this.recipesList = new JList<>();
        this.recipesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.recipesList.setAlignmentX(0);
        this.recipesList.setPreferredSize(new Dimension(300, 250));
        this.recipesList.setMaximumSize(new Dimension(300, 250));
        // Set recipes list contents
        this.refreshRecipesListContents(this.recipesSortType);
        // Handles when an item in the list is clicked
        this.recipesList.addListSelectionListener(e -> this.onRecipeSelected());
        return this.recipesList;
    }
    // Handles when an item in the list is clicked
    private void onRecipeSelected(){
        RecipeManager recipeManager = RecipeManager.getInstance();
        // Gets the selected recipe
        Recipe selectedRecipe = recipeManager.getRecipeByTitle(this.recipesList.getSelectedValue());
        if (selectedRecipe != null) {
            // Updates the selected recipe id
            recipeManager.setSelectedRecipeId(selectedRecipe.getId());
            RecipeInfoPanel.getInstance().updateRecipeInfo(selectedRecipe);
            this.recipesList.clearSelection();
        }
    }
    // Add recipe button that shows the PopupWindow
    private JButton buildAddRecipeButton(){
        JButton addNewRecipeButton = new Button("Add New Recipe");
        // Opens the popup window on click
        addNewRecipeButton.addActionListener(ae -> PopupWindow.getInstance().show(true));
        return addNewRecipeButton;
    }
    // Updates the contents in the recipes list
    private void refreshRecipesListContents(RecipesSortType recipesSortType){
        // Creates the array for the recipes list component
        DefaultListModel<String> recipesModel = new DefaultListModel<>();
        ArrayList<Recipe> recipes = RecipeManager.getInstance().getRecipes();
        // Sorts recipe by specified
        recipes.sort((recipe, recipe1) -> {
            if(recipesSortType == RecipesSortType.ALPHABETICAL){
                // Alphabetical
                return recipe.getTitle().compareToIgnoreCase(recipe1.getTitle());
            }else{
                // Reverse alphabetical
                return -recipe.getTitle().compareToIgnoreCase(recipe1.getTitle());
            }
        });
        for(Recipe recipe: recipes){
            recipesModel.addElement(recipe.getTitle());
        }
        this.recipesList.setModel(recipesModel);
    }
    public void refreshRecipesListContents(){
        this.refreshRecipesListContents(this.recipesSortType);
    }
}
