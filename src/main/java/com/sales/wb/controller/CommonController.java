package com.sales.wb.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.sales.wb.common.constrains.ServiceMaster;
import com.sales.wb.service.CompanyVo;
import com.sales.wb.service.GetCompanyResp;

/**
 * @author kbjani
 *
 */
@Controller
public class CommonController {
	private static final Logger log = Logger.getLogger(CommonController.class);
	
	@RequestMapping(value = "company", method = RequestMethod.GET)
	   public ModelAndView callcompany() {
		log.info("======== Inside callcompany ======");				
		try{	
				GetCompanyResp resp = ServiceMaster.getMasterService().getCompanyDetail();
				ModelAndView modelAndView = new ModelAndView("/master/company");
				for(CompanyVo vo : resp.getCompanyList()){
					 modelAndView.addObject("compname",vo.getCompanyName());
					  modelAndView.addObject("compadd", vo.getCompanyAddress());
					  modelAndView.addObject("phone", vo.getCompanyPhoneNo());
					  modelAndView.addObject("mobile", vo.getCompanyMobileNo());
				}
				return modelAndView;     
		}catch(Exception e){
			e.printStackTrace();			
            return new ModelAndView("/master/company");
		}		      
	  }
}
