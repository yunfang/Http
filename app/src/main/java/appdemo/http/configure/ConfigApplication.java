package appdemo.http.configure;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zhouyunfang on 17/4/18.
 */
public class ConfigApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
