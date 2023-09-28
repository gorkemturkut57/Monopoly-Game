public class Monsters {
    private int health;
    private int damage;

    public String[] getItemList() {
        return itemList;
    }

    public void setItemList(String[] itemList) {
        this.itemList = itemList;
    }

    private int money;
    private int id;
    private String[] itemList;

    Monsters(int health,int damage,int money,int id,String[] itemList){
        this.health=health;
        this.damage=damage;
        this.money=money;
        this.id=id;
        this.itemList=itemList;
    }

    public String toString(){
        return "Health:"+this.health+"\nDamage:"+this.damage+"\nAward:"+this.money;
    }

    public int getHealth(){
        return this.health;
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
class Spider extends Monsters{
    Spider() {
        super(10, 3, 4,1,new String[10]);
    }
}

class Vampire extends Monsters{
    Vampire() {
        super(14, 4, 7, 2,new String[20]);
    }
}


class bear extends Monsters{
    bear(){
        super(20,7,12,3,new String[20]);
    }
}