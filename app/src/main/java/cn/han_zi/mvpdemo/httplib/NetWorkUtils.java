package cn.han_zi.mvpdemo.httplib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:获取网络状态工具
 */
public class NetWorkUtils{

    /**
     * 网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetWorkConnect(Context context){
        if (context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * wifi是否可用
     * @param context
     * @return
     */
    public static boolean isWifiConnect(Context context){
        if (context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }


}
