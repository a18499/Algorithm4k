package core

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule






class AlogorithmMainTest {
    lateinit var testAlgo: AlogorithmMain
   // @Mock
   // var mockBubble:BubbleSort = Mockito.mock(BubbleSort::class.java)
    @Test
    fun init() {
       // testAlgo.bubble = mockBubble
        //val mockBubble : BubbleSort = mock()

       // whenever(mockBubble.init(arrayOf(2,3,6,5,4,5))).thenReturn(true)
        //Mockito.`when`(mockBubble.init(arrayOf(2,3,6,5,4,5))).thenReturn(true)

        //given(mock.finalMethod()).willReturn("not anymore");
        assertEquals(true,testAlgo.init())
       // Mockito.verify(mockBubble).init(arrayOf(2,3,6,5,4,5))
    }

}