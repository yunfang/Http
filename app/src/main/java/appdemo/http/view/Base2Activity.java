package appdemo.http.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

import appdemo.http.utils.ActivityManager;
import appdemo.http.utils.ViewUtils;
import appdemo.http.utils.notify.DataChangeNotification;
import appdemo.http.utils.notify.ObserverGroup;

/**
 * Created by zhouyunfang on 17/4/18.
 */
public abstract class Base2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.initContentView(this);
        initView();
    }

    protected abstract void initView();


}
