import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by tanjianhui on 2017/2/10.
 */
public class MyTest {
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    private Jedis jedis;

    @BeforeClass
    public void setup(){
        jedis = new Jedis("10.10.28.222",6379);
    }

    @Test
    public void test(){
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testRedisString(){
        jedis.set("test", "Hello, World!");
        logger.info("[key:test,value:{}]",jedis.get("test"));
        jedis.del("test");
        logger.info("[key:test,value:{}]",jedis.get("test"));
    }

    @Test
    public void testRedisList(){
        String listKey = "listKey";
        jedis.lpush(listKey, "myLeftPush");
        jedis.rpush(listKey, "myRightPush");
        jedis.lpush(listKey, "myLeftPush");
        logger.info("{}", jedis.lrange(listKey, 0, -1));
        logger.info(jedis.lpop(listKey));
        logger.info(jedis.lpop(listKey));
        logger.info(jedis.lpop(listKey));
    }

    @Test
    public void testRedisSet(){
        String setKey = "setKey";
        jedis.sadd(setKey, "sadd");
        jedis.sadd(setKey, "sadd2");
        jedis.sadd(setKey, "sadd3");
        jedis.sadd(setKey, "sadd");
        logger.info("{}", jedis.smembers(setKey));
        logger.info("{}", jedis.sismember(setKey, "sadd4"));
        logger.info("{}", jedis.sismember(setKey, "sadd"));
        logger.info("{}", jedis.srem(setKey, "sadd4"));
        logger.info("{}", jedis.srem(setKey, "sadd3"));
        logger.info("{}", jedis.smembers(setKey));

        // clean
        jedis.srem(setKey, "sadd2");
        jedis.srem(setKey, "sadd1");
    }

    @Test
    public void testRedisHash() {
        String hashKey = "hashKey";

        jedis.hset(hashKey, "subKey1", "value1");
        jedis.hset(hashKey, "subKey2", "value2");
        jedis.hset(hashKey, "subKey1", "value1");
        logger.info("{}", jedis.hgetAll(hashKey));
        jedis.hdel(hashKey, "subKey2");
        jedis.hdel(hashKey, "subKey2");
        logger.info("{}", jedis.hget(hashKey,"subKey1"));
        logger.info("{}", jedis.hgetAll(hashKey));

        // clean
        jedis.hdel(hashKey, "subKey1");
    }

    @Test
    public void testRedisZset(){
        String zsetKey = "zsetKey";

        jedis.zadd(zsetKey, 5, "zsetKey1");
        jedis.zadd(zsetKey, 3, "zsetkey2");
        jedis.zadd(zsetKey, 3, "zsetkey2");
        logger.info("{}", jedis.zrangeWithScores(zsetKey, 0, -1));
        logger.info("{}", jedis.zrange(zsetKey, 0, -1));
        logger.info("{}", jedis.zrangeByScoreWithScores(zsetKey, 0, 4));
        jedis.zrem(zsetKey, "zsetKey1");
        logger.info("{}", jedis.zrangeWithScores(zsetKey, 0, -1));
        logger.info("{}", jedis.zrange(zsetKey, 0, -1));

        // clean
        jedis.zrem(zsetKey, "zsetKey2");
    }
}
