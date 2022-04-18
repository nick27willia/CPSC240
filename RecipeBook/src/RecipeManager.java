import java.util.ArrayList;

public class RecipeManager {
    private ArrayList<Recipe> recipes;

    public RecipeManager(){
        this.recipes = new ArrayList<>();
        // TODO: load recipes from file path
    }

    // Adds a new recipe to the recipes arraylist
    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }
    // Finds the recipe in the recipes arraylist and updates it
    public void editRecipe(Recipe recipe){
    }
    // Finds the recipe in the recipes arraylist and deletes it
    public void deleteRecipe(Recipe recipe){
    }

    // Returns recipes
    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}
