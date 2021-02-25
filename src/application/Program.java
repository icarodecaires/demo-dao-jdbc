package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//testeSeller();
		
		testeDepartment();
		
	}
	
	
	public static void testeDepartment() {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("=== TESTE 1 INSERT ===");
		
		Department newDepartment = new Department(null,"Dev");
		departmentDao.insert(newDepartment);
		System.out.println("Id Novo Departamento Inserido: "+newDepartment.getId());
		*/
		
		System.out.println("=== TESTE 2 Busca Departamento Pelo Id ===");
		
		Department dep = departmentDao.findById(6);
		System.out.println("Resultado Busca Departamento Por Id - DEPARTMENTO: "+dep.getId()+" - "+dep.getName() );
		
		
		System.out.println("=== TESTE 3 Update Departamento ===");
		dep.setName("Compras");
		departmentDao.update(dep);
		
		/*
		System.out.println("=== TESTE 4 Delete por Id ===");
		dep.setName("Compras");
		departmentDao.deleteById(7);
		*/
		
		System.out.println("=== TESTE 4 Retornar Todos ===");
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
				
	}
	
	public static void testeSeller() {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1 Busca de Vendedor Pelo Id === ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2 Busca de Vendedor Pelo Departamento === ");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TESTE 3 Busca todos os Vendedores === ");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
		/*
		
		System.out.println("\n=== TESTE 4 Inserindo Vendedor === ");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Id do novo Vendedor: "+ newSeller.getId());
		*/
		
		System.out.println("\n=== TESTE 5 Update do Vendedor === ");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Concluido");
		
		
		System.out.println("\n=== TESTE 6 Delete do Vendedor === ");
		System.out.println("Entre com um id para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletado com sucesso");
		sc.close();
		
	}

}
