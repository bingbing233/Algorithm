package 回溯算法


import java.util.*

/**
 *  n皇后问题
 *  给你⼀个 N×N 的棋盘，让你放置 N 个 皇后，使得它们不能互相攻击。（每行只能放一个皇后）
 *  可以把这个问题看成全排列问题
 *  选过的数字无法再次选择
 */

//存放多个list结果  每个list代表每个棋盘的摆放方式，list的每个item代表皇后放在改行的第几格，list的index代表棋盘的第几行
val resultList = LinkedList<LinkedList<Int>>()
fun solveNQueue(n: Int) {

    val track = LinkedList<Int>()
    backtrack(n, track)

    for (list in resultList) {
        for(i in list){
            val board =  Array(n) { 0 }
            board[i] = 1
            println(board.toString2())
        }
        println()
    }
}

fun backtrack(n: Int, track: LinkedList<Int>) {
    //到达最后一行，触发结束条件
    if (track.size == n) {
        resultList.add(LinkedList(track))
    }

    for (i in 0 until n) {
        //排除已经选择的路径
        if (track.contains(i))
            continue
        //选择路径
        track.add(i)
        //进入一下层决策树
        backtrack(n, track)
        //取消选择（回溯）
        track.removeLast()
    }
}

fun Array<Int>.toString2():String{
    val builder = StringBuilder()
    builder.append("[")
    for(i in indices){
        builder.append(get(i))
        builder.append(",")
        if(i == size-1)
            builder[builder.length-1] = ']'
    }
    return builder.toString()
}

fun main() {
    solveNQueue(5)
}
