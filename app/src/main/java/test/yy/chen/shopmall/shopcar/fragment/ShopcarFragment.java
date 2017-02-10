package test.yy.chen.shopmall.shopcar.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alipay.sdk.app.PayTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.base.BaseFragment;
import test.yy.chen.shopmall.home.bean.GoodsBean;
import test.yy.chen.shopmall.shopcar.adapter.ShopAdapter;
import test.yy.chen.shopmall.utils.CacheUtil;
import test.yy.chen.shopmall.zhifubao.AuthResult;
import test.yy.chen.shopmall.zhifubao.Offerbean;
import test.yy.chen.shopmall.zhifubao.OrderInfoUtil2_0;
import test.yy.chen.shopmall.zhifubao.PayResult;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class ShopcarFragment extends BaseFragment {

    @BindView(R.id.iv_atguigu)
    ImageView ivAtguigu;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.btn_empty)
    Button btnEmpty;
    @BindView(R.id.tl_empty)
    RelativeLayout tlEmpty;
    @BindView(R.id.lv_shop)
    ListView lvShop;
    @BindView(R.id.cb_all)
    CheckBox cbAll;
    @BindView(R.id.tv_conut)
    TextView tvConut;
    @BindView(R.id.btn_accounts)
    Button btnAccounts;
    @BindView(R.id.rl_data)
    RelativeLayout rlData;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.ll_account)
    LinearLayout llAccount;
    @BindView(R.id.cb_editall)
    CheckBox cbEditall;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_complish)
    Button btnComplish;
    @BindView(R.id.ll_edit)
    LinearLayout llEdit;
    private ShopAdapter shopAdapter;
    private boolean isEditState=false;//是否是在编辑状态 默认 false
  private SparseArray<GoodsBean> cache;
      /** 支付宝支付业务：入参app_id */
      public static final String APPID = "2016032901249316";

      /** 支付宝账户登录授权业务：入参pid值 */
      public static final String PID = "2088911876712776";
      /** 支付宝账户登录授权业务：入参target_id值 */
      public static final String TARGET_ID = "chenlei@atguigu.com";

      /** 商户私钥，pkcs8格式 */
      /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
      /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
      /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
      /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
      /** 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1 */
      public static final String RSA2_PRIVATE ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCWbt7NQf3PvKcuO/8QcErmfCC4qYZ924qcSGt1tMP6v3xs8EiPThQhSkwTscdiQxdKEQuANvREhjSNdvyp4okTQNCaPvSlaNf1Ivyja8auJbnxHrYbMOEpUIZUKRYXfih6pWxc8lnymfDvrE6Cx/SolydnZZzIRzDWO5Misv8qKiwRnbuedgN3RYeyK6mf3K0kZhjzC8DgPTdGfh6ZS+c9etcwxCvdQjlR82KR8ujI6eQPlxKf/aHNw5kFealwtoaqPQDLppszDawWrjMDoxJUXf6lxFty7tBePujZ1zSlGzVaoffULdTCRDXszmOq3Q5jwxxiPwLk9lD24NSc1eftAgMBAAECggEAZDP5yPN6I1PgcFWactK5sYlhKmARq+f/DlbW7ZK5MF84fEAZtQsnMX2R61RyISvbaYStCnyQfMyAWPK3Hlo9QEveJ8BjqYKKx0jEy/5QW1PZ5Zi1aKtIcAKpV4n+oytvvzJNWiQ8cfLEoIE/0rFqcJourxrqMiXpi+om+egNO4HJLaBVx7kkpmXzFwZB0GY6hTWgacwrAVNbJuNJFpgv/IPYLhkVeN9RLbv2GxSvuOhzLbW4NgD9TxS11pgSktm6mscEBaGUOjR8qGugKT7xlSze40ywHOHP3lF2rdNwZfazsuN41Ziewx0E4nXgctZTQlES/TpXOXITDfNW1QQ8aQKBgQD/uqyrbLdlTDhRIivRvewaqDaWHdHfZNEM09IG3Qu8l1oAcMBQhh6Vk0GEooaa+Mt+vLpMuQPVyxxzubHuhGoRqNhfCgnudk3ZhbEDV2UfG2VIquBALf+9TvHTS9bn27/wNCbTbdUPjGBhHZmFnN5CejLU4ghyBNVxLtM3IVDyuwKBgQCWl6ayG3FxBwqTw4/mkxySjwtXoM6/QtR3I8h83yjAv1KBYMJ+8VqWeUQ9n2rtT/6cXXKzO2EhPdvWPNanYLcDt0tIHGHGS5BvF0GbgBnPNw6el5xpv3CBveKYLiGGlqu68Wb7e/Q7EpyUgSv1xwVjLxm4EfHhcMH/pdyty32JdwKBgAgIymH8YWqqUV6jLzNAv0k7HbPrretR1IuNoBydF0BOlQJMiI4/GHjkjntnS8lUpbgOn9/HNEqkPfmYzPFMcbSqVFnwC83VI68A10Xemgu3JaB51d/OUimVcF2OFWtlaQtX6BxeaAI8C88hSfB7tDPseOpdS5yhcD9FFFe4ET3/AoGAP1zJt9ESN0OGMMwtJRArCoODezhfJVyCNyroNZpT9F3L4kILNAxrWDrn+qG0BOwOrk4nb8CBStJTSF5K1xw7hSW/WDUQ8rVirUt0wG/y7Bw3W4VhO6FgPkbeK7flRVLqKPtfoFr0VVKsbVO4Ym5+FtB/mtJ6GqguCFoKc1nWlVsCgYBfWdcYHrZiLY+U6KctOJjxnEH8xcVmbhiWqFzcu1+1XEH+X9sfaux3cciXTJi/hg1TwxSe9dlsJ7jV3dwYTv9Zkh0dhb/nIqjckPGeYtdJSUTety/fZAFfnVXbkwi1ygJJczWyn+71jfMjU64myRgLVeucCltsqr1bzKCqlS3zLw==";


      public static final String RSA_PRIVATE = "";

      private static final int SDK_PAY_FLAG = 1;
      private static final int SDK_AUTH_FLAG = 2;
      @SuppressLint("HandlerLeak")
      private Handler mHandler = new Handler() {
            @SuppressWarnings("unused")
            public void handleMessage(Message msg) {
                  switch (msg.what) {
                        case SDK_PAY_FLAG: {
                              @SuppressWarnings("unchecked") PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                              /**
                               对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                               */
                              String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                              String resultStatus = payResult.getResultStatus();
                              // 判断resultStatus 为9000则代表支付成功
                              if (TextUtils.equals(resultStatus, "9000")) {
                                    // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                                    Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                              } else {
                                    // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                                    Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
                              }
                              break;
                        }
                        case SDK_AUTH_FLAG: {
                              @SuppressWarnings("unchecked") AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                              String resultStatus = authResult.getResultStatus();

                              // 判断resultStatus 为“9000”且result_code
                              // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                              if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                                    // 获取alipay_open_id，调支付时作为参数extern_token 的value
                                    // 传入，则支付账户为该授权账户
                                    Toast.makeText(context,
                                            "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                            .show();
                              } else {
                                    // 其他状态值则为授权失败
                                    Toast.makeText(context,
                                            "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                              }
                              break;
                        }
                        default:
                              break;
                  }
            };
      };
    @Override
    public View initView() {
        View view = inflater.inflate(R.layout.fragment_shopcar, null);
        ButterKnife.bind(this, view);
        CacheUtil.setSparseArray(context);
        cache=CacheUtil.cache;
        shopAdapter = new ShopAdapter(context, cache, btnDelete, cbAll,
                cbEditall, tvConut,tlEmpty,llEdit);
        EventBus.getDefault().register(this);
        initShop();
        return view;
    }

    private void initShop() {
        hideData();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
 public void onEventMainThread(Integer count){
        if(count==0){
            tlEmpty.setVisibility(View.VISIBLE);
            llEdit.setVisibility(View.GONE);
            llAccount.setVisibility(View.GONE);
            tvEdit.setText("編輯");
            shopAdapter.notifyDataSetChanged();
        }

 }
    @Override
    public void bindData() {
//        super.bindData();

       if(CacheUtil.cache.size()>0){
           Log.e(TAG, "bindData: "+cache.size() );
           lvShop.setAdapter(shopAdapter);
       }

    }

    @OnClick({R.id.iv_atguigu, R.id.btn_empty,R.id.tv_edit,R.id.btn_complish,R.id.btn_accounts})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_atguigu:
                break;
            case R.id.btn_empty:
                break;
            case R.id.tv_edit:
                if(!isEditState){
                    isEditState=true;
                    tvEdit.setText("编辑中");
                    llAccount.setVisibility(View.GONE);
                    llEdit.setVisibility(View.VISIBLE);
                }else{
                    isEditState=false;
                    tvEdit.setText("编辑完成");
                    llAccount.setVisibility(View.VISIBLE);
                    llEdit.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_complish:
                llAccount.setVisibility(View.VISIBLE);
                llEdit.setVisibility(View.GONE);
                tvEdit.setText("编辑");
                isEditState=false;
                break;
            case R.id.btn_accounts:
                Toast.makeText(context, "结算", Toast.LENGTH_SHORT).show();

                  payV2();
                break;
        }
    }
      public void payV2() {
            if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
                  new AlertDialog.Builder(context).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                          .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialoginterface, int i) {
                                      //
                                    getActivity(). finish();
                                }
                          }).show();
                  return;
            }

            /**
             * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
             * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
             * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
             *
             * orderInfo的获取必须来自服务端；
             */
            boolean rsa2 = (RSA2_PRIVATE.length() > 0);
            String s = tvConut.getText().toString().substring(3);
            Offerbean offerbean=new Offerbean();
            offerbean.setTotal_amount(s);
            String s1 = JSON.toJSONString(offerbean);
            Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2,s1);
            String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

            String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
            String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
            final String orderInfo = orderParam + "&" + sign;

            Runnable payRunnable = new Runnable() {

                  @Override
                  public void run() {
                        PayTask alipay = new PayTask((Activity) context);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        Log.i("msp", result.toString());

                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                  }
            };

            Thread payThread = new Thread(payRunnable);
            payThread.start();
      }
    private static final String TAG = "ShopcarFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            hideData();
        }


        Log.e(TAG, "onHiddenChanged: ");
    }

    private void hideData() {
        if (cache.size() <= 0) {
            tlEmpty.setVisibility(View.VISIBLE);
            rlData.setVisibility(View.GONE);
        } else {
            if (CacheUtil.dataChange){
           lvShop.setAdapter(shopAdapter);
                Log.e(TAG, "hideData: "+"jinlai" );
            }
            tlEmpty.setVisibility(View.GONE);
            rlData.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //保存数据
        CacheUtil.saveGoods(context);
        Log.e(TAG, "onDestroy: "+"fragment" );
    }
}
