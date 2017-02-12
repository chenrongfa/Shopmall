package test.yy.chen.shopmall.type.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import test.yy.chen.shopmall.R;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/10
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class LetfAdapter extends BaseAdapter {
      Context context;
      String[] titles;
      private int currpostion;
      public LetfAdapter(Context context, String[] titles) {
            this.context=context;
            this.titles=titles;
      }

      @Override
      public int getCount() {
            return titles.length;
      }

      @Override
      public Object getItem(int i) {
            return titles[i];
      }

      @Override
      public long getItemId(int i) {
            return 0;
      }

      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if(view ==null){
               view= View.inflate(context,R.layout.left_tag_item,null);
                  viewHolder=new ViewHolder();
                  viewHolder.tv_left_tag= (TextView) view.findViewById(R.id.tv_lefttag);
                  view.setTag(viewHolder);
            }else{
                  viewHolder= (ViewHolder) view.getTag();
            }
            if(i==currpostion) {
                  viewHolder.tv_left_tag.setSelected(true);
//                  viewHolder.tv_left_tag.setBackgroundResource(R.drawable.selector_left_tag);
                  viewHolder.tv_left_tag.setBackgroundColor(Color.RED);
            }else{
//                  viewHolder.tv_left_tag.setSelected(false);
//                  viewHolder.tv_left_tag.setBackgroundResource(R.drawable.selector_left_tag_sel);
                  viewHolder.tv_left_tag.setBackgroundColor(Color.GRAY);
            }


            viewHolder.tv_left_tag.setText(titles[i]);
            return view;
      }
      static class ViewHolder{
            private TextView tv_left_tag;
      }
      public void setSelecttion(int position){
            if(currpostion!=position){
                  currpostion=position;
            notifyDataSetChanged();

            }
      }

}
