package Selenium_OH_Myroslava;

import java.util.*;

public class CollectionsReviewAkbar {

    public static void main(String[] args) {
        //Lets assume you are searching for iphone on amazon
        //may search results came in
        //i want you to store all the price elements on the result page
        //we can use findElement and getText together
        //it will give us a List<String> that contains prices
        //but we want to get List<Double>

//        String price = "10.5";
//        double priceDouble = Double.parseDouble(price);
//        System.out.println("priceDouble = " + priceDouble);
//        try{
//            if (priceDouble <20){
//                System.out.println("number");
//            }
//        }catch (Exception e){
//            System.out.println("string");
//        }

        List<String> priceLstStr = new ArrayList<>(Arrays.asList("99.99","149.99","79.99","299.99","599.99"));
        priceLstStr.add("999.99");
        System.out.println("priceLstStr = " + priceLstStr);
        System.out.println("priceLstStr.size = " + priceLstStr.size());

        //but we want to get List<Double>
        List<Double> pricesD = new ArrayList<>();

        for (String eachprice : priceLstStr) {
            Double doubelPrice = Double.parseDouble(eachprice);
            pricesD.add(doubelPrice);
        }

        System.out.println("pricesD = " + pricesD);


        //how do I get max, min, average price


        //remove items which are above average


        //get the unique prices
        //each and every collection implementation classes has constructor

        Set<Double> uniquePrices = new HashSet<>(pricesD);
        System.out.println("uniquePrices = " + uniquePrices);







    }
}
