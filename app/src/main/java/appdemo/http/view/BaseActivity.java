package appdemo.http.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

import appdemo.http.utils.ActivityManager;
import appdemo.http.utils.notify.DataChangeNotification;
import appdemo.http.utils.notify.ObserverGroup;

/**
 * Created by zhouyunfang on 17/4/18.
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected ObserverGroup mObserverGroup;  //通知的消息队列
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayout());
        x.view().inject(this);

        setInterfaceView();
        ActivityManager.instance().onCreate(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityManager.instance().onDestroy(this);
        removeObserverGroup();
    }

    /**
     * 设置界面XML 也就是Layout
     * @return
     */
    public abstract int setLayout();

    /**
     *  初始化view布局
     */
    protected abstract void setInterfaceView();

    protected void removeObserverGroup() {
        if (mObserverGroup != null) {
            DataChangeNotification.getInstance().removeObserver(mObserverGroup);
            mObserverGroup = null;
        }
    }
}
