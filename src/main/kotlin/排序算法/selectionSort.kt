package 排序算法

import 回溯算法.toString2

/**
 * 选择排序
 * 遍历数组n次，每次找到最值存入新的数组,n为数组长度
 */

fun selectionSort(array: Array<Int>): Array<Int> {

    var minIndex = 0
    val newArray = Array(array.size){ Int.MAX_VALUE }
    for( i in array.indices){
        var min = Int.MAX_VALUE
        for (j in array.indices){
            if(array[j] < min ){
                min = array[j]
                minIndex = j
            }
        }
        array[minIndex] = Int.MAX_VALUE
        newArray[i] = min
    }
    return newArray
}


fun main(){
    val array = arrayOf(5,3,1,6,7)
    println(selectionSort(array).toString2())
}

