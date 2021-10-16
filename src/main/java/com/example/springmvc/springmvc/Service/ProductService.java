package com.example.springmvc.springmvc.Service;

import com.example.springmvc.springmvc.model.Product;
import com.example.springmvc.springmvc.model.Receipt;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ProductService {

    private static List<Product> products = new ArrayList<>();

    // Data to add products. Using static code block to simulate a database.
    static {
        //Initialize Data
        Product product1 = new Product();
        product1.setName("Bar1");
        product1.setDescription("Milky Bar with chocolate and hazelnut");
        product1.setType("CANDIES");
        product1.setCategory("BARS");
        product1.setPrice(1.99);

        Product product2 = new Product();
        product2.setName("Bar2");
        product2.setDescription("Milky Bar with chocolate and hazelnut");
        product2.setType("CANDIES");
        product2.setCategory("BARS");
        product2.setPrice(1.99);

        Product product3 = new Product();
        product3.setName("Bar3");
        product3.setDescription("Milky Bar with chocolate and hazelnut");
        product3.setType("CANDIES");
        product3.setCategory("BARS");
        product3.setPrice(1.99);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public Model addItem(Model model) {

        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Output the prompt
        System.out.println("Enter chocolate name: ");

        // Wait for the user to enter something.
//        double value = input.nextDouble();
        String  value = input.next();

        // Tell them what they entered.
        System.out.println("You entered: " + value);

        for (Product product : products) {
            if (product.getName().equals(value)) {
                return model.addAttribute(product);
            }
        }
        return null;
    }

    public Double addTotal(List<Product> allProducts) {
        Double totalPrice = 0.00;
        boolean applyDiscount = false;

        List<Double> totalList = new ArrayList<>();
        for(Product product : allProducts){
            totalList.add(product.getPrice());
        }

        for(Double productTotal : totalList){
            totalPrice += productTotal;
        }

        return roundOff(totalPrice);
    }

    // Send to FE.
    public Receipt getReceipt(List<Product> basketItems){
        Receipt receipt = new Receipt();

        Double basketTotalCost = addTotal(basketItems);
        String purchaseDateAndTime = getPurchaseDateAndTime();

        receipt.setCost(basketTotalCost);
        receipt.setDate(purchaseDateAndTime);
        receipt.setItemsIbBasket(basketItems);

        return receipt;
    }

    public String getPurchaseDateAndTime() {
     DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     Calendar cal = Calendar.getInstance();
     System.out.println();

        return sdf.format(cal.getTime());
    }

    private double roundOff(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double applyDiscount(boolean decision, double basketTotal) {
        if (decision)
            return discount(basketTotal);
        return basketTotal;
    }

    private double discount(double price) {
        double  discount,amount,sum;

        // 10% off
        discount=10;
        sum=100-discount;
        amount= (sum*price)/100;

        return amount;
    }
}
