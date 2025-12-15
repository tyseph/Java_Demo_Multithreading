package org.advanced.streams;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        String value;
        Node next;
        Node prev;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    static class Cache {

        final int capacity;
        Map<Integer, Node> cacheMap;
        Node head;
        Node tail;

        Cache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>();
            this.head = new Node(-1, "null");
            this.tail = new Node(-1, "null");
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        // Function to get the value for a given key
        public String get(int key) {
            if (!cacheMap.containsKey(key)) {
                return "Empty";
            }

            Node node = cacheMap.get(key);
            remove(node);
            add(node);
            return node.value;
        }

        // Function to put a key-value pair into the cache
        void put(int key, String value) {
            if (cacheMap.containsKey(key)) {
                Node oldNode = cacheMap.get(key);
                remove(oldNode);
            }

            Node node = new Node(key, value);
            cacheMap.put(key, node);
            add(node);

            if (cacheMap.size() > capacity) {
                Node nodeToDelete = tail.prev;
                remove(nodeToDelete);
                cacheMap.remove(nodeToDelete.key);
            }
        }

        void add(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
        }

        void remove(Node node) {
//            Node prevNode = tail.prev;
//            prevNode.next = node.next;
//            prevNode.prev = node.prev;

            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

        }
    }


    public static void main(String[] args) {

        Cache cache = new Cache(4);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache: " + cache.get(2));
        System.out.println("Cache: " + cache.get(4));
        cache.put(4, "D");
        cache.put(3, "E");
        System.out.println("Cache: " + cache.get(4));
        cache.put(1, "A");

        cache.cacheMap.forEach((integer, node) -> {
            System.out.println(integer + ": " + node.value + " -> [" + node.prev + "," + node.next + "]");
        });

        Node i = cache.head;
        while (i.next != null) {
            System.out.println(i.next.key + ": " + i.next.value);
            i = i.next;
        }
    }
}