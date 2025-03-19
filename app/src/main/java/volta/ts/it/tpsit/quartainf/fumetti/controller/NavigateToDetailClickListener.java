package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.io.Serializable;

import volta.ts.it.tpsit.quartainf.fumetti.FumettoDetail;
import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;

public class NavigateToDetailClickListener implements View.OnClickListener {

    private Fumetto item = null;
    private Context context;

    public NavigateToDetailClickListener(Context context){
        this.context = context;

    }
    public NavigateToDetailClickListener(Fumetto item, Context context){
        this(context);
        this.item = item;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, FumettoDetail.class);
        intent.putExtra("detail", (Serializable) item);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

}
