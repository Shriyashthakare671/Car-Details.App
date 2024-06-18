package com.shriyasht.sqlitedbroomlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shriyasht.sqlitedbroomlib.R;
import com.shriyasht.sqlitedbroomlib.entity.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    Context context;
    List<Car> carList;

    public CarAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
    }

    public void setCarList (List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_car, null);
        return new CarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.textcarNo.setText("CarNo - "+carList.get(position).getCarNo());
        holder.textcarName.setText("Car Name - "+carList.get(position).getCarName());
        holder.textcarPrice.setText("Car Price - " +carList.get(position).getPrice());
    }

    public int getItemCount() {
        return carList.size();
    }

    class  CarViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView textcarNo, textcarName, textcarPrice;
        public CarViewHolder(@NonNull View itemview) {
            super(itemview);
            textcarNo = itemview.findViewById(R.id.textcarNo);
            textcarName = itemview.findViewById(R.id.textcarName);
            textcarPrice = itemview.findViewById(R.id.textcarPrice);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
