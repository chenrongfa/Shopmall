package test.yy.chen.shopmall.type.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.type.adapter.ListHotAdapter;
import test.yy.chen.shopmall.type.bean.Typebean;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ListViewHolder extends BaseViewHolder {
      private RecyclerView rv_hot;
      public ListViewHolder(View itemView) {
            super(itemView);
            rv_hot = (RecyclerView) itemView.findViewById(R.id.rv_hot);


      }

      @Override
      public void bindData(Typebean typebean, Context co) {
            super.bindData(typebean, co);
            rv_hot.setLayoutManager(new LinearLayoutManager(co,LinearLayoutManager.HORIZONTAL,false));
            rv_hot.setAdapter(new ListHotAdapter(typebean.getResult().get(0).getHot_product_list(),co ));
      }
}
