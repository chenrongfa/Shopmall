package test.yy.chen.shopmall.home.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.home.adapter.HotAdapter;
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
public class HotViewHolder extends BaseViewHolder implements View.OnClickListener {
    private TextView tv_hot_more;
    private TextView tv_hot;
    private GridView gv_hot;
    private  HomeData.ResultBean resultBean;
    private Context context;
    public HotViewHolder(View itemView) {
        super(itemView);
        tv_hot_more= (TextView) itemView.findViewById(R.id.tv_hot_more);
        tv_hot= (TextView) itemView.findViewById(R.id.tv_hot);
        gv_hot= (GridView) itemView.findViewById(R.id.gv_hotmain);
    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, Context co) {
        super.bindData(resultBean, co);
        this.resultBean=resultBean;
        context=co;
        gv_hot.setAdapter(new HotAdapter(resultBean.getHot_info()
        ,co));
        tv_hot.setOnClickListener(this);
        tv_hot_more.setOnClickListener(this);
        gv_hot.setOnItemClickListener(new HotListener());
    }
    private class HotListener implements android.widget.AdapterView
            .OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            HomeData.ResultBean.HotInfoBean hotInfoBean = resultBean.getHot_info().get(i);
            GoodsBean goodsBean=new GoodsBean();
            goodsBean.setCover_price(hotInfoBean.getCover_price());
            goodsBean.setProduct_id(hotInfoBean.getProduct_id());
            goodsBean.setName(hotInfoBean.getName());//描述
            goodsBean.setFigure(Constants.IMG_URL+hotInfoBean.getFigure());//图片
            Constants.startAvtivity(context,goodsBean);
        }
    }
    @Override
    public void onClick(View view) {
        if(view==tv_hot){
            Toast.makeText(context, "hot", Toast.LENGTH_SHORT).show();

        }else if(view==tv_hot_more){
            Toast.makeText(context, "hot_more", Toast.LENGTH_SHORT).show();

        }

    }
}
