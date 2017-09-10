package collection

class CollectionPtratice {
    fun parsePath( path:String):String{
        var directory = path.substringBeforeLast("/")
        var fullname = path.substringAfterLast("/")
        var filename = fullname.substringBeforeLast(".")
        var ext = path.substringAfterLast(".")
        println("directory: $directory Fullname : $fullname FileName:$filename Ext: $ext")

        return ""
    }

    companion object {
        val test = "Test"
        fun getHashCode(){
            println("Companion $test")
        }
    }


}

fun main(args: Array<String>) {
    val(name , value) = "password" to "lablab"
    val map = mapOf(Pair(name , value))
    for((index , element)in map){
        println("$index : $element")
    }
    //Mutiple seperator
    val stringArr = "12.345-6.A".split(".","-")
    println(stringArr)
    var test = CollectionPtratice()
    test.parsePath("/home/peter/SparkTest/build.gradle")
    //Triple comment
    val testtest = """./test"test"/.//hi"""
    println(testtest)
    println(CollectionPtratice.test)
    val subScriber = Factory.newsubScribingUser("a184999@gmail.com")
    println("${subScriber.nickname
    }")
}