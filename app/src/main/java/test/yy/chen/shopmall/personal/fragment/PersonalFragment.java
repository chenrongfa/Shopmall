package test.yy.chen.shopmall.personal.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class PersonalFragment extends BaseFragment {
    TextView textView;
    private static final String TAG = "HomeFragment";
    @Override
    public View initView() {
        textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    public void bindData() {
//        super.bindData();
        Log.e(TAG, "bindData: 2" );
        textView.setText(R.string.personal);
    }
}
