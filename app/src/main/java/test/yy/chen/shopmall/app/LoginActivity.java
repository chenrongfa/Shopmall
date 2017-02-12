package test.yy.chen.shopmall.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.yy.chen.shopmall.R;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/12
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */
public class LoginActivity extends AppCompatActivity {
      @BindView(R.id.ib_backToIndex)
      ImageButton ibBackToIndex;
      @BindView(R.id.textView)
      TextView textView;
      @BindView(R.id.ib_message)
      ImageButton ibMessage;
      @BindView(R.id.et_account)
      EditText etAccount;
      @BindView(R.id.et_password)
      EditText etPassword;
      @BindView(R.id.ib_show)
      ImageButton ibShow;
      @BindView(R.id.btn_login)
      Button btnLogin;
      @BindView(R.id.cb_protocol)
      CheckBox cbProtocol;
      @BindView(R.id.tv_protocol)
      TextView tvProtocol;
      @BindView(R.id.tv_register)
      TextView tvRegister;
      @BindView(R.id.tv_password)
      TextView tvPassword;
      @BindView(R.id.tv_other_login)
      TextView tvOtherLogin;
      private boolean isShow=false;//默认不显示

      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            ButterKnife.bind(this);
      }

      private static final String TAG = "LoginActivity";

      @OnClick({R.id.ib_backToIndex, R.id.ib_message, R.id.et_account, R.id.et_password, R.id.ib_show, R.id.btn_login, R.id.tv_protocol,
              R.id.tv_register, R.id.tv_password, R.id.tv_other_login})
      public void onClick(View view) {
            switch (view.getId()) {
                  case R.id.ib_backToIndex:
                        finish();
                        Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                        for (int i=0;i<100;i++){
                              Log.e(TAG, "onClick: "+i );
                        }
                        break;
                  case R.id.ib_message:
                        break;
                  case R.id.et_account:
                        break;
                  case R.id.et_password:
                        break;
                  case R.id.ib_show:
                        if(!isShow){
                              isShow=true;
                              etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                              ibShow.setBackgroundResource(R.drawable.new_password_drawable_visible);
                        }else{
                              isShow=false;
                              etPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                              ibShow.setBackgroundResource(R.drawable.new_password_drawable_invisible);
                        }
                        int length = etPassword.getText().length();
                        etPassword.setSelection(length);
                        break;
                  case R.id.btn_login:
                        break;
                  case R.id.tv_protocol:
                        break;
                  case R.id.tv_register:
                        break;
                  case R.id.tv_password:
                        break;
                  case R.id.tv_other_login:
                        break;
            }
      }
}
