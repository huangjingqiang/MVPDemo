package cn.han_zi.mvpdemo.base;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.squareup.leakcanary.LeakCanary;

import cn.han_zi.mvpdemo.MyApp;

/**
 * Create by xjs
 * _______date : 17/7/24
 * _______description:
 */
public class InitializeService extends IntentService {
    private static final String ACTION_INIT = "initApplication";

    public InitializeService() {
        super(ACTION_INIT);
    }
    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT.equals(action)) {
                initApplication();
            }
        }
    }

    private void initApplication(){
        //初始化内存泄漏检测
        LeakCanary.install(MyApp.getInstance());
    }
}
