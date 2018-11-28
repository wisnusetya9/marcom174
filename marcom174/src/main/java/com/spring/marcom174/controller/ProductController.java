package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.marcom174.model.ProductModel;
/*import com.spring.marcom174.model.UserModel;*/
import com.spring.marcom174.service.ProductService;
import com.spring.marcom174.service.SequenceService;
/*import com.spring.marcom174.service.UserService;*/
import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.service.MenuService;

@Controller
public class ProductController  extends BaseController{
	
	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MenuService menuService;
	
	/*@Autowired
	private UserService userService;*/
	
	//FUngsi utk mngambil Akses Login
	public void aksesLogin(Model model) {
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		/*List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList = this.userService.searchNameRole(idRole);*/
		
		
		model.addAttribute("menuModelList", menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
		
	}
	
	
	@RequestMapping(value="product")
	public String product(Model model) {
		this.aksesLogin(model);
		String jsp = "product/product";
		return jsp;
	}
	
	
	//ADD-----------
	@RequestMapping(value="product/add")
	public String productAdd(Model model) {
		String codeAuto = "";
		codeAuto = this.codeGenerator();
		model.addAttribute("codeAuto", codeAuto);
		
		/*//Untuk Validasi Name not Same
		List<ProductModel> productModelName = new ArrayList<ProductModel>();
		productModelName = this.productService.select();
		model.addAttribute("productModelName", productModelName);*/
		
		
		/*this.listNameProduct(model);*/
		
		String jsp="product/add";
		return jsp;
		
	}
	
	@RequestMapping(value="product/add/save")
	public String productAddSave(HttpServletRequest request, Model model) throws Exception {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		ProductModel productModel = new ProductModel(); //Object productmodel
		//Set productModel
		productModel.setCode(code);
		productModel.setName(name);
		productModel.setDescription(description);
		
		//SET AUDITRAIL CREATED
		productModel.setIsDelete(0);//Belum di hapus
		String createdBy = this.getUserModel().getUsername();
		productModel.setCreatedBy(createdBy);
		productModel.setCreatedDate(new Date());//set Date
		
		this.productService.create(productModel);
		model.addAttribute("productModel", productModel);
		
		String jsp = "product/product";
		return jsp;
	}
	
	
	//LIST------
	@RequestMapping(value="product/list")
	public String productList(Model model) {
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = this.productService.selectNotDelete();
		model.addAttribute("productModelList", productModelList);
		
		String jsp = "product/list";
		return jsp;
	}
	
	//DETAIL----------
	@RequestMapping(value="product/detail")
	public String productDetail(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		ProductModel productModel = new ProductModel();
		productModel = this.productService.searchById(id);
		model.addAttribute("productModel",productModel);
		
		String jsp = "product/detail";
		return jsp;
	}
	
	//DELETE---------
	@RequestMapping(value="product/delete")
	public String productDelete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id")); 
		ProductModel productModel = new ProductModel();
		productModel = this.productService.searchById(id);
		model.addAttribute("productModel", productModel);
		
		String jsp = "product/delete";
		return jsp;
	}
	
	@RequestMapping(value="product/delete/save")
	public String productDeleteSave(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		ProductModel productModel = new ProductModel();
		productModel = this.productService.searchById(id);
		
		//SET AUDITRAIL DELETE/UPDATED
		productModel.setIsDelete(1);// dihapus dari aplikasi
		
		String updatedBy = this.getUserModel().getUsername();
		productModel.setUpdatedBy(updatedBy);//
		productModel.setUpdatedDate(new Date());
		
		this.productService.update(productModel);//jalankan method update di Service
		model.addAttribute("productModel",productModel);
		String jsp = "product/product";
		return jsp;
	}
	
	
	//UPDATED-------------
	@RequestMapping(value="product/edit")
	public String productEdit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		ProductModel productModel = this.productService.searchById(id);
		model.addAttribute("productModel", productModel);
		
		String jsp = "product/edit";
		return jsp;
	}
	@RequestMapping(value="product/edit/save")
	public String productEditSave(HttpServletRequest request,Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		ProductModel productModelDB = this.productService.searchById(id);
		//SET
		productModelDB.setCode(code);
		productModelDB.setName(name);
		productModelDB.setDescription(description);
		
		//SET AUDITRAIL UPDATED
		productModelDB.setIsDelete(0);
		
		String updatedBy = this.getUserModel().getUsername();
		productModelDB.setUpdatedBy(updatedBy);
		productModelDB.setUpdatedDate(new Date());
		
		this.productService.update(productModelDB);//memanggil fungsi update
		model.addAttribute("productModel", productModelDB);
		
		
		String jsp = "product/product";
		return jsp;
	}
	
	//----codeGenerator for ProductCODE----------------
		public String codeGenerator() {
			Integer idProduct = 0;
			idProduct = this.sequenceService.nextIdProduct();
			
			String codeAuto = "";
			if (idProduct<10) {
				codeAuto = "PR000" + idProduct;
			} else if (idProduct>=10 && idProduct<100) {
				codeAuto = "PR00" + idProduct;
			} else if (idProduct >= 100 && idProduct<1000) {
				codeAuto = "PR0" + idProduct;
			} else if (idProduct >= 1000) {
				codeAuto = "PR" + idProduct;
			}else {

			}
			return codeAuto;
		}
		
	
}
