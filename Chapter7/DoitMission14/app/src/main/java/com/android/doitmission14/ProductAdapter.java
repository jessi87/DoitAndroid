package com.android.doitmission14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<Product> items = new ArrayList<>();
    OnItemClickListener listener;

    //커스텀 리스너 생성
    public interface OnItemClickListener{
        void onItemClick(ProductAdapter.ViewHolder holder, View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){ //아이템뷰 클릭시 리스너의 메소드 호출
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }

        public void setItem(Product item) {
            imageView.setImageResource(item.getResid());
            textView1.setText(item.getName());
            textView2.setText(item.getPrice()+"원");
            textView3.setText(item.getInfo());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.product,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Product item){
        items.add(item);
    }

    public Product getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Product item){
        items.set(position,item);
    }



}
