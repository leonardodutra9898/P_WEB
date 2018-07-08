package br.ufc.crateus.os.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="controlesBean")
@SessionScoped
public class PermissoesPaginas implements Serializable{

	/**
	 * 
	 */
	private  final long serialVersionUID = 1L;
	
	
	private boolean adminOsNew;
	private  boolean adminOsEdit;
	private  boolean adminOsDelete;
	private  boolean adminOsList;	
	
	private  boolean tecOsNew;
	private  boolean tecOsEdit;
	private  boolean tecOsDelete;
	private  boolean tecOsList;	
	
	private  boolean gerOsNew;
	private  boolean gerOsEdit;
	private  boolean gerOsDelete;
	private  boolean gerOsList;
	
	private  boolean supOsNew;
	private  boolean supOsEdit;
	private  boolean supOsDelete;
	private  boolean supOsList;


	
	
	private  boolean adminFinanceiroNew;
	private  boolean adminFinanceiroEdit;
	private  boolean adminFinanceiroDelete;
	private  boolean adminFinanceiroList;	
	
	private  boolean tecFinanceiroNew;
	private  boolean tecFinanceiroEdit;
	private  boolean tecFinanceiroDelete;
	private  boolean tecFinanceiroList;	
	
	private  boolean gerFinanceiroNew;
	private  boolean gerFinanceiroEdit;
	private  boolean gerFinanceiroDelete;
	private  boolean gerFinanceiroList;
	
	private  boolean supFinanceiroNew;
	private  boolean supFinanceiroEdit;
	private  boolean supFinanceiroDelete;
	private  boolean supFinanceiroList;

	
	
	
	
	private  boolean adminFuncionarioNew;
	private  boolean adminFuncionarioEdit;
	private  boolean adminFuncionarioDelete;
	private  boolean adminFuncionarioList;	
	
	private  boolean tecFuncionarioNew;
	private  boolean tecFuncionarioEdit;
	private  boolean tecFuncionarioDelete;
	private  boolean tecFuncionarioList;	
	
	private  boolean gerFuncionarioNew;
	private  boolean gerFuncionarioEdit;
	private  boolean gerFuncionarioDelete;
	private  boolean gerFuncionarioList;
	
	private  boolean supFuncionarioNew;
	private  boolean supFuncionarioEdit;
	private  boolean supFuncionarioDelete;
	private  boolean supFuncionarioList;

	
	
	
	
	
	private  boolean adminClienteNew;
	private  boolean adminClienteEdit;
	private  boolean adminClienteDelete;
	private  boolean adminClienteList;	
	
	private  boolean tecClienteNew;
	private  boolean tecClienteEdit;
	private  boolean tecClienteDelete;
	private  boolean tecClienteList;	
	
	private  boolean gerClienteNew;
	private  boolean gerClienteEdit;
	private  boolean gerClienteDelete;
	private  boolean gerClienteList;
	
	private  boolean supClienteNew;
	private  boolean supClienteEdit;
	private  boolean supClienteDelete;
	private  boolean supClienteList;
	
	private boolean leo = true;

	
	
