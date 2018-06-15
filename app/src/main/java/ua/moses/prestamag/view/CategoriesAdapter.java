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

    private static class ViewHolder {
        TextView categoryName;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.categoryName = (TextView) convertView.findViewById(R.id.category_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.categoryName.setText(categoryList.get(position).getName());

        return convertView;
    }
}
