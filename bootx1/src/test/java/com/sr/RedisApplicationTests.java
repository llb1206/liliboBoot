package com.sr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * redis  集合类型，皆是对应Java的类型 String  List  Set  Map
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    private final static String USERKEY = "username";
    private final static String LISTKEY = "studentList";
    private final static String SETKEY = "usernameSet";
    private final static String HASHKEY = "studentHash";

    /**
     * String
     */
    @Test
    public void String() {
        redisTemplate.delete(USERKEY);
        redisTemplate.hasKey(USERKEY);
        redisTemplate.opsForValue().set(USERKEY, "nasus");
        redisTemplate.opsForValue().get(USERKEY);
        //在原有的值基础上新增字符串到末尾。
        redisTemplate.opsForValue().append(USERKEY, "ssss");
        redisTemplate.opsForValue().getAndSet(USERKEY, "ssss");
        //以"增量"的方式将long/double值存储在变量中。初始值为0 ，，可以先设置一个初始值
        redisTemplate.opsForValue().increment(USERKEY, 1);
        //默认增量-1
        redisTemplate.opsForValue().decrement(USERKEY);
        //如果不存在则赋值，存在不动
        redisTemplate.opsForValue().setIfAbsent(USERKEY, 222);
        //批量加入，设置了一个map
        redisTemplate.opsForValue().multiSet(new HashMap());
        //List<String> valueList = redisTemplate.opsForValue().multiGet(paraList);pi量取值
        redisTemplate.opsForValue().multiGet(new ArrayList());
    }

    /**
     * LIST
     * https://www.cnblogs.com/zhuyeshen/p/11430961.html
     */
    @Test
    public void List() {
        List<Student> students = new ArrayList<>();
        Student s = new Student(1, "AA", 1);
        Student s2 = new Student(2, "AA22", 2);
        students.add(s);
        students.add(s2);
        //在变量左边添加元素值。
        students.forEach(value -> redisTemplate.opsForList().leftPush(LISTKEY, value));
        //获取指定区间的值。
        log.info("studentList->{}", redisTemplate.opsForList().range(LISTKEY, 0, 1));
        //获取集合指定位置的值。
        log.info("studentList->{}", redisTemplate.opsForList().index(LISTKEY, 1));
        //把最后一个参数值放到指定集合的第一个出现中间参数的前面，如果中间参数值存在的话。
        log.info("studentList->{}", redisTemplate.opsForList().leftPush(LISTKEY, 0, 1));
        //向左边批量添加参数元素。
        log.info("studentList->{}", redisTemplate.opsForList().leftPushAll(LISTKEY, 0, 1, 1, 1));
        //以集合的方式向左边批量添加元素。
        log.info("studentList->{}", redisTemplate.opsForList().leftPushAll(LISTKEY, students));
        //向集合最右边添加元素。
        log.info("studentList->{}", redisTemplate.opsForList().rightPush(LISTKEY, students));
        //获取集合长度。
        log.info("studentList->{}", redisTemplate.opsForList().size(LISTKEY));
        log.info("studentList->{}", redisTemplate.opsForList().leftPop(LISTKEY));
        //截取集合元素长度，保留长度内的数据
        redisTemplate.opsForList().trim(LISTKEY, 2L, 5L);
    }

    /**
     * Set  跟Java Set一样
     * <p>
     * https://blog.csdn.net/XinhuaShuDiao/article/details/84906490?
     * utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2
     * .control&dist_request_id=&depth_1-utm_source=distribute
     * .pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
     */
    @Test
    public void Set() {
        List<String> usernameList = new ArrayList<>();
        usernameList.add("nasus");
        usernameList.add("nasus");
        usernameList.add("一个优秀的废人");
        //循环向添加值
        usernameList.forEach(value -> redisTemplate.opsForSet().add(SETKEY, value));
        //没有get  用这个members取值
        log.info("取出usernameSet->{}", redisTemplate.opsForSet().members(SETKEY));
        //随机获取变量中的元素。
        redisTemplate.opsForSet().randomMember(usernameList);
        //检查给定的元素是否在变量中。
        redisTemplate.opsForSet().isMember(usernameList, "nasus");
        //转移变量的元素值到目的变量。
        redisTemplate.opsForSet().move(usernameList, "nasus", usernameList);
        //弹出变量中的元素
        redisTemplate.opsForSet().pop(usernameList);
        //检查给定的元素是否在变量中。
        redisTemplate.opsForSet().isMember(usernameList, "nasus");
        //  批量   移除变量中的元素。
        redisTemplate.opsForSet().remove(usernameList, "nasus");
        redisTemplate.opsForSet().isMember(usernameList, "nasus");
        //弹出变量中的元素。
        redisTemplate.opsForSet().pop(usernameList);
        //通过给定的key求2个set变量的差值。
        redisTemplate.opsForSet().difference(usernameList, usernameList);
        //将求出来的差值元素保存。
        redisTemplate.opsForSet().differenceAndStore(usernameList, usernameList, usernameList);
        //求交集
        redisTemplate.opsForSet().intersect(usernameList, usernameList);
        redisTemplate.opsForSet().intersectAndStore(usernameList, usernameList, usernameList);
        //合集
        redisTemplate.opsForSet().union(usernameList, usernameList);
        //重载方法，可以是集合
        redisTemplate.opsForSet().unionAndStore(usernameList, usernameList, usernameList);
        //获取2个变量合集后保存到最后一个参数上。
        redisTemplate.opsForSet().intersectAndStore(usernameList, usernameList, usernameList);
    }

    /**
     * Hash  是一个Java对象/HashMap   对象name - 属性 - 参数值
     * https://blog.csdn.net/zf18234031156/article/details/100122172
     * ?utm_medium=distribute.pc_relevant.none-task-blog-baidujs
     * _baidulandingword-3&spm=1001.2101.3001.4242
     */
    @Test
    public void Hash() {
        redisTemplate.opsForHash().put(HASHKEY, "age", 11);
        redisTemplate.opsForHash().put(HASHKEY, "name", "sss");
        redisTemplate.opsForHash().put(HASHKEY, "class", "no3");

        List<Object> hashList = redisTemplate.opsForHash().values(HASHKEY);
        System.out.println("通过values(H key)方法获取变量中的hashMap值:" + hashList);

        Map<Object, Object> map = redisTemplate.opsForHash().entries(HASHKEY);
        System.out.println("通过values(H key)方法获取变量中的hashMap值:" + map);
        //        Object mapValue = redisTemplate.opsForHash().get(HASHKEY,"age");
        Object mapValue = redisTemplate.opsForHash().get(HASHKEY, "age");
        System.out.println("通过get(H key, Object hashKey)方法获取map键的值:" + mapValue);

        boolean hashKeyBoolean = redisTemplate.opsForHash().hasKey(HASHKEY, "age");
        System.out.println("通过hasKey(H key, Object hashKey)方法判断变量中是否存在map键:" + hashKeyBoolean);

        //获取变量中的键。
        Set<Object> keySet = redisTemplate.opsForHash().keys("hashValue");
        System.out.println("通过keys(H key)方法获取变量中的键:" + keySet);


        Map newMap = new HashMap();
        newMap.put("map3", "map3-3");
        newMap.put("map5", "map5-5");
        redisTemplate.opsForHash().putAll("hashValue", newMap);
        map = redisTemplate.opsForHash().entries("hashValue");
        System.out.println("通过putAll(H key, Map<? extends HK,? extends HV> m)方法以map集合的形式添加键值对:" + map);

        redisTemplate.opsForHash().putIfAbsent("hashValue", "map6", "map6-6");
        map = redisTemplate.opsForHash().entries("hashValue");
        System.out.println("通过putIfAbsent(H key, HK hashKey, HV value)方法添加不存在于变量中的键值对:" + map);

        //scan  搜索
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("hashValue", ScanOptions.scanOptions().match("map1").build());
        while (cursor.hasNext()) {
            Map.Entry<Object, Object> entry = cursor.next();
            System.out.println("通过scan(H key, ScanOptions options)方法获取匹配键值对:" + entry.getKey() + "---->" + entry.getValue());
        }
    }

    /**
     * Z-SET
     * https://blog.csdn.net/qq_39071667/article/details/88867677
     */
    @Test
    public void Z_SET() {
        //添加元素到变量中同时指定元素的分值。
        redisTemplate.opsForZSet().add("zSetValue", "A", 1);
        redisTemplate.opsForZSet().add("zSetValue", "B", 3);
        redisTemplate.opsForZSet().add("zSetValue", "C", 5);
        redisTemplate.opsForZSet().add("zSetValue", "D", 4);

        //获取变量指定区间的元素-取得是索引。   全部是0 ，-1
        Set zSetValue = redisTemplate.opsForZSet().range("zSetValue", 0, 2);
        System.out.println("索引" + zSetValue);

        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        //range.gt("B");
        //range.lt("C");
        //排名
        zSetValue = redisTemplate.opsForZSet().rangeByLex("zSetValue", range);
        System.out.println("排名:" + zSetValue);
//-----------------------------
        RedisZSetCommands.Limit limit = new RedisZSetCommands.Limit();
        limit.count(2);
        //起始下标为0
        limit.offset(1);
        zSetValue = redisTemplate.opsForZSet().rangeByLex("zSetValue", range, limit);
        System.out.println(zSetValue);

//--------------------------
        //根据设置的score获取区间值。
        zSetValue = redisTemplate.opsForZSet().rangeByScore("zSetValue", 1, 2);
        System.out.println("取的区间值" + zSetValue);

        //根据设置的score获取区间值从给定下标和给定长度获取最终值。
//--------------------------
        zSetValue = redisTemplate.opsForZSet().rangeByScore("zSetValue", 1, 3, 0, 3);
        System.out.println("前两个参数是值范围,后两个是索引范围" + zSetValue);
//------------------***************************
        //通过TypedTuple方式新增数据。
        ZSetOperations.TypedTuple<Object> typedTuple1 = new DefaultTypedTuple<>("E", 6.0);
        ZSetOperations.TypedTuple<Object> typedTuple2 = new DefaultTypedTuple<>("F", 7.0);
        ZSetOperations.TypedTuple<Object> typedTuple3 = new DefaultTypedTuple<>("G", 5.0);
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet = new HashSet<>();
        typedTupleSet.add(typedTuple1);
        typedTupleSet.add(typedTuple2);
        typedTupleSet.add(typedTuple3);
        redisTemplate.opsForZSet().add("typedTupleSet", typedTupleSet);
        zSetValue = redisTemplate.opsForZSet().range("typedTupleSet", 0, -1);
        System.out.println(zSetValue);
//--------------------  l参数的都是索引位置
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet222 = redisTemplate.opsForZSet().rangeWithScores("typedTupleSet", 1, 3);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = typedTupleSet222.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score = typedTuple.getScore();
            System.out.println(value + "**********" + score);
        }
