package sadyath.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class detailfruits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailfruits);


        TextView text1 = findViewById(R.id.outputnom);
        TextView text2 = findViewById(R.id.outputinit);
        TextView text3 = findViewById(R.id.outptutulise);
        TextView text4 = findViewById(R.id.outputres);

        String json = null;
        InputStream jsonFile = null;

        Intent intent = getIntent();
        int position = (int) intent.getExtras().get("position");

        try {
            jsonFile = getAssets().open("grocery.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);

            JSONArray childArray = object.getJSONArray("banane");
            for (int i = 0; i < childArray.length(); i++) {
                if (position == i) {
                    text2.setText(childArray.getJSONObject(i).getString("quantité initiale"));
                    text3.setText(childArray.getJSONObject(i).getString("quantité utilisé"));
                    text4.setText(childArray.getJSONObject(i).getString("quantité restante"));
                }
                //Toast.makeText(this,""+ childArray.getJSONObject(i).getString("titre"),
                //Toast.LENGTH_SHORT).show();
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }



    }
}