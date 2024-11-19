import java.util.*; 

public class WordManager {
  private Map<Integer, List<String>> categories;  // creates a map with an int and a list of strings for the categories  
  private String currentWord; 

  public WordManager() {
    loadCategories(); 
  }

  // function loads words into categories depending on the level 
  public void loadCategories() {
    System.out.println("Loading categories for testing..."); // testing
    categories = new HashMap<>();   
    categories.put(1, Arrays.asList("apple", "banana", "orange"));      // level 1 - easy 
    categories.put(2, Arrays.asList("donkey", "squirrel", "octopus"));  // level 2 - medium
    categories.put(3, Arrays.asList("buttercup", "gardenia", "periwinkle")); // level 3 - hard 
    categories.put(4, Arrays.asList("jumanji", "inception", "ratatouille")); // level 4 - extreme
    categories.put(5, Arrays.asList("belgium", "croatia", "mongolia")); // level 5 - boss 
    /* 
      we can add more levels by adding more categories
      for testing purposes, we are keeping three levels with three word options in each level. 
      this way, we can test what happens when the user guesses the correct word vs does not guess the word.
    }*/
  }

  public String chooseRandomWord(int level) {
    List<String> words = categories.get(level); 
    if (words == null || words.isEmpty()) {
        return null; // return null if no words are found for the level
    }
    currentWord = words.get(new Random().nextInt(words.size()));
    return currentWord;
  }

  // getter for current word 
  public String getCurrentWord() { return currentWord; }

  // checks if there is a next level or not 
  public boolean hasNextLevel(int level) {
    if (categories.containsKey(level + 1)) {
      return true; 
    }
    return false; 
  }
}