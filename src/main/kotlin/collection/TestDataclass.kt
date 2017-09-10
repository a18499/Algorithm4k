package collection


fun main(args: Array<String>) {
    val users = hashSetOf(User(1,"peter","a184999@gmail.com"))
    val loginuser = User(1,"peter","a184999@gmail.com")
    for(user in users){
        println(user.toString())
        println(user==loginuser)
    }


}