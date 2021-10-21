package aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class Main {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n===== teste findByDepartment=======");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== teste findAll=======");

		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== Inserir=======");

		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insert! new Id = " + newSeller.getId());

		System.out.println("\n===== Editar=======");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete");

		System.out.println("\n=====Delete=======");
		System.out.println("Entre com id para delecao");
		int id = scn.nextInt();
		sellerDao.deleteById(id);

		System.out.println("Delete complete!");
		scn.close();
	}
}
