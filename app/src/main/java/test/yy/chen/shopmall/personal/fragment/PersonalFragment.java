package test.yy.chen.shopmall.personal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.yy.chen.shopmall.R;
import test.yy.chen.shopmall.app.LoginActivity;
import test.yy.chen.shopmall.base.BaseFragment;

/**
 * shopmall2
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class PersonalFragment extends BaseFragment implements View.OnTouchListener {
      TextView textView;
      private static final String TAG = "HomeFragment";
      @BindView(R.id.iv_navigate)
      ImageView ivNavigate;
      @BindView(R.id.iv_set)
      ImageView ivSet;
      @BindView(R.id.iv_message)
      ImageView ivMessage;
      @BindView(R.id.iv_logo)
      ImageView ivLogo;
      @BindView(R.id.btn_login)
      Button btnLogin;
      @BindView(R.id.btn_register)
      Button btnRegister;
      @BindView(R.id.ll_login)
      LinearLayout llLogin;
      @BindView(R.id.tv_allorder)
      TextView tvAllorder;
      @BindView(R.id.tv_wait_offer)
      TextView tvWaitOffer;
      @BindView(R.id.tv_wait_send)
      TextView tvWaitSend;
      @BindView(R.id.tv_tranform)
      TextView tvTranform;
      @BindView(R.id.tv_complish)
      TextView tvComplish;
      @BindView(R.id.tv_help)
      TextView tvHelp;
      @BindView(R.id.tv_address)
      TextView tvAddress;
      @BindView(R.id.tv_collection)
      TextView tvCollection;
      @BindView(R.id.view)
      View view;
      @BindView(R.id.tv_balence)
      TextView tvBalence;
      @BindView(R.id.tv_ticket)
      TextView tvTicket;
      @BindView(R.id.tv_score)
      TextView tvScore;
      @BindView(R.id.tv_prize)
      TextView tvPrize;
      @BindView(R.id.tv_invitation)
      TextView tvInvitation;
      @BindView(R.id.tv_feedback)
      TextView tvFeedback;
      @BindView(R.id.tv_service)
      TextView tvService;
      @BindView(R.id.ll_user)
      LinearLayout llUser;

      @Override
      public View initView() {
//        textView=new TextView(context);
//        textView.setGravity(Gravity.CENTER);
//        textView.setClickable(true);
            View inflate = inflater.inflate(R.layout.personal, null);


            return inflate;
      }

      @Override
      public void bindData() {
//        super.bindData();
            Log.e(TAG, "bindData: 2");
//        textView.setText(R.string.personal);
      }


      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
            if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                  Toast.makeText(context, "nihao", Toast.LENGTH_SHORT).show();
                  return true;
            }
            return false;
      }


      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // TODO: inflate a fragment view
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            ButterKnife.bind(this, rootView);
            return rootView;
      }

      @OnClick({R.id.iv_navigate, R.id.iv_set, R.id.iv_message, R.id.iv_logo, R.id.btn_login, R.id.btn_register, R.id.tv_allorder, R.id
              .tv_wait_offer, R.id.tv_wait_send, R.id.tv_tranform, R.id.tv_complish, R.id.tv_help, R.id.tv_address, R.id.tv_collection, R
              .id.tv_balence, R.id.tv_ticket, R.id.tv_score, R.id.tv_prize, R.id.tv_invitation, R.id.tv_feedback, R.id.tv_service})
      public void onClick(View view) {
            switch (view.getId()) {
                  case R.id.iv_navigate:
                        break;
                  case R.id.iv_set:
                        break;
                  case R.id.iv_message:
                        break;
                  case R.id.iv_logo:
                        break;
                  case R.id.btn_login:
                        Toast.makeText(context , "denglu", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context ,LoginActivity.class);
                        getActivity().startActivity(intent);
                        for (int i=0;i<100;i++){
                              Log.e(TAG, "onClickstart: "+i );
                        }
                        break;
                  case R.id.btn_register:
                        break;
                  case R.id.tv_allorder:
                        break;
                  case R.id.tv_wait_offer:
                        break;
                  case R.id.tv_wait_send:
                        break;
                  case R.id.tv_tranform:
                        break;
                  case R.id.tv_complish:
                        break;
                  case R.id.tv_help:
                        break;
                  case R.id.tv_address:
                        break;
                  case R.id.tv_collection:
                        break;
                  case R.id.tv_balence:
                        break;
                  case R.id.tv_ticket:
                        break;
                  case R.id.tv_score:
                        break;
                  case R.id.tv_prize:
                        break;
                  case R.id.tv_invitation:
                        break;
                  case R.id.tv_feedback:
                        break;
                  case R.id.tv_service:
                        break;
            }
      }
}
