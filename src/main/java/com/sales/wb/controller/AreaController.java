package com.sales.wb.controller;


import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.sales.wb.common.constrains.ServiceMaster;
import com.sales.wb.common.constrains.WebConstrains;
import com.sales.wb.form.AreaForm;
import com.sales.wb.service.AreaVO;

import com.sales.wb.service.Resp;



@Controller
public class AreaController {
	private static final Logger log = Logger.getLogger(AreaController.class);
	
	
	@RequestMapping(value = "/area", method = RequestMethod.GET)
	   public ModelAndView callArea() {
		log.info("======== Inside callArea ======");
		
	      return new ModelAndView("addArea", "command", new AreaForm());
	   }
	
	@RequestMapping(value = "/createarea", method = RequestMethod.POST)
	public String insertArea(@ModelAttribute("areaForm")	AreaForm areaform, BindingResult result) {
		log.info("======== Inside Add Area ======");
		log.info(areaform.getAreaCode());
		log.info(areaform.getAreaName());
		AreaVO vo = new AreaVO();
		vo.setAreaCode(areaform.getAreaCode());
		vo.setAreaName(areaform.getAreaName());		
		  Resp resp = ServiceMaster.getMasterService().createArea(vo);
		  if(resp.getRespCode().value().equalsIgnoreCase(WebConstrains.SUCCESS)){
			  log.info(resp.getRespMsg().toString());
		  }else{
			  log.info(resp.getRespMsg().toString());
		  }		
		return "redirect:/index";
	}
}
