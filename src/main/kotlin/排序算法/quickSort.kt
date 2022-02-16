package 排序算法

import 回溯算法.toString2
import java.util.*
import kotlin.collections.ArrayList

/**
 * 快速排序
 * 分而治之的思想
 * 递归
 */

fun quickSort(array: ArrayList<Int>): ArrayList<Int> {
    if(array.size<2){
        return array
    }

    //取一个数当基准点
    val pivot = array[0]
    val less = ArrayList<Int>()
    val greater = ArrayList<Int>()
    //找出基准数左边和右边的数
    array.forEach {
        if (it < pivot) {
            less.add(it)
        }
        if (it > pivot) {
            greater.add(it)
        }
    }
    //对less和greater进行同样的操作，直到数组长度为1
    return merge(quickSort(less),ArrayList<Int>().apply { add(pivot) }, quickSort(greater))
}

fun merge(vararg array: ArrayList<Int>): ArrayList<Int> {
    val newArray = ArrayList<Int>()
    array.forEach {
        newArray.addAll(it)
    }
    return newArray
}

/**
 * 快速排序另一种解法
 */
fun quickSort2(array: Array<Int>, low:Int, high:Int){
    if(low == high){
        println(array.toString2())
        return
    }
    var mLow = low
    var mHigh = high
    val pivot = array[mLow]
    while (mLow < mHigh){
        while (mLow < mHigh){
            if(array[mHigh] > pivot){
                mHigh -=1
            }

            if(array[mHigh] < pivot) {
                array[mLow] = array[mHigh]
                break
            }
        }

        while (mLow < mHigh){
            if(array[mLow] < pivot){
                mLow+=1
            }

            if(array[mLow] > pivot) {
                array[mHigh] = array[mLow]
                break
            }
        }
        if(mLow == mHigh){
            array[mLow] = pivot
            println(array.toString2())
        }
    }
   // quickSort2(array,0,high-1)
    //quickSort2(array,high+1,array.size-1)

}



fun main() {
    val array = ArrayList<Int>()
    array.apply {
        add(2)
        add(1)
        add(0)
        add(5)
        add(8)
        add(6)
    }
    //println(quickSort(array))
    val array2 = arrayOf(2,1,0,5,8,6,4,3,7)
    quickSort2(array2,0,array2.size-1)
    println(array2.toString2())
}