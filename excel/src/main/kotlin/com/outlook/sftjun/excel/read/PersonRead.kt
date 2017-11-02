package com.outlook.sftjun.excel.read

import com.outlook.sftjun.excel.domain.Person
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import kotlin.collections.ArrayList

/**
 * Created by SftJun on 01/11/2017
 */
class PersonRead {

    /**
     * read person object from excel
     * @param fileName 文件名
     * @return person list from excel
     */
    fun readPerson(fileName: String): List<Person> {
        val excelFileInputStream = FileInputStream(File(fileName))
        val workBook = XSSFWorkbook(excelFileInputStream)
        val personSheet = workBook.getSheetAt(0)
        val rows = personSheet.physicalNumberOfRows

        val personList = ArrayList<Person>()
        // skip first row
        for (i in IntRange(1, rows - 1)) {
            val p = Person(
                    id = BigDecimal(personSheet.getRow(i).getCell(0).toString()).toInt(),
                    name = personSheet.getRow(i).getCell(1).toString(),
                    age = BigDecimal(personSheet.getRow(i).getCell(2).toString()).toInt()
            )
            personList.add(p)
        }
        return personList
    }
}