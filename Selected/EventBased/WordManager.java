import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Field;


public class WordManager {
    private int currentWordNum;
    private int currentLevelNum;
    private List<String> levelCategories;
    private List<Integer> numPerCategory;
    private List<String> animals;
    private List<String> countries;

    public WordManager() {
        // Current word in category starts at zero
        currentWordNum = 0;

        // Current category or level is the first element in levelCategories
        currentLevelNum = 0;

        // different words for different categories, remember to update the number of words in each category if this is changed
        animals = new ArrayList<String>(Arrays.asList("lion"));
        countries = new ArrayList<String>(Arrays.asList("argentina", "usa", "brazil"));

        // All categories
        levelCategories = new ArrayList<String>(Arrays.asList("animals", "countries"));
        
        // The number of words for each category
        numPerCategory = new ArrayList<Integer>(Arrays.asList(1, 3));
        
        // setup all the categories
        
    }

    public String getFirstWord(){
        // whatever category is the current level num
        String category = levelCategories.get(currentLevelNum);

        try {
            Field categoryField = this.getClass().getDeclaredField(category);
            categoryField.setAccessible(true);
            List<String> words = (List<String>) categoryField.get(this);
            return words.get(currentWordNum);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getNextWord() {
        // Logic to select the next word
        currentWordNum ++;
        if(currentWordNum >= numPerCategory.get(currentLevelNum)){
            currentWordNum = 0;
            currentLevelNum ++;
        }
        if(currentLevelNum >= levelCategories.size()){
            return "Game Complete";
        }

        // whatever category is the current level num
        String category = levelCategories.get(currentLevelNum);

        try {
            Field categoryField = this.getClass().getDeclaredField(category);
            categoryField.setAccessible(true);
            List<String> words = (List<String>) categoryField.get(this);
            return words.get(currentWordNum);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isNextLevelUp(){
        if(currentWordNum + 1 >= numPerCategory.get(currentLevelNum)){
            return true;
        }
        return false;
    }
  
    public void reset() {
        // Logic to reset for a new level
        currentWordNum = 0;
        currentLevelNum = 0;
    }

    public String getLevelCategory() {
        return levelCategories.get(currentLevelNum);
    }
}
