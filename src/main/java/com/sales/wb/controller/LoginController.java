package com.sales.wb.controller;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sales.wb.common.constrains.ServiceMaster;
import com.sales.wb.common.constrains.WebConstrains;
import com.sales.wb.form.LoginForm;
import com.sales.wb.service.EmployeeMasterVO;
import com.sales.wb.service.Resp;

/**
 * @author kbjani
 *
 */
@Controller
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	 /**
     * This method will load the login.jsp page when the application starts
     */
    @RequestMapping(value = "/calllogin",method = RequestMethod.GET)
    public ModelAndView callLoging() {  
    	log.info("======== Inside login INIT ======");
        return new ModelAndView("login", "loginform", new LoginForm());
    }
	
    /**
     * This method will be called when the user submits the login details from login.jsp page.
     * If there is any error it will be displayed on the same page, if the user is valid then, will
     * be redirected to success page.
     *
     * @param loginform
     * @param bindingResult
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginform")LoginForm loginform, BindingResult bindingResult, 
    		HttpServletRequest request, HttpServletResponse response){
        try{
        	log.info("======== Inside login ======");
    		log.info(loginform.getEmpCode());
    		log.info(loginform.getPassword());	
            // Using Spring ValidationUtils class to check for empty fields.
            // This will add the error if any in the bindingResult object.
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"empCode","empCode", "Employee Code can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"password","password", "Password not be empty");
 
            if (bindingResult.hasErrors()){
                //returning the errors on same page if any errors..
                return new ModelAndView("login", "loginform", loginform);
            }else{
                // If the user details is validated then redirecting the user to success page,
                // else returning the error message on login page.
            	EmployeeMasterVO vo = new EmployeeMasterVO();
            	vo.setEmpCode(loginform.getEmpCode());
            	vo.setPassword(loginform.getPassword());
            	Resp resp = ServiceMaster.getMasterService().authenticateUser(vo);
            	log.info("++ Resp form Service : "+ resp.getRespMsg());
                if(resp.getRespCode().value().equalsIgnoreCase(WebConstrains.SUCCESS)){
                	//put login details into session
                    request.getSession().setAttribute("login", loginform);
                    //Creating a redirection view to success page. This will redirect to UsersController
                    RedirectView redirectView = new RedirectView("welcome", true);
                    return new ModelAndView(redirectView);
                }else{
                    bindingResult.addError(new ObjectError("Invalid", resp.getRespMsg()));
                    return new ModelAndView("login", "loginform",loginform);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in LoginController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("login", "loginform", new LoginForm());
        }
    }
    
    /**
     * This method will load the welcome.jsp page when the application starts
     */
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView callWelcome() {  
    	log.info("======== Inside login INIT ======");
        return new ModelAndView("welcome", "", "");
    }
    
}
