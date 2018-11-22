package net.ebook.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class PdfUtil {

	
	private static final String Pdf_PATH = "C:/Users/Akshi/git/online-shopping/onlineshopping/src/main/webapp/assets/Pdf/";
	
	private static String Actual_PATH = null;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadPdf(HttpServletRequest request, MultipartFile pdf, String name) 
	{				
		// get the real server path
		Actual_PATH = request.getSession().getServletContext().getRealPath("/assets/Pdf/");
		
		logger.info(Actual_PATH);					
		// create the directories if it does not exist
		
		if(!new File(Actual_PATH).exists()) {
			new File(Actual_PATH).mkdirs();
		}
		
		if(!new File(Pdf_PATH).exists()) {
			new File(Pdf_PATH).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			pdf.transferTo(new File(Actual_PATH + name + ".pdf"));
			pdf.transferTo(new File(Pdf_PATH + name + ".pdf"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	
	public static void uploadNoPdf(HttpServletRequest request, String name) {
		// get the real server path
		Actual_PATH = request.getSession().getServletContext().getRealPath("/assets/Pdf/");
	
		String pdfURL = "http://placehold.it/640X480?text=No Pdf";
		String destinationServerFile = Actual_PATH + name + ".pdf";
		String destinationProjectFile = Actual_PATH + name + ".pdf";
				
		try {
			URL url = new URL(pdfURL);				
			try (	
					InputStream is = url.openStream();
					OutputStream osActual_PATH = new FileOutputStream(destinationServerFile);
					OutputStream osPdf_PATH = new FileOutputStream(destinationProjectFile);
				){
			
				byte[] b = pdfURL.getBytes();
				int length;
				while((length = is.read(b))!= -1) {
					osActual_PATH.write(b, 0, length);
					osPdf_PATH .write(b, 0, length);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
