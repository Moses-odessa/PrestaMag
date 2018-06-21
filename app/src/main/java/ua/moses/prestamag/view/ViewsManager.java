package ua.moses.prestamag.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import ua.moses.prestamag.R;
import ua.moses.prestamag.controller.PrestashopClient;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.IdEntity;
import ua.moses.prestamag.entity.Product;
import ua.moses.prestamag.entity.ProductDetails;

public class ViewsManager {
    private Context context;
    private ListView listCategories;
    private ListView listGoods;

    public ViewsManager(Context context, ListView listCategories, ListView listGoods) {
        this.context = context;
        this.listCategories = listCategories;
        this.listGoods = listGoods;

    }

    public void updateProducts(List<Product> goodsList, PrestashopClient client){
        listGoods.setAdapter(new ProductsAdapter(goodsList, context, client));
    }

    public void updateCategories(List<Category> categoriesList) {
        listCategories.setAdapter(new CategoriesAdapter(categoriesList, context));
    }


    public Context getContext() {
        return context;
    }

    public void showDetail(ProductDetails productDetails, PrestashopClient client) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View detailView = inflater.inflate(R.layout.product_detail, null);
        builder.setView(detailView)
                .setTitle(productDetails.getName())
                .setCancelable(false)
                .setNegativeButton("Close",
                        (dialog, id) -> dialog.cancel());
        TextView description = (TextView) detailView.findViewById(R.id.description);
        TextView price = (TextView) detailView.findViewById(R.id.product_price);
        ViewAnimator gallery = (ViewAnimator) detailView.findViewById(R.id.images_gallery);
        Button buyButton = (Button) detailView.findViewById(R.id.buy_button);

        description.setText(Html.fromHtml(productDetails.getDescription()));
        price.setText(Double.toString(productDetails.getPrice()));
        List<IdEntity> images = productDetails.getAssociations().getImages();
        for (int i = 0; i < images.size(); i++) {
            ImageView imageView = new ImageView(this.context);
            Picasso picasso = new Picasso.Builder(this.context)
                    .downloader(new OkHttp3Downloader(client.getOkHttpClient()))
                    .build();
            picasso.load(client.getImageUrl(productDetails.getId(),images.get(i).getId(), PrestashopClient.IMAGES_TYPES.medium_default))
                    //.resize(200, 200)
                    //.centerCrop()
                    .placeholder((R.drawable.ic_menu_gallery))
                    .error(R.drawable.ic_menu_send)
                    .into(imageView);
            gallery.addView(imageView); // add child view in ViewAnimator
        }

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gallery.showNext();
            }
        });
        AlertDialog detailDialog = builder.create();
        detailDialog.show();
        //TextView textInfo = (TextView) detailDialog.findViewById(android.R.id.message);
        //textInfo.setTextSize(14);
    }
}
