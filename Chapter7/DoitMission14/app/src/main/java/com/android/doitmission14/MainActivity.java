package com.android.doitmission14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);

        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);
        
        getData(); //어댑터에 데이터 추가

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"상품명 : "+item.getName()+"\n가격 : "+item.getPrice()+"원",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getData() {
        List<String> listName = Arrays.asList("맨투맨", "니트", "후드", "가방", "운동화", "구두");
        List<String> listPrice = Arrays.asList("56,000","48,000","62,000","2,370,000","52,000","290,000");
        List<String> listInfo = Arrays.asList("상큼한 오랜지색","워너비 남친룩","힙한 레터링","러블리한 명품백","스테디셀러 스니커즈","시선집중 하이힐");
        List<Integer> listResId = Arrays.asList(
                R.drawable.clothes1,
                R.drawable.clothes2,
                R.drawable.clothes3,
                R.drawable.clothes4,
                R.drawable.clothes5,
                R.drawable.clothes6);
        for (int i = 0; i < listName.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Product data = new Product();
            data.setName(listName.get(i));
            data.setPrice(listPrice.get(i));
            data.setInfo(listInfo.get(i));
            data.setResid(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

}
