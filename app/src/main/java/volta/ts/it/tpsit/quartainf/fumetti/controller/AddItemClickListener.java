package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;

public class AddItemClickListener implements View.OnClickListener{

    private BaseAdapter adapter;
    private FumettiBusiness business;
    private Fumetto item;

    public AddItemClickListener(FumettiBusiness business, Fumetto item, BaseAdapter adapter) {
        this.business = business;
        this.item = item;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        this.business.addCopy(item);

        //int position = (int) v.getTag();
        Toast.makeText(v.getContext(),
                String.format("Aggiunta una nuova copia per %s",item.Nome),
                    Toast.LENGTH_LONG).show();

        adapter.notifyDataSetChanged();

    }
}
