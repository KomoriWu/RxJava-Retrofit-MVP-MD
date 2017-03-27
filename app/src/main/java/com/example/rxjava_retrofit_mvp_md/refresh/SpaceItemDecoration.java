package com.example.rxjava_retrofit_mvp_md.refresh;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/**
 * Created by KomoriWu
 * on 2017-03-25.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration{
  
        private int space;  
  
        public SpaceItemDecoration(int space) {  
            this.space = space;  
        }  
  
        @Override  
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
  
            if(parent.getChildPosition(view) != 0)  
                outRect.top = space;  
        }  
    }