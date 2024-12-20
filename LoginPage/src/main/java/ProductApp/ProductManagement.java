package ProductApp;

import java.util.ArrayList;

public class ProductManagement
{
	public static ArrayList<Product> pr = new ArrayList<>();
	static int id = 1 ;
	//New Product
	public boolean AddProduct(String name , float price) {
		
		Product p = new Product(id++ ,name , price );
		pr.add(p);
//		System.out.println(p.name);
//		System.out.println(p.price);
		return true;
	}
	
	public boolean updateProduct(int id, float price) {
		for(Product p1 : pr) {
			if(p1.getId() == id) {
				p1.setPrice(price);
				System.out.println(p1.getId());
				System.out.println(p1.getName());
				System.out.println(p1.getPrice());
				return true ;
			}
		
		}
		
		
		
		return false ;
	}

}
