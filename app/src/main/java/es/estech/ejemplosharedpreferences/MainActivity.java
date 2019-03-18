package es.estech.ejemplosharedpreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnSave;
    private Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.BtnSave);
        btnLoad = findViewById(R.id.BtnLoad);

        btnSave.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences prefs =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", "estech@email.com");
                editor.putString("name", "Estech");
                editor.apply();
            }
        });

        btnLoad.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //Recuperamos las preferencias
                SharedPreferences prefs =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

                String mail = prefs.getString("email", "default@email.com");
                String name = prefs.getString("name", "defaultName");
                String other = prefs.getString("other", "defaultOther");

                Log.i("Preferences", "Correo: " + mail);
                Log.i("Preferences", "Nombre: " + name);
                Log.i("Preferences", "other: " + other);
            }
        });
    }



}