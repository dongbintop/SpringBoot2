package com.dongbin.springboot2.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestMaven {

    private static final String CHANNEL = "mychannel";

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 56379;

    private final static JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();
    private final static JedisPool JEDIS_POOL = new JedisPool(POOL_CONFIG, HOST, PORT, 0);

    public static void main(String[] args) {
        final Jedis subscriberJedis = JEDIS_POOL.getResource();
        final Jedis publisherJedis = JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    subscriberJedis.subscribe(subscriber, CHANNEL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Publisher(publisherJedis, CHANNEL).startPublish();

//        publisherJedis.close();
//        subscriber.unsubscribe();
//        subscriberJedis.close();
    }
}
