package test.yy.chen.shopmall.home.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.home.adapter.RecommedAdapter;
import test.yy.chen.shopmall.home.bean.GoodsBean;
import test.yy.chen.shopmall.home.bean.HomeData;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/21
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class RecommendViewHolder extends BaseViewHolder implements View.OnClickListener {
    private TextView  tv_groom;
    private TextView  tv_rdmore;
    private GridView  gv_rdmore;
    private Context co;
    private HomeData.ResultBean result;
    public RecommendViewHolder(View view) {
        super(view);
        tv_groom= (TextView) view.findViewById(R.id.tv_groom);
        tv_rdmore= (TextView) view.findViewById(R.id.tv_groom_more);
        gv_rdmore= (GridView) view.findViewById(R.id.gv_rdmain);

    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, Context co) {
        super.bindData(resultBean, co);
        this.co=co;
        result=resultBean;
        tv_groom.setOnClickListener(this);
        tv_rdmore.setOnClickListener(this);
        gv_rdmore.setAdapter(new RecommedAdapter(resultBean.getRecommend_info()
        ,co));
        gv_rdmore.setOnItemClickListener(new RecommendListener());
    }

    @Override
    public void onClick(View view) {
        if(view==tv_groom){
            Toast.makeText(co, "tv_groom", Toast.LENGTH_SHORT).show();
        }else if(view==tv_rdmore){
            Toast.makeText(co, "tv_rdmore", Toast.LENGTH_SHORT).show();
        }

    }

    private class RecommendListener implements android.widget.AdapterView
            .OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            HomeData.ResultBean.RecommendInfoBean hotInfoBean = result.getRecommend_info().get(i);
            GoodsBean goodsBean=new GoodsBean();
            goodsBean.setCover_price(hotInfoBean.getCover_price());
            goodsBean.setProduct_id(hotInfoBean.getProduct_id());
            goodsBean.setName(hotInfoBean.getName());//描述
            goodsBean.setFigure(Constants.IMG_URL+hotInfoBean.getFigure());//图片

            Constants.startAvtivity(co, goodsBean);
        }
    }
}
