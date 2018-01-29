/**
 * 尾递归
 * Created by 江婷婷 on 2018/1/29.
 */
data class ListNode(val value: Int, var next: ListNode ?= null)

//最后调用自身 调用自己后不做任何操作
//如果是尾递归 加tailrec关键字 编译器会把它转换成迭代
tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) {
        return head
    } else {
        return findListNode(head.next, value)
    }
}

fun main(args: Array<String>) {
    val MAX_NODE_COUNT = 100000
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX_NODE_COUNT) {
        p.next = ListNode(i)
        p = p.next!!
    }
    println(findListNode(head, MAX_NODE_COUNT - 2)?.value)
}

//调用完还会乘以n 不是尾递归
fun jiecheng(n: Long): Long {
    return n * jiecheng(n - 1)
}

data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) {
        return root
    }
    return findTreeNode(root.left, value) ?: return findTreeNode(root.right, value)
    //    (            不是尾递归                                                  )
}