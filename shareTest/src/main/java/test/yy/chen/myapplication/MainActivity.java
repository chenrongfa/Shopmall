package test.yy.chen.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MainActivity extends Activity{
      UMShareListener umShareListener = new UMShareListener() {
            @Override
            public void onResult(SHARE_MEDIA share_media) {
                  Toast.makeText(MainActivity.this, "onResult", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                  Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {

            }
      };
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            new ShareAction(this).withText("hello").setDisplayList(SHARE_MEDIA.ALIPAY).setCallback(umShareListener).open();
      }
      public void click(View view){
            new ShareAction(this).withText("hello").setDisplayList(SHARE_MEDIA.ALIPAY).setCallback(umShareListener).open();


      }

      private static final String TAG = "MainActivity";
      @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
            Log.e(TAG, "onActivityResult:num ");
      }
}
