package aplicacao;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Seller;

public class Main {
	public static void main(String[] args) {
		
		SellerDao sellerDao	= DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}
}
