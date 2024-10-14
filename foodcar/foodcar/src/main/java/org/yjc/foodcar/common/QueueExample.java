package org.yjc.foodcar.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class QueueExample {
    public static void main(String[] args) {
        // 创建一个 LinkedList 实现的队列
        Queue<String> queue = new LinkedList<>();

        // 添加元素到队列中（enqueue）
        queue.offer("Element 1");
        queue.offer("Element 2");
        queue.offer("Element 3");

        System.out.println("队列内容: " + queue);

        // 查看队列头部的元素（peek），不移除
        System.out.println("队列头部的元素: " + queue.peek());

        // 移除并返回队列头部的元素（dequeue）
        System.out.println("移除元素: " + queue.poll());

        System.out.println("移除后的队列: " + queue);

        // 判断队列是否为空
        if (queue.isEmpty()) {
            System.out.println("队列为空");
        } else {
            System.out.println("队列不为空");
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        objectObjectHashMap.put(null,"1");
//        objectObjectConcurrentHashMap.put(null,"2");
        String o = (String) objectObjectHashMap.get(null);

        System.out.printf(o);
    }
}
