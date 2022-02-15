package 查找算法

/**
 * 简单查找
 * 遍历数组
 * 时间负责度 O(n) n为数组长度
 */

fun simpleSearch(num:Int,array: Array<Int>): Int {
    array.forEach {
        if(num == array[it])
            return it
    }
    return -1
}