package com.zk.demo.dubboprovider.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 不带虚拟节点的一致性Hash算法
 * @author zhoukun
 */
public class HashAlgorithm {

    private static Integer[] dbs = {
            1,2,3,4,5
    };

    /**key表示服务器的hash值，value表示库号*/
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    static {
        for (int i = 0; i< dbs.length; i++){
            int hash = getHash(String.valueOf(dbs[i]));
            System.out.println(String.format("%s 加入集合中，其hash值为%s ", dbs[i], hash));
            sortedMap.put(hash, String.valueOf(dbs[i]));
        }
    }

    private static String getDB (String key){
        int hash = getHash(key);
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if(subMap.isEmpty()){
            //返回起点
            Integer i = sortedMap.firstKey();
            return sortedMap.get(i);
        }else {
            //第一个Key就是顺时针过去离node最近的那个结点
            Integer i = subMap.firstKey();
            //返回对应的服务器
            return subMap.get(i);
        }
    }

    public static int getHash(String str){
        final int p = 16777619;
        int hash = (int)2166136261L;

        for (int i = 0; i <str.length(); i++) {
            hash = (hash ^ str.charAt(i) * p);
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args){
       String[] keys = {"1234", "4567", "789", "012"};
        for (String key : keys) {
            System.out.println(String.format("%s的hash值是%s,被路由到节点%s", key, getHash(key), getDB(key)));
        }
    }
}
