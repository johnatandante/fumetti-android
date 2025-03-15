package volta.ts.it.tpsit.quartainf.fumetti;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private final List<String> immagine = new ArrayList<>();
    private final List<String> nome = new ArrayList<>();
    private final List<String> casaEditrice = new ArrayList<>();

    private final List<String> mData0 = new ArrayList<>();
    private final List<String> mData1 = new ArrayList<>();
    private final List<String> mData2 = new ArrayList<>();

    ListView llComics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        llComics = findViewById(R.id.listView);

        popolaListe();
        caricaListView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void popolaListe() {
        immagine.add("batman");
        nome.add("Batman");
        casaEditrice.add("DC");
        immagine.add("superman");
        nome.add("Superman");
        casaEditrice.add("DC");
        immagine.add("spiderman");
        nome.add("Spiderman");
        casaEditrice.add("Marvel");
        immagine.add("fantasticfour");
        nome.add("Fantastic Four");
        casaEditrice.add("Marvel");
    }

    public void caricaListView() {
        llComics.setAdapter(null);
        MyCustomAdapter mAdapter = new MyCustomAdapter();
        for(int i=0;i<immagine.size();i++) {
            mAdapter.addItem(immagine.get(i),nome.get(i),casaEditrice.get(i));
        }
        llComics.setAdapter(mAdapter);
    }

    private class MyCustomAdapter extends BaseAdapter {

        private static final int TYPE_ITEM = 0;
        private static final int TYPE_SEPARATOR = 1;
        private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;


        private final LayoutInflater mInflater;

        private final TreeSet<Integer> mSeparatorsSet = new TreeSet<>();

        public MyCustomAdapter() {
            mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        public void removeAll() {
            mData0.clear();
            mData1.clear();
            mData2.clear();
        }
        public void addItem(String immagine, String nome, String casa) {
            mData0.add(immagine);
            mData1.add(nome);
            mData2.add(casa);
            notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
        }

        @Override
        public int getViewTypeCount() {
            return TYPE_MAX_COUNT;
        }

        @Override
        public int getCount() {
            return mData1.size();
        }

        @Override
        public String getItem(int position) {
            return mData0.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.row, null);

            holder.immagine = convertView.findViewById(R.id.imgComic);
            holder.nome = convertView.findViewById(R.id.txtNome);
            holder.casa = convertView.findViewById(R.id.txtCasaEditrice);


            holder.nome.setText(mData1.get(position));
            holder.casa.setText(mData2.get(position));

            int res = getResources().getIdentifier(mData0.get(position), "drawable", getApplicationContext().getPackageName());
            holder.immagine.setImageResource(res);

            holder.immagine.setTag(position);

            holder.immagine.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    Toast.makeText(getApplicationContext(),
                            mData1.get(position), Toast.LENGTH_LONG).show();
                }
            });

            convertView.setTag(holder);

            return convertView;
        }

    }

    public static class ViewHolder {
        TextView nome;
        TextView casa;
        ImageView immagine;

    }

}