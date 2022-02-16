package 图

/**
 * 数据结构 -- 图
 */
//这是节点
data class Node<T>(val value: T, val neighbor: Array<Node<T>>?)

val school = Node("school",null)
val shop = Node("shop", arrayOf(school))
val cafe = Node("cafe", arrayOf(school))
val market = Node("market", arrayOf(shop))
val home = Node("home", arrayOf(market, cafe))

//home is start node
//school is end node