package com.sales.wb.common.constrains;


import org.apache.log4j.Logger;

import com.sales.wb.controller.AreaController;
import com.sales.wb.service.MasterService;
import com.sales.wb.service.imp.MasterServiceImpService;

/*Service Master for using SOAP Web Services 
 * in a Singleton Pattern*/

/*
 * @author : Kruti Jani
 */

public class ServiceMaster {
	private static final Logger log = Logger.getLogger(AreaController.class);
	public static MasterService masterService;
	static {
		masterService = new MasterServiceImpService().getMasterServiceImpPort();
		log.info("****** All Service Port Created Successfully ******");
	}
	public static MasterService getMasterService() {
		return masterService;
	}
	public static void setMasterService(MasterService masterService) {
		ServiceMaster.masterService = masterService;
	}
}
