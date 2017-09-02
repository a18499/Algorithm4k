package core

import sorting.BubbleSort
import sorting.Quicksort


class AlogorithmMain(val bookService:BubbleSort) {
   // var bubble : BubbleSort = BubbleSort()
   lateinit var tt :BubbleSort
    var quickSort:Quicksort = Quicksort()
    fun init():Boolean{
        var data =arrayOf(2,3,6,5,4,5)
        this.tt = bookService
        return this.tt.init(data)
    }

}