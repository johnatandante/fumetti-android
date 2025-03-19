package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;

public class ShowTextClickListener implements View.OnClickListener {
    private final Fumetto item;

    public ShowTextClickListener(Fumetto item) {
        this.item = item;
    }

    @Override
    public void onClick(View v) {

        //int position = (int) v.getTag();
        Toast.makeText(v.getContext(),
                item.Nome, Toast.LENGTH_LONG).show();
    }
}
