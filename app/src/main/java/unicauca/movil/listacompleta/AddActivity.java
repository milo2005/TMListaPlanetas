package unicauca.movil.listacompleta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import unicauca.movil.listacompleta.models.Planeta;
import unicauca.movil.listacompleta.util.Data;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, gravedad;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.nombre);
        gravedad = (EditText) findViewById(R.id.gravedad);
        guardar = (Button) findViewById(R.id.guardar);

        guardar.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String n = nombre.getText().toString();
        String g =  gravedad.getText().toString();
        Planeta p =  new Planeta(n, Float.parseFloat(g));
        Data.planetas.add(p);
        finish();
    }
}
