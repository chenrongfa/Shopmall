package test.yy.chen.shopmall.home.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseViewHolder;
import test.yy.chen.shopmall.home.adapter.ChannelAdapter;
import test.yy.chen.shopmall.home.bean.HomeData;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/20
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class ChannelViewHolder extends BaseViewHolder {
    private Context context;
    private GridView gv_main;
    public ChannelViewHolder(View view) {
        super(view);
        gv_main= (GridView) view.findViewById(R.id.gv_main);
    }

    @Override
    public void bindData(HomeData.ResultBean resultBean, final Context context) {
        super.bindData(resultBean, context);
        this.context=context;
        gv_main.setAdapter(new ChannelAdapter(resultBean.getChannel_info(),context));
        gv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Constants.startAvtivity(context, goodsBean);
                    }
        });
    }
}
