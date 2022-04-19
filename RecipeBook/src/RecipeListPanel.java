import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// The recipe list panel is the panel on the left of MainWindow
public class RecipeListPanel extends JPanel {
    public RecipeListPanel(){
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
        String[] sortOptions = new String[]{"Alphabetically, A-Z"};
        JComboBox<String> sortOptionsComboBox = new JComboBox<>(sortOptions);
        sortOptionsComboBox.setPreferredSize(new Dimension(300, 36));
        sortOptionsComboBox.setMaximumSize(new Dimension(300, 36));
        sortOptionsComboBox.setAlignmentX(0);
        return sortOptionsComboBox;
    }
    // Creates the recipes list component
    private JList<String> buildRecipesList(){
        // Creates the array for the recipes list component
        DefaultListModel<String> recipesModel = new DefaultListModel<>();
        ArrayList<Recipe> recipes = RecipeManager.getInstance().getRecipes();
        for(Recipe recipe: recipes){
            recipesModel.addElement(recipe.getTitle());
        }
        // Creates the recipes list component
        JList<String> recipesList = new JList<>(recipesModel);
        recipesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        recipesList.setAlignmentX(0);
        recipesList.setPreferredSize(new Dimension(300, 250));
        recipesList.setMaximumSize(new Dimension(300, 250));

        recipesList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                RecipeManager recipeManager = RecipeManager.getInstance();
                // Gets index of selected recipe
                int selectedIdx = recipesList.getSelectedIndex();
                // Gets the selected recipe
                Recipe selectedRecipe = recipeManager.getRecipes().get(selectedIdx);
                // Updates the selected recipe id
                recipeManager.setSelectedRecipeId(selectedRecipe.getId());
            }
        });
        return recipesList;
    }
    // Add recipe button that shows the PopupWindow
    private JButton buildAddRecipeButton(){
        JButton addNewRecipeButton = new Button("Add New Recipe");
        // Opens the popup window on click
        addNewRecipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                PopupWindow.getInstance().show(true);
            }
        });
        return addNewRecipeButton;
    }
}
