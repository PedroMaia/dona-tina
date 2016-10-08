package com.app.donatina.donatina;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
/**
 * @author Pedro Maia <pedromaia@nutrium.io>
 * @version 1.0
 * @since 07/10/2016.
 */

public class PageAdapter extends ArrayAdapter<Card> {
private final ArrayList<Card> cards;
private final LayoutInflater layoutInflater;

public PageAdapter(Context context, ArrayList<Card> cards) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);
        }


@Override
public View getView(int position, View convertView, ViewGroup parent) {
        Card card = cards.get(position);
        View view = layoutInflater.inflate(R.layout.page_item, parent, false);
        //       ((ImageView)view.findViewById(R.id.card_image)).setImageURI(card.imageUrl);
//        ((TextView)view.findViewById(R.id.helloText_1)).setText(card.name);
//        ((TextView)view.findViewById(R.id.helloText)).setText(card.name);
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
