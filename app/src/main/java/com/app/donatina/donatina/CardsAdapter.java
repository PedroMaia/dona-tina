package com.app.donatina.donatina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Cards adapter
 *
 * @author Pedro Maia <pedromaia@nutrium.io>
 * @version 1.0
 * @since 07/10/2016.
 */
public class CardsAdapter extends ArrayAdapter<Card> {
    private final ArrayList<Card> cards;
    private final LayoutInflater layoutInflater;

    public CardsAdapter(Context context, ArrayList<Card> cards) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Card card = cards.get(position);
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        ImageView iv_food= (ImageView) view.findViewById(R.id.iv_food);

        Picasso.with(getContext()).load(card.imageUrl).into(iv_food);
        ((TextView)view.findViewById(R.id.tv_title)).setText(card.name);
        ((TextView)view.findViewById(R.id.tv_description)).setText(card.description);
        return view;
    }

    @Override
    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
