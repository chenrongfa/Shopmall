package test.yy.chen.shopmall.type.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.home.bean.GoodsBean;
import test.yy.chen.shopmall.type.bean.Typebean;
import test.yy.chen.shopmall.utils.Constants;

import static android.content.ContentValues.TAG;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ListHotAdapter extends RecyclerView.Adapter {
      List<Typebean.ResultBean.HotProductListBean> hot_product_list;
      Context co;


      public ListHotAdapter(List<Typebean.ResultBean.HotProductListBean> hot_product_list, Context co) {
            this.hot_product_list = hot_product_list;
            this.co = co;
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(co, R.layout.list_hot_item, null);
            return new ViewHolder(inflate) ;

      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final ViewHolder viewHolder= (ViewHolder) holder;
            Log.e(TAG, "onBindViewHolder: " );
            Glide.with(co).load(Constants.IMG_URL+hot_product_list.get(position).getFigure())
                    .into(viewHolder.ivListHot);
            viewHolder.tvListPrice.setText(hot_product_list.get(position).getCover_price());
            viewHolder.ivListHot.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        GoodsBean goodsBean=new GoodsBean();
                        goodsBean.setCover_price(hot_product_list.get(position).getCover_price());
                        goodsBean.setFigure(Constants.IMG_URL+hot_product_list.get(position).getFigure());
                        goodsBean.setName(hot_product_list.get(position).getName());
                        goodsBean.setProduct_id(hot_product_list.get(position).getProduct_id());
                        Constants.startAvtivity(co,goodsBean);
                  }
            });
      }


      @Override
      public int getItemCount() {
            Log.e(TAG, "getItemCount: "+hot_product_list.size());
            return hot_product_list.size();
      }

      static class ViewHolder extends  RecyclerView.ViewHolder{
            ImageView ivListHot;
            TextView tvListPrice;
            public ViewHolder(View itemView) {
                  super(itemView);
                  ivListHot = (ImageView) itemView.findViewById(R.id.iv_list_hot);
                  tvListPrice = (TextView) itemView. findViewById(R.id.tv_list_price);
            }
      }
}
