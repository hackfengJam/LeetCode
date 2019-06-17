package leetcode.tree.base;

public class LRU {
    /*
    *
    *
    哈希表 + 双向链表。

    每次写入数据时将数据放入链表头结点。
    使用数据时候将数据移动到头结点。
    缓存数量超过阈值时移除链表尾部数据。
    * */

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
//    private Node<K,V> tailer;
    private TreeNode tailer;

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

}