	public boolean isLeo() {
		return leo;
	}
	public void setLeo(boolean leo) {
		this.leo = leo;
	}
	public boolean isAdminOsNew() {
		return adminOsNew;
	}
	public void setAdminOsNew(boolean adminOsNew) {
		this.adminOsNew = adminOsNew;
	}
	public boolean isAdminOsEdit() {
		return adminOsEdit;
	}
	public void setAdminOsEdit(boolean adminOsEdit) {
		this.adminOsEdit = adminOsEdit;
	}
	public boolean isAdminOsDelete() {
		return adminOsDelete;
	}
	public void setAdminOsDelete(boolean adminOsDelete) {
		this.adminOsDelete = adminOsDelete;
	}
	public boolean isAdminOsList() {
		return adminOsList;
	}
	public void setAdminOsList(boolean adminOsList) {
		this.adminOsList = adminOsList;
	}
	public boolean isTecOsNew() {
		return tecOsNew;
	}
	public void setTecOsNew(boolean tecOsNew) {
		this.tecOsNew = tecOsNew;
	}
	public boolean isTecOsEdit() {
		return tecOsEdit;
	}
	public void setTecOsEdit(boolean tecOsEdit) {
		this.tecOsEdit = tecOsEdit;
	}
	public boolean isTecOsDelete() {
		return tecOsDelete;
	}
	public void setTecOsDelete(boolean tecOsDelete) {
		this.tecOsDelete = tecOsDelete;
	}
	public boolean isTecOsList() {
		return tecOsList;
	}
	public void setTecOsList(boolean tecOsList) {
		this.tecOsList = tecOsList;
	}
	public boolean isGerOsNew() {
		return gerOsNew;
	}
	public void setGerOsNew(boolean gerOsNew) {
		this.gerOsNew = gerOsNew;
	}
	public boolean isGerOsEdit() {
		return gerOsEdit;
	}
	public void setGerOsEdit(boolean gerOsEdit) {
		this.gerOsEdit = gerOsEdit;
	}
	public boolean isGerOsDelete() {
		return gerOsDelete;
	}
	public void setGerOsDelete(boolean gerOsDelete) {
		this.gerOsDelete = gerOsDelete;
	}
	public boolean isGerOsList() {
		return gerOsList;
	}
	public void setGerOsList(boolean gerOsList) {
		this.gerOsList = gerOsList;
	}
	public boolean isSupOsNew() {
		return supOsNew;
	}
	public void setSupOsNew(boolean supOsNew) {
		this.supOsNew = supOsNew;
	}
	public boolean isSupOsEdit() {
		return supOsEdit;
	}
	public void setSupOsEdit(boolean supOsEdit) {
		this.supOsEdit = supOsEdit;
	}
	public boolean isSupOsDelete() {
		return supOsDelete;
	}
	public void setSupOsDelete(boolean supOsDelete) {
		this.supOsDelete = supOsDelete;
	}
	public boolean isSupOsList() {
		return supOsList;
	}
	public void setSupOsList(boolean supOsList) {
		this.supOsList = supOsList;
	}
	public boolean isAdminFinanceiroNew() {
		return adminFinanceiroNew;
	}
	public void setAdminFinanceiroNew(boolean adminFinanceiroNew) {
		this.adminFinanceiroNew = adminFinanceiroNew;
	}
	public boolean isAdminFinanceiroEdit() {
		return adminFinanceiroEdit;
	}
	public void setAdminFinanceiroEdit(boolean adminFinanceiroEdit) {
		this.adminFinanceiroEdit = adminFinanceiroEdit;
	}
	public boolean isAdminFinanceiroDelete() {
		return adminFinanceiroDelete;
	}
	public void setAdminFinanceiroDelete(boolean adminFinanceiroDelete) {
		this.adminFinanceiroDelete = adminFinanceiroDelete;
	}
	public boolean isAdminFinanceiroList() {
		return adminFinanceiroList;
	}
	public void setAdminFinanceiroList(boolean adminFinanceiroList) {
		this.adminFinanceiroList = adminFinanceiroList;
	}
	public boolean isTecFinanceiroNew() {
		return tecFinanceiroNew;
	}
	public void setTecFinanceiroNew(boolean tecFinanceiroNew) {
		this.tecFinanceiroNew = tecFinanceiroNew;
	}
	public boolean isTecFinanceiroEdit() {
		return tecFinanceiroEdit;
	}
	public void setTecFinanceiroEdit(boolean tecFinanceiroEdit) {
		this.tecFinanceiroEdit = tecFinanceiroEdit;
	}
	public boolean isTecFinanceiroDelete() {
		return tecFinanceiroDelete;
	}
	public void setTecFinanceiroDelete(boolean tecFinanceiroDelete) {
		this.tecFinanceiroDelete = tecFinanceiroDelete;
	}
	public boolean isTecFinanceiroList() {
		return tecFinanceiroList;
	}
	public void setTecFinanceiroList(boolean tecFinanceiroList) {
		this.tecFinanceiroList = tecFinanceiroList;
	}
	public boolean isGerFinanceiroNew() {
		return gerFinanceiroNew;
	}
	public void setGerFinanceiroNew(boolean gerFinanceiroNew) {
		this.gerFinanceiroNew = gerFinanceiroNew;
	}
	public boolean isGerFinanceiroEdit() {
		return gerFinanceiroEdit;
	}
	public void setGerFinanceiroEdit(boolean gerFinanceiroEdit) {
		this.gerFinanceiroEdit = gerFinanceiroEdit;
	}
	public boolean isGerFinanceiroDelete() {
		return gerFinanceiroDelete;
	}
	public void setGerFinanceiroDelete(boolean gerFinanceiroDelete) {
		this.gerFinanceiroDelete = gerFinanceiroDelete;
	}
	public boolean isGerFinanceiroList() {
		return gerFinanceiroList;
	}
	public void setGerFinanceiroList(boolean gerFinanceiroList) {
		this.gerFinanceiroList = gerFinanceiroList;
	}
	public boolean isSupFinanceiroNew() {
		return supFinanceiroNew;
	}
	public void setSupFinanceiroNew(boolean supFinanceiroNew) {
		this.supFinanceiroNew = supFinanceiroNew;
	}
	public boolean isSupFinanceiroEdit() {
		return supFinanceiroEdit;
	}
	public void setSupFinanceiroEdit(boolean supFinanceiroEdit) {
		this.supFinanceiroEdit = supFinanceiroEdit;
	}
	public boolean isSupFinanceiroDelete() {
		return supFinanceiroDelete;
	}
	public void setSupFinanceiroDelete(boolean supFinanceiroDelete) {
		this.supFinanceiroDelete = supFinanceiroDelete;
	}
	public boolean isSupFinanceiroList() {
		return supFinanceiroList;
	}
	public void setSupFinanceiroList(boolean supFinanceiroList) {
		this.supFinanceiroList = supFinanceiroList;
	}
	public boolean isAdminFuncionarioNew() {
		return adminFuncionarioNew;
	}
	public void setAdminFuncionarioNew(boolean adminFuncionarioNew) {
		this.adminFuncionarioNew = adminFuncionarioNew;
	}
	public boolean isAdminFuncionarioEdit() {
		return adminFuncionarioEdit;
	}
	public void setAdminFuncionarioEdit(boolean adminFuncionarioEdit) {
		this.adminFuncionarioEdit = adminFuncionarioEdit;
	}
	public boolean isAdminFuncionarioDelete() {
		return adminFuncionarioDelete;
	}
	public void setAdminFuncionarioDelete(boolean adminFuncionarioDelete) {
		this.adminFuncionarioDelete = adminFuncionarioDelete;
	}
	public boolean isAdminFuncionarioList() {
		return adminFuncionarioList;
	}
	public void setAdminFuncionarioList(boolean adminFuncionarioList) {
		this.adminFuncionarioList = adminFuncionarioList;
	}
	public boolean isTecFuncionarioNew() {
		return tecFuncionarioNew;
	}
	public void setTecFuncionarioNew(boolean tecFuncionarioNew) {
		this.tecFuncionarioNew = tecFuncionarioNew;
	}
	public boolean isTecFuncionarioEdit() {
		return tecFuncionarioEdit;
	}
	public void setTecFuncionarioEdit(boolean tecFuncionarioEdit) {
		this.tecFuncionarioEdit = tecFuncionarioEdit;
	}
	public boolean isTecFuncionarioDelete() {
		return tecFuncionarioDelete;
	}
	public void setTecFuncionarioDelete(boolean tecFuncionarioDelete) {
		this.tecFuncionarioDelete = tecFuncionarioDelete;
	}
	public boolean isTecFuncionarioList() {
		return tecFuncionarioList;
	}
	public void setTecFuncionarioList(boolean tecFuncionarioList) {
		this.tecFuncionarioList = tecFuncionarioList;
	}
	public boolean isGerFuncionarioNew() {
		return gerFuncionarioNew;
	}
	public void setGerFuncionarioNew(boolean gerFuncionarioNew) {
		this.gerFuncionarioNew = gerFuncionarioNew;
	}
	public boolean isGerFuncionarioEdit() {
		return gerFuncionarioEdit;
	}
	public void setGerFuncionarioEdit(boolean gerFuncionarioEdit) {
		this.gerFuncionarioEdit = gerFuncionarioEdit;
	}
	public boolean isGerFuncionarioDelete() {
		return gerFuncionarioDelete;
	}
	public void setGerFuncionarioDelete(boolean gerFuncionarioDelete) {
		this.gerFuncionarioDelete = gerFuncionarioDelete;
	}
	public boolean isGerFuncionarioList() {
		return gerFuncionarioList;
	}
	public void setGerFuncionarioList(boolean gerFuncionarioList) {
		this.gerFuncionarioList = gerFuncionarioList;
	}
	public boolean isSupFuncionarioNew() {
		return supFuncionarioNew;
	}
	public void setSupFuncionarioNew(boolean supFuncionarioNew) {
		this.supFuncionarioNew = supFuncionarioNew;
	}
	public boolean isSupFuncionarioEdit() {
		return supFuncionarioEdit;
	}
	public void setSupFuncionarioEdit(boolean supFuncionarioEdit) {
		this.supFuncionarioEdit = supFuncionarioEdit;
	}
	public boolean isSupFuncionarioDelete() {
		return supFuncionarioDelete;
	}
	public void setSupFuncionarioDelete(boolean supFuncionarioDelete) {
		this.supFuncionarioDelete = supFuncionarioDelete;
	}
	public boolean isSupFuncionarioList() {
		return supFuncionarioList;
	}
	public void setSupFuncionarioList(boolean supFuncionarioList) {
		this.supFuncionarioList = supFuncionarioList;
	}
	public boolean isAdminClienteNew() {
		return adminClienteNew;
	}
	public void setAdminClienteNew(boolean adminClienteNew) {
		this.adminClienteNew = adminClienteNew;
	}
	public boolean isAdminClienteEdit() {
		return adminClienteEdit;
	}
	public void setAdminClienteEdit(boolean adminClienteEdit) {
		this.adminClienteEdit = adminClienteEdit;
	}
	public boolean isAdminClienteDelete() {
		return adminClienteDelete;
	}
	public void setAdminClienteDelete(boolean adminClienteDelete) {
		this.adminClienteDelete = adminClienteDelete;
	}
	public boolean isAdminClienteList() {
		return adminClienteList;
	}
	public void setAdminClienteList(boolean adminClienteList) {
		this.adminClienteList = adminClienteList;
	}
	public boolean isTecClienteNew() {
		return tecClienteNew;
	}
	public void setTecClienteNew(boolean tecClienteNew) {
		this.tecClienteNew = tecClienteNew;
	}
	public boolean isTecClienteEdit() {
		return tecClienteEdit;
	}
	public void setTecClienteEdit(boolean tecClienteEdit) {
		this.tecClienteEdit = tecClienteEdit;
	}
	public boolean isTecClienteDelete() {
		return tecClienteDelete;
	}
	public void setTecClienteDelete(boolean tecClienteDelete) {
		this.tecClienteDelete = tecClienteDelete;
	}
	public boolean isTecClienteList() {
		return tecClienteList;
	}
	public void setTecClienteList(boolean tecClienteList) {
		this.tecClienteList = tecClienteList;
	}
	public boolean isGerClienteNew() {
		return gerClienteNew;
	}
	public void setGerClienteNew(boolean gerClienteNew) {
		this.gerClienteNew = gerClienteNew;
	}
	public boolean isGerClienteEdit() {
		return gerClienteEdit;
	}
	public void setGerClienteEdit(boolean gerClienteEdit) {
		this.gerClienteEdit = gerClienteEdit;
	}
	public boolean isGerClienteDelete() {
		return gerClienteDelete;
	}
	public void setGerClienteDelete(boolean gerClienteDelete) {
		this.gerClienteDelete = gerClienteDelete;
	}
	public boolean isGerClienteList() {
		return gerClienteList;
	}
	public void setGerClienteList(boolean gerClienteList) {
		this.gerClienteList = gerClienteList;
	}
	public boolean isSupClienteNew() {
		return supClienteNew;
	}
	public void setSupClienteNew(boolean supClienteNew) {
		this.supClienteNew = supClienteNew;
	}
	public boolean isSupClienteEdit() {
		return supClienteEdit;
	}
	public void setSupClienteEdit(boolean supClienteEdit) {
		this.supClienteEdit = supClienteEdit;
	}
	public boolean isSupClienteDelete() {
		return supClienteDelete;
	}
	public void setSupClienteDelete(boolean supClienteDelete) {
		this.supClienteDelete = supClienteDelete;
	}
	public boolean isSupClienteList() {
		return supClienteList;
	}
	public void setSupClienteList(boolean supClienteList) {
		this.supClienteList = supClienteList;
	}


}
