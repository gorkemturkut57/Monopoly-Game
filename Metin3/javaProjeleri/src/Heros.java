import java.util.ArrayList;

public class Heros {
    private int id;
    private int health;
    private int damage;
    private int money;
    private int specialPower;
    private items armor;
    private items weapon;
    private ArrayList items;

    public items getArmor() {
        return armor;
    }

    public void setArmor(items armor) {
        this.armor = armor;
    }

    public items getWeapon() {
        return weapon;
    }

    public void setWeapon(items weapon) {
        this.weapon = weapon;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public int getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(int specialPower) {
        this.specialPower = specialPower;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(String  item) {
        items.add(item);
    }


    public Heros(int id,int health,int damage,int money,int specialPower,ArrayList items,items armor,items weapon){
        this.damage=damage;
        this.id=id;
        this.money=money;
        this.health=health;
        this.specialPower=specialPower;
        this.items=items;
        this.armor=armor;
        this.weapon=weapon;
    }

    public String toString(){
        return "Health:"+this.health+"\nDamage:"+this.damage+"\nMoney:"+this.money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
class Samurai extends Heros {

    public Samurai() {
        super(1, 21, 5, 15,2,new ArrayList(),new items("0",0,0,0,0),new items("0",0,0,0,0));
    }
}

class Archer extends Heros {
    ArrayList arr=new ArrayList();
    public Archer() {
        super(2, 18, 7, 20,3,new ArrayList(),new items("0",0,0,0,0),new items("0",0,0,0,0));
    }
}

class Knight extends Heros {

    public Knight() {
        super(3, 24, 8, 5,3,new ArrayList(),new items("0",0,0,0,0),new items("0",0,0,0,0));
    }
}



