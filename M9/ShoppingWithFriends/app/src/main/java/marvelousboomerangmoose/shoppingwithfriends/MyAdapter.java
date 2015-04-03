package marvelousboomerangmoose.shoppingwithfriends;

/**
 * Add an item to the item list and adjust the display and show it on the
 * item list page.
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import marvelousboomerangmoose.shoppingwithfriends.Model.Product;

class MyAdapter extends BaseAdapter {
    private final ArrayList mData;

    // Constructor
    public MyAdapter(Map<String, Product> map) {
        mData = new ArrayList();
        //noinspection unchecked
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, Product> getItem(int position) {
        //noinspection unchecked
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_item, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, Product> item = getItem(position);

        // TODO replace findViewById by ViewHolder
        ((TextView) result.findViewById(android.R.id.text1)).setText(item.getKey());
        ((TextView) result.findViewById(android.R.id.text2)).setText("Price: $" + item.getValue().getPrice());

        return result;
    }
}
