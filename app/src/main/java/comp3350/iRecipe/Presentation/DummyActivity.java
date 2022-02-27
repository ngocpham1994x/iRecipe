package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import comp3350.iRecipe.R;

//A dummy activity to use for testing purpose in AndroidTest
public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
    }
}