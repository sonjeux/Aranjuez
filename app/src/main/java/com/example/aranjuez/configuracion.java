package com.example.aranjuez;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class configuracion extends AppCompatActivity {

    EditText eDispositivo, eUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        eDispositivo=findViewById(R.id.eDispositivo);
        eUrl=findViewById(R.id.eUrl);

        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        SharedPreferences preferences=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        eDispositivo.setText(preferences.getString("Dispositivo", ""));
        eUrl.setText(preferences.getString("Url", ""));
    }

    public void guardarConfiguracion(View view) {
        SharedPreferences preferences=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        String Dispositivo=eDispositivo.getText().toString();
        String Url=eUrl.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("Dispositivo", Dispositivo);
        editor.putString("Url", Url);
        editor.commit();

        Toast.makeText(getApplicationContext(), "Datos Guardados", Toast.LENGTH_SHORT).show();
    }
}
