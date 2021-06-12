package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Album;
import dao.AlbumDao;

// 앨범 상세 보기
@Controller
public class AlbumDetailController {
	@Autowired
	@Qualifier("dao")
	private AlbumDao albumDao;
	
	@RequestMapping(value = "/detail.al", method = RequestMethod.GET)
	public ModelAndView  handleReuqest(
			@RequestParam(value = "id", required = true) int id ){
		
		Album album = this.albumDao.getAlbumById(id);
		
		ModelAndView mav = new ModelAndView();
		
		String viewName = "alDetail";
		mav.setViewName(viewName);
		mav.addObject("album", album);
		
		return mav;
	}
}
