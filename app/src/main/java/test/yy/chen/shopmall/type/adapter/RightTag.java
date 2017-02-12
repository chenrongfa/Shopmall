package test.yy.chen.shopmall.type.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.type.viewholder.GrivViewHolder;
import test.yy.chen.shopmall.type.bean.Typebean;
import test.yy.chen.shopmall.type.viewholder.ListViewHolder;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class RightTag extends RecyclerView.Adapter {
      Context context;
      Typebean result;
      private final int HOT=0;
      private final int ODERNARY=1;
      int type=0;

      public RightTag(Context context, Typebean result) {
            this.context=context;
            this.result=result;
      }

      @Override
      public int getItemViewType(int position) {
            if(position==HOT)
                  type=0;
            else
            type=1;
            return type;
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if(viewType==HOT){
                  view=View.inflate(context, R.layout.list_item,null);
                  return  new ListViewHolder(view);
           }else if(viewType==ODERNARY){
                  view=View.inflate(context, R.layout.griv_item,null);
                  return  new GrivViewHolder(view);
            }

            return null;
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((BaseViewHolder) holder).bindData(result,context);
      }

      @Override
      public int getItemCount() {
            return 2;
      }
}
