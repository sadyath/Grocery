package sadyath.grocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class grocery_adapter extends BaseAdapter {
    private Context context;
    private List<grocery> groceryItemList;
    private LayoutInflater inflater;

    public grocery_adapter(Context context, List<grocery> groceryItemList) {
        this.context = context;
        this.groceryItemList = groceryItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return groceryItemList.size();  }

    @Override
    public Object getItem(int position) {
        return groceryItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_grocery, null);

        grocery itemCourant = (grocery) getItem(i);
        String itemName = itemCourant.getNom();
        String image =itemCourant.getImage();
        int itemRes =itemCourant.getQteRest();

        ImageView itemIconView = convertView.findViewById(R.id.imageIcon);
        String ressourceName = "ic_" +image+ "_ic";
        int resID = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resID);

        TextView textName = convertView.findViewById(R.id.nom);
        textName.setText(itemName);

        TextView textAdress = convertView.findViewById(R.id.qteres);
        textAdress.setText(itemRes+"");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Vous avez cliquez sur "+itemName+
                        " avec pour qteRest "+itemRes+" ", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
