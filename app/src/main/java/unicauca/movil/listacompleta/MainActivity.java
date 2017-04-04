package unicauca.movil.listacompleta;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.listacompleta.adapters.PlanetaAdapter;
import unicauca.movil.listacompleta.databinding.ActivityMainBinding;
import unicauca.movil.listacompleta.models.Planeta;
import unicauca.movil.listacompleta.util.Data;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    ActivityMainBinding binding;
    PlanetaAdapter adapter;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Data.planetas = new ArrayList<>();
        adapter = new PlanetaAdapter(this, Data.planetas);

        binding.list.setAdapter(adapter);
        loadPlanetas();

        registerForContextMenu(binding.list);
    }

    //region Load Data
    public void loadPlanetas(){
        Planeta p1 =  new Planeta("Tierra", 9.8f);
        Planeta p2 =  new Planeta("Marte", SensorManager.GRAVITY_MARS);
        Planeta p3 =  new Planeta("Estrella de la Muerte", SensorManager.GRAVITY_DEATH_STAR_I);
        Data.planetas.add(p1);
        Data.planetas.add(p2);
        Data.planetas.add(p3);
        adapter.notifyDataSetChanged();
    }
    //endregion

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    //region Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
            case R.id.action_more:
                Toast.makeText(this, "Presionaste More", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        pos = info.position;
        switch (item.getItemId()){
            case R.id.action_delete:
                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Eliminar")
                        .setMessage("Desea eliminar el planeta")
                        .setPositiveButton("Aceptar", this)
                        .setNegativeButton("Cancelar", this)
                        .create();
                alert.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE){
            Data.planetas.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }
}
