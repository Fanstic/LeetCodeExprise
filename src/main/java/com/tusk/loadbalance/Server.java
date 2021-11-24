package com.tusk.loadbalance;

/**
 * @author tusk
 * @desc
 * @date 2021/11/24 12:39
 */
public class Server {
    private String name;
    private String ip;
    private int weight;
    private int currentWeight;

    public Server(String name, String ip) {
        this(name,ip,0);
    }

    public Server(String name, String ip, int weight) {
        this.name = name;
        this.ip = ip;
        this.weight = weight;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "Server{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", weight=" + weight +
                ",currentWeight=" + currentWeight +
                '}';
    }
}
