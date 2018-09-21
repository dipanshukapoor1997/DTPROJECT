package com.shopping.snapdealbackend.dao;

import java.util.List;

import com.shopping.snapdealbackend.dto.Supplier;




public interface SupplierDao {
	
	boolean insertSupp(Supplier supplier);
	boolean updateSupp(Supplier supplier);
	boolean deleteSupp(int supplierId);
	public Supplier getSupplierById(int supplierId);
	public List<Supplier> listSuppliers();
}
