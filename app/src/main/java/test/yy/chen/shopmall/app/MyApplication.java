package test.yy.chen.shopmall.app;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
        okHttpClient.connectTimeout(5*1000, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(5*1000,TimeUnit.MILLISECONDS);
        OkHttpUtils.initClient(okHttpClient.build());

    }
}
