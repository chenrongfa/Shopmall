package test.yy.chen.shopmall.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.shopcar.fragment.ShopcarFragment;

public class ShopActivity extends AppCompatActivity {
    private FrameLayout fr_container;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        fr_container = (FrameLayout) findViewById(R.id.fr_container);


    }

    @Override
    protected void onResume() {
        super.onResume();
        manager=getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fr_container,new ShopcarFragment()).commit();
    }
}
