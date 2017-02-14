package test.yy.chen.shopmall.app;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Map;
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
        UMShareAPI.get(this);
        Config.DEBUG=true;
        PlatformConfig.setAlipay("2016032901249316");

        OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
        okHttpClient.connectTimeout(5*1000, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(5*1000,TimeUnit.MILLISECONDS);
        OkHttpUtils.initClient(okHttpClient.build());

    }

}
