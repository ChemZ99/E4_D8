package Catalogo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Customer jhon = new Customer(01,"jhon",2);
        Customer bob = new Customer(02,"bob",2);
        Customer luke = new Customer(03,"luke", 1);
        Product book1 = new Product(0001,"il signore degli anelli","books",119.99);
        Product book2 = new Product(0002,"il silmarillion","books",13.99);
        Product book3 = new Product(0003,"harry potter","books",211.99);
        Product book4 = new Product(0004,"topolino","books",4.99);
        Product item1 = new Product(1001,"cacciavite","items",9.99);
        Product item2 = new Product(1002,"chiave inglese","items",11.99);
        Product baby1 = new Product(2001,"pannolini","baby", 9.99);
        Product baby2 = new Product(2002,"ciuccio","baby", 4.99);
        Product boys1 = new Product(3001,"gameboy","boys",59.99);
        Product boys2 = new Product(3002,"jeans","boys",39.99);
        List<Product> productList = new ArrayList<>();
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(book4);
        productList.add(item1);
        productList.add(item2);
        List<Product> booksList;
        List<Product> boyscheckList = new ArrayList<>();
        boyscheckList.add(baby1);
        boyscheckList.add(baby2);
        boyscheckList.add(boys1);
        boyscheckList.add(boys2);
        boyscheckList.add(book3);
        boyscheckList.add(item2);
        List<Product> order1List = new ArrayList<>();
        order1List.add(book1);
        order1List.add(book2);
        order1List.add(baby1);
        List<Product> order2List = new ArrayList<>();
        order2List.add(item1);
        order2List.add(item2);
        order2List.add(baby2);
        List<Product> order3List = new ArrayList<>();
        order3List.add(book4);
        order3List.add(item1);
        order3List.add(book3);
        Order order1 = new Order(001,"delivered", LocalDate.of(2021,3,12),LocalDate.of(2021,3,20),order1List,jhon);
        Order order2 = new Order(002,"delivered",LocalDate.of(2021,3,15),LocalDate.of(2021,3,21),order2List,bob);
        Order order3 = new Order(003,"packing",LocalDate.now(),LocalDate.now().plusDays(3),order3List,luke);
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);
        allOrders.add(order3);
        List<Order> filteredOrders = new ArrayList<>();
        //******************************************************1************************************************************
        Predicate<Product> isaBook = Product -> Product.getCategory().equals("books");
        Predicate<Product> isover100 = Product -> Product.getPrice() > 100;
        booksList = productList.stream().filter(isaBook).filter(isover100).toList();
        System.out.println("product list");
        System.out.println(productList);
        System.out.println("books over 100 list");
        System.out.println(booksList);
        //******************************************************2************************************************************
        Predicate<Order> containsaBaby = Order -> Order.getProducts().stream().anyMatch(Product -> Product.getCategory().equals("baby"));
        filteredOrders = allOrders.stream().filter(containsaBaby).toList();
        System.out.println("orders with baby products");
        System.out.println(filteredOrders);
    }
}