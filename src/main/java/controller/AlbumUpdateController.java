package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.Album;
import bean.CheckBean;
import dao.AlbumDao;

@Controller
public class AlbumUpdateController {
	// 데이터베이스를 사용하기 위해 쓰는 코딩
	@Autowired
	@Qualifier("dao")
	private AlbumDao albumDao;
	
	@ModelAttribute("mediatypelist") // 미디어 유형
	public List<CheckBean> aaa(){
		List<CheckBean> lists = this.albumDao.GetList("album", "mediatype");
		return lists;
	}
	
	@ModelAttribute("emailagreelist") // 이메일 수신 여부 관련
	public List<CheckBean> bbb(){
		List<CheckBean> lists = this.albumDao.GetList("album", "emailagree");
		return lists;
	}
	
	@ModelAttribute("genrelist") // 장르 목록
	public List<CheckBean> ccc(){
		List<CheckBean> lists = this.albumDao.GetList("album", "genre");
		return lists;
	}
	
	private final String commandName = "album"; // 커맨드 이름
	
	@ModelAttribute(commandName)
	public Album some(){
		return new Album();
	}
	
	private final String requesturl = "/update.al"; // 요청 url
	
	private final String gotopage = "alUpdateForm";
	
	// 5.x 버전에서 생긴 어노테이션
	@GetMapping(value = requesturl)
	public ModelAndView doGet(
		@RequestParam(value = "id", required = true) int id) {
		System.out.println("AlbumUpdateController-id : " + id);
		
		Album album = this.albumDao.getAlbumById(id);
		System.out.println("이전 앨범의 정보");
		System.out.println(album.toString());
		
		// 이전 앨범 등록시 기입했던 내용을 수정 폼으로 가져 갑니다.
		// album객체를 가지고 gotopage(alUpdateForm.jsp)파일로 이동
		return new ModelAndView(gotopage, "album", album);
	}
	
	private final String redirect = "redirect:/list.al";
	
	@PostMapping(value = requesturl)
	public ModelAndView doPost(
		@ModelAttribute(commandName) @Valid Album xxx, 
		BindingResult asdf,
		HttpServletRequest request) {
		
		System.out.println("커맨드 객체 정보");
		System.out.println(xxx.toString());
		
		ModelAndView mav = new ModelAndView();
		
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제가 있음");
			System.out.println(asdf.toString());
			mav.setViewName(gotopage);
		} else {
			System.out.println("유효성 검사에 문제가 없음");
			
			MultipartFile multi = xxx.getAbcd();
			String uploadPath = "/WEB-INF/upload";
			String realPath = request.getRealPath(uploadPath);
			
			System.out.println(realPath);
			
			try {
				// 파일 업로드
				File destination = utility.Utility.getUploadFileInfo(multi, realPath);
				multi.transferTo(destination);
				
				// 데이터 베이스에 행을 수정해야 합니다.
				xxx.setImage(destination.getName());
				
				this.albumDao.update(xxx);
				
				mav.setViewName(redirect);
				
			} catch (Exception e) {
				e.printStackTrace();
				// 수정하기 페이지로 다시 이동하되, 
				mav.setViewName("redirect:/update.al" + "?id=" + xxx.getId());
			}
		}
		
		return mav;
	}
}
