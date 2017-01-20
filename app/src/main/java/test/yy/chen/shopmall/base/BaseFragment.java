package test.yy.chen.shopmall.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    public LayoutInflater inflater;
    public Context context;
    public BaseFragment(){
        Log.e(TAG, "BaseFragment: " );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindData();
    }

    /**
     * 绑定数据
     */
   public  void bindData() {
       Log.e(TAG, "bindData: 1" );
    }

    /**
     * 初始化view
     * @return
     */
    public abstract View initView();
}
