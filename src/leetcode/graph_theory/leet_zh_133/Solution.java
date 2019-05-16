package leetcode.graph_theory.leet_zh_133;

import java.util.*;

public class Solution {

    /*
     *
     *
     * 执行用时 : 6 ms, 在Clone Graph的Java提交中击败了13.54% 的用户
     * 内存消耗 : 32.4 MB, 在Clone Graph的Java提交中击败了66.53% 的用户
     *
     借助HashMap，定义一个HashMap<Node,Node> map对象，key和value都是value类型
     * */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        Map<Node, Node> map = new HashMap<>();

        // traversal graph
        // copy to Map
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(cur.val, null));
            }
            if (cur.neighbors == null)
                continue;
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, null));
                    queue.offer(neighbor);
                }
            }
        }

        // build links
        for (Node cur : map.keySet()) {
            if (cur.neighbors == null)
                continue;
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
