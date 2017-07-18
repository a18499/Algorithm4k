package sorting

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuicksortTest {
    var testquicksort : Quicksort?=null
    @BeforeEach
    fun setUp() {
        testquicksort = Quicksort()
    }

    @Test
    fun sortIt() {

        val testarray:Array<Int> = arrayOf(5,1,6,4,7,95,2,8,45,4,55,666,21,54)
        testquicksort!!.init(testarray)
        val result = testquicksort!!.sortIt()
        result.forEach { print(" $it") }
    }

}