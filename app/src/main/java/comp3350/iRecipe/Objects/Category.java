package comp3350.iRecipe.Objects;

public enum Category {
    MAIN_DISHES{
        @Override
        public String toString() {
            return "Main dishes";
        }
    },
    SOUPS{
        @Override
        public String toString(){
            return "Soup";
        }
    },
    DESSERTS{
        @Override
        public String toString(){
            return "Dessert";
        }
    },
    DRINKS{
        @Override
        public String toString(){
            return "Drink";
        }
    },
    INVALID_CATEGORY{   //This in theory should never be used
        @Override
        public String toString(){
            return "Invalid Category";
        }
    };

    public static Category getCategory(String label){
        label = label.toUpperCase();
        for(Category e : values()){
            if(label.equals(e.toString().toUpperCase())){
                return e;
            }
        }
        return INVALID_CATEGORY;
    }
}
