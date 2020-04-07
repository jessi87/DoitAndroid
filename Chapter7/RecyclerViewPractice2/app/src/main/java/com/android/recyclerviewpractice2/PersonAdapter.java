package com.android.recyclerviewpractice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener{
    ArrayList<Person> items = new ArrayList<>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //뷰그룹의 context를 참조
        View itemView = inflater.inflate(R.layout.person_item,viewGroup,false); //뷰 객체 만들기

        return new ViewHolder(itemView,this); //뷰홀더 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체 반환
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

    //어댑터 클래스 밖에서 이벤트 처리를 하기 위해 외부에서 리스너를 설정하고
    //외부에서 재정의된 onItemClick()이 호출되도록 한 것 (메인 액티비티에서 설정해줌)
    public void setOnItemClickListener(OnPersonItemClickListener listener){
        this.listener = listener;
    }

    //뷰홀더 클래스 안에서 뷰가 클릭되었을 때 호출 (그냥 해놓은것)
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }


    //각각의 아이템을 위하나 뷰는 뷰홀더에 담음 , 뷰홀더를 어댑터안에 넣어둔다고 생각
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        //뷰 객체를 전달받음
        public ViewHolder(@NonNull View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() { //아이템뷰에 리스너 설정
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){ //아이템뷰 클릭시 리스너의 메소드 호출
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }

        public void setItem(Person item){
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }
}
