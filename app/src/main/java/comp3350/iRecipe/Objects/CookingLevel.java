package comp3350.iRecipe.Objects;

import java.util.Locale;

public enum CookingLevel {
    EASY{
        @Override
        public String toString(){
            return "Easy";
        }
    },
    MEDIUM{
        @Override
        public String toString(){
            return "Medium";
        }
    },
    HARD{
        @Override
        public String toString(){
            return "Hard";
        }
    },
    INVALID_COOKING_LEVEL{
      @Override
      public String toString(){
          return "Invalid_Cooking_Level";
      }
    };

    public static CookingLevel getCookingLevel(String level){
        level = level.toUpperCase();
        for(CookingLevel e : values()){
            if(level.equals(e.toString().toUpperCase()))
                return e;
        }
        return INVALID_COOKING_LEVEL;
    }
}
