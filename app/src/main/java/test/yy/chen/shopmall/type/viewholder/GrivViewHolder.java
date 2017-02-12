package test.yy.chen.shopmall.type.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.type.adapter.GrivAdapter;
import test.yy.chen.shopmall.type.bean.Typebean;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class GrivViewHolder extends BaseViewHolder  {
      private GridView gv_ordernary;
      public GrivViewHolder(View view)
      {
            super(view);
            gv_ordernary = (GridView) view.findViewById(R.id.gv_odernary);
      }

      @Override
      public void bindData(Typebean typebean,final Context co) {
            super.bindData(typebean, co);
            gv_ordernary.setAdapter(new GrivAdapter(typebean.getResult().get(0).getChild(),co));
            gv_ordernary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(co, ""+i, Toast.LENGTH_SHORT).show();
                  }
            });
      }
}
