package com.android.doitmission13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    ArrayList<Person> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //뷰그룹의 context를 참조
        View itemView = inflater.inflate(R.layout.person_info,viewGroup,false); //뷰 객체 만들기

        return new ViewHolder(itemView); //뷰홀더 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체 반환
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person item = items.get(position); //ArrayList 에서 Person 객체를 꺼내어 설정
        viewHolder.setItem(item);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item){
        items.add(item);
    }

    public void setItems(ArrayList<Person> items){
        this.items = items;
    }

    public Person getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Person item){
        items.set(position,item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        TextView textView3;

        //뷰 객체를 전달받음
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }

        public void setItem(Person item){
            textView.setText(item.getName());
            textView2.setText(item.getBirthday());
            textView3.setText(item.getMobile());

        }
    }
}
