package com.fdmt.bancomer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fdmt.bancomer.R;
import com.fdmt.bancomer.resposnes.ListMov;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * A simple adapter to populate the RecyclerView.
 */

public class MovementsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<ListMov> data = Collections.emptyList();

    public MovementsAdapter(Context context, List<ListMov> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_movement, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder myHolder= (ViewHolder) holder;
        ListMov current=data.get(position);
        myHolder.number.setText(current.getPhoneDestination());
        myHolder.amount.setText(String.format(Locale.US, "%s", NumberFormat.getCurrencyInstance(Locale.US).format(current.getAmount())));
        myHolder.date.setText(getDateSpanish(current.getDateCreate()));
    }

    private String getDateSpanish(Long milis) {
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(milis);
        return String.format(Locale.US, "%d de %s del %d", date.get(Calendar.DAY_OF_MONTH), months[date.get(Calendar.MONTH)], date.get(Calendar.YEAR));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView number;
        TextView amount;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);

            number = (TextView) itemView.findViewById(R.id.txt_number);
            amount = (TextView) itemView.findViewById(R.id.txt_amount);
            date = (TextView) itemView.findViewById(R.id.txt_date);
        }
    }
}
