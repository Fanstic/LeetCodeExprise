package com.tusk.loadbalance;

import java.util.List;

/**
 * @author tusk
 * @desc
 * @date 2021/11/24 12:41
 */
public abstract class AbstractLoadBalance {
    abstract Server getServer(List<Server> servers);
}
