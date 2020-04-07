package com.android.recyclerviewpractice2;

import android.view.View;

public interface OnPersonItemClickListener {
    //아이템 클릭했을 때 기능 설정
    public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);
}
