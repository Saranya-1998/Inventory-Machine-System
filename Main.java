import java.util.*;

abstract class Product
{
  int productId;
  String productName;
  double price;
  
  Product(int pid, String pname, double pprice)
  {
    productId = pid;
    productName = pname;
    price = pprice;
  }

  public int getpid()
  {
    return productId;
  }
  public String getpname()
  {
    return productName;
  }
  public double getprice()
  {
    return price;
  }

  public abstract double calculateDiscounts();
}

class Electronics extends Product
{
  int warrantyPeriod;

  Electronics(int pid, String pname, double pprice, int wperiod)
  {
    super(pid, pname, pprice);
    warrantyPeriod = wperiod;
  }

  public int getWarrantyPeriod()
  {
    return warrantyPeriod;
  }

  public double calculateDiscounts()
  {
    if (warrantyPeriod > 12)
    {
      return 0.20;
    }
    else
    {
      return 0.10;
    }
  }

}

class Clothing extends Product
{
  String size;
  
  Clothing(int pid, String pname, double pprice, String s)
  {
    super(pid, pname, pprice);
    size = s.toLowerCase();
  }

  public String getSize()
  {
    return size;
  }

  public double calculateDiscounts()
  {
    if (size.equals("small"))
    {
       return 0.20;
    }
    else if (size.equals("medium"))
    {
       return 0.15;
    }
    else
    {
       return 0.10;
    }
  }

}

class Inventory
{
  ArrayList <Product> products;
  
  Inventory()
  {
    this.products = new ArrayList<Product>();
  }

  public void addProduct(Product p)
  {
    products.add(p);
  }

  public void removeProduct(Product p)
  {
    products.remove(p);
  }

  public void displayInventory()
  {
    for(Product p: products)
     {
        System.out.println("Product Id : " + p.getpid());
        System.out.println("Product name : " + p.getpname());
        System.out.println("Product price : " + p.getprice());
        System.out.println("Discount amount : " + (p.calculateDiscounts()) * 100 + "%");
        System.out.println("_____________________________________________");
     }
  }
}

public class Main
{
  public static void main(String args[])
  {
    Electronics e1 = new Electronics(1, "Speaker", 25000.50, 10); 
    Electronics e2 = new Electronics(2, "Headphone", 10000.75, 14);
    Clothing c1 = new Clothing(3, "Sweater", 1500.00, "Large");
    Clothing c2 = new Clothing(4, "Shirt", 2000.24, "Small");
    
    Inventory i = new Inventory();
    
    i.addProduct(e1);
    i.addProduct(e2);
    i.addProduct(c1);
    i.addProduct(c2);

    System.out.println("\n Current Products in Inventory \n");
    i.displayInventory();

    i.removeProduct(e2);
    i.removeProduct(c1);

    System.out.println("\n\n Current Products in Inventory after removal \n");
    i.displayInventory(); 


    // use of polymorphism by calling the calculateDiscount method on different types of products.

    System.out.println("\n\nDiscount amount for Electronics product: " + (e1.calculateDiscounts())*100 + "%");
    System.out.println("Discount amount for Clothing product: " + (c2.calculateDiscounts()) * 100 + "%");
  }
}