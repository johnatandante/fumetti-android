package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;
import volta.ts.it.tpsit.quartainf.fumetti.ui.FumettiListAdapter;

public class DeleteItemClickListener implements View.OnClickListener {

    private BaseAdapter adapter;
    private FumettiBusiness business;
    private Fumetto item;

    public DeleteItemClickListener(FumettiBusiness business, Fumetto item, BaseAdapter adapter) {
        this.business = business;
        this.item = item;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {

        business.remove(item);
        if(item.getQuanti() > 0) {
            Toast.makeText(v.getContext(),
                    String.format("Rimossa una copia per %s",item.Nome),
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(v.getContext(),
                    String.format("Rimosso tutte le copia di %s",item.Nome),
                    Toast.LENGTH_LONG).show();
        }

        adapter.notifyDataSetChanged();

    }

}
