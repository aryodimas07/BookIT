package com.filkom.aryodimas.bookit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.filkom.aryodimas.bookit.R;
import com.filkom.aryodimas.bookit.model.OrderHistoryModel;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.HistoryViewHolder> {

    private Context mContext;
    private ArrayList<OrderHistoryModel> orderHistoryModels;

    public OrderHistoryAdapter(Context mContext,ArrayList<OrderHistoryModel> orderHistoryModels) {
        this.mContext = mContext;
        this.orderHistoryModels = orderHistoryModels;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_order_history,viewGroup,false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int i) {
        OrderHistoryModel orderHistoryModel = orderHistoryModels.get(i);
        historyViewHolder.tv_order_id.setText(orderHistoryModel.getOrderId());
        historyViewHolder.tv_cinema_location.setText(orderHistoryModel.getCinemaLocation());
        historyViewHolder.tv_total_price.setText(orderHistoryModel.getTotalPrice());
        historyViewHolder.iv_order_image.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.ic_ticket_confirmation));
    }

    @Override
    public int getItemCount() {
        return orderHistoryModels.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_order_id,tv_cinema_location,tv_total_price;
        ImageView iv_order_image;

        public HistoryViewHolder(View itemView){
            super(itemView);
            tv_order_id = itemView.findViewById(R.id.tv_order_id);
            tv_cinema_location = itemView.findViewById(R.id.tv_cinema_location);
            tv_total_price = itemView.findViewById(R.id.tv_price_order);
            iv_order_image = itemView.findViewById(R.id.iv_order_history);
        }
    }
}
