package ua.moses.prestamag.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ua.moses.prestamag.R;
import ua.moses.prestamag.entity.Category;

public class CategoriesAdapter extends BaseAdapter {
    private List<Category> categoryList;
    private Context context;

    public CategoriesAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.category_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.category_name);
        textView.setText(categoryList.get(position).getName());

        return rowView;
    }
}
