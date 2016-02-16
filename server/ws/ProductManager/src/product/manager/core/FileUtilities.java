package product.manager.core;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class FileUtilities {
	
	/**
	 * Save JsonOjbect to file. Travel the content and make the decision to save:
	 * TODO- if the object is null, ignore the object
	 * TODO- if the array is null, ignore the array 
	 * @param fileName
	 * @param content
	 * @return
	 */
	public boolean save (String fileName, JsonObject content) {
		OutputStream output = getOutput(fileName);
		JsonWriter jsonWriter = Json.createWriter(output);
		jsonWriter.write(content);
		jsonWriter.close();
		return true;
	}
	
	
	private OutputStream getOutput (String fileName) {
		OutputStream ot =  null;
		File f = null;
		try {
			f = createFileIfNotExist(fileName);
			ot = new BufferedOutputStream(new FileOutputStream(f), 1024);
		} catch (Exception e) {
			// Do Nothing
		}
		return ot;
	}
	
	
	private File createFileIfNotExist (String fileName) throws Exception{
		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
		}
		return f;
	}
	
	
	
	/**
	 * Return file name: path/domain_category_yymmdd
	 * @param data
	 * @param path
	 * @return
	 */
	public String generateFileName (JsonObject data, String path) {
		String fileName = ".txt";
		String domain = getDomain(data.getString(ProductFields.URL));
		String currentDate = getDate();
		fileName = domain + "_" + data.getString(ProductFields.CATEGORY) + "_" + currentDate + fileName;
		return path + File.separator + fileName;
	}
	
	
	/*
	 * (?http://)?([a-zA-Z_0-9\\-]+(?\\.\\w[a-zA-Z_0-9\\-]+))+(?/[#&\\n\\-=?\\+\\%/\\.\\w]+)?
	 */
	private String getDomain (String urlStr) {
		String domain = ProductFields.NODOMAIN;
		String regex = "(?:http://)?([a-zA-Z_0-9\\-]+(?:\\.\\w[a-zA-Z_0-9\\-]+))+(?:/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
		Matcher matcher = (Pattern.compile(regex)).matcher(urlStr);
		if (matcher.find()) {
			domain = matcher.group(1);
		}
		return domain;
	}
	
	
	private String getDate () {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yymmdd'T'hhmmss");
		return simpleDateFormat.format(new Date());
	}

}
