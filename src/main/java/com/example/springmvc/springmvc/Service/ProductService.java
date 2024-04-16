package com.example.springmvc.springmvc.Service;

import com.example.springmvc.springmvc.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ProductService {

    public BigDecimal addTotal(List<Product> allProducts) {
        List<Double> totalList = new ArrayList<>();

        allProducts.forEach(product -> totalList.add(product.getPrice()));

        return roundOff(totalList.stream().reduce(0.00, Double::sum));
    }

    public String getPurchaseDateAndTime() {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }

    private BigDecimal roundOff(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }
}
