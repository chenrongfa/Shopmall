package test.yy.chen.shopmall.type.bean;

import java.util.List;

/**
 * shopmall2
 * Created by chenrongfa on 2017/2/9
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class TagBean {


      private int code;
      private String msg;
      private List<ResultBean> result;

      public int getCode() {
            return code;
      }

      public void setCode(int code) {
            this.code = code;
      }

      public String getMsg() {
            return msg;
      }

      public void setMsg(String msg) {
            this.msg = msg;
      }

      public List<ResultBean> getResult() {
            return result;
      }

      public void setResult(List<ResultBean> result) {
            this.result = result;
      }

      public static class ResultBean {
            /**
             * name : 尚硅谷
             * tag_id : 1
             */

            private String name;
            private String tag_id;

            public String getName() {
                  return name;
            }

            public void setName(String name) {
                  this.name = name;
            }

            public String getTag_id() {
                  return tag_id;
            }

            public void setTag_id(String tag_id) {
                  this.tag_id = tag_id;
            }
      }
}
