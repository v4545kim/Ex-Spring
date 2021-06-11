package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AlbumDao;

// @PostMapping, GetMapping
@Controller
public class TemplateController {
	@Autowired
	@Qualifier("dao")
	private AlbumDao albumDao;
	
	@RequestMapping(value="/xxx.al", method = RequestMethod.GET)
	public String doGet() {
		return null;
	}
	
	@RequestMapping(value="/xxx.al", method = RequestMethod.POST)
	public ModelAndView doPost() {
		return null;
	}
}
