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
    public void edit(String title, ArrayList<String> steps, String ingredients) {

        // to implement: functionality with GUI:
        // upon pressing editRecipeButton, (if editRecipeButton.getModel().isPressed())
        // retrieve fileName of recipe that user interacts with

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
    public static void main(String[] args){
        PopupWindow popupWindow = new PopupWindow();
        MainWindow mainWindow = new MainWindow(popupWindow);
    }
}
