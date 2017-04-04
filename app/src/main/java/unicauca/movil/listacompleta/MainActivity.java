package unicauca.movil.listacompleta;

import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.listacompleta.adapters.PlanetaAdapter;
import unicauca.movil.listacompleta.models.Planeta;

public class MainActivity extends AppCompatActivity {

    ListView list;
    PlanetaAdapter adapter;
    List<Planeta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new PlanetaAdapter(this, data);

        list.setAdapter(adapter);
        loadPlanetas();
    }

    //region Load Data
    public void loadPlanetas(){

        Planeta p1 =  new Planeta("Tierra", 9.8f);
        Planeta p2 =  new Planeta("Marte", SensorManager.GRAVITY_MARS);
        Planeta p3 =  new Planeta("Estrella de la Muerte", SensorManager.GRAVITY_DEATH_STAR_I);

        data.add(p1);
        data.add(p2);
        data.add(p3);

        adapter.notifyDataSetChanged();
    }
    //endregion


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_add:
                Toast.makeText(this, "Presionaste ADD", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_more:
                Toast.makeText(this, "Presionaste More", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
