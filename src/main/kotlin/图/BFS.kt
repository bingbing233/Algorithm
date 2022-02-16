package 图

import java.util.*

/**
 * 广度优先搜索
 * 1、可以找出两点之间是否可达
 * 2、可以找出两点之间的最短路径
 */

/**
 * 两个节点之间是否可访问
 * （图的遍历）
 */
fun isAccessible(startNode: Node<String>, endNode: Node<String>): Boolean {
    val queue = LinkedList<Node<String>>()
    queue.add(startNode)
    while (queue.size > 0) {
        //打印一下当前层的节点
        for (node in queue){
            print(node.value + " " )
        }
        println()
        //取出队列第一个节点
        val currentNode = queue.first
        queue.removeFirst()
        if (currentNode.value == endNode.value) {
            return true
        }

        for (node in currentNode.neighbor!!) {
            //当前节点的邻接节点全部入队
            if(queue.contains(node))
                continue
            queue.add(node)
        }
    }
    return false
}


fun main() {
    println(isAccessible(home, school))
}