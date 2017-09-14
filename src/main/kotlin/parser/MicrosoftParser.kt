package parser

import org.dom4j.Attribute
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.SAXReader
import java.io.File

class MicrosoftParser{
    private val xmlreader = SAXReader()
    lateinit var document:Document
    lateinit var root :Element
    lateinit var tagFilter:String
    fun init(filepath:String){
        try {

            document =  xmlreader.read(File(filepath))
        }catch (e:Exception){
            println("init failed: ${e.toString()}")
        }
        root = document.rootElement
        println("Parse Complete")
    }
    /*fun parse(){

        println("root name: ${root.name}")
       // println("All Data: ${printXMLTree()}")
        printElement(root , 0 )
    }*/
   /*private fun printElement(element:Element , level: Int ){
        // 依照階層print
       var i = 0
        while (i<level){
            i++
            print("\t")
        }


        // 取得該TAG的Attr
       val attributes = element.attributes()
       println("<${element.getQualifiedName() }>")
       val value = element.stringValue
       println("value: $value")
       for (eachAttr in attributes){
           if(eachAttr is Attribute){
               println("Attr: ${eachAttr.name } == ${eachAttr.value}")
           }
       }
       val iter = element.elementIterator()

        while(iter.hasNext()){
            val next = iter.next()
            if(next is Element){
                println("Test "+next.getXPathResult(0))
                printElement(next, level+1 )
            }
        }
        return
    }*/

    fun findnode(xpath:String,tagfilter:String){
        tagFilter = tagfilter
        val xpathList = xpath.split("/")
        println("xpathListSize ${xpathList.size}")
       findNodewithXpath(root,0,xpathList)
    }
    fun findNodewithXpath(element:Element , level: Int,xpathList:List<String>){


            val childList = element.elements()
           // println("Level = $level xpathsize = ${xpathList.size}")
        if(element.getQualifiedName()=="MetricValue"){
            checkvalue(element)
            return
        }
            if(childList.size==0&&level==xpathList.size){

                println("Find it ")
                println("xpath =${xpathList.get(level-1)} QualifiedName = ${element.getQualifiedName()} ")
                println("value = ${element.stringValue} ")
                checkvalue(element)
                return
            }
            for (child in childList){
                if(child is Element){

                    if(level==xpathList.size){
                        try {
                            if(child.stringValue.toDouble()==3.8662097454071){
                                println("Find it ")
                                println("xpath =${xpathList.get(level-1)} QualifiedName = ${child.getQualifiedName()} ")
                                println("value = ${child.stringValue} ")
                                checkvalue(child)
                            }
                            return
                        }catch (e:Exception){
                            println("Error ${e.toString()}")
                        }


                    }else if(child.getQualifiedName()==xpathList.get(level)){
                       // println("xpath =${xpathList.get(level)} QualifiedName = ${child.getQualifiedName()}")
                        findNodewithXpath(child,level+1,xpathList)
                    }else{
                       /* println("in Else ")
                        println("xpathList = ${xpathList.get(level)}")
                        println("QualifiedName = ${child.getQualifiedName()}")*/
                    }
                }

            }

    }
    fun checkvalue(element: Element){
        //println("In checkvalue")
        val elements = element.elements()
        for (each in elements){
            if (each is Element){
                if(each.getQualifiedName() =="ProgrammaticName"&&each.stringValue==tagFilter){
                    println("QualifiedName = ${each.getQualifiedName()}")
                    println("Value = ${each.stringValue}")
                    val values = elements.get(0)
                    if(values is Element){
                        println("QualifiedName = ${values.getQualifiedName()}")
                        println("Value = ${values.stringValue}")
                    }
                }
            }


        }

    }

}

fun main(args: Array<String>) {
    if(args.size<1){
        println("please insert -h for help")
    }else{
        var command = "No"
        command = args[0]
        if(command!=null){
            when(command){
                "-h" -> {
                    println("Parser v1.0")
                    println("-------------------------------help-----------------------------")
                    println("usage: -p [xmlPath] [xmlLevel] [filtertag]")
                    println("""Ex usage: -p "JobResults_DESKTOP-41ACUOA_2017-0906_0857-40.801.xml" "AssessmentResults/AssessmentResult/Iterations/Iteration/MetricValues/MetricValue" "WorkloadAverageConsumptionRate" """)

                }
                "-p" -> {
                    val filepath = args[1]
                    val xmlLevel = args[2]
                    val filtertag = args[3]
                    val parser = MicrosoftParser()
                    parser.init(filepath)
                    parser.findnode(xmlLevel,filtertag)
                }
            }
        }
    }
/*
    val filepath ="C:\\Users\\a1849\\Desktop\\JobResults_DESKTOP-41ACUOA_2017-0906_0857-40.801.xml" //args[0]
    //println("File Path $filepath")
    val parser = MicrosoftParser()
    parser.init(filepath)

   // parser.parse()
    //AxeJobResults > AssessmentResults > AssessmentResult > Iterations > Iteration > MetricValues > MetricValue
    //parser.getDataByPath("""//AxeJobResults/AssessmentResults""")
    parser.findnode("AssessmentResults/AssessmentResult/Iterations/Iteration/MetricValues/MetricValue","AverageConsumptionRate")

    //AxeJobResults > AssessmentResults > AssessmentResult > Iterations > Iteration > TestCases > TestCase > MetricValues > MetricValue
    parser.findnode("AssessmentResults/AssessmentResult/Iterations/Iteration/TestCases/TestCase/MetricValues/MetricValue","WorkloadAverageConsumptionRate")
    //parser.getNode()
    //AxeJobRsults > AssessmentResults > AssessmentResult > Iterations > Iteration > MetricValues > MetricValue
    parser.findnode("AssessmentResults/AssessmentResult/Iterations/Iteration/MetricValues/MetricValue","EstimatedFull2Natural")
*/
}