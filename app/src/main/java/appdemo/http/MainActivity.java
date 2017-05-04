package appdemo.http;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;

import appdemo.http.bean.PatentBean;
import appdemo.http.net.ParamsApi;
import appdemo.http.net.biz.RequestCallback;
import appdemo.http.utils.JSONUtils;
import appdemo.http.utils.notify.DetailDialog;
import appdemo.http.view.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @ViewInject(R.id.tv_id)
    TextView tv_id;

    @ViewInject(R.id.id_dialog)
    Button id_dialog;

    @ViewInject(R.id.id_bu_three)
    Button id_bu_three;

    private int MSG_WHAT = 12;
    private HandlerThread mHandlerThread;

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

        id_dialog.setOnClickListener(this);
        id_bu_three.setOnClickListener(this);

        // 创建对象，并启动该线程
        mHandlerThread = new HandlerThread("sub_thread");
        mHandlerThread.start();


        // 获取 Looper 对象
        MyHandler mHandler = new MyHandler(mHandlerThread.getLooper());
        // 创建 Bundle 对象，传递数据
        Bundle bundle = new Bundle();
        bundle.putString("main", "我这边事情太多，麻烦你帮忙处理一下！");
        // 发送消息
        Message msg = new Message();
        msg.what = MSG_WHAT;
        msg.setData(bundle);
        msg.setTarget(mHandler);
        msg.sendToTarget();

        Log.d("mark", "UI----" + "threadName: " + Thread.currentThread().getName() + "，threadId: " + Thread.currentThread().getId());


    }
    DetailDialog detailDialog;
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.id_dialog:
                detailDialog = new DetailDialog(this);
                detailDialog.setDetailMessage("", null, null, null);
                detailDialog.show();
                detailDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            if (detailDialog != null && detailDialog.isShowing()) {
                                detailDialog.dismiss();
                            }
                        }
                        return false;
                    }
                });
                Window win = detailDialog.getWindow();
                win.getDecorView().setPadding(0, 0, 0, 0);
                win.getDecorView().setBackgroundColor(Color.parseColor("#f2f2f2"));
                win.setGravity(Gravity.BOTTOM);  //此处可以设置dia
                WindowManager.LayoutParams lp = win.getAttributes();
                lp.width = WindowManager.LayoutParams.FILL_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                win.setAttributes(lp);

                //显示键盘
                detailDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                break;
            case R.id.id_bu_three:
                Intent intent3 = new Intent(this,InfoActivity.class);
                startActivity(intent3);
                break;
        }
    }


    class MyHandler extends Handler {

        public MyHandler() {
            super();
        }

        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // super.handleMessage(msg);
            if(msg.what == MSG_WHAT) {
                Bundle bundle = msg.getData();
                String info = bundle.getString("main");
                Log.d("mark", "我接受任务：" + info);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandlerThread != null){
            mHandlerThread.quit();
        }
    }
}
