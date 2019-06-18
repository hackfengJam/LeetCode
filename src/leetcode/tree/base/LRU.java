package leetcode.tree.base;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    /*
    *
    *
    哈希表 + 双向链表。

    每次写入数据时将数据放入链表头结点。
    使用数据时候将数据移动到头结点。
    缓存数量超过阈值时移除链表尾部数据。
    * */


    private Map<Integer, TreeNode> cache = new HashMap<>();

    /**
     * 最大缓存大小
     */
    private int cacheSize;

    /**
     * 节点大小
     */
    private int nodeCount;


    /**
     * 头结点
     */
    private TreeNode header;

    /**
     * 尾节点
     */
    private TreeNode tailer;
//    private Node<K,V> tailer;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;

        // 头结点的下一个节点为空
        header = new TreeNode(-1);
        // header.pre = null;
        header.left = null;


        // 尾节点的上一个节点为空
        tailer = new TreeNode(-1);
        // tailer.post = null;
        tailer.right = null;


        // 双向链表 头结点的下节点指向尾节点
        header.right = tailer;

        // 尾结点的上结点指向头结点
        tailer.left = header;
    }

    public int get(int key) {
        TreeNode node = cache.get(key);
        if (node == null) {
            // should raise exception here.
            return -1;
        }

        // 当前访问节点移动到头部
        this.moveToHead(node);

        return node.val;
    }


    /**
     * 总是向 header 右边添加新的 node
     */
    private void addNode(TreeNode node) {
        if (nodeCount + 1 > cacheSize)
            // TODO 待优化
            popTail();

        node.left = header;
        node.right = header.right;

        header.right = node;
        header.right.left = node;

        nodeCount++;
    }

    /**
     * 从链表中移除一个存在的 node
     */
    private void removeNode(TreeNode node) {
        TreeNode pre = node.left;
        TreeNode post = node.right;

        pre.right = post;
        post.left = pre;
    }

    /**
     * 将 node 从中间移到头部
     */
    private void moveToHead(TreeNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop 当前尾部元素
     */
    private TreeNode popTail() {
        TreeNode res = tailer.left;
        this.removeNode(res);
        return res;
    }
}