//--------------------
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet33 = redisTemplate.opsForZSet().rangeByScoreWithScores("typedTupleSet", 6, 8);
        iterator = typedTupleSet33.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score = typedTuple.getScore();
            System.out.println(value + "---253---->" + score);
        }
//---------------------
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet444 = redisTemplate.opsForZSet().rangeByScoreWithScores("typedTupleSet", 5, 8, 1, 2);
        iterator = typedTupleSet444.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score = typedTuple.getScore();
            System.out.println(value + "》》》》 " + score);
        }
//-----------------------------
        long count = redisTemplate.opsForZSet().count("zSetValue", 1, 5);
        System.out.println("266 (K key, double min, double max)方法获取区间值的个数:" + count);
//-----------------------------
        long index = redisTemplate.opsForZSet().rank("zSetValue", "B");
        System.out.println("269 rank(K key, Object o)方法获取变量中元素的索引:" + index);
//-----------------------------
//Cursor<Object> cursor = redisTemplate.opsForSet().scan("setValue", ScanOptions.NONE);
        Cursor<ZSetOperations.TypedTuple<Object>> cursor = redisTemplate.opsForZSet().scan("zSetValue", ScanOptions.scanOptions().match("C").build());
        while (cursor.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = cursor.next();
            System.out.println(" 275 can(K key, ScanOptions options)方法获取匹配元素:" + typedTuple.getValue() + "--->" + typedTuple.getScore());
        }
//------------------------------
        double score = redisTemplate.opsForZSet().score("zSetValue","B");
        System.out.println("279 score(K key, Object o)方法获取元素的分值:" + score);
//----------------------------
        long zCard = redisTemplate.opsForZSet().zCard("zSetValue");
        System.out.println("282 zCard(K key)方法获取变量的长度:" + zCard);
//-----------------------------
        double incrementScore = redisTemplate.opsForZSet().incrementScore("zSetValue","C",5);
        System.out.print("285 incrementScore(K key, V value, double delta)方法修改变量中的元素的分值:" + incrementScore);
        score = redisTemplate.opsForZSet().score("zSetValue","C");
        System.out.print("287,修改后获取元素的分值:" + score);
        zSetValue = redisTemplate.opsForZSet().range("zSetValue",0,-1);
        System.out.println("289，修改后排序的元素:" + zSetValue);
//-------------
        zSetValue = redisTemplate.opsForZSet().reverseRange("zSetValue",0,-1);
        System.out.println("292 通过reverseRange(K key, long start, long end)方法倒序排列元素:" + zSetValue);
//--------------
        zSetValue = redisTemplate.opsForZSet().reverseRangeByScore("zSetValue",1,5);
        System.out.println("295 通过reverseRangeByScore(K key, double min, double max)方法倒序排列指定分值区间元素:" + zSetValue);
