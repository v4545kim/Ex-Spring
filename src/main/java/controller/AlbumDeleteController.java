package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AlbumDao;

@Controller
public class AlbumDeleteController {
	@Autowired
	@Qualifier("dao")
	private AlbumDao albumDao;
	
	@RequestMapping(value ="/delete.al", method = RequestMethod.GET)
	public ModelAndView handle(
			@RequestParam(value="id", required = true) int id) {
		
		this.albumDao.delete(id);
		
		return new ModelAndView("redirect:/list.al");
	}
}
