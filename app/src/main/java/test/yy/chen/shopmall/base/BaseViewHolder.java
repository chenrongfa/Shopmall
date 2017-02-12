package test.yy.chen.shopmall.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.yy.chen.shopmall.home.bean.HomeData;
import test.yy.chen.shopmall.type.bean.Typebean;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public void bindData(HomeData.ResultBean resultBean, Context co){}
    public void bindData(Typebean typebean, Context co){}
}
