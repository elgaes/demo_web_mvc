package haibang.demo.spring.web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import haibang.demo.jpa.Claim;
import haibang.demo.spring.config.AppConstants;
import haibang.demo.spring.service.PersonInfoService;
/**
 * This simple controller class will handle all request to Person record 
 * management. It s light in functionality at the moment since most of 
 * data access delegated to the PersonInfoService class
 * 
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */
@Controller
@RequestMapping("/views/person/*")
public class PersonCtrl extends AbstractController
{
	@Autowired
	private PersonInfoService personService;

	@GetMapping("list")
	public String listAll(Model model)
	{
		model.addAttribute("personList", personService.getAllPersons());
		return AppConstants.TEMPLATE_PERSON_LIST;
	}

}
