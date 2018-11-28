package com.spring.marcom174.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.EventModel;
import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.model.SouvenirModel;
import com.spring.marcom174.model.SouvenirSettlementDetailModel;
import com.spring.marcom174.model.SouvenirSettlementModel;
import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.EventService;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.SequenceService;
import com.spring.marcom174.service.SouvenirService;
import com.spring.marcom174.service.SouvenirSettlementDetailService;
import com.spring.marcom174.service.SouvenirSettlementService;

@Controller
public class SouvenirSettlementRequestController extends BaseController{

	//For Auto GenerateCode
	@Autowired
	private SequenceService sequenceService;
	//For SideBar
	@Autowired
	private MenuService menuService;
	
	//SouvenirSettlement dan SouvenirSettlementDetail
	@Autowired
	private SouvenirSettlementService souvenirSettlementService;
	@Autowired
	private SouvenirSettlementDetailService souvenirSettlementDetailService;
	
	//Join
	@Autowired
	private EventService eventService;
	@Autowired
	private SouvenirService souvenirService;
	
	
	
	public void aksesLogin(Model model) {
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		model.addAttribute("menuModelList", menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
		
	}
	
	@RequestMapping(value="souvenirsettlement_request")
	public String souvenirSettlementRequest(Model model) {
		this.aksesLogin(model);
		String jsp = "souvenirsettlement_request/souvenirsettlement_request";
		return jsp;
	}
	
	
	
	//ADD-------------
	@RequestMapping(value="souvenirsettlement_request/add")
	public String souvenirSettlementRequestAdd(Model model) {
		
		//codeAuto
		String codeAuto = "";
		codeAuto = this.transactionCodeGenerator();
		model.addAttribute("codeAuto", codeAuto);
		
		//request date
		String date = SouvenirSettlementRequestController.getDate2();
		model.addAttribute("date",date);
		
		//memanggil method listevent dan listsouvenir
		this.listDataEvent(model);
		this.listDataSouvenir(model);
		
		//Mengambil Request By//di jsp Hidden
		Integer requestBy = this.getUserModel().getId();
		model.addAttribute("requestBy",requestBy);
		
		//UserModel untuk menampilkan value username
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser",requestByUser);

		
		String jsp ="souvenirsettlement_request/add";
		return jsp;
	}
	//ADD SAVE--------------
	@RequestMapping(value="souvenirsettlement_request/add/save")
	public String souvenirSettlementRequestAddSave(HttpServletRequest request, Model model) throws ParseException {
		//GET data from ADD.jsp
		String code = request.getParameter("code");
		Integer eventCode = Integer.valueOf(request.getParameter("eventName"));
		Integer requestBy = Integer.valueOf(request.getParameter("requestBy"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date requestDate = sdf.parse(request.getParameter("requestDate"));
		Date dueDate = sdf.parse(request.getParameter("dueDate"));
		String note = request.getParameter("note");
		
		//instance model souvenir
		SouvenirSettlementModel souvenirSettlementModel = new SouvenirSettlementModel();
		//SET data to model
		souvenirSettlementModel.setCode(code);
		souvenirSettlementModel.settEventId(eventCode);
		souvenirSettlementModel.setRequestBy(requestBy);
		souvenirSettlementModel.setRequest_date(requestDate);
		souvenirSettlementModel.setNote(note);
		souvenirSettlementModel.setDueDate(dueDate);
		souvenirSettlementModel.setStatus(1);
		//AuditTrail
		souvenirSettlementModel.setIsDelete(0);
		
		//getCreatedBy
		Integer createdBy = this.getUserModel().getId();
		souvenirSettlementModel.setCreatedBy(createdBy);
		//SET DATE
		souvenirSettlementModel.setCreatedDate(new Date());
		
		this.souvenirSettlementService.create(souvenirSettlementModel);
		model.addAttribute("souvenirSettlementModel",souvenirSettlementModel);
		
		//Add Item--input Model ke  SouvenirSettlementDetailMOdel
		String jumlahDetail = request.getParameter("numberRow");
		int jumlahDetailInteger = Integer.valueOf(jumlahDetail) + 1; // ditambah satu karena start dari 0;

		for (int i = 0; i < jumlahDetailInteger; i++) {

			if (request.getParameter("idSouvenir_" + i) != null) {

				String souvenir = request.getParameter("idSouvenir_" + i);
				String[] result = souvenir.split("-");

				Integer idSouvenir = Integer.valueOf(result[0]);
				Integer qtyTrxSvrItem = Integer.valueOf(request.getParameter("qty_" + i));
				String noteTrxSvrItem = request.getParameter("note_" + i);

				// set variable2 tsb ke dalam modelnya
				SouvenirSettlementDetailModel souvenirSettlementDetailModel = new SouvenirSettlementDetailModel();

				souvenirSettlementDetailModel.settSouvenirSettlementId(souvenirSettlementModel.getId()); // set id trans souvenir (dengan
																						// mengambil gettSouvenirSettlementId)
				souvenirSettlementDetailModel.setmSouvenirId(idSouvenir); // set id M_SOUVENIR_ID (combo box)
				souvenirSettlementDetailModel.setQty(qtyTrxSvrItem);
				souvenirSettlementDetailModel.setNote(noteTrxSvrItem);

				// audit trail
				souvenirSettlementDetailModel.setCreatedBy(this.getUserModel().getId());
				souvenirSettlementDetailModel.setCreatedDate(new Date());
				souvenirSettlementDetailModel.setIsDelete(0);

				this.souvenirSettlementDetailService.create(souvenirSettlementDetailModel); // save designItem sebanyak baris di add

			}
		}
		
		String jsp = "souvenirsettlement_request/souvenirsettlement_request";
		return jsp;
	}
	
	
	
	//LIST---------------
	@RequestMapping(value="souvenirsettlement_request/list")
	public String souvenirSettlementRequestList(Model model) {
		List<SouvenirSettlementModel> souvenirSettlementModelList = new ArrayList<SouvenirSettlementModel>();
		souvenirSettlementModelList = this.souvenirSettlementService.selectNotDelete();
		model.addAttribute("souvenirSettlementModelList",souvenirSettlementModelList);
		UserModel createdtByUser = this.getUserModel();
		model.addAttribute("createdtByUser",createdtByUser);
		String jsp = "souvenirsettlement_request/list";
		return jsp;
	}
	
	//DETAIL-------------------
	@RequestMapping(value="souvenirsettlement_request/detail")
	public String souvenirSettlementRequestDetail(HttpServletRequest request, Model model ) {
		
		//memanggil method listevent dan listsouvenir
		this.listDataEvent(model);
		this.listDataSouvenir(model);
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirSettlementModel souvenirSettlementModel = new SouvenirSettlementModel();

		souvenirSettlementModel = this.souvenirSettlementService.searchById(id);
		model.addAttribute("souvenirSettlementModel",souvenirSettlementModel);
		
		//Mengambil Request By//di jsp Hidden
		Integer requestBy = this.getUserModel().getId();
		model.addAttribute("requestBy",requestBy);
		
		//UserModel untuk menampilkan value username
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser",requestByUser);
		
		String jsp = "souvenirsettlement_request/detail";
		return jsp;
	}
	
	//SETTLEMENT
	@RequestMapping(value="souvenirsettlement_request/settlement")
	public String souvenirSettlementRequestSettlement(HttpServletRequest request, Model model ) {
	
		//memanggil method listevent dan listsouvenir
		this.listDataEvent(model);
		this.listDataSouvenir(model);
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		SouvenirSettlementModel souvenirSettlementModel = new SouvenirSettlementModel();
		souvenirSettlementModel = this.souvenirSettlementService.searchById(id);
		model.addAttribute("souvenirSettlementModel",souvenirSettlementModel);
		
		//Mengambil Request By//di jsp Hidden
		Integer requestBy = this.getUserModel().getId();
		model.addAttribute("requestBy",requestBy);
		//UserModel untuk menampilkan value username
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser",requestByUser);
		
		String jsp = "souvenirsettlement_request/settlement";
		return jsp;
	}
	
	//SETTLEMENT SAVE
	@RequestMapping("souvenirsettlement_request/settlement/save")
	public String souvenirSettlementRequestSettlementSave(HttpServletRequest request, Model model) {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer idDetail = Integer.valueOf(request.getParameter("idDetail"));
		SouvenirSettlementModel  souvenirSettlementModel= new SouvenirSettlementModel();
		SouvenirSettlementDetailModel  souvenirSettlementDetailModel= new SouvenirSettlementDetailModel();
		souvenirSettlementModel = this.souvenirSettlementService.searchById(id);
		souvenirSettlementDetailModel = this.souvenirSettlementDetailService.searchById(idDetail);
				
		Integer qtyActual = Integer.valueOf(request.getParameter("qtyActual"));
		souvenirSettlementDetailModel.setQtySettlement(qtyActual);
		souvenirSettlementModel.setSettlementDate(new Date());
		souvenirSettlementModel.setStatus(4);
		
		this.souvenirSettlementDetailService.update(souvenirSettlementDetailModel);
		this.souvenirSettlementService.update(souvenirSettlementModel);
		
		model.addAttribute("souvenirSettlementModel",souvenirSettlementModel);
		
		String jsp="souvenirsettlement_request/souvenirsettlement_request";
		return jsp;
	}
	
	
	//DATE for Code Gen------
	private static String getDate()  {
		String pattern ="ddMMyy";    
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
		   
	}
	//Date for Duedate
	private static String getDate2()  {
		String pattern ="dd-MM-yyyy";    
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
		   
	}
	
	
	//----codeGenerator for TransactionCode--------------
	private String transactionCodeGenerator() {
		Integer idSouvenirSettlement = 0;
		idSouvenirSettlement = this.sequenceService.nextIdSouvenirSettlement();
		
		String date = SouvenirSettlementRequestController.getDate();
		
		String codeAuto = "";
		if (idSouvenirSettlement<10) {
			codeAuto = "TRSV" + date + "0000" +idSouvenirSettlement;
		} else if (idSouvenirSettlement>=10 && idSouvenirSettlement<100) {
			codeAuto = "TRSV" + date + "000" +idSouvenirSettlement;
		} else if (idSouvenirSettlement>=100 && idSouvenirSettlement<1000) {
			codeAuto = "TRSV" + date + "00" +idSouvenirSettlement;
		}else if (idSouvenirSettlement>=1000 && idSouvenirSettlement<10000) {
			codeAuto = "TRSV" + date + "0" +idSouvenirSettlement;
		}else if (idSouvenirSettlement>=10000 && idSouvenirSettlement<100000) {
			codeAuto = "TRSV" + date + idSouvenirSettlement;
		}else {
			
		}
		return codeAuto;
	}
	
	//JOIN TABLE M_EVENT
	private void listDataEvent(Model model) {
		List<EventModel> eventModelList = new ArrayList<EventModel>();
		eventModelList = this.eventService.select();
		model.addAttribute("eventModelList", eventModelList);
	}
	
	//JOIN TABLE M_SOUVENIR
	private void listDataSouvenir(Model model) {
		List<SouvenirModel> souvenirModelList = new ArrayList<SouvenirModel>();
		souvenirModelList = this.souvenirService.select();
		model.addAttribute("souvenirModelList" ,souvenirModelList);
	}
	
	
}
