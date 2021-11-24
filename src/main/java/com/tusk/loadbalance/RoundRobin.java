package com.tusk.loadbalance;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tusk
 * @desc 轮询算法
 * @date 2021/11/24 12:36
 */
public class RoundRobin extends AbstractLoadBalance{

    private AtomicInteger COUNTER = new AtomicInteger(0);
    @Override
    Server getServer(final List<Server> servers) {
        Server[] serverArr = servers.toArray(new Server[0]);

        if(COUNTER.get()>=serverArr.length){
            COUNTER.set(0);
        }

        return serverArr[COUNTER.getAndIncrement()];
    }
}
