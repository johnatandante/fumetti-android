package volta.ts.it.tpsit.quartainf.fumetti.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.TreeSet;

import volta.ts.it.tpsit.quartainf.fumetti.R;
import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;
import volta.ts.it.tpsit.quartainf.fumetti.controller.ShowTextClickListener;

public class FumettiListAdapter extends BaseAdapter {

        private final FumettiBusiness business;
        private final Resources resources;
        private final Context context;

        private static final int TYPE_ITEM = 0;
        private static final int TYPE_SEPARATOR = 1;
        private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;

        private final LayoutInflater mInflater;

        private final TreeSet<Integer> mSeparatorsSet = new TreeSet<>();

        public FumettiListAdapter(FumettiBusiness business, Resources resources, Context context, LayoutInflater layoutInflater) {
            mInflater = layoutInflater;
            this.resources= resources;
            this.context = context;
            this.business = business;
        }

        public void addItem(String immagine, String nome, String casa) {
            business.add(immagine, nome, casa);
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
            return this.business.Fumetti.size();
        }

        @Override
        public String getItem(int position) {
            return this.business.Fumetti.get(position).Tag;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final RowViewHolder holder = new RowViewHolder();
            final Fumetto f = this.business.Fumetti.get(position);
            convertView = mInflater.inflate(R.layout.row, null);

            holder.immagine = convertView.findViewById(R.id.imgComic);
            holder.nome = convertView.findViewById(R.id.txtNome);
            holder.casa = convertView.findViewById(R.id.txtCasaEditrice);

            holder.nome.setText(f.Nome);
            holder.casa.setText(f.CasaEditrice);

            int res = resources.getIdentifier(f.Tag, "drawable", context.getPackageName());
            holder.immagine.setImageResource(res);
            holder.immagine.setTag(position);

            holder.immagine.setOnClickListener(new ShowTextClickListener(f));

            convertView.setTag(holder);

            return convertView;
        }

    }


