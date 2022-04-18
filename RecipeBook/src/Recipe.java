import java.util.ArrayList;

// identifies a recipe and its components
public class Recipe {
    private String title = "";
    private ArrayList<String> steps;
    private ArrayList<String> ingredients;
    public static String id = "";

    // constructor for gathering recipe parameters
    public Recipe(String title, ArrayList<String> steps, ArrayList<String> ingredients, String id) {
        this.title = title;
        this.steps = steps;
        this.ingredients = ingredients;
        this.id = id;
    }
    // constructor for editing a recipe, gathering parameters
    public void edit(String title, ArrayList<String> steps, ArrayList<String> ingredients) {
        this.title = title;
        this.steps = steps;
        this.ingredients = ingredients;
    }
    public String getTitle() {
        return this.title;
    }

    public String getId() {
        return this.id;
    }
    public ArrayList<String> getSteps() {
        return this.steps;
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }
}