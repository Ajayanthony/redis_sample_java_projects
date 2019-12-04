import redis.clients.jedis.Jedis;

public class JedisExample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();

        jedis.set("key1", "ajay_anthony");

        System.out.println("Fetching:key1=" + jedis.get("key1"));
    }
}
