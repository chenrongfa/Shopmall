package test.yy.chen.shopmall.type.fragment;

import android.view.View;
import android.widget.TextView;

import test.yy.chen.shopmall.base.BaseFragment;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ListTypeFragment extends BaseFragment {
      @Override
      public View initView() {
            TextView textView=new TextView(context );
            textView.setText("110");
            return textView;
      }
}
