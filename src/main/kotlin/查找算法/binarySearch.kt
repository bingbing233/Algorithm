package 查找算法

/**
 * 二分查找
 * 给定一个有序数组和一个目标数字，查找这个数字在数组中的位置
 * 时间复杂度 O(logN),N为数组长度
 * 每次查找都将数组减去一半
 */

fun binarySearch(num: Int, array: Array<Int>): Int {
    var low = 0
    var high = array.size - 1
    var mid = (low + high) / 2

    var index = -1
    while (low < high) {
        if (num == array[mid]) {
            index = mid
            break
        }

        if (num < array[mid]) {
            high = mid

        } else {
            low = mid
        }
        mid = (low + high) / 2
    }
    return index
}