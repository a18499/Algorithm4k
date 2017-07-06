package sorting



/**
 * Created by a1849 on 2017/7/5.
 */
class Quicksort {

    var beforeSortArray : Array<Int> = arrayOf()
    fun init(arrays:Array<Int>):Boolean{
        if(arrays.isEmpty()){
            print("array is empty")
            return false
        }else{
            beforeSortArray = arrays
        }
        return true
    }

    fun sortIt():Array<Int>{
        beforeSortArray
        println("Input data: First "+beforeSortArray[0]+" Last:"+beforeSortArray[(beforeSortArray.size-1)])
        quicksort(0,beforeSortArray.size-1)
        return beforeSortArray
    }
    fun quicksort(left:Int,right:Int){
        var Left:Int
        var Right:Int
        val Base:Int
        Left=left
        Right=right
        if(Left>Right){
            return
        }
        Base = beforeSortArray[Left]

        while (Left!=Right){
            while (Base<=beforeSortArray[Right]&&(Left<Right))
                Right--

            while (Base>=beforeSortArray[Left]&&(Left<Right))
                Left++

            if(Left<Right){
                var tempvalue:Int
                tempvalue = beforeSortArray[Left]
                beforeSortArray[Left]=beforeSortArray[Right]
                beforeSortArray[Right]=tempvalue
            }
        }
        beforeSortArray[left]=beforeSortArray[Left]
        beforeSortArray[Left]=Base
        quicksort(left,Left-1)
        quicksort(Left+1,right)
    }

}
fun main(args: Array<String>) {
    val testarray:Array<Int> = arrayOf(5,1,6,4,7,95,2,8,45,4,55,666,21,54)
    val testquick:Quicksort= Quicksort()
    testquick.init(testarray)


    val result = testquick.sortIt()
    result.forEach { print(" $it") }
    val even: IntArray = intArrayOf(2, 4, 6)
    val odd: IntArray = intArrayOf(1, 3, 5)

    val lala: Array<IntArray> = arrayOf(even, odd)
    for(each in lala){
        for (each1 in each){
            println(each1)
        }

    }
    //readLine()
}