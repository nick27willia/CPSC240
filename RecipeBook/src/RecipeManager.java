import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RecipeManager {
    private static RecipeManager instance;
    private ArrayList<Recipe> recipes;
    private String selectedRecipe = "";

    // Make the RecipeManager class singleton so both windows can access the same instance (PopupWindow & MainWindow)
    public static RecipeManager getInstance(){
        if(instance == null){
            instance = new RecipeManager();
        }
        return instance;
    }
    // The recipe manager manages all the individual recipes and holds them in an arraylist
    // Each recipe is stored in its own .txt file
    private RecipeManager(){
        this.recipes = new ArrayList<Recipe>();

        File f = new File("./RecipeBook/Recipes");
        String[] files = f.list();
        if(files != null){
            for (String filename : files) {
                if(filename.endsWith(".txt")){
                    Recipe recipe = parseRecipeFromFile(filename);
                    if(recipe != null){
                        this.recipes.add(recipe);
                    }
                }
            }
        }
    }
    // Creates a recipe object from the recipe txt file
    public Recipe parseRecipeFromFile(String filename) {
        File file = new File("./RecipeBook/Recipes/"+filename);
        Scanner scnr;
        try{
            scnr = new Scanner(file);
        } catch (FileNotFoundException e){
            return null;
        }
        String id, title;
        ArrayList<String> ingredients, steps;

        try{
            id = scnr.next().replace("Id:","");
            title = scnr.next().replace("Title:","");

            String[] stepsArr = scnr.next().replace("Steps:", "").split(",");
            steps = new ArrayList<>(Arrays.asList(stepsArr));

            String[] ingredientsArr = scnr.next().replace("Ingredients:", "").split(",");
            ingredients = new ArrayList<>(Arrays.asList(ingredientsArr));
        }catch(Exception e){
            System.out.printf("Exception: file %s is in an invalid format\n", filename);
            return null;
        }

        return new Recipe(id, title, steps, ingredients);
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
        for(Recipe recipe: this.recipes){
            recipe.save();
        }
    }
    // Returns recipes
    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
    public void setSelectedRecipe(String id) {
        selectedRecipe = id;
    }
}
