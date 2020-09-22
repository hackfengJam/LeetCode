package leetcode.algo.list.leet_zh_138;

public class Solution {

    /*
     *
     *
     * 138. 复制带随机指针的链表
     * 执行用时 : 1 ms, 在Copy List with Random Pointer的Java提交中击败了99.71% 的用户
     * 内存消耗 : 34.2 MB, 在Copy List with Random Pointer的Java提交中击败了67.96% 的用户
     *
     * */

//    方法一：借助HashMap的特性，定义一个HashMap<Node,Node> map对象，key和value都是value类型 ，key来存旧的链表，value来存新的链表。最后利用老节点和新节点的对应关系来实现一个拷贝新的链表。
//
//对于理解哈希表的同学来说，应该不难理解，code也比较容易：

///* 方法一：借助HashMap，定义一个HashMap<Node,Node> map对象，key和value都是value类型 */
//    public static Node copyListWithRandom1(Node head) {
//        HashMap<Node, Node> map = new HashMap<Node, Node>();
//        Node cur = head;
//        /* 将单链表的所有节点和value对应放进去map对象中 */
//        while (cur != null) {
//            map.put(cur, new Node(cur.value));// 这里新建一个节点，这个节点放head的value
//            cur = cur.next;
//        }
//        /* 重新构建链表的结构，注意，此时map对象为map<cur,cur'>,cur'为新建立的节点 */
//        cur = head;
//        /*
//         * 为了让大家更好的理解，我们假设旧节点和旧节点的next还有旧节点rand分别为cur,curJiu，curRand
//         * （不懂的同学可以先去了解一下hashMap特点）所以有：cur.next= curJiu,cur.rand= curRand
//         * 因此，为了保持这种结构，就有了(map.get(cur)).next = map.get(cur.next),rand同理。
//         */
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).rand = map.get(cur.rand);
//            cur = cur.next;
//        }
//        return map.get(head);
//
//    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Node cur = head;

        // copy list
        while (cur != null) {
            Node copy = new Node();
            copy.val = cur.val;

            // insert copy Node
            copy.next = cur.next;
            cur.next = copy;


            cur = copy.next;
        }

        // build random links
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;

            cur = cur.next.next;
        }

        // extract copyList
        Node newDummyHead = new Node(), newCur = newDummyHead;
        cur = head;
        while (cur != null) {
            newCur.next = cur.next;
            newCur = newCur.next;

            cur.next = cur.next.next;
            cur = cur.next;
        }

        return newDummyHead.next;
    }

    public void Main() {
        Node head = new Node();
        Node p1 = new Node();
//        Node p2 = new Node();
//        Node p3 = new Node();

        head.val = 1;
        p1.val = 2;
//        p2.val = 3;
//        p3.val = 4;

        head.next = p1;
        p1.next = null;
//        p1.next = p2;
//        p2.next = p3;
//        p3.next = null;

//        head.random = p2;
//        p1.random = p3;
        p1.random = p1;

        System.out.println(copyRandomList(head));

    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ss.Main();
    }


}

