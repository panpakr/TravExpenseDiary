package com.example.pkumar.travexpensesdiary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pkumar on 20/9/16.
 */
public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ViewHolder>{

    private ArrayList<Expense> expenses;


    public  ExpensesAdapter(ArrayList<Expense> expenseArrayList)
    {
        expenses = expenseArrayList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

         TextView tvnotes;
         TextView tvamount;

        public ViewHolder(View itemView) {
            super(itemView);

            tvnotes= (TextView) itemView.findViewById(R.id.trow_notes);
            tvamount = (TextView) itemView.findViewById(R.id.trow_amount);
        }
    }




    @Override
    public ExpensesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvnotes.setText(expenses.get(position).getNotes());
        holder.tvamount.setText(expenses.get(position).getAmount());



    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }
}
