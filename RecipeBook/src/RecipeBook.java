package RecipeBook.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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

    public void addRecipe() {
        //add to the directory or file folder
        //be able to create a file
    }

    public void deleteRecipe() {
        //go into the directory if that name exists then delete it, if not return error
        //delete a file
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

    public static void main(String[] args){
        PopupWindow popupWindow = new PopupWindow();
        MainWindow mainWindow = new MainWindow(popupWindow);
    }
}
