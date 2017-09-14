package haibang.demo.spring.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import haibang.demo.spring.service.ClaimInfoService;
/**
 * This simple controller class will handle all request for record management 
 * associate with Person's claims. It s light in functionality at the moment since most of 
 * data access delegated to the ClaimInfoService class
 * 
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */
@Controller
@RequestMapping("/views/claim/*")
public class ClaimCtrl extends AbstractController
{

	@Autowired
	private ClaimInfoService claimService;
	
	@RequestMapping(path="personclaims", produces="application/json")
	@ResponseBody
	public List<Claim> getPersonClaims(
			@RequestParam(value = "personId", required = false, defaultValue = "0") 
			String selectedPerson,
			Model model)
	{
		List<Claim> list=claimService.getPersonClaims(selectedPerson);
		for(Claim c: list)
		{
			//Stop JSon serialiser from traverse the the whole JPA graph and 
			//endup in a loop which cause stackover flow
			c.setPerson(null);
		}
		return list;
	}
	
	/**
	 * This method query the entity manager for all the person and return a list
	 * of person available. 
	 * 
	 * @return      List of Person from backend, if nothing found return empty list
	 * 
	 */
	
	@RequestMapping(path="bypersonid")
	public String listPersonClaims(
			@RequestParam(value = "personId", required = true, defaultValue = "0") 
			String personId,
			Model model)
	{
		//Get the this claim list associate with personId from claim service
		List<Claim> claimList=claimService.getPersonClaims(personId);
		model.addAttribute("claimList", claimList);
		
		return AppConstants.TEMPLATE_PERSON_CLAIMS;
	}
	/**
	 * This method query the entity manager for all the person and return a list
	 * of person available. 
	 * 
	 * @return      List of Person from backend, if nothing found return empty list
	 * 
	 */
	
	@RequestMapping(path="list")
	public String listAll(Model model)
	{
		//Get the this claim list associate with personId from claim service
		List<Claim> claimList=claimService.getAllClaims();
		model.addAttribute("claimList", claimList);
		
		return AppConstants.TEMPLATE_CLAIM_LIST;
	}

}
