package test.yy.chen.shopmall.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import test.yy.chen.shopmall.app.GoodsActivity;
import test.yy.chen.shopmall.home.bean.GoodsBean;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class Constants {
    public static final String BASE_URL="http://192.168.2.101:8080/atguigu";
    public static final String HOME_URL=BASE_URL +
            "/json/HOME_URL.json";
    public static final  String IMG_URL=BASE_URL+"/img";

  public static void  startAvtivity(Context context, GoodsBean goodsBean){
      Intent intent=new Intent(context , GoodsActivity.class);
      intent.putExtra("goods",goodsBean);
      context.startActivity(intent);

    }
    public static void showTip(Context context,String message){
        if (message!=null)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

}
