package com.androidpillars.covid19.custom_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidpillars.covid_19.R;
import com.asksira.loopingviewpager.LoopingPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Gowtham.R on 2020-04-06.
 */
public class DashBoradScreenPagerAdapter extends LoopingPagerAdapter<String> {

    private static final int VIEW_TYPE_NORMAL = 100;
    private static final int VIEW_TYPE_SPECIAL = 101;

    public DashBoradScreenPagerAdapter(Context context, ArrayList<String> itemList, boolean isInfinite) {
        super(context, itemList, isInfinite);
    }

    @Override
    protected int getItemViewType(int listPosition) {
        //if (itemList.get(listPosition).equals("Avoid going out during the lockdown. Help break the chain of spread.")) return VIEW_TYPE_SPECIAL;
        return VIEW_TYPE_NORMAL;
    }

    @Override
    protected View inflateView(int viewType, ViewGroup container, int listPosition) {
        if (viewType == VIEW_TYPE_SPECIAL) return LayoutInflater.from(context).inflate(R.layout.dash_board_pager_adapter, container, false);
        return LayoutInflater.from(context).inflate(R.layout.dash_board_pager_adapter, container, false);
    }

    @Override
    protected void bindView(View convertView, int listPosition, int viewType) {
        if (viewType == VIEW_TYPE_SPECIAL) return;
        convertView.findViewById(R.id.image).setBackgroundColor(context.getResources().getColor(getBackgroundColor(listPosition)));
        TextView description = convertView.findViewById(R.id.description);
        description.setText(String.valueOf(itemList.get(listPosition)));
    }


    private int getBackgroundColor (int number) {
        switch (number) {
            case 0:
                return android.R.color.holo_red_light;
            case 1:
                return android.R.color.holo_orange_light;
            case 2:
                return android.R.color.holo_green_light;
            case 3:
                return android.R.color.holo_blue_light;
            case 4:
                return android.R.color.holo_purple;
            case 5:
                return android.R.color.black;
            default:
                return android.R.color.black;
        }
    }
}