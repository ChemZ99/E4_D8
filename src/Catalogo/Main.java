package Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Product book1 = new Product(0001,"il signore degli anelli","books",119.99);
        Product book2 = new Product(0002,"il silmarillion","books",13.99);
        Product book3 = new Product(0003,"harry potter","books",211.99);
        Product book4 = new Product(0004,"topolino","books",4.99);
        Product item1 = new Product(1001,"cacciavite","items",9.99);
        Product item2 = new Product(1002,"chiave inglese","items",11.99);
        List<Product> productList = new ArrayList<Product>();
        List<Product> booksList = new ArrayList<Product>();
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(book4);
        productList.add(item1);
        productList.add(item2);
        Predicate<Product> isaBook = Product -> Product.getCategory().equals("books");
        Predicate<Product> isover100 = Product -> Product.getPrice() > 100;
        booksList = productList.stream().filter(isaBook).filter(isover100).toList();
        System.out.println("product list");
        System.out.println(productList);
        System.out.println("books over 100 list");
        System.out.println(booksList);
    }
}