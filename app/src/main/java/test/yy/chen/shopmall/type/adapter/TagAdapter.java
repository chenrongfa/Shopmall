package test.yy.chen.shopmall.type.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.type.bean.TagBean;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class TagAdapter extends BaseAdapter {
      Context context;
      List<TagBean.ResultBean> result;
      private int[] color;
      private int[] colorSelector=new int[]{Color.BLACK,Color.BLUE,Color.GREEN,Color.YELLOW};
      public TagAdapter(Context context, List<TagBean.ResultBean> result) {
            this.context=context;
            this.result=result;
            color=new int[result.size()];
            setColor();
      }

      private void setColor() {

            for (int i=0;i<color.length;i++){
                  color[i]=colorSelector[(int)(Math.random()*4)];
            }
      }

      @Override
      public int getCount() {
            return result.size();
      }

      @Override
      public Object getItem(int i) {
            return result.get(i);
      }

      @Override
      public long getItemId(int i) {
            return 0;
      }

      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
           ViewHolder  viewHolder;
            if(view==null){
                  view=View.inflate(context,R.layout.tag_item,null);
                 viewHolder=new ViewHolder();
                  viewHolder.tv_tag= (TextView) view.findViewById(R.id.tv_tag);
                  viewHolder.tv_tag.setTextColor(color[i]);
                  view.setTag(viewHolder);
            }else {
                  viewHolder= (ViewHolder) view.getTag();

            }
                  viewHolder.tv_tag.setText(result.get(i).getName());
            return view;
      }
      static  class ViewHolder{
            TextView tv_tag;
      }
}
