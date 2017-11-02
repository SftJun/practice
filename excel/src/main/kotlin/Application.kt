import com.outlook.sftjun.excel.read.PersonRead

/**
 * Created by SftJun on 01/11/2017
 */
fun main(args: Array<String>) {
    val absolutePath = ClassLoader.getSystemResource("excel/person.xlsx").path
    val personList = PersonRead().readPerson(absolutePath)
    personList.forEach {
        println(it.toString())
    }
}