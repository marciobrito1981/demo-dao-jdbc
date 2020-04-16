package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department find by id ===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("=== TEST 2: Department Find All ===");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: Insert Department ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println(" New Department Inserted ! New id = " + newDepartment.getId());
		
		System.out.println();
		System.out.println("=== TEST 4: Update Department ===");
		dep = departmentDao.findById(1);
		dep.setName("Computers");
		departmentDao.update(dep);
		System.out.println("Update Department completed");
		
		
		System.out.println();
		System.out.println("=== TEST 5: Delete Department ===");
		System.out.print("Entre com um ID para deleção: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Department completed");

		
		sc.close();
		
	
	}
}

