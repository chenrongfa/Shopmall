package test.yy.chen.shopmall.home.viewholder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.home.adapter.ActPager;
import test.yy.chen.shopmall.home.bean.HomeData;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ActViewHolder extends BaseViewHolder {
    private ViewPager viewPager;
    public ActViewHolder(View view) {
        // TODO: 2017/1/22  
        super(view);
        viewPager= (ViewPager) view.findViewById(R.id.vp_v4);
        viewPager.setPageMargin(20);
    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, Context context) {
        super.bindData(resultBean, context);
        viewPager.setAdapter(new ActPager(resultBean.getAct_info(),context));
        //// FIXME: 2017/1/22
        // 
        //// TODO: 2017/1/22
        System.out.println("ActViewHolder.bindData");


    }
}
