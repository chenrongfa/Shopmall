package test.yy.chen.shopmall.type.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.home.adapter.TagAdapter;
import test.yy.chen.shopmall.type.bean.TagBean;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class TabFragment extends BaseFragment {
      private GridView gv_tab;
      private static final String TAG = "TabFragment";
      private TagBean tagBean;

      @Override
      public View initView() {
            View inflate = inflater.inflate(R.layout.tabfragment, null);
            gv_tab = (GridView) inflate.findViewById(R.id.gl_tab);
            return inflate;
      }

      @Override
      public void bindData() {
            super.bindData();
            getInternetData();
            gv_tab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(context, ""+((TextView)view).getText()+i, Toast.LENGTH_SHORT).show();
                  }
            });

      }

      private void getInternetData() {
                  OkHttpUtils
                          .get()
                          .tag(context)
                  .url(Constants.TAG_URL)
                          .build()
                          .execute(new MyInternetCall());


      }
       class MyInternetCall extends StringCallback{

             @Override
             public void onError(Call call, Exception e, int i) {
                   Log.e(TAG, "onError: " +e.toString() );

             }

             @Override
             public void onResponse(String s, int i) {
                tagBean= parseJson(s);
                   if (tagBean!=null){
                         if(tagBean.getResult().size()>0){
                               gv_tab.setAdapter(new TagAdapter(context ,tagBean.getResult()));
                         }
                   }
             }
       }

      private TagBean parseJson(String s) {
            TagBean   tagBeen =  JSON.parseObject(s,TagBean.class);
            return tagBeen;
      }
}
