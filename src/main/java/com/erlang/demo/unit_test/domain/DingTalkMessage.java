package com.erlang.demo.unit_test.domain;

/**
 * 钉钉信息
 *
 * @author yj
 * @since 2021-02-20 8:50
 */
public class DingTalkMessage {

    /**
     * 消息类型
     */
    private String msgtype = "text";

    /**
     * 消息内容
     */
    private String text;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
