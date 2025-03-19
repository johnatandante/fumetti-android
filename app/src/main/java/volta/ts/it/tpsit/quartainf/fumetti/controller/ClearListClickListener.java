package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.view.View;
import android.widget.BaseAdapter;

import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;

public class ClearListClickListener implements View.OnClickListener {

    FumettiBusiness business;
    BaseAdapter adapter;

    public ClearListClickListener(FumettiBusiness business, BaseAdapter adapter) {
        this.business = business;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        this.business.clearList();
        this.adapter.notifyDataSetChanged();

    }
}
