package com.tusk.loadbalance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tusk
 * @desc
 * @date 2021/11/24 12:51
 */
public class Main {

    private static List<Server> serverList = new ArrayList<>();

    public static void main(String[] args) {
        initServerList();
        RoundRobin roundRobin = new RoundRobin();
        WeightRoundRobin weightRoundRobin = new WeightRoundRobin();


        for (int i=0;i<12;i++){
            System.out.println(weightRoundRobin.getServer(serverList));
        }
    }

    static void initServerList() {
        serverList.add(new Server("server1", "192,168.9.1",1));
        serverList.add(new Server("server2", "192,168.9.2",2));
        serverList.add(new Server("server3", "192,168.9.3",3));
    }
}
