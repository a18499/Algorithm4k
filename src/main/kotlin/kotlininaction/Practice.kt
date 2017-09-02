package kotlininaction

class Practice {
    fun max(a:Int,b:Int):Int{
        return if(a>b) a else b
    }
    fun min(a:Int,b:Int) = if (a<b) a else b

    fun recognize(c: Char){
        when(c){
            in '0' ..'9' -> {
                c.toInt()
                println("it is a digit $c")
            }
            in 'a'..'z',in 'A'..'Z' -> {
                println("it is a alpa $c")
            }
        }
    }
}