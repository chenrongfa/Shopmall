package test.yy.chen.shopmall.type.fragment;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.utils.Constants;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class TypeFragment extends BaseFragment implements View.OnClickListener {

      private static final String TAG = "HomeFragment";
      SegmentTabLayout stlSwitch;
      ImageButton ibSearch;
      FrameLayout frTypecontainer;
      private ArrayList<BaseFragment> baseFragments;
      private String[] title;
      private int currPosition=0;
     private android.support.v4.app.FragmentManager fragmentManager;
      private BaseFragment currFragment;

      @Override
      public View initView() {
            View inflate = inflater.inflate(R.layout.typefragment, null);
            stlSwitch= (SegmentTabLayout) inflate.findViewById(R.id.stl_switch);
            ibSearch = (ImageButton) inflate.findViewById(R.id.ib_search);
            //准备数据
            readyData();
            return inflate;
      }
      private void readyData() {
            fragmentManager=getActivity().getSupportFragmentManager();
            currFragment=this;
            title = new String[]{"分类", "标签"};
            baseFragments = new ArrayList<>();
            baseFragments.add(new ListTypeFragment());
            baseFragments.add(new TabFragment());

      }

      @Override
      public void bindData() {
//        super.bindData();
            setEvent();
           switchFragment(null,baseFragments.get(0));

            stlSwitch.setTabData(title);

      }

      private void setEvent() {
            ibSearch.setOnClickListener(this);
            stlSwitch.setOnTabSelectListener(new OnTabSelectListener() {
                  //位置发生改变
                  @Override
                  public void onTabSelect(int position) {
                        Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                        switchFragment(currFragment,baseFragments.get(position));
                  }
//没有改变
                  @Override
                  public void onTabReselect(int position) {
                        Toast.makeText(context , "re"+position, Toast.LENGTH_SHORT).show();
                  }
            });
      }

      private void switchFragment(BaseFragment currFragment, BaseFragment nextFragment) {
            if(nextFragment!=currFragment){
                  FragmentTransaction transaction = fragmentManager.beginTransaction();
                  if(nextFragment.isAdded()) {
                        transaction.show(nextFragment);
                        if(currFragment!=null) {
                              transaction.hide(currFragment);
                        }
                  }else{
                        transaction.add(R.id.fr_type_container,nextFragment);
                        if(currFragment!=null){
                              transaction.hide(currFragment);
                        }
                  }
                  transaction.commit();
                  this.currFragment=nextFragment;
            }

      }


      @Override
      public void onClick(View view) {
            if(view==ibSearch){
                  Constants.showTip(context,"搜索");

            }

      }
}
