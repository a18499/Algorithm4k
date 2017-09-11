package parser

import org.dom4j.Attribute
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.SAXReader
import java.io.File

class MicrosoftParser{
    val xmlreader = SAXReader()
    lateinit var document:Document
    lateinit var root :Element
    fun init(filepath:String){
        try {
            document =  xmlreader.read(File(filepath))
        }catch (e:Exception){
            println("init failed: ${e.toString()}")
        }
        root = document.rootElement
        println("Parse Complete")
    }
    fun parse(){

        println("root name: ${root.name}")
       // println("All Data: ${printXMLTree()}")
        printElement(root , 0 )
    }
   fun printElement(element:Element , level: Int ){
        // 依照階層print
       var i:Int = 0
        while (i<level){
            i++
            print("\t")
        }
        println("<${element.getQualifiedName() }>")

        // 取得該TAG的Attr
        var attributes = element.attributes()
       for (eachAttr in attributes){
           if(eachAttr is Attribute){
               println("Attr: ${eachAttr.name } == ${eachAttr.value}")
           }
       }
        var iter = element.elementIterator()

        while(iter.hasNext()){
            var next = iter.next()
            if(next is Element){
                printElement(next, level+1 )
            }
        }
        return
    }
    fun getDataByPath(xmlpath:String){
        //printElement(next, 7 )
        var nodes = document.selectNodes(xmlpath)
        println("Node Size: ${nodes.size}")

        if(nodes is Element){
            println("$xmlpath = ${nodes.stringValue}")
            println("${nodes.data}")
        }
        var nodesIt = document.selectNodes(xmlpath).iterator()
       while(nodesIt.hasNext()){
            var next = nodesIt.next()
            if(next is Element){
                println("<${next.getQualifiedName() }>")
                println("$xmlpath = ${next.stringValue}")
            }
        }
    }
}

fun main(args: Array<String>) {
    var filepath ="C:\\Users\\a1849\\Desktop\\JobResults_DESKTOP-41ACUOA_2017-0906_0857-40.801.xml" //args[0]
    //println("File Path $filepath")
    val parser = MicrosoftParser()
    parser.init(filepath)
    //parser.parse()
    //AxeJobRsults > AssessmentResults > AssessmentResult > Iterations > Iteration > MetricValues > MetricValue
    parser.getDataByPath("""/AxeJobResults/AxeJobManifest""")
}