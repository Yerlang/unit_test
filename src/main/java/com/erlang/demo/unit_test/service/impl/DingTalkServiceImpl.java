package com.erlang.demo.unit_test.service.impl;

import com.erlang.demo.unit_test.domain.DingTalkMessage;
import com.erlang.demo.unit_test.service.DingTalkService;
import org.springframework.stereotype.Service;

/**
 * @author yj
 * @since 2021-02-20 8:32
 */
@Service
public class DingTalkServiceImpl implements DingTalkService {

    @Override
    public void sendNotice(DingTalkMessage message) {
        System.out.println(12);
    }
}
