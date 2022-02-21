package sadyath.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<grocery> groceryList = new ArrayList<>();
        groceryList.add(new grocery("BANANE", 10,"banane"));
        groceryList.add(new grocery("Orange", 10, "orange"));
        groceryList.add(new grocery("Pomme", 10,"pomme"));
        groceryList.add(new grocery("Fraise", 3,"fraise"));
        groceryList.add(new grocery("Mangue", 4,"mangue"));
        groceryList.add(new grocery("Riz", 13,"riz"));
        groceryList.add(new grocery("Huile", 4,"huile"));
        groceryList.add(new grocery("Epices", 2,"epices"));


        ListView food = findViewById(R.id.listV);
        food.setAdapter(new grocery_adapter(this, groceryList));
    }
}