package collection

class Factory private constructor(val nickname:String){
    companion object {
        fun newsubScribingUser(email:String) = Factory(email.substringBefore("@"))

        //fun newFaceBookUser(accountid:Int) = Factory()
    }
}