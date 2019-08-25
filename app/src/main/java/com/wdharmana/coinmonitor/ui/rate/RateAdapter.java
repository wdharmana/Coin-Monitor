package com.wdharmana.coinmonitor.ui.rate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wdharmana.coinmonitor.R;
import com.wdharmana.coinmonitor.model.Rate;
import com.wdharmana.coinmonitor.model.RateResponse;

import java.util.List;

public class RateAdapter extends RecyclerView.Adapter<RateAdapter.CustomViewHolder> {

    private List<Rate> rateList;
    private Context context;

    public RateAdapter(Context context, List<Rate> rateList){
        this.context = context;
        this.rateList = rateList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtName;
        TextView txtRate;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtName = mView.findViewById(R.id.tv_asset_name);
            txtRate = mView.findViewById(R.id.tv_rate);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_rate, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtName.setText("BTC - "+rateList.get(position).getAssetIdQuote());
        holder.txtRate.setText(String.valueOf(rateList.get(position).getRate()));
    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }

}
