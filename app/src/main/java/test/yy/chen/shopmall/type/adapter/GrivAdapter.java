package test.yy.chen.shopmall.type.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.type.bean.Typebean;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class GrivAdapter extends BaseAdapter {
      List<Typebean.ResultBean.ChildBean> child;
      Context co;
      public GrivAdapter(List<Typebean.ResultBean.ChildBean> child, Context co) {
      this.child=child;
            this.co=co;
      }

      private static final String TAG = "GrivAdapter";
      @Override
      public int getCount() {
            Log.e(TAG, "getCount: "+child.size() );
            return
                    child.size();
      }

      @Override
      public Object getItem(int i) {
            return child.get(i);
      }

      @Override
      public long getItemId(int i) {
            return 0;
      }

      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if(view ==null){
                view=  View.inflate(co, R.layout.list_hot_item,null);
                  viewHolder=new ViewHolder();
                  viewHolder. ivListHot = (ImageView) view.findViewById(R.id.iv_list_hot);
                  viewHolder.  tvListPrice = (TextView) view. findViewById(R.id.tv_list_price);
                  view.setTag(viewHolder);
            }else{
                  viewHolder= (ViewHolder) view.getTag();
            }
                  Glide.with(co).load(Constants.IMG_URL+child.get(i).getPic())
                          .diskCacheStrategy(DiskCacheStrategy.ALL)
                          .into(viewHolder.ivListHot);
                  viewHolder.tvListPrice.setText(child.get(i).getName());

            return view;
      }
      static class ViewHolder {
            ImageView ivListHot;
            TextView tvListPrice;

      }
}
