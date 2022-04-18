import java.io.File;
import java.util.ArrayList;

public class RecipeManager {
    private ArrayList<Recipe> recipes;

    public RecipeManager(){
        this.recipes = new ArrayList<Recipe>();
        File f = new File("./RecipeBook/Recipes");
        for (String filename : f.list()) {
            //System.out.println(pathname);
            parseRecipeFromFile(filename);
        }
    }
    public Recipe parseRecipeFromFile(String filename) {

        this.
    }

    // Adds a new recipe to the recipes arraylist
    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
        saveRecipes();
    }
    // Finds the recipe in the recipes arraylist and updates it
    public void editRecipe(Recipe recipe){
        for (int i = 0; this.recipes.size() > i; i++) {
            if (recipe.getId().equals(this.recipes.get(i).getId())) {
                this.recipes.set(i,recipe);
                break;
            }
        }
        saveRecipes();
    }
    // Finds the recipe in the recipes arraylist and deletes it
    public void deleteRecipe(Recipe recipe){
        for (int i = 0; this.recipes.size() > i; i++) {
            if (recipe.getId().equals(this.recipes.get(i).getId())) {
                this.recipes.remove(i);
                break;
            }
        }
        saveRecipes();
    }


    public void saveRecipes() {

    }

    // Returns recipes
    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}
