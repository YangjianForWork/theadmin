package com.yang.thelab.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class PushUtil {
    /**jpush appkey*/
    private final static String APPKEY        = "0dcb3d21bcdff11331c3e595";
    /**jpush masterSecret*/
    private final static String MASTER_SECRET = "ab820340fda73412e3a0815b";
    /**日志*/
    private final static Logger LOG           = LoggerFactory.getLogger(PushUtil.class);

    @SuppressWarnings("deprecation")
    public void push(String message) {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APPKEY, 3);
        PushPayload payload = buildPushObject_all_all_alert();
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    private PushPayload buildPushObject_all_all_alert() {
        /*return PushPayload.newBuilder().setPlatform(Platform.android())
            .setAudience(Audience.tag("tag1"))
            .setNotification(Notification.android("content", "title", null)).build();*/
        return PushPayload.alertAll("alert");
    }

}
