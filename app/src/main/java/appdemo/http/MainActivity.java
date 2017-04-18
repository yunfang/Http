package appdemo.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

import appdemo.http.bean.PatentBean;
import appdemo.http.bean.PatentBean2;
import appdemo.http.net.ParamsApi;
import appdemo.http.net.biz.RequestCallback;
import appdemo.http.utils.JSONUtils;
import appdemo.http.view.BaseActivity;

public class MainActivity extends BaseActivity {


    @ViewInject(R.id.tv_id)
    TextView tv_id;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setInterfaceView() {

        HashMap<String,Object> map = new HashMap<>();

        //get 方法
        ParamsApi.getPatientCode(map).execute(new RequestCallback<PatentBean>() {
            @Override
            public void onRequestSuccess(PatentBean dataResult) {

                System.out.println("----------"+JSONUtils.gsonInstance().toJson(dataResult));

                tv_id.setText(JSONUtils.gsonInstance().toJson(dataResult));


            }

            @Override
            public void onRequestFailure(PatentBean dataResult) {

            }
        });

//        //post 方法
//        ParamsApi.getPatient2(map).execute(new RequestCallback<PatentBean2>() {
//            @Override
//            public void onRequestSuccess(PatentBean2 dataResult) {
//                System.out.println("----------"+JSONUtils.gsonInstance().toJson(dataResult));
//            }
//
//            @Override
//            public void onRequestFailure(PatentBean2 dataResult) {
//
//            }
//        });


    }
}
