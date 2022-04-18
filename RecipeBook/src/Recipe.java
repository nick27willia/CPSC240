// identifies a recipe and its components
public class Recipe {
    private String title = "";
    private ArrayList<String> steps = new ArrayList<String>();
    private ArrayList<String> ingredients = "";
    private String fileName = "";
}

public Recipe(String title, ArrayList<String> steps, ArrayList<String> ingredients) {
    this.title = title;
    this.steps = steps;
    this.ingredients = ingridents;
}

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
            System.out.println("Error");
            return;
        }
    }