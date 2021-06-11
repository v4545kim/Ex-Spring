package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Utility {
	// 업로드될 파일의 정보를 반환해주는 메소드 작성
	public static File getUploadFileInfo(MultipartFile multi, String realPath) {
		// multi : 멀티 파트 객체
		// realpath : 실제 이미지가 업로드 되는 위치
		
		String pattern = "yyyyMMddhhmmss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(new Date());
		
		String somefile = multi.getOriginalFilename();
		System.out.println("somefile : " + somefile);
		
		int dot = somefile.indexOf("."); // 도트의 위치
		
		String filename = somefile.substring(0, dot); // 파일 이름
		String fileext = somefile.substring(dot); // 파일의 확장자
		String newfile = filename + now + fileext; // 신규로 만들어질 파일 이름
		
		String myfile = realPath + File.separator + newfile;
		
		return new File(myfile);
	}
}
