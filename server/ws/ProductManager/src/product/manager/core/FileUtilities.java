package product.manager.core;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
		fileName = domain + "_" + data.getString(ProductFields.CATEGORY) + fileName;
		return path + File.separator + fileName;
	}
	
	
	/*
	 * (?http://)?([a-zA-Z_0-9\\-]+(?\\.\\w[a-zA-Z_0-9\\-]+))+(?/[#&\\n\\-=?\\+\\%/\\.\\w]+)?
	 */
	private String getDomain (String urlStr) {
		String domain = "NoDomain";
		System.out.println(urlStr);
		String regex = "(?:http://)?([a-zA-Z_0-9\\-]+(?:\\.\\w[a-zA-Z_0-9\\-]+))+(?:/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(urlStr);
		if (matcher.find()) {
			domain = matcher.group(1);
		}
		
		System.out.println(domain);
		return domain;
	}

}
