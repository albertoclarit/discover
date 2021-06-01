package com.example.discover;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class RedisBean
{
   // private JedisCluster jc = null;
   Jedis jedis = new Jedis(new HostAndPort("redis", 6379));

    /*

    jedis.set("foo", "bar");
    String value = jedis.get("foo");
     */
    public RedisBean() {
        /*Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
         jc = new JedisCluster(jedisClusterNodes);*/
    }

    public  void putValue(String key, String value){

        jedis.set(key, value);

    }

    public String getValue(String key){
        return jedis.get(key);
    }
}
