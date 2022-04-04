package main;


import domain.Cow;
import structures.Farm;

public class DairyFarmApp {
    public static void main(String[] args) {


        Cow firstCow = new Cow(1, "Bella");

        Farm farm = new Farm(firstCow);

        farm.giveBirth(1, 2, "Maggie");
        farm.giveBirth(1, 3, "Goldie ");
        farm.giveBirth(1, 4, "Ella");
        farm.giveBirth(2, 5, "Milky");
        farm.giveBirth(2, 6, "Penny");
        farm.giveBirth(6,99,"Annabelle");
        farm.giveBirth(3,7,"Rosie");
        farm.giveBirth(5,50, "Daisy");
        farm.endLifeSpan(2);
        farm.endLifeSpan(1);
        farm.endLifeSpan(50);
        farm.printData();



    }
}
