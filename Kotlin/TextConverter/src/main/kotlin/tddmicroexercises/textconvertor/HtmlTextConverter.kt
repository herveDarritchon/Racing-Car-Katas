package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class HtmlTextConverter
{
    private var fullFilenameWithPath : String? = null

    fun HtmlTextConverter(fullFilenameWithPath: String)
    {
        this.fullFilenameWithPath = fullFilenameWithPath
    }

    fun convertToHtml() : String {

	    val reader : BufferedReader = BufferedReader(FileReader(fullFilenameWithPath))

	    var line : String = reader.readLine()
	    var html : String = ""

	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line)
	        html += "<br />"
	        line = reader.readLine()
	    }
	    return html

    }

	fun getFilename() : String? {
		return this.fullFilenameWithPath;
	}
}
