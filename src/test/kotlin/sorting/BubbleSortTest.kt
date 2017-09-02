package sorting

import org.junit.Test
import org.junit.Assert.*

class BubbleSortTest {
    @Test
    fun sort() {
        val testBulbble : BubbleSort = BubbleSort()
        val testArray = arrayOf(2,55,1,44,88,77,44,22,11,485,87468,414,1,5,5,55)
        testBulbble.init(testArray)
        val sortArray = testBulbble.sort()
        sortArray?.forEach { print(" $it") }
        assertEquals(testArray.size,sortArray?.size)
    }

}