package test.yy.chen.shopmall.type.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.type.adapter.LetfAdapter;
import test.yy.chen.shopmall.type.adapter.RightTag;
import test.yy.chen.shopmall.type.bean.Typebean;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ListTypeFragment extends BaseFragment {

      ListView lvTag;
private int currSelelct=-1;
      RecyclerView rvTag;
      private String[] titles ;
      private String[] urls ;
      private RightTag rightTag;
      private boolean isFirst=false;
      Typebean result;
      private LetfAdapter leftAdapter;
      private GridLayoutManager gridLayoutManager;
      @Override
      public View initView() {
            View inflate = inflater.inflate(R.layout.percent_list, null);
           findView(inflate);
            return inflate;
     }

      private void findView(View inflate) {
            lvTag = (ListView) inflate.findViewById(R.id.lv_tag);
            rvTag = (RecyclerView) inflate.findViewById(R.id.rv_tag);
      }

      private void setEvent() {
            lvTag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(context, "selector"+ ((TextView)view).getText()+ i, Toast.LENGTH_SHORT).show();
                        getInternetData(urls[0]);
                        leftAdapter.notifyDataSetChanged();
                  }
                  @Override
                  public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(context, "onNothingSelected", Toast.LENGTH_SHORT).show();
                  }
            });

            lvTag.setOnItemClickListener(new LvTagItemClick());
            lvTag.setSelection(1);
      }

      @Override
      public void bindData() {
            super.bindData();

            titles = new String[]{"小裙子", "上衣", "下装", "外套", "配件",
                    "包包", "装扮", "居家宅品", "办公文具", "数码周边", "游戏专区"};
            urls = new String[]{Constants.SKIRT_URL, Constants.JACKET_URL, Constants.PANTS_URL, Constants.OVERCOAT_URL,
                    Constants.ACCESSORY_URL, Constants.BAG_URL, Constants.DRESS_UP_URL, Constants.HOME_PRODUCTS_URL, Constants.STATIONERY_URL,
                    Constants.DIGIT_URL, Constants.GAME_URL};
            leftAdapter=new LetfAdapter(context ,titles);
            lvTag.setAdapter(leftAdapter);
            rightTag=new RightTag(context,result);
            setEvent();
            getInternetData(urls[0]);





      }

      private void getInternetData(String url) {
            OkHttpUtils.get().url(url).build().execute(new TypeStringCall());
      }

      //lv item点击事件
      class LvTagItemClick implements AdapterView.OnItemClickListener{
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if (currSelelct!=i){
                  Toast.makeText(context, "00", Toast.LENGTH_SHORT).show();
                     getInternetData(urls[i]);
//                     rightTag.notifyDataSetChanged();
                     leftAdapter.setSelecttion(i);
                     currSelelct=i;
               }
            }
      }
      class TypeStringCall extends StringCallback{

            @Override
            public void onError(Call call, Exception e, int i) {

            }

            @Override
            public void onResponse(String s, int i) {
                  result = parseJson(s);
                  if(result!=null){
//                        if(!isFirst){
//                              gridLayoutManager=new GridLayoutManager(context,3);
//                              gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                                    @Override
//                                    public int getSpanSize(int position) {
//                                          if(position==0)
//                                          return 1;
//                                          else
//                                                return 3;
//                                    }
//                              });
                              rvTag.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,
                                      false));
                              rvTag.setAdapter(new RightTag(context,result));
                              isFirst=true;
//                        }else{
//                              rightTag.notifyDataSetChanged();
//                        }



                  }
            }
      }

      private Typebean parseJson(String s) {
            Typebean typebean = JSON.parseObject(s, Typebean.class);
            return typebean;
      }
}
