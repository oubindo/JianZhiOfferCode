/**
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历顺序的下一个节点？树中节点除了指向左右节点的指针外，还有一个指向父节点的指针
 * 思路如下：比较简单，如果一个节点有右子树，那next就是右子树的最左节点。如果没有右子树，那么我们要找到一个是他父节点的左子节点的节点。如果这样额节点存在，那么这个节点
 * 的父节点就是我们要找的next
 * Created by oubin on 17-3-14.
 */
public class Ques58NextNodeInTree {
}
