package 排序算法

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

    array.forEach {
        if (it < pivot) {
            less.add(it)
        }
        if (it > pivot) {
            greater.add(it)
        }
    }
    return merge(quickSort(less),ArrayList<Int>().apply { add(pivot) }, quickSort(greater))

}

fun merge(vararg array: ArrayList<Int>): ArrayList<Int> {
    val newArray = ArrayList<Int>()
    array.forEach {
        newArray.addAll(it)
    }
    return newArray
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
    println(quickSort(array))
}