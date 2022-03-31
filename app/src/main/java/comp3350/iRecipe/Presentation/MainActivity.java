package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.iRecipe.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterMainPage adapter;

    public static final String dbName="SC";
    private static String dbPathName;

    String searchByList[] = {"Recipe Name", "Ingredients"};
    String searchBy;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyDatabaseToDevice();

        // widget, view by category cards
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new AdapterMainPage(this);
        recyclerView.setAdapter(adapter);

        // search dropdown menu
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.search_by_dropdown,searchByList);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchBy = parent.getItemAtPosition(position).toString();
            }
        });
    }

    private void copyDatabaseToDevice() {
        String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            MainActivity.setDBPathName(dataDirectory.toString() + "/" + MainActivity.dbName);

        } catch (final IOException ioe) {
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }

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

    public void showSearchResult(View view)     // search icon button onClick()
    {
        Intent intent = new Intent(this, ListRecipeActivity.class);

        EditText searchText = (EditText) findViewById(R.id.searchText);
        String searchString = searchText.getText().toString();

        intent.putExtra("searchString", searchString);
        intent.putExtra("searchBy", searchBy);

        startActivity(intent);
    }

    public void showAddRecipe(View view)     // add recipe button onClick()
    {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        startActivity(intent);
    }
}
