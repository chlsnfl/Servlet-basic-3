package web07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.validator.routines.UrlValidator;

public class WebPageReader {
	
	//필드
	private String webpage;
	private String content;
	
	//생성자
	public WebPageReader setwebPageName(String name) {
		webpage = name;
		return this;
	}
	
	//메소드
	public String getwebPageContent() {
		try {
			boolean valid = validateUrl(webpage);
			
			if(!valid) {
				content = "Invalid URL; use http(s)://www.test.com format";
				return content;
			}
			
			URL url = new URL(webpage);
			
			try(InputStream is = url.openStream();
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is, StandardCharsets.UTF_8))){
				content = br.lines().collect(
					Collectors.joining(System.lineSeparator()));
				}
			}catch(IOException e) {
				content = String.format("Cannot read webpage %s", e);
				Logger.getLogger(WebPageReader.class.getName()).log(Level.SEVERE, null, e);
			}
			return content;
		}
	
	private boolean validateUrl(String webpage) {
		UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid(webpage);
	}
}
