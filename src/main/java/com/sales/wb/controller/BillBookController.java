package com.sales.wb.controller;


import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.sales.wb.common.constrains.ServiceMaster;
import com.sales.wb.common.constrains.WebConstrains;

import com.sales.wb.form.BillBookForm;

import com.sales.wb.service.BillBookVo;
import com.sales.wb.service.GetAllBillBookDtlResp;


import com.sales.wb.service.Resp;



@Controller
public class BillBookController {
	private static final Logger log = Logger.getLogger(BillBookController.class);
	
	
	@RequestMapping(value = "billbook", method = RequestMethod.GET)
	   public ModelAndView callBillBook() {
		log.info("======== Inside callBillBook ======");		
	      return new ModelAndView("/master/billbookmaster", "billbookform", new BillBookForm());
	   }
	
	@RequestMapping("/getallbillbook")
	public void getallBillbook(HttpServletRequest request,HttpServletResponse response) {
		
		 try{
			PrintWriter out = response.getWriter();
			List<BillBookVo> list;
			GetAllBillBookDtlResp resp = ServiceMaster.getMasterService().getAllBillBookdtl();
			list = resp.getBillBookList();
			if (list != null && !list.isEmpty()) {
				String rows = request.getParameter("rows");
				String pageno = request.getParameter("page");
				String cpage = pageno;

				int count = 0;
				count = list.size();

				int pageval = 0;
				pageval = (count / Integer.parseInt(rows));

				int limitstart = 0;

				limitstart = (Integer.parseInt(rows) * Integer.parseInt(pageno))- Integer.parseInt(rows);
				int total = count / Integer.parseInt(rows);
				String totalrow = String.valueOf(total + 1);

				JSONObject responcedata = new JSONObject();
				net.sf.json.JSONArray cellArray = new net.sf.json.JSONArray();
				net.sf.json.JSONArray cell = new net.sf.json.JSONArray();
				net.sf.json.JSONObject cellObj = new net.sf.json.JSONObject();

				for (BillBookVo vo : list) {
					if (vo != null) {
						cellObj.put("id", vo.getBillBookId());
						cell.add(vo.getBillBookId());
						cell.add(vo.getBillBookNum());
						cell.add(vo.getStartRange());
						cell.add(vo.getEndRange());

						cellObj.put("cell", cell);
						cell.clear();
						cellArray.add(cellObj);
					}
				}
				responcedata.put("total", totalrow);
				responcedata.put("page", cpage);
				responcedata.put("records", count);
				responcedata.put("rows", cellArray);
				out.println(responcedata);

			}
		} catch (Exception e) {
			System.out.println("There is some error");
		}
	}
		
		
	
	@RequestMapping(value = "createbillbook" ,method=RequestMethod.POST)
	public ModelAndView insertArea(@ModelAttribute("billbookform")	BillBookForm billbookform, BindingResult bindingResult,
			HttpServletRequest request,HttpServletResponse response) {		
		log.info(billbookform.getBillbookId());
		log.info(billbookform.getBillbooknum());
		log.info(billbookform.getEndrange());
		log.info(billbookform.getStartrange());
		try{	
			BillBookVo vo = new BillBookVo();
			vo.setBillBookNum(billbookform.getBillbooknum());
			vo.setEndRange(billbookform.getEndrange());
			vo.setStartRange(billbookform.getStartrange());
			
			Resp resp;
			if(billbookform.getBillbookId().trim()!=null && billbookform.getBillbookId().trim().length()>0){
				log.info("=== Inside Updating Bill Book dtl ===");
				vo.setBillBookId(Long.parseLong(billbookform.getBillbookId().trim()));
				resp= ServiceMaster.getMasterService().updateBillbook(vo);
			}else{
				log.info("=== Inside Adding Bill Book dtl ===");				
				resp= ServiceMaster.getMasterService().createBillBook(vo);
			}
			  if(resp.getRespCode().value().equalsIgnoreCase(WebConstrains.SUCCESS)){
				  log.info("-- Success : "+resp.getRespMsg().toString());			 
				  ModelAndView modelAndView = new ModelAndView("/master/billbookmaster");
				  modelAndView.addObject("message", resp.getRespMsg().toString());
	              return modelAndView;              
			  }else{
				  log.info("-- error :"+resp.getRespMsg().toString());
				  bindingResult.addError(new ObjectError("Invalid", resp.getRespMsg()));
	              return new ModelAndView("/master/billbookmaster","billbookform",billbookform);
			  }
		}catch(Exception e){
			e.printStackTrace();
			bindingResult.addError(new ObjectError("Invalid",e.getMessage()));
            return new ModelAndView("/master/billbookmaster", "billbookform",billbookform);
		}		
	}

}
