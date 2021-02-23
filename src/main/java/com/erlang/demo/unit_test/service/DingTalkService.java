package com.erlang.demo.unit_test.service;

import com.erlang.demo.unit_test.domain.DingTalkMessage;

/**
 * @author yj
 * @since 2021-02-20 8:29
 */
public interface DingTalkService {

    /**
     * 发送通知
     *
     * @param message 消息
     */
    void sendNotice(DingTalkMessage message);
}
