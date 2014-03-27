package com.sales.wb.controller;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

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
import com.sales.wb.service.GetAreaDtlResp;

import com.sales.wb.service.Resp;



@Controller
public class AreaController {
	private static final Logger log = Logger.getLogger(AreaController.class);
	
	
	@RequestMapping(value = "area", method = RequestMethod.GET)
	   public ModelAndView callArea() {
		log.info("======== Inside callArea ======");		
	      return new ModelAndView("/master/addArea", "command", new AreaForm());
	   }
	
	@RequestMapping("/getallarea")
	public void getallArea(HttpServletRequest request,HttpServletResponse response) {
		
		 try{
			 PrintWriter out = response.getWriter();
		List <AreaVO> list;
		 GetAreaDtlResp resp = ServiceMaster.getMasterService().getAreaMasterDtl();
		 list= resp.getList();
		if(list != null && !list.isEmpty()) {
	          
	        	   String rows=request.getParameter("rows");
	               String pageno=request.getParameter("page");
	               String cpage=pageno;

	               int count=0;	              
	               count=resp.getList().size(); 

	               int  pageval=0;
	               pageval=(count/Integer.parseInt(rows));

	               int limitstart=0;

	               limitstart=(Integer.parseInt(rows)*Integer.parseInt(pageno))-Integer.parseInt(rows);
	               int total=count/Integer.parseInt(rows);
	               String totalrow=String.valueOf(total+1);

	               
	            JSONObject responcedata=new JSONObject();	            
	            net.sf.json.JSONArray cellArray=new net.sf.json.JSONArray();
	            net.sf.json.JSONArray cell=new net.sf.json.JSONArray();
	            net.sf.json.JSONObject cellObj=new net.sf.json.JSONObject();
	                 
	            for(AreaVO vo : list) {
	             if(vo!= null) {
	            	   
	              cellObj.put("id",vo.getAreaID());
	              cell.add(vo.getAreaID());
	              cell.add(vo.getAreaCode().toString());
	              cell.add(vo.getAreaName());
	              
	              cellObj.put("cell", cell);
	              cell.clear();
	              cellArray.add(cellObj);
	              
	             }
	            }
	            responcedata.put("total",totalrow);
	            responcedata.put("page",cpage);
	            responcedata.put("records",count);	           
	            responcedata.put("rows",cellArray);
	            out.println(responcedata);
	          
	          }
		 }catch(Exception e) {
	            System.out.println("There is some error");
	           }
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
