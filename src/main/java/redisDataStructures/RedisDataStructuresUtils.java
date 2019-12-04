package redisDataStructures;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisDataStructuresUtils {

    public static void storeLists(Jedis jedis) {
        jedis.lpush("queue#tasks", "task1");
        jedis.lpush("queue#tasks", "task2");

        System.out.println("Getting task:" + jedis.rpop("queue#tasks"));
    }

    public static void storeSets(Jedis jedis) {
        jedis.sadd("nicknames", "name1");
        jedis.sadd("nicknames", "name2");
        jedis.sadd("nicknames", "name1");

        Set<String> names = jedis.smembers("nicknames");
        System.out.println("name1 exists? " + names.contains("name1"));
    }

    public static void storeHashMap(Jedis jedis) {
        jedis.hset("user#1", "name", "Aj");
        jedis.hset("user#1", "coder", "yes");

        System.out.println("User name:" + jedis.hget("user#1", "name"));

        Map<String, String> fields = jedis.hgetAll("user#1");
        String coder = fields.get("coder");
        System.out.println("Is coder: " + coder);
    }

    public static void storeSortedSets(Jedis jedis) {
        jedis.zadd("ranking", 100, "aj");
        jedis.zadd("ranking", 150, "ak");
        jedis.zadd("ranking", 200, "al");

        String student = jedis.zrevrange("ranking", 0, 1).iterator().next();
        long rank = jedis.zrevrank("ranking", "aj");

        System.out.println("Top student: " + student);
        System.out.println("Aj's rank: " + rank);
    }
}
