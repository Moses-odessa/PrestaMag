package ua.moses.prestamag.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ua.moses.prestamag.R;
import ua.moses.prestamag.entity.Good;

public class GoodsAdapter extends BaseAdapter {
    private List<Good> goodsList;
    private Context context;

    public GoodsAdapter(List<Good> goodsList, Context context) {
        this.goodsList = goodsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return goodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return goodsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.good_item, parent, false);
        TextView goodName = (TextView) rowView.findViewById(R.id.good_name);
        goodName.setText(goodsList.get(position).getName());
        TextView goodPrice = (TextView) rowView.findViewById(R.id.good_price);
        goodPrice.setText("" + goodsList.get(position).getPrice());
        ImageView goodImage = (ImageView) rowView.findViewById(R.id.good_image);
        goodImage.setImageResource(R.drawable.ic_menu_gallery);

        return rowView;
    }
}
