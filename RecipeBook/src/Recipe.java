import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// identifies a recipe and its components
public class Recipe {
    private String id;
    private String title = "";
    private ArrayList<String> steps;
    private ArrayList<String> ingredients;
    // constructor for gathering recipe parameters
    public Recipe(String id, String title, ArrayList<String> steps, ArrayList<String> ingredients) {
        this.id = id;
        this.title = title;
        this.steps = steps;
        this.ingredients = ingredients;
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
    // Save the recipe to file
    public void save(){
        String filename = "./RecipeBook/Recipes/"+this.id+".txt";
        File file = new File(filename);
        try{
            file.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
            return;
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Id:"+this.id);
            writer.newLine();
            writer.write("Title:"+this.title);
            writer.newLine();
            writer.write("Steps:"+String.join(",", this.steps));
            writer.newLine();
            writer.write("Ingredients:"+String.join(",", this.ingredients));
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}