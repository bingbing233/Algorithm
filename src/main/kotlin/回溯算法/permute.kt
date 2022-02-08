package 回溯算法

import java.util.*

/**
 *  全排列问题
 *  输入一组不重复的数字，返回他们的全排列
 *  回溯问题
 */

val result = LinkedList<LinkedList<Int>>()
fun permute(array: Array<Int>): LinkedList<LinkedList<Int>> {
    //记录路径
    val track = LinkedList<Int>()
    backtrack(array,track)
    return result
}

fun backtrack(nums: Array<Int>, track:LinkedList<Int>){
    //触发结束条件
    if(track.size == nums.size){
        result.add(LinkedList(track))
        return
    }

    for(num in nums){
        //排除不合法的选择
        if (track.contains(num)) {
            continue
        }
        //做选择
        track.add(num)
        //进入下一层决策树
        backtrack(nums,track)
        //取消选择（回溯）
        track.removeLast()
    }
}

fun main(){
    val nums = arrayOf(1,2,3)
    println(permute(nums))
}