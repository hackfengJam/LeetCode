package leetcode.tree.leet_1167;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    public String funLi(List<TreeNode> li) {
        List<TreeNode> lii = new ArrayList<TreeNode>();
        if (li.size() == 0) {
            return "";
        }
        String s = "";
        for (TreeNode node : li) {
            if (node == null) {
                s += ",null";
            } else {
                s += "," + node.val;
                lii.add(node.left);
                lii.add(node.right);
            }
        }
        s += funLi(lii);
        return s;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        List<TreeNode> li = new ArrayList<TreeNode>();
        li.add(root);
        String s = funLi(li);
        String[] ss = s.split(",");
        int index = 0;
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals("null")) {
                continue;
            } else {
                index = i;
                break;
            }
        }

        String[] res = new String[index];
        for (int i = 1; i <= index; i++) {
            res[i - 1] = ss[i];
        }
        return "[" + String.join(",", res) + "]";
    }


    public TreeNode fundeSerialize(String[] li, int index, List<TreeNode> lii, int deep) {
        if (lii.size() <= 0) {
            return null;
        }
        TreeNode node;
        List<TreeNode> liiChr = new ArrayList<TreeNode>();
//        int step = 1 << deep;
        int step = 0;
        int i = index;
        for (TreeNode tr : lii) {
//            if (i > index + step - 1) {
//                break;
//            }
            if (tr == null) {
                continue;
            }
            if (i <= li.length - 1) {
                if (li[i].equals("null")) {
                    node = null;
                } else {
                    node = new TreeNode(Integer.parseInt(li[i]));
                }
                if (tr != null) {
                    tr.left = node;
                }
                step++;
                liiChr.add(node);
            }
            if (i + 1 <= li.length - 1) {
                if (li[i + 1].equals("null")) {
                    node = null;
                } else {
                    node = new TreeNode(Integer.parseInt(li[i + 1]));
                }
                if (tr != null) {
                    tr.right = node;
                }
                step++;
                liiChr.add(node);
            }
            i += 2;
        }
        index += step;
        return fundeSerialize(li, index, liiChr, deep + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]") || data.equals("null")) {
            return null;
        }
        String subData = data.substring(1, data.length() - 1);
        if (subData.trim().equals("")) {
            return null;
        }
        String[] li = subData.split(",");
        int deep = 1;
        TreeNode root = new TreeNode(-1);
        root.val = Integer.parseInt(li[0]);
        int ln = li.length;
        List<TreeNode> lii = new ArrayList<TreeNode>();
        lii.add(root);
        int index = 1;
        fundeSerialize(li, index, lii, deep);
        return root;
    }


    // Encodes a tree to a single string.
    public String preOrder(TreeNode root) {
        if (root == null) {
            return "null";
        }
        List<TreeNode> li = new ArrayList<TreeNode>();
        li.add(root);

        li.add(root.left);
        li.add(root.right);


        String val = "" + root.val;
        String lv = preOrder(root.left);
        String rv = preOrder(root.right);
        val += ", " + lv;
        val += ", " + rv;
        return val;
    }

    public void main() {
//        TreeNode root = new TreeNode(1);
//        TreeNode le = new TreeNode(2);
//        TreeNode ri = new TreeNode(3);
//        TreeNode rile = new TreeNode(4);
//        TreeNode riri = new TreeNode(5);
//        root.left = le;
//        root.right = ri;
//        ri.left = rile;
//        ri.right = riri;
//
//        String s = serialize(root);
//        System.out.println(s);

//        TreeNode root = deserialize("[1,2,3,null,null,4,5]");
//        TreeNode root = deserialize("[]");
        TreeNode root;
        root = deserialize("[5,2,3,null,null,2,4,3,1]");
        root = deserialize("[1,2,null,3,null,4,null,5]");
//        String str = preOrder(root);
//        System.out.println(str);
        String s = serialize(root);
        System.out.println(s);

    }

    public static void main(String[] args) {
        new Codec().main();
    }
}