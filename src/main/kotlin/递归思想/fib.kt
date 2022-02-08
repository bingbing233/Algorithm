package 递归思想

/**
 * 斐波那契数列
 * 求斐波那契数列第N项的值
 * 递归（拆分子问题）
 */


/**
 * 暴力穷举
 * 递归（自顶向下）
 * 问题：重复计算过多，时间复杂度 O = 2^n
 */
fun fib(n: Int): Int {
    if (n == 1 || n == 2)
        return 1
    return fib(n - 1) + fib(n - 2)
}

/**
 *  使用备忘录记录已经计算过的值，避免重复计算
 *  递归（自顶向下）
 */
val dpTable = HashMap<Int,Int>()
fun fib2(n:Int):Int{
    if(dpTable.containsKey(n))
        return dpTable[n]!!

    if(n == 1 || n == 2)
        return 1

    val value = fib2(n-1) + fib2(n-2)
    dpTable[n] = value
    return value
}

/**
 * 使用循环（自底向上）
 */
fun fib3(n:Int):Int{
    if(n == 1 || n == 2)
        return 1
    //创建一个数组记录结果
    val result = Array(n+1) { 1 }
    for(i in 0 until n-1){
        result[i+2] = result[i]+result[i+1]
    }
    return result[n-1]
}

/**
 * 只存储前面两个值，降低空间复杂度
 */
fun fib4(n:Int):Int{
    var pre = 1
    var cur = 1
    if(n == 1|| n == 2)
        return 1
    for(i in 3..n){
        val tempCur = cur
        cur+=pre
        pre = tempCur
    }
    return cur
}
fun main(){
    for(i in 1..10){
        println(fib4(i))
    }
}