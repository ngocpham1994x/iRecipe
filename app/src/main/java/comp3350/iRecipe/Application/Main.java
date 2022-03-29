package comp3350.iRecipe.Application;

import android.util.Log;

public class Main {

    private static String dbPathName;

    public static void setDBPathName(String name){
        try{
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        }catch(Exception e){
            Log.e("Error", "setDBPathName: ClassNotFound" );
        }
        dbPathName = name;
    }

    public static String getDBPathName(){
        return dbPathName;
    }
}
