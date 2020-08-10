package hard;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 *);
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得关键字 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得关键字 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 */
public class Q146 {
    Node head;
    Node end;
    private Map<Integer,Node> data;
    int capacity;
    int current = 0;

    class Node{
        public int val;
        public int key;
        public Node next;
        public Node last;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Q146(int capacity) {
        this.data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = data.get(key);
        if (node != null){
            if (node.equals(head) && node.equals(end)){

            } else if (node.equals(head)){
                head = head.next;
                head.last = null;
                end.next = node;
                node.last = end;
                end = node;
                end.next = null;
            } else if (node.equals(end)){

            } else {
                node.last.next = node.next;
                node.next.last = node.last;
                node.next = null;
                end.next = node;
                node.last = end;
                end = node;
            }
            return node.val;
        }
        return -1;

    }

    public void put(int key, int value) {
        Node node = data.get(key);
        if (node != null){
            node.val = value;
            if (node.equals(head) && node.equals(end)){

            } else if (node.equals(head)){
                head = head.next;
                head.last = null;
                end.next = node;
                node.last = end;
                end = node;
                end.next = null;
            } else if (node.equals(end)){

            } else {
                node.last.next = node.next;
                node.next.last = node.last;
                node.next = null;
                end.next = node;
                node.last = end;
                end = node;
            }
        } else {
             node = new Node(key,value);
             if (current == 0 ||(current == 1 && capacity ==1)){

                 head = node;
                 end = node;
                 data.put(key,node);
                 if (current<capacity){
                     current++;
                 }

                 return;
             }
             if (current == 1){
                 end = node;
                 end.last = head;
                 head.next = end;
                 current++;
                 data.put(key,node);
                 return;
             }
             if (current<capacity){
                 end.next = node;
                 node.last = end;
                 end = node;
                 current++;
                 data.put(key,node);
                 return;
             }
             if (current == capacity){
                 end.next = node;
                 node.last = end;
                 end = node;
                 int del = head.key;
                 data.remove(del);
                 head = head.next;
                 head.last = null;
                 data.put(key,node);
                 return;
             }

        }
    }

    public static void main(String[] args) {
        Q146 q146 = new Q146(1);
//        q146.put(1,1);
        q146.put(2,1);
//        q146.put(3,3);
//        q146.put(4,4);
//        int i = q146.get(4);
//        int i3 = q146.get(3);
//        int i4 = q146.get(2);
        int i5 = q146.get(2);
        q146.put(3,2);
        int i6 = q146.get(2);
//        q146.put(4,4);
//        int i7 = q146.get(1);
        int i8 = q146.get(3);
        int i9 = q146.get(4);
        int i10 = q146.get(5);
        q146.put(1,1);
        q146.put(4,1);
        int i1 = q146.get(2);
        int i2 = q146.get(3);
        System.out.println(i5);
    }
}
