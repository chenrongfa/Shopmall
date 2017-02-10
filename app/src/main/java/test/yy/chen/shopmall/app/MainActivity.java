package test.yy.chen.shopmall.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.community.fragment.CommunityFragment;
import test.yy.chen.shopmall.home.fragment.HomeFragment;
import test.yy.chen.shopmall.personal.fragment.PersonalFragment;
import test.yy.chen.shopmall.shopcar.fragment.ShopcarFragment;
import test.yy.chen.shopmall.type.fragment.TypeFragment;

import static test.yy.chen.shopmall.R.id.rb_shopcar;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_type)
    RadioButton rbType;
    @BindView(R.id.rb_community)
    RadioButton rbCommunity;
    @BindView(rb_shopcar)
    RadioButton rbShopcar;
    @BindView(R.id.rb_personal)
    RadioButton rbPersonal;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.fl_container)
    FrameLayout fl_container;
    private FragmentManager fragmentManager;
    private List<BaseFragment> baseFragment;
    private int currposition;
    private BaseFragment currFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgMain= (RadioGroup) findViewById(R.id.rg_main);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        fragmentManager=getSupportFragmentManager();
        baseFragment=new ArrayList<>();
        initFragments();
        rgMain.setOnCheckedChangeListener(new MyOnCheckListener());
        rgMain.check(R.id.rb_home);
    }
        class MyOnCheckListener implements RadioGroup.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    default:
                    case R.id.rb_home:
                        currposition=0;
                        break;
                    case R.id.rb_type:
                        currposition=1;
                        break;
                    case R.id.rb_community:
                        currposition=2;
                        break;
                    case rb_shopcar:
                        currposition=3;
                        break;
                    case R.id.rb_personal:
                        currposition=4;
                        break;

                }
                BaseFragment nextFragment=getFragment(currposition);
                switchFragment (currFragment,nextFragment);
            }
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
                transaction.add(R.id.fl_container,nextFragment);
                if(currFragment!=null){
                    transaction.hide(currFragment);
                }
            }
            transaction.commit();
           this.currFragment=nextFragment;
        }

    }

    /**
     * 得到下一个fragment
     * @param currposition
     * @return
     */
    private BaseFragment getFragment(int currposition) {
        if(baseFragment!=null &&baseFragment.size()>=currposition){
            return baseFragment.get(currposition);
        }
        return null;
    }

    private void initFragments() {
        baseFragment.add(new HomeFragment());
        baseFragment.add(new TypeFragment());
        baseFragment.add(new CommunityFragment());
        baseFragment.add(new ShopcarFragment());
        baseFragment.add(new PersonalFragment());

    }


}
