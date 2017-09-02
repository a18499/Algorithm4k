package image


class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { // 属性的获取函数声明
            return height == width
        }
    val isLongger:Boolean
        get() = height>width
}

fun main(args: Array<String>) {
    //var bitmap : Bitmap
    var test = Rectangle(100,100)
    print(test.isSquare)
}