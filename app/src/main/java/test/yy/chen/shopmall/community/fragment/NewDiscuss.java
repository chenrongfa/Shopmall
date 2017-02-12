package test.yy.chen.shopmall.community.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.community.adapter.NewAdapter;
import test.yy.chen.shopmall.community.bean.NewBean;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/11
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class NewDiscuss extends BaseFragment {
      private ListView listView;
      @Override
      public View initView() {
            View inflate = inflater.inflate(R.layout.newdiscusslist, null);
            listView= (ListView) inflate.findViewById(R.id.lv_new);
            return inflate;
      }

      @Override
      public void bindData() {
            super.bindData();
            getInternetData(Constants.NEW_POST_URL);
      }

      private void getInternetData(String url) {
            OkHttpUtils.get()
                    .url(url)
                    .build()
                    .execute(new CommunityString());

      }
    class CommunityString extends StringCallback{
          @Override
          public void onError(Call call, Exception e, int i) {
                Toast.makeText(context, "错误吗"+i, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onResponse(String s, int i) {
                NewBean newBean = parseJson(s);
                if (newBean!=null&&newBean.getResult().size()>0){
                        listView.setAdapter(new NewAdapter(context,newBean.getResult()));
                }
          }
    }

      /**
       *   解析json
       * @param s
       * @return NewBean;
       */
      private NewBean parseJson(String s) {
            NewBean newBean = JSON.parseObject(s, NewBean.class);
            return newBean;
      }
}
