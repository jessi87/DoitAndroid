package com.android.jsonpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    ArrayList<Movie> items = new ArrayList<>();

    //아이템 파일을 인플레이션 한 뒤 뷰홀더 객체 생성, 그안에 넣고 반환
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.movie_item,parent,false);

        return new ViewHolder(itemView);
    }

    //인덱스에 맞는 Movie 객체를 찾아 뷰홀더에 객체를 설정
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Movie item){
        items.add(item);
    }
    public void clearItem(){
        items.clear();
    }

    public void setItems(ArrayList<Movie> items){
        this.items = items;
    }

    public Movie getItems(int position){
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) { //각각의 아이템을 위한 뷰를 뷰홀더에 담아둠
            super(itemView);

            textView = itemView.findViewById(R.id.textView2);
            textView2 = itemView.findViewById(R.id.textView3);
        }
        public void setItem(Movie item){
            textView.setText(item.movieNm);
            textView2.setText(item.audiCnt+"명");
        }
    }

}
