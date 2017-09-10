package sorting

/**
 * Created by a1849 on 2017/7/6.
 */
class BubbleSort {
    var Beforesorted:Array<Int>?=null

    fun init(arrays:Array<Int>):Boolean{
        Beforesorted = arrays
        println("ArraySize "+Beforesorted?.size)
        return true
    }
    fun sort():Array<Int>?{
        var temp:Int
        val arraysize = if (Beforesorted != null) Beforesorted?.lastIndex else -1
        var index =0

        while (index <arraysize!!.toInt()){
            var innerindex = 0

            while (innerindex < arraysize.toInt()-index){

                if(Beforesorted!![innerindex]> Beforesorted!![innerindex+1]){
                    temp = Beforesorted!![innerindex]
                    Beforesorted!![innerindex] = Beforesorted!![innerindex+1]
                    Beforesorted!![innerindex+1] = temp
                }
                innerindex++
            }
            index++
        }
        return Beforesorted
    }
}

fun main(args: Array<String>) {
    val testBulbble : BubbleSort = BubbleSort()
    val testArray = arrayOf(2,55,1,44,88,77,44,22,11,485,87468,414,1,5,5,55)
    testBulbble.init(testArray)
    val sortArray = testBulbble.sort()
    sortArray?.forEach { print(" $it") }
}