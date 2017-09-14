package haibang.demo.spring.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import haibang.demo.spring.config.AppConstants;

/**
 * This abstract class just to put here to to provide some basic repetitive function which we don't want 
 * to code every time we need a Spring controller. Thing like logging system setup and logging entry or 
 * default error handler should be implemented one only and reuse by app through extending. More stuff can
 * be added here if often need. In larger multi project environment this class can be stuck in a separated
 * shared common module and let maven manage dependency.
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */
public abstract class AbstractController
{
	protected static Logger logger = null;
	public AbstractController()
	{
		logger=LoggerFactory.getLogger(this.getClass());
	}
	
	/**
	 * All unhandle exception by controller during processing will be 
	 * handle by this method. The method will log an entry in log and 
	 * route the error info to default error template.
	 * 
	 * @param  req  HTTP request object
	 * @param  ex	Exception that has not been handled by the controller 
	 * @return      The spring view Model
	 * 
	 */

	@ExceptionHandler(Throwable.class)
	public ModelAndView handleUnknownException(HttpServletRequest req, Throwable ex)
	{
		logger.error("\nError URL: " + req.getRequestURL() + "\nError Message: " + ex.getMessage()+"\nError Type: "+ex.getClass().getName(),ex);
		ModelAndView model = new ModelAndView();		
		model.addObject("errorUrl", req.getRequestURL());
		model.addObject("errorText", ex.getMessage()==null?ex.toString():ex.getMessage());
		model.addObject("errorType", ex.getClass().getName());
		model.setViewName(AppConstants.TEMPLATE_DEFAULT_ERROR);	
		return model;
	}
}
