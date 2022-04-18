import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// defines a RecipeBook
public class RecipeBook {
    private String title = "";
    private ArrayList<String> steps;
    private String ingredients = "";
    private String fileName = "";

    // constructor for setting given parameters to instance variables
    public RecipeBook(String title, ArrayList<String> steps, String ingredients) {
        this.title = title;
        this.steps = steps;
    }
    // edits a recipe
    public void editRecipe(String title, ArrayList<String> steps, String ingredients) {

        // to implement: functionality with GUI:
        // upon pressing editRecipeButton, (if editRecipeButton.getModel().isPressed())
        // retrieve fileName of recipe that user interacts with

        //if editRecipeButton.getModel().isPressed() {}

        try {
            File f = new File("RecipeBook/recipes/" + fileName);
            Scanner in = new Scanner(new FileReader("recipes/" + fileName));
            if (f.exists()) {
                while(in.hasNextLine()) {
                    this.steps.add(in.toString());
                    in.nextLine();
                }
            }
        } catch(FileNotFoundException e) {
        }
    }

    public static void addRecipe() {
        //add to the directory or file folder
        //be able to create a file
        String recipe = "";
        File file = new File("./recipes");
        if (!file.exists()) {
            file.mkdir();
        }
        String deckN = "./recipe/" +recipe.replace(" ", "_").toLowerCase() + ".recipe";
        Recipe recipe1 = new Recipe();
        recipe1.file(deckN);

        try {
            recipe1.save();
        }
        catch (IOException e) {
            System.out.println("Error");
            return;
        }
        //created if it gets to this point
    }

    public void deleteRecipe() {
        //go into the directory if that name exists then delete it, if not return error
        //delete a file
        ArrayList arr = getRecipe();
        int size = arr.size();
        if (size > 0) {
            //idk how to get what button they pressed
            //so for this i will have it delete 2nd recipe

            int choice = 1;
            String file = (String) arr.get(choice);
            try {
                if (file.delete()) {
                    System.out.println("deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static ArrayList getRecipe() {
        //check the directory if it does not exist create it
        //return a string of the recipes that they can access
        //the file names
        ArrayList arr  = new ArrayList();
        File file1 = new File("./recipes");
        String[] arrL = file1.list();
        if (arrL != null) {
            int j = arrL.length;
            for (String file : arrL) {
                if (file.endsWith(".recipe")) {
                    arr.add("./recipes/" + file);
                }
            }
        }
        return arr;
    }
}
