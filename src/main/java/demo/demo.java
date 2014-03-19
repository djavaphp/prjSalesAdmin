package demo;

import com.sales.wb.common.constrains.ServiceMaster;
import com.sales.wb.service.GetAllBillBookDtlResp;


public class demo {
	public static void main(String ar[]){
		/*stub genrated from MasterServiceImpservice. to use Apache Cxf. Select Project -> Properties 
		-> Project Facate -> select cxf , dynamic web  and , java -> choose server.
        */		 
	  System.out.println(  ServiceMaster.getMasterService().helloworld() );
	  GetAllBillBookDtlResp resp = ServiceMaster.getMasterService().getAllBillBookdtl();
	  System.out.println(resp.getBillBookList().size());
	  System.out.println(resp.getResp().getRespMsg());

	}
}
