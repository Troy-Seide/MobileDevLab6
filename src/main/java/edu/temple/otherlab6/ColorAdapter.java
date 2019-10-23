package edu.temple.otherlab6;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Locale;

public class ColorAdapter extends BaseAdapter {
    private final Context Context;
    private String[] engcolorarray;
    private String[] spancolorarray;


    public ColorAdapter(Context context, String[] engcolorarray, String[] spancolorarray){
        this.Context = context;
        this.engcolorarray = engcolorarray;
        this.spancolorarray = spancolorarray;
    }


    @Override
    public int getCount(){
        return spancolorarray.length;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public Object getItem(int position){
        return null;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView text;
        Locale localegetter=Locale.getDefault();
        String backgroundColor;
        String col2;
        String backgroundColor2;
        if(convertView instanceof TextView){
            text = new TextView(Context);
        }
        else{
            text= new TextView(Context);
        }
        backgroundColor=engcolorarray[position];
        col2=spancolorarray[position];
        backgroundColor2 = engcolorarray[position];

        if(localegetter.getLanguage()=="en"){
            text.setText(backgroundColor);
        }
        else{
            text.setText(col2);
        }
        text.setBackgroundColor(Color.parseColor(backgroundColor2));
        //textView.setText(Colors2[pos]);
        //textView.setBackgroundColor(Color.parseColor(Colors[pos]));
        return text;

        /*
        TextView colorTextView = new TextView(mContext);
        colorTextView.setText(androidColors[position]);
        colorTextView.setBackgroundColor(Color.parseColor(androidColors[position]));
        return colorTextView;
         */
    }
}
