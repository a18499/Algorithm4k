package collection

import java.lang.IllegalArgumentException

data class User(val id:Int,val name :String,val email:String) {
    val nickname :String
        get() = email.substringBefore("@")
    fun saveUser(user:User){
        fun validate(value:String , fieldName:String){
            if(value.isEmpty()){
                throw IllegalArgumentException( "Can't save user ${user.id}")
            }
        }
        validate(user.name,"")
    }


}

