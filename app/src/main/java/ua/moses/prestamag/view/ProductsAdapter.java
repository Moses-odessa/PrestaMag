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
import ua.moses.prestamag.controller.PrestashopClient;
import ua.moses.prestamag.controller.PrestashopService;
import ua.moses.prestamag.entity.Product;

public class ProductsAdapter extends BaseAdapter {
    private List<Product> productList;
    private Context context;
    private PrestashopClient client;

    public ProductsAdapter(List<Product> productList, Context context, PrestashopClient client) {
        this.productList = productList;
        this.context = context;
        this.client = client;
    }

    private static class ViewHolder {
        TextView goodName;
        TextView goodPrice;
        ImageView goodImage;
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
        ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.good_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.goodName = (TextView) convertView.findViewById(R.id.good_name);
            viewHolder.goodPrice = (TextView) convertView.findViewById(R.id.good_price);
            viewHolder.goodImage = (ImageView) convertView.findViewById(R.id.good_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Product product = productList.get(position);
        viewHolder.goodName.setText(product.getName());
        viewHolder.goodPrice.setText("" + product.getPrice());



// todo control scrolling http://lucasr.org/2014/09/23/new-features-in-picasso/
        Picasso picasso = new Picasso.Builder(this.context)
                .downloader(new OkHttp3Downloader(client.getOkHttpClient()))
                .build();
        picasso.load(client.getImageUrl(product.getId(),product.getIdDefaultImage(), PrestashopClient.IMAGES_TYPES.small_default))
                .resize(100, 100)
                .centerCrop()
                .placeholder((R.drawable.ic_menu_gallery))
                .error(R.drawable.ic_menu_send)
                .into(viewHolder.goodImage);

        return convertView;
    }
}
