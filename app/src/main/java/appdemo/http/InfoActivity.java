package appdemo.http;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import appdemo.http.utils.ContentView;
import appdemo.http.utils.Id;
import appdemo.http.view.Base2Activity;

/**
 * Created by zhouyunfang on 17/5/4.
 */
@ContentView(R.layout.activity_main3)
public class InfoActivity extends Base2Activity implements View.OnClickListener {

    @Id(R.id.tv_id)
    TextView tv_id;

    @Id(R.id.id_bu)
    Button id_bu;

    @Override
    protected void initView() {
        id_bu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_bu:
                tv_id.setText("自定义注解id");
                break;
        }
    }
}