//-------------
        zSetValue = redisTemplate.opsForZSet().reverseRangeByScore("zSetValue",1,5,1,2);
        System.out.println("298 通过reverseRangeByScore(K key, double min, double max, long offset, long count)方法倒序排列从给定下标和给定长度分值区间元素:" + zSetValue);
//--------------
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet666 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("zSetValue",1,5);
        iterator = typedTupleSet666.iterator();
        while (iterator.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score1 = typedTuple.getScore();
            System.out.println("306 通过reverseRangeByScoreWithScores(K key, double min, double max)方法倒序排序获取RedisZSetCommands.Tuples的区间值:" + value + "---->" + score1 );
        }
//--------------------
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet7777 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("zSetValue",1,5,1,2);
        iterator = typedTupleSet.iterator();
        while (iterator.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score1 = typedTuple.getScore();
            System.out.println("315 通过reverseRangeByScoreWithScores(K key, double min, double max, long offset, long count)方法倒序排序获取RedisZSetCommands.Tuples的从给定下标和给定长度区间值:" + value + "---->" + score1 );
        }
//--------------------
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet888 = redisTemplate.opsForZSet().reverseRangeWithScores("zSetValue",1,5);
        iterator = typedTupleSet888.iterator();
        while (iterator.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            double score1 = typedTuple.getScore();
            System.out.println("324 通过reverseRangeWithScores(K key, long start, long end)方法索引倒序排列区间值:" + value + "----->" + score1);
        }
//-----------------------
        long reverseRank = redisTemplate.opsForZSet().reverseRank("zSetValue","B");
        System.out.println("328 通过reverseRank(K key, Object o)获取倒序排列的索引值:" + reverseRank);
//---------------------
        redisTemplate.opsForZSet().intersectAndStore("zSetValue","typedTupleSet","intersectSet");
        zSetValue = redisTemplate.opsForZSet().range("intersectSet",0,-1);
        System.out.println("332 通过intersectAndStore(K key, K otherKey, K destKey)方法获取2个变量的交集存放到第3个变量里面:" + zSetValue);
//------------------------
        List list = new ArrayList();
        list.add("typedTupleSet");
        redisTemplate.opsForZSet().intersectAndStore("zSetValue",list,"intersectListSet");
        zSetValue = redisTemplate.opsForZSet().range("intersectListSet",0,-1);
        System.out.println("338 通过intersectAndStore(K key, Collection<K> otherKeys, K destKey)方法获取多个变量的交集存放到第3个变量里面:" + zSetValue);
 //------------------------
        redisTemplate.opsForZSet().unionAndStore("zSetValue","typedTupleSet","unionSet");
        zSetValue = redisTemplate.opsForZSet().range("unionSet",0,-1);
        System.out.println("342 通过unionAndStore(K key, K otherKey, K destKey)方法获取2个变量的交集存放到第3个变量里面:" + zSetValue);
//---------------------------
        redisTemplate.opsForZSet().unionAndStore("zSetValue",list,"unionListSet");
        zSetValue = redisTemplate.opsForZSet().range("unionListSet",0,-1);
        System.out.println("346 通过unionAndStore(K key, Collection<K> otherKeys, K destKey)方法获取多个变量的交集存放到第3个变量里面:" + zSetValue);
//--------------------------
        long removeCount = redisTemplate.opsForZSet().remove("unionListSet","A","B");
        zSetValue = redisTemplate.opsForZSet().range("unionListSet",0,-1);
        System.out.print("350 通过remove(K key, Object... values)方法移除元素的个数:" + removeCount);
        System.out.println("351 ,移除后剩余的元素:" + zSetValue);
//----------------------------
        removeCount = redisTemplate.opsForZSet().removeRangeByScore("unionListSet",3,5);
        zSetValue = redisTemplate.opsForZSet().range("unionListSet",0,-1);
        System.out.print("355 通过removeRangeByScore(K key, double min, double max)方法移除元素的个数:" + removeCount);
        System.out.println("356 ,移除后剩余的元素:" + zSetValue);
//---------------------------
        removeCount = redisTemplate.opsForZSet().removeRange("unionListSet",3,5);
        zSetValue = redisTemplate.opsForZSet().range("unionListSet",0,-1);
        System.out.print("360 通过removeRange(K key, long start, long end)方法移除元素的个数:" + removeCount);
        System.out.println("361 ,移除后剩余的元素:" + zSetValue);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private Integer id;

    private String name;

    private Integer age;
}

