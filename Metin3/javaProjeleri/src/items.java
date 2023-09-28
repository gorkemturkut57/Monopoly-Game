public class items {
    private String name;
    private int ID;
    private int qualification;
    private int buyPrice;
    private int sellPrice;

    public items(String name, int ID, int qualification, int buyPrice, int sellPrice) {
        this.name = name;
        this.ID = ID;
        this.qualification = qualification;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}
class lightArmor extends items{

    public lightArmor() {
        super("Light Armor",1 , 1, 16, 8);
    }
}

class normalArmor extends items{

    public normalArmor() {
        super("Normal Armor",2 , 3, 28, 14);
    }
}

class bigArmor extends items{

    public bigArmor() {
        super("Big Armor",3 , 5, 40, 20);
    }
}

class sword extends items{

    public sword() {
        super("Sword",4 , 3, 26, 13);
    }
}

class gun extends items{

    public gun() {
        super("Gun",5 , 5, 36, 18);
    }
}

class rifle extends items{

    public rifle() {
        super("Rifle",6 , 7, 46, 23);
    }
}

class apple extends items{

    public apple() {
        super("Apple",7 , 2, 4, 2);
    }
}

class vodka extends items{

    public vodka() {
        super("Vodka",8 , 6, 8, 4);
    }
}

class kebab extends items{

    public kebab() {
        super("Kebab",9 , 10, 12, 6);
    }
}

class eyeOfTheSpider extends items{

    public eyeOfTheSpider() {
        super("Eye of the spider",10 , 1, 1, 1);
    }
}

class toothOfTheVampire extends items{

    public toothOfTheVampire() {
        super("Tooth of the vampire",11 , 1, 1, 1);
    }
}

class russianBear extends items{

    public russianBear() {
        super("Claw of the bear",12 , 1, 1, 1);
    }
}

