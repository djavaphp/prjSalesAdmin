<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Master</title>
	<link href="<c:url value="/resources/css/sales.css" />" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/jquery-ui/pepper-grinder/jquery-ui-1.8.16.custom.css"/>'/>
	<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/ui.jqgrid-4.3.1.css"/>'/>
	
	
	<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.6.4.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/jquery-ui-1.8.16.custom.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/grid.locale-en-4.3.1.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/jquery.jqGrid.min.4.3.1.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/custom.js"/>'></script>
	<script type='text/javascript'>
	$(function() {
		$("#grid").jqGrid({
		   	url:'getallarea',
			datatype: 'json',
			//mtype: 'GET',
		   	colNames:['Id', 'Area Code', 'Area Name'],
		   	colModel:[
		   		{name:'id',index:'id', width:55, editable:false, editoptions:{readonly:true, size:10},hidden:true},
		   		{name:'acode',index:'acode', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
		   		{name:'aname',index:'aname', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}}		   		
		   	],		  
			rowNum:10,
			multiselect:true,
		   	rowList:[10,20,40,60],
		   	height: 240,
		   	autowidth: true,
			rownumbers: true,
		   	pager: '#pager',
		   	sortname: 'id',
		    viewrecords: true,
		    //sortorder: "asc",
		    caption:"Records",
		    emptyrecords: "Empty records",
		    loadonce: true,
		    onSelectRow: function (id) {
		    	 var gridRow = $(this).getRowData(id);		         
		    	var code=gridRow["acode"];
		    	var areaname=gridRow["aname"];
		      $("#areaID").val(id);
		      $("#areaCode").val(code);
		      $("#areaName").val(areaname);
		    },		  
		}).navGrid('#pager',{edit:false,add:false,del:false,search:false})	;
		/* .navGrid('#pager',{edit:false,add:false,del:false,search:false})	
			.navButtonAdd('#pager',{
			   caption:"Del", 
			   buttonicon:"ui-icon-trash",
			   url: 'xxx.xxx/product/DeleteProduct?productId=',
			   onClickButton: function(){
				   
			   		// Get the currently selected row
					var row = $('#grid').jqGrid('getGridParam','selrow');
					if( row != null ){
						//alert(row);
						
					}else {
						$('#msgbox').text('You must select a record first!');
						$('#msgbox').dialog(
						{ 	title: 'Error',
							modal: true,
							buttons: {"Ok": function() {
								$(this).dialog("close");}
							}
						});
					}
			   }, 
			   position:"last",
			   reloadAfterSubmit: true,
	            closeOnEscape: true
			});
 */
		// Toolbar Search
		$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"}); 
	});
		
	</script>
</head>
<body>
	<div id="main">
		<div id="header">
			<jsp:include page="../menu/headermenu.jsp" />
		</div>
		<div id="middle">
			<div id="left-column">
				<jsp:include page="../menu/leftmenu.jsp" />
			</div>
			<div id="center-column">
				<div class="table">
					<table align="center">
						<tr>
							<td colspan="2">Area Master</td>
						</tr>
					</table>
					<table width="100%">
						<tr>
							<td>
								<fieldset>
									<legend>Add Area</legend>
									<table align="center">	
									<form:form method="POST" action="createarea" modelAttribute="areaform">
										<input type="hidden" id="areaID" name="areaID"/>	
											<tr>
												<td colspan="3" align="center"><font color="green">${message}</font></td>
											</tr>
										
											<tr>
												<td colspan="3" align="center"><font color="red"><form:errors /></font></td>
											</tr>
											<tr>
												<td><form:label path="areaCode"> Area Code :</form:label></td>
												<td><form:input path="areaCode" /></td>
											</tr>
											<tr>
												<td><form:label path="areaName"> Area Name :</form:label></td>
												<td><form:input path="areaName" /></td>
											</tr>
											<tr>
												<td colspan="2" align="center"><input type="submit" id="btnAreaSubmit"
													value="Add Area" /></td>
											</tr>
											</form:form>										
									</table>
								</fieldset>
							</td>
						</tr>
						<tr>
						<td>
								<fieldset>
									<legend>View Area Detail</legend>
									<div id='jqgrid'>
										<table id='grid'></table>
										<div id='pager'></div>
									</div>

									<div id='msgbox' title='' style='display: none'></div>
								</fieldset>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="footer">
			<jsp:include page="../menu/footer.jsp" />
		</div>
	</div>
</body>
</html>