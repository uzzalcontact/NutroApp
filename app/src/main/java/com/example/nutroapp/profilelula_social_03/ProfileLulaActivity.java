package com.example.nutroapp.profilelula_social_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.nutroapp.R;
import com.example.nutroapp.profileeva_social_04.ProfileEvaActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileLulaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewItem;
    private List<ItemModel> itemModelList;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private TextView textViewLulaLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_lula);

        // Transparent action bar define .. ##
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setStatusBar(this,R.color.color_white);

        // find view
        textViewLulaLong = (TextView) findViewById(R.id.text_profile_lua_long_id);
        recyclerViewItem = (RecyclerView) findViewById(R.id.recycler_lula_long_id);


        // text profile lula long to explore activity .. ##
        textViewLulaLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileLulaActivity.this,
                        ProfileEvaActivity.class));
            }
        });



        // declare to manager with crate a adapter .. ##
        //  ItemRecyclerAdapter adapter = new ItemRecyclerAdapter(this,itemModelList);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerViewItem.setLayoutManager(staggeredGridLayoutManager);


        // create a list.
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel(R.drawable.item_recipes_long_1));
        list.add(new ItemModel(R.drawable.item_recipes_long_2));
        list.add(new ItemModel(R.drawable.item_recipes_long_3));
        list.add(new ItemModel(R.drawable.item_recipes_long_4));
        list.add(new ItemModel(R.drawable.item_recipes_long_1));
        list.add(new ItemModel(R.drawable.item_recipes_long_2));
        list.add(new ItemModel(R.drawable.item_recipes_long_3));
        list.add(new ItemModel(R.drawable.item_recipes_long_4));
        list.add(new ItemModel(R.drawable.item_recipes_long_1));
        list.add(new ItemModel(R.drawable.item_recipes_long_2));
        list.add(new ItemModel(R.drawable.item_recipes_long_3));
        list.add(new ItemModel(R.drawable.item_recipes_long_4));


        // list set an adapter.
        ItemRecyclerAdapter adapter = new ItemRecyclerAdapter(this, list);
        recyclerViewItem.setAdapter(adapter);



    }

    // this is method using to setStatus bar ... ##
    public void setStatusBar(Activity activity, int colorResourceId){

        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity,colorResourceId));
    }
}