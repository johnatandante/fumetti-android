package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;

import volta.ts.it.tpsit.quartainf.fumetti.ui.FumettiListAdapter;

public class MainActivityOnBackPressedCallback extends OnBackPressedCallback {

    private final BaseAdapter adapter;
    private final Context context;
    public MainActivityOnBackPressedCallback(BaseAdapter adapter, Context context) {
        super(true);
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    public void handleOnBackPressed() {
        this.adapter.notifyDataSetChanged();
        Toast.makeText(this.context, "Data updated", Toast.LENGTH_LONG).show();
    }
}
