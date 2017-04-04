package unicauca.movil.listacompleta.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unicauca.movil.listacompleta.R;
import unicauca.movil.listacompleta.models.Planeta;

/**
 * Created by Dario Chamorro on 28/03/2017.
 */

public class PlanetaAdapter extends BaseAdapter{

    private Context context;
    private List<Planeta> data;

    public PlanetaAdapter(Context context, List<Planeta> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if(v == null)
            v = View.inflate(context, R.layout.template_planeta, null);

        Planeta  p = data.get(i);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView gravedad = (TextView) v.findViewById(R.id.gravedad);

        nombre.setText(p.getNombre());
        gravedad.setText(""+p.getGravedad());

        return v;
    }
}
