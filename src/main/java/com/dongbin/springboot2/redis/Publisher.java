package com.dongbin.springboot2.redis;

import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Publisher {

    private Jedis publisherJedis;

    private String channel;

    public Publisher(Jedis publisherJedis, String channel) {
        this.publisherJedis = publisherJedis;
        this.channel = channel;
    }

    public void startPublish() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("message:");
                String line = reader.readLine();
                if (!"exit".equals(line)) {
                    publisherJedis.publish(channel, line);
                } else {
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
