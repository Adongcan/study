package com.ztkj.victe.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class AlarmUtils {
    private AlarmUtils() {
    }

    // 日志 TAG
    private static final String TAG = AlarmUtils.class.getSimpleName();

    /**
     * 开启定时器
     * @param context
     * @param triggerAtMillis 执行时间
     * @param pendingIntent 响应动作
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startAlarmIntent(Context context, long triggerAtMillis, PendingIntent pendingIntent) {
        try {
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                manager.setExact(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
            } else {
                manager.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    /**
     * 关闭定时器
     * @param context
     * @param pendingIntent
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopAlarmIntent(Context context, PendingIntent pendingIntent) {
        try {
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            manager.cancel(pendingIntent);
        } catch (Exception e) {
//            LogPrintUtils.eTag(TAG, e, "stopAlarmIntent");
            e.printStackTrace();
        }
    }

    /**
     * 开启轮询服务
     * @param context
     * @param triggerAtMillis
     * @param cls
     * @param action
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startAlarmService(Context context, long triggerAtMillis, Class<?> cls, String action) {
        try {
            Intent intent = new Intent(context, cls);
            intent.setAction(action);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            startAlarmIntent(context, triggerAtMillis, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止轮询服务
     * @param context
     * @param cls
     * @param action
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopAlarmService(Context context, Class<?> cls, String action) {
        try {
            Intent intent = new Intent(context, cls);
            intent.setAction(action);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            stopAlarmIntent(context, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启轮询广播
     * @param context
     * @param triggerAtMillis
     * @param intent
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startAlarmBroadcast(Context context, long triggerAtMillis, Intent intent) {
        try {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            startAlarmIntent(context, triggerAtMillis, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止轮询广播
     * @param context
     * @param intent
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopAlarmBroadcast(Context context, Intent intent) {
        try {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            stopAlarmIntent(context, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启轮询 Activity
     * @param context
     * @param triggerAtMillis
     * @param intent
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startAlarmActivity(Context context, long triggerAtMillis, Intent intent) {
        try {
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            startAlarmIntent(context, triggerAtMillis, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止轮询 Activity
     * @param context
     * @param intent
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopAlarmActivity(Context context, Intent intent) {
        try {
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            stopAlarmIntent(context, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
