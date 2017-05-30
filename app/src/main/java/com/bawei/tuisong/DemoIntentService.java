package com.bawei.tuisong;

import android.content.Context;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * Created by yufuhao on 2017/5/11.
 */

/**
 * 继承 GTIntentService 接收来⾃自个推的消息,
 * 所有消息在线程中回调, 如果注册了了该服务,
 * 则务必要在 AndroidManifest中声明,
 * 否则⽆无法接受消息<br> *
 * onReceiveMessageData 处理理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理理回执 <br>
 */
public class DemoIntentService extends GTIntentService {
    public DemoIntentService() {
    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskId = msg.getTaskId();
        String messageId = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String clientId = msg.getClientId();
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskId, messageId, 90002);



        Log.d(TAG, "onReceiveMessageData: " + clientId);
        if (payload == null) {
            Log.d(TAG, "payload=null");
        } else {
            String data = new String(payload);
            Log.d(TAG, "payload: " + data);
        }
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }
}
