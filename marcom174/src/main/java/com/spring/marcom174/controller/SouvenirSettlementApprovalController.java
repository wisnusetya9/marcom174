package com.spring.marcom174.controller;

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
import com.spring.marcom174.model.SouvenirSettlementModel;
import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.EventService;
import com.spring.marcom174.service.MenuService;
import com.spring.marcom174.service.SequenceService;
/*import com.spring.marcom174.service.SouvenirSettlementDetailService;*/
import com.spring.marcom174.service.SouvenirSettlementService;
import com.spring.marcom174.service.SouvenirService;

@Controller
public class SouvenirSettlementApprovalController extends BaseController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SouvenirService souvenirService;
	
	@Autowired
	private SouvenirSettlementService souvenirsettlementService;
	
/*	@Autowired
	private SouvenirSettlementDetailService souvenirsettlementDetailService;
*/	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SequenceService sequenceService;
	
	public void aksesLogin(Model model) {
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		model.addAttribute("menuModelList", menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
	}
	
	@RequestMapping(value="souvenirset_approval")
	public String souvenirReqRequest(Model model) {
		
		this.aksesLogin(model);
		String jsp = "souvenirset_approval/souvenirset_approval";
		return jsp;
	}
	
	@RequestMapping(value="souvenirset_approval/add")
	public String souvenirReqRequestAdd(Model model) {
		String codeGen ="";
		codeGen = this.transactionCodeGenerator();
		model.addAttribute("codeGen", codeGen);
		
		UserModel approvalByUser = this.getUserModel();
		model.addAttribute("approvalByUser", approvalByUser);
		
		Integer approvalBy = this.getUserModel().getId();
		model.addAttribute("approvalBy", approvalBy);
		
		String pattern = "dd-MM-yyyy";
		String approvalDate = this.getDate(pattern);
		model.addAttribute("approvalDate", approvalDate);
		
		this.listDataEvent(model);
		this.listDataSouvenir(model);
						
		String jsp = "souvenirset_approval/add";
		return jsp;
	}
	
	@RequestMapping(value="souvenirset_approval/approve/save")
	public String souvenirReqRequestAddSave(HttpServletRequest request, Model model) {

		Integer id = Integer.valueOf(request.getParameter("id"));
		
		SouvenirSettlementModel souvenirsettlementModelDB = new SouvenirSettlementModel();
		
		try {
			souvenirsettlementModelDB = this.souvenirsettlementService.searchById(id);
			String pilih = request.getParameter("pilih");

			String approved = null;
			if (pilih.equals("approve")) {
				//approved
				approved = "yes";
				Integer approvedBy =  this.getUserModel().getId();
				souvenirsettlementModelDB.setApprovedBy(approvedBy);
				souvenirsettlementModelDB.setApprovedDate(new Date());
				souvenirsettlementModelDB.setStatus(5); //diubah menjadi 5 yaitu approved
				
			}else if (pilih.equals("reject")) {
				//reject
				souvenirsettlementModelDB.setStatus(0); //diubah menjadi 0 yaitu reject
				String rejectReason = request.getParameter("rejectReason");
				souvenirsettlementModelDB.setRejectReason(rejectReason);
			}else {
				
			}
			
			model.addAttribute("approved",approved);
			//audit trail
			Integer updatedBy = this.getUserModel().getId();
			souvenirsettlementModelDB.setUpdatedBy(updatedBy);
			souvenirsettlementModelDB.setUpdatedDate(new Date());
			
			this.souvenirsettlementService.update(souvenirsettlementModelDB);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String jsp = "souvenirset_approval/souvenirset_approval";
		return jsp;
	}
	
	@RequestMapping(value="souvenirset_approval/list")
	public String souvenirRequestList(Model model) {
		List<SouvenirSettlementModel> souvenirsettlementModelList = new ArrayList<SouvenirSettlementModel>();
		souvenirsettlementModelList = this.souvenirsettlementService.selectNotDelete();
		model.addAttribute("souvenirsettlementModelList", souvenirsettlementModelList);
		
		
		String jsp = "souvenirset_approval/list";
		return jsp;
	}
	
	@RequestMapping(value="souvenirset_approval/approval")
	public String souvenirReqRequestDetail(HttpServletRequest approval, Model model) {
		
							
		Integer id = Integer.valueOf(approval.getParameter("id"));
		SouvenirSettlementModel souvenirsettlementModel = new SouvenirSettlementModel();
		
		souvenirsettlementModel = this.souvenirsettlementService.searchById(id);
		model.addAttribute("souvenirsettlementModel", souvenirsettlementModel);
		
		UserModel approvalByUser = this.getUserModel();
		model.addAttribute("approvalByUser", approvalByUser);
		
		Integer approvalBy = this.getUserModel().getId();
		model.addAttribute("approvalBy", approvalBy);
		
		//UserModel untuk menampilkan value username
		UserModel requestByUser = this.getUserModel();
		model.addAttribute("requestByUser",requestByUser);
		
		this.listDataEvent(model);
		this.listDataSouvenir(model);
		
		String jsp = "souvenirset_approval/approval";
		return jsp;
	}
	
	@RequestMapping(value="souvenirset_approval/edit")
	public String souvenirReqRequestEdit(HttpServletRequest approval, Model model) {
		Integer id = Integer.valueOf(approval.getParameter("id"));
		SouvenirSettlementModel souvenirsettlementModel = new SouvenirSettlementModel();
		
		souvenirsettlementModel = this.souvenirsettlementService.searchById(id);
		model.addAttribute("souvenirsettlementModel", souvenirsettlementModel);
		
		UserModel approvalByUser = this.getUserModel();
		model.addAttribute("approvalByUser", approvalByUser);
		
		Integer approvalBy = this.getUserModel().getId();
		model.addAttribute("approvalBy", approvalBy);
		
		this.listDataEvent(model);
		this.listDataSouvenir(model);
		
		String jsp = "souvenirset_approval/edit";
		return jsp;
	}
	
	public String getDate(String pattern) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
	}
	
	public String transactionCodeGenerator() {
		Integer tCode = 0;
		tCode = this.sequenceService.nextIdSouvenirSettlement();
		
		String pattern = "ddMMyy";
		String date = this.getDate(pattern);
		
		String codeAuto  = "";
		
		if (tCode < 10) {
			codeAuto  = "TRSV" +date+ "0000" + tCode;
		}else if (tCode >= 10 && tCode < 100) {
			codeAuto  = "TRSV" +date+ "000" + tCode;
		}else if (tCode >= 100 && tCode < 1000) {
			codeAuto = "TRSV" +date+ "00" + tCode;
		}else if (tCode >=1000) {
			codeAuto = "TRSV" +date+ "0" + tCode;
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