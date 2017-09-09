package kotlininaction

class Rectangle(val height:Int,val width:Int){
    val isSquare:Boolean
      get() {
          return height==width
      }
    fun String.lastChar():Char = get(this.length-1)

    fun testLastChar() = println("Test".lastChar())
}