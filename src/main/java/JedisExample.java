import redis.clients.jedis.Jedis;
import redisDataStructures.RedisDataStructuresUtils;

/**
 * Jedis Hello World.
 */
public class JedisExample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();

        jedis.set("key1", "ajay_anthony");

        System.out.println("Fetching:key1=" + jedis.get("key1"));

        testDatastructures(jedis);
    }

    public static void testDatastructures(Jedis jedis) {
        RedisDataStructuresUtils.storeLists(jedis);

        RedisDataStructuresUtils.storeSets(jedis);

        RedisDataStructuresUtils.storeHashMap(jedis);

        RedisDataStructuresUtils.storeSortedSets(jedis);
    }
}
