import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        RecipeManager recipeManager = new RecipeManager();

        ArrayList<String> steps = new ArrayList<String>();
        steps.add("test");
        steps.add("tesr2");
        ArrayList<String> ingredients = new ArrayList<String>();
        recipeManager.addRecipe(new Recipe("test1", "bacon egg & cheese", steps, ingredients));
//        PopupWindow popupWindow = new PopupWindow();
//        MainWindow mainWindow = new MainWindow(popupWindow);
    }
}
