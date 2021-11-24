package com.tusk.loadbalance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author tusk
 * @desc 权重轮询
 * weight:每个服务器的权重
 * curWeight:每个服务器当前的权重，默认值为0
 * totalWeight:所有的服务器的weight之和
 *
 * 1.循环所有的Server
 * 2.将curWeight = curWeight + weights
 *
 * 找到当前curWeight最大的项，该项便是此次负载均衡的目的服务器，
 * 将目的服务器的curWeight = curWeight - totalWeight
 * @date 2021/11/24 12:37
 */
public class WeightRoundRobin extends AbstractLoadBalance {

    @Override
    Server getServer(List<Server> servers) {
        int totalWeight = servers.stream().mapToInt(c -> c.getWeight()).sum();

        AtomicReference<Server> maxCurWeightServer = new AtomicReference<>();
        AtomicInteger maxCurWeight = new AtomicInteger();

        servers.forEach(c->{
            int curWeight = c.getCurrentWeight() + c.getWeight();
            c.setCurrentWeight(curWeight);

            if(c.getCurrentWeight()> maxCurWeight.get()){
                maxCurWeight.set(c.getCurrentWeight());
                maxCurWeightServer.set(c);
            }
        });

        Server server = maxCurWeightServer.get();
        int newCurWeight = server.getCurrentWeight() - totalWeight;
        server.setCurrentWeight(newCurWeight);
        return server;

    }


}
