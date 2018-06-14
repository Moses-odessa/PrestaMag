package ua.moses.prestamag.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import okhttp3.OkHttpClient;
import ua.moses.prestamag.R;
import ua.moses.prestamag.controller.PrestashopService;
import ua.moses.prestamag.entity.Product;

public class ProductsAdapter extends BaseAdapter {
    private List<Product> productList;
    private Context context;
    private OkHttpClient okHttpClient;

    public ProductsAdapter(List<Product> productList, Context context, OkHttpClient okHttpClient) {
        this.productList = productList;
        this.context = context;
        this.okHttpClient = okHttpClient;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.good_item, parent, false);
        TextView goodName = (TextView) rowView.findViewById(R.id.good_name);
        goodName.setText(productList.get(position).getName());
        TextView goodPrice = (TextView) rowView.findViewById(R.id.good_price);
        goodPrice.setText("" + productList.get(position).getPrice());
        ImageView goodImage = (ImageView) rowView.findViewById(R.id.good_image);
        //goodImage.setImageResource(R.drawable.ic_menu_gallery);


        Picasso picasso = new Picasso.Builder(this.context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
        picasso.load(productList.get(position).getDefaultFotoLink())
                .resize(100, 100)
                .centerCrop()
                .placeholder((R.drawable.ic_menu_gallery))
                .error(R.drawable.ic_menu_send)
                .into(goodImage);

        return rowView;
    }
}
