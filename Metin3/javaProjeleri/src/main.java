import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {



    public static void main(String[] args){
        String[] itemList={"Light Armor","Normal Armor","Big Armor","Sword","Gun","Rifle","Apple","Vodka","Kebab","Eye of the spider","Tooth of the vampire","Claw of the bear"};
        int[] itemPriceList={6,10,16,6,10,16,2,6,10,2,2,2};

        String[] spiderItemList={"Light Armor","Sword","Eye of the spider","Eye of the spider","Eye of the spider","Vodka","Apple","Apple","Apple","Apple"};
        String[] vampireItemList={"Light Armor","Light Armor","Normal Armor","Normal Armor","Big Armor","Gun","Gun","Gun","Sword","Sword","Apple","Apple","Apple","Vodka","Vodka","Vodka","Kebab","Tooth of the vampire","Tooth of the vampire","Tooth of the vampire"};
        String[] BearItemList={"Normal Armor","Big Armor","Big Armor","Big Armor","Sword","Sword","Rifle","Rifle","Rifle","Vodka","Vodka","Vodka","Kebab","Kebab","Kebab","Kebab","Kebab","Claw of the bear","Claw of the bear","Claw of the bear"};


        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter your name:");
        String name=scanner.nextLine();
        System.out.println();
        System.out.println("Welcome to the game "+name+"!");
        System.out.println("Please choose your warrior:");
        System.out.println("1-)Samurai");
        System.out.println("2-)Archer");
        System.out.println("3-)Knight");

        int go=1;
        int easterEgg=0;
        int id=0;
        while (go==1) {

            id = scanner.nextInt();

            if (0 < id && 4 > id) {
                go = 0;
            } else {
                System.out.println("Please enter a valid value!");
            }
        }
        Heros hero;
        if (id==1){
            hero=new Samurai();
        }
        else if (id==2){
            hero=new Archer();
        }
        else{
            hero=new Knight();
        }

        System.out.println("Warrior created successfully!");
        System.out.println("ID:"+hero.getId()+" Damage:"+hero.getDamage()+" Health:"+hero.getHealth()+" Money:"+hero.getMoney());
        int originalDamage=hero.getDamage();
        int originalHealth=hero.getHealth();
        int oDamage=hero.getDamage();
        int oHealth=hero.getHealth();




        int devam=1;
        while (devam==1) {
            System.out.println();
            System.out.println("Please select a location you want to go:");
            System.out.println("1-)Safehouse-->Safe zone,you will be healed");
            System.out.println("2-)Cave-->There will be spiders!");
            System.out.println("3-)Forest-->There will be vampires!");
            System.out.println("4-)River-->There will be bears!");
            System.out.println("5-)Toolstore-->You can buy stuffs");
            System.out.println("6-)Warehouse-->See your items");

            go = 1;
            int placeNo = 0;
            while (go == 1) {
                placeNo = scanner.nextInt();

                if (-1 < placeNo && 7 > placeNo) {
                    go = 0;
                } else {
                    System.out.println("Please enter a valid value!");
                }
            }

            if (placeNo == 1) {
                if (hero.getMoney()<3){
                    System.out.println("You dont have enough money to go to safehouse!");
                }
                else{
                    if (hero.getHealth()<oHealth){
                        hero.setHealth(oHealth);
                    }
                    hero.setMoney(hero.getMoney()-3);
                    System.out.println(hero);
                }
            }
            else {
                Random random = new Random();
                int MonsterQuantity = 1+(random.nextInt(5));

                if (placeNo == 2) {
                    System.out.println("Be careful! There are " + MonsterQuantity + " spider(s) in the cave!");
                    System.out.println("<C>ombat or <F>lee ?");

                    scanner.nextLine();
                    String answer = scanner.nextLine();

                    if(answer.equals("C")){
                        for (int i=0;i<MonsterQuantity;i++){

                            Monsters monster=new Spider();
                            monster.setItemList(spiderItemList);
                            if(i==0){

                                System.out.println();
                                System.out.println("Player Stats");
                                System.out.println("------------");
                                System.out.println(hero);

                                System.out.println();
                                System.out.println("Enemy Stats");
                                System.out.println("-----------");
                                System.out.println(monster);
                            }



                            int GIR=1;
                            while (GIR==1){
                                System.out.println("<H>it the "+(i+1)+". spider or <F>lee:");
                                answer = scanner.nextLine();


                                if(answer.equals("H")){
                                    hero.setHealth(hero.getHealth()-monster.getDamage());
                                    monster.setHealth(monster.getHealth()-hero.getDamage());
                                }


                                else{
                                    GIR=0;
                                    i=MonsterQuantity;
                                }

                                if(monster.getHealth()>0&&hero.getHealth()>0){
                                    System.out.println();
                                    System.out.println("Player Stats");
                                    System.out.println("------------");
                                    System.out.println(hero);

                                    System.out.println();
                                    System.out.println("Enemy Stats");
                                    System.out.println("-----------");
                                    System.out.println(monster);
                                }

                                if(hero.getHealth()<=0){
                                    System.out.println("You are dead...Rest in peace mate :(");
                                    devam=0;
                                    i=MonsterQuantity;
                                    break;
                                }

                                if (hero.getItems().contains("Eye of the spider")&&hero.getItems().contains("Tooth of the vampire")&&hero.getItems().contains("Claw of the bear")){
                                    System.out.println("Congratulations!You collected the whole charms and saved the village!");
                                    devam=0;
                                    i=MonsterQuantity;
                                    break;
                                }


                                else if(monster.getHealth()<=0){
                                    System.out.println("You killed the spider!");
                                    GIR=0;
                                    hero.setMoney(hero.getMoney()+monster.getMoney());
                                    int random2=1+(random.nextInt(2));
                                    for (int j=0;j<random2;j++){
                                        int random3=random.nextInt(10);
                                        String droppedItem=monster.getItemList()[random3];
                                        hero.setItems(droppedItem);
                                        System.out.println("You dropped a "+droppedItem+"!");

                                    }
                                }
                            }
                        }
                    }
                }

                if (placeNo == 3) {
                    if (hero.getMoney()<5){
                        System.out.println("You dont have enough money to enter the cave!");
                    }
                    else{
                        hero.setMoney(hero.getMoney()-5);

                        System.out.println("Be careful! There are " + MonsterQuantity + " vampire(s) in the cave!");
                        System.out.println("<C>ombat or <F>lee ?");

                        scanner.nextLine();
                        String answer = scanner.nextLine();

                        if(answer.equals("C")){
                            for (int i=0;i<MonsterQuantity;i++){

                                Monsters monster=new Vampire();
                                monster.setItemList(vampireItemList);
                                if(i==0){

                                    System.out.println();
                                    System.out.println("Player Stats");
                                    System.out.println("------------");
                                    System.out.println(hero);

                                    System.out.println();
                                    System.out.println("Enemy Stats");
                                    System.out.println("-----------");
                                    System.out.println(monster);
                                }



                                int GIR=1;
                                while (GIR==1){
                                    System.out.println("<H>it the "+(i+1)+". vampire or <F>lee:");
                                    answer = scanner.nextLine();


                                    if(answer.equals("H")){
                                        hero.setHealth(hero.getHealth()-monster.getDamage());
                                        monster.setHealth(monster.getHealth()-hero.getDamage());
                                    }


                                    else{
                                        GIR=0;
                                        i=MonsterQuantity;
                                    }

                                    if(monster.getHealth()>0&&hero.getHealth()>0){
                                        System.out.println();
                                        System.out.println("Player Stats");
                                        System.out.println("------------");
                                        System.out.println(hero);

                                        System.out.println();
                                        System.out.println("Enemy Stats");
                                        System.out.println("-----------");
                                        System.out.println(monster);
                                    }

                                    if(hero.getHealth()<=0){
                                        System.out.println("You are dead...Rest in peace mate :(");
                                        devam=0;
                                        i=MonsterQuantity;
                                        break;
                                    }

                                    else if(monster.getHealth()<=0){
                                        System.out.println("You killed the vampire!");
                                        GIR=0;
                                        hero.setMoney(hero.getMoney()+monster.getMoney());
                                        int random2=1+(random.nextInt(3));
                                        for (int j=0;j<random2;j++){
                                            int random3=random.nextInt(20);
                                            String droppedItem=monster.getItemList()[random3];
                                            hero.setItems(droppedItem);
                                            System.out.println("You dropped a "+droppedItem+"!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (placeNo == 4) {
                    if (hero.getMoney()<10){
                        System.out.println("You dont have enough money to go to the forest!");
                    }
                    else{
                        hero.setMoney(hero.getMoney()-10);

                        easterEgg=0;
                        System.out.println("Be careful! There are " + MonsterQuantity + " bear(s) in the cave!");
                        System.out.println("<C>ombat or <F>lee ?");

                        scanner.nextLine();
                        String answer = scanner.nextLine();

                        if(answer.equals("C")){
                            for (int i=0;i<MonsterQuantity;i++){

                                Monsters monster=new bear();
                                monster.setItemList(BearItemList);
                                if(i==0){

                                    System.out.println();
                                    System.out.println("Player Stats");
                                    System.out.println("------------");
                                    System.out.println(hero);

                                    System.out.println();
                                    System.out.println("Enemy Stats");
                                    System.out.println("-----------");
                                    System.out.println(monster);
                                }



                                int GIR=1;
                                while (GIR==1){
                                    System.out.println("<H>it the "+(i+1)+". bear or <F>lee:");
                                    answer = scanner.nextLine();


                                    if(answer.equals("H")){
                                        hero.setHealth(hero.getHealth()-monster.getDamage());
                                        monster.setHealth(monster.getHealth()-hero.getDamage());
                                    }


                                    else{
                                        GIR=0;
                                        i=MonsterQuantity;
                                    }

                                    if(monster.getHealth()>0&&hero.getHealth()>0){
                                        System.out.println();
                                        System.out.println("Player Stats");
                                        System.out.println("------------");
                                        System.out.println(hero);

                                        System.out.println();
                                        System.out.println("Enemy Stats");
                                        System.out.println("-----------");
                                        System.out.println(monster);
                                    }

                                    if(hero.getHealth()<=0){
                                        System.out.println("You are dead...Rest in peace :(");
                                        devam=0;
                                        i=MonsterQuantity;
                                        break;
                                    }

                                    else if(monster.getHealth()<=0){
                                        System.out.println("You killed the bear!");
                                        easterEgg+=1;
                                        GIR=0;
                                        hero.setMoney(hero.getMoney()+monster.getMoney());
                                        int random2=1+(random.nextInt(4));
                                        for (int j=0;j<random2;j++){
                                            int random3=random.nextInt(20);
                                            String droppedItem=monster.getItemList()[random3];
                                            hero.setItems(droppedItem);
                                            System.out.println("You dropped a "+droppedItem+"!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (placeNo==5){
                    System.out.println();
                    System.out.println("Buying Prices:");
                    System.out.println("--------------");
                    System.out.println();
                    System.out.println("Armors:");
                    System.out.println("-------");
                    System.out.println("Light Armor(ID:1):"+"6");
                    System.out.println("Normal Armor(ID:2):"+"10");
                    System.out.println("Big Armor:(ID:3)"+"16");
                    System.out.println();

                    System.out.println("Weapons:");
                    System.out.println("--------");
                    System.out.println("Sword(ID:4)"+"6");
                    System.out.println("Gun(ID:5)"+"10");
                    System.out.println("Rifle(ID:6):"+"16");
                    System.out.println();

                    System.out.println("Foods:");
                    System.out.println("------");
                    System.out.println("Apple:(ID:7)"+"2");
                    System.out.println("Vodka(ID:8):"+"6");
                    System.out.println("Kebab(ID:9):"+"10");
                    System.out.println();


                    int exit=0;
                    while (exit==0){
                        System.out.print("Please enter the ID of the item you want to buy.If you want to sell your items please press 10.If you want to exit please press Zero'0':");
                        int heroMoney=hero.getMoney();

                        int itemID=scanner.nextInt();
                        System.out.println();

                        if (itemID==0){
                            exit=1;
                        }

                        else if (itemID==10){
                            if (hero.getItems().size()==0){
                                System.out.println("You dont have any item to sell");
                            }
                            else{
                                System.out.println();
                                System.out.println("Sale Prices:");
                                System.out.println("------------");
                                System.out.println();
                                System.out.println("Armors:");
                                System.out.println("-------");
                                System.out.println("Light Armor(ID:1):"+itemPriceList[0]/2);
                                System.out.println("Normal Armor(ID:2):"+itemPriceList[1]/2);
                                System.out.println("Big Armor(ID:3):"+itemPriceList[2]/2);

                                System.out.println();
                                System.out.println("Weapons:");
                                System.out.println("--------");
                                System.out.println("Sword(ID:4):"+itemPriceList[3]/2);
                                System.out.println("Gun(ID:5):"+itemPriceList[4]/2);
                                System.out.println("Rifle(ID:6):"+itemPriceList[5]/2);

                                System.out.println();
                                System.out.println("Foods:");
                                System.out.println("-----");
                                System.out.println("Apple(ID:7):"+itemPriceList[5]/2);
                                System.out.println("Vodka(ID:8):"+itemPriceList[6]/2);
                                System.out.println("Kebab(ID:9):"+itemPriceList[8]/2);

                                System.out.println();
                                System.out.println("Awards:");
                                System.out.println("------");
                                System.out.println("Eye of the spider(ID:10):"+itemPriceList[9]/2);
                                System.out.println("Tooth of the vampire(ID:11):"+itemPriceList[10]/2);
                                System.out.println("Claw or the bear(ID:12):"+itemPriceList[11]/2);
                                System.out.println();
                                System.out.println("Your Envanter:");
                                System.out.println("--------------");
                                ArrayList itemsToSell=hero.getItems();
                                int size=hero.getItems().size();

                                int availableArmor=0;


                                System.out.print("Armors:");
                                for (int k=0;k<size;k++){
                                    if (itemsToSell.get(k).equals("Light Armor")||itemsToSell.get(k).equals("Normal Armor")||itemsToSell.get(k).equals("Big Armor")) {
                                        System.out.print(itemsToSell.get(k)+"-");
                                        availableArmor=1;
                                    }
                                }
                                if (availableArmor==0){
                                    System.out.print("-");
                                }


                                int availableWeapon=0;

                                System.out.println();

                                System.out.print("Weapons:");
                                for (int k=0;k<size;k++){
                                    if (itemsToSell.get(k).equals("Gun")||itemsToSell.get(k).equals("Sword")||itemsToSell.get(k).equals("Rifle")) {
                                        System.out.print(itemsToSell.get(k)+"-");
                                        availableWeapon=1;
                                    }
                                }
                                if (availableWeapon==0){
                                    System.out.print("-");
                                }


                                int availableFood=0;

                                System.out.println();

                                System.out.print("Foods:");
                                for (int k=0;k<size;k++){
                                    if (itemsToSell.get(k).equals("Apple")||itemsToSell.get(k).equals("Vodka")||itemsToSell.get(k).equals("Kebab")) {
                                        System.out.print(itemsToSell.get(k)+"-");
                                        availableFood=1;
                                    }
                                }
                                if (availableFood==0){
                                    System.out.print("-");
                                }


                                int availableAwards=0;

                                System.out.println();

                                System.out.print("Awards:");
                                for (int k=0;k<size;k++){
                                    if (itemsToSell.get(k).equals("Eye of the spider")||itemsToSell.get(k).equals("Tooth of the vampire")||itemsToSell.get(k).equals("Claw of the bear")) {
                                        System.out.print(itemsToSell.get(k)+"-");
                                        availableAwards=1;
                                    }
                                }
                                if (availableAwards==0){
                                    System.out.print("-");
                                }

                                System.out.println();
                                System.out.print("Please enter the ID of the item you want to sell:");


                                int sellItemID=scanner.nextInt();

                                if (hero.getItems().contains(itemList[sellItemID-1])){
                                    System.out.println("You sold "+itemList[sellItemID-1]+"! You earned "+itemPriceList[sellItemID-1]/2+" gold.");
                                    hero.setMoney(hero.getMoney()+itemPriceList[sellItemID-1]/2);
                                    hero.getItems().remove(itemList[sellItemID-1]);
                                }
                                else{
                                    System.out.println("You dont have "+itemList[sellItemID-1]+" in your envanter"+"!");
                                }
                            }
                        }


                        else{
                            if (itemPriceList[itemID-1]<=heroMoney){
                                System.out.println("You bought "+itemList[itemID-1]+"!");
                                hero.setItems(itemList[itemID-1]);
                                hero.setMoney(hero.getMoney()-itemPriceList[itemID-1]);
                            }

                            else{
                                System.out.println("You dont have enough money!");
                            }


                        }
                    }
                }


                if (placeNo==6){
                    ArrayList items=hero.getItems();
                    int size=hero.getItems().size();

                    int availableArmor=0;

                    System.out.println();
                    System.out.print("Armors:");
                    for (int k=0;k<size;k++){
                        if (items.get(k).equals("Light Armor")||items.get(k).equals("Normal Armor")||items.get(k).equals("Big Armor")) {
                            System.out.print(items.get(k)+"-");
                            availableArmor=1;
                        }
                    }
                    if (availableArmor==0){
                        System.out.print("-");
                    }


                    int availableWeapon=0;

                    System.out.println();

                    System.out.print("Weapons:");
                    for (int k=0;k<size;k++){
                        if (items.get(k).equals("Gun")||items.get(k).equals("Sword")||items.get(k).equals("Rifle")) {
                            System.out.print(items.get(k)+"-");
                            availableWeapon=1;
                        }
                    }
                    if (availableWeapon==0){
                        System.out.print("-");
                    }


                    int availableFood=0;

                    System.out.println();

                    System.out.print("Foods:");
                    for (int k=0;k<size;k++){
                        if (items.get(k).equals("Apple")||items.get(k).equals("Vodka")||items.get(k).equals("Kebab")) {
                            System.out.print(items.get(k)+"-");
                            availableFood=1;
                        }
                    }
                    if (availableFood==0){
                        System.out.print("-");
                    }


                    int availableAwards=0;

                    System.out.println();

                    System.out.print("Awards:");
                    for (int k=0;k<size;k++){
                        if (items.get(k).equals("Eye of the spider")||items.get(k).equals("Tooth of the vampire")||items.get(k).equals("Claw of the bear")) {
                            System.out.print(items.get(k)+"-");
                            availableAwards=1;
                        }
                    }
                    if (availableAwards==0){
                        System.out.print("-");
                    }
                    System.out.println();
                    System.out.print("To use an item press 1,to wear off an item press 2,to exit press 0:");
                    int useItem = scanner.nextInt();
                    System.out.println();

                    if (useItem == 1) {

                        if (availableArmor == 1 || availableFood == 1 || availableWeapon == 1) {
                            int beginningHealth = hero.getHealth();
                            int beginningDamage = hero.getDamage();

                            System.out.print("Please enter the name of the item you want to use:");
                            scanner.nextLine();
                            String itemName = scanner.nextLine();
                            System.out.println();

                            if (hero.getItems().contains(itemName)) {
                                System.out.println("You used " + itemName + "!");
                                hero.getItems().remove(itemName);
                                if (itemName.equals("Light Armor")) {

                                    if (hero.getArmor().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        if (hero.getHealth()>oHealth){
                                            hero.setItems(hero.getArmor().getName());
                                            beginningHealth=oHealth;
                                        }
                                    }
                                    hero.setHealth(beginningHealth + 1);
                                    hero.setArmor(new lightArmor());

                                }
                                else if (itemName.equals("Normal Armor")) {
                                    if (hero.getArmor().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        if (hero.getHealth()>oHealth){
                                            hero.setItems(hero.getArmor().getName());

                                            beginningHealth=oHealth;
                                        }                                    }
                                    hero.setHealth(beginningHealth + 3);
                                    hero.setArmor(new normalArmor());
                                } else if (itemName.equals("Big Armor")) {
                                    if (hero.getArmor().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        if (hero.getHealth()>oHealth){
                                            hero.setItems(hero.getArmor().getName());

                                            beginningHealth=oHealth;
                                        }                                    }
                                    hero.setHealth(beginningHealth + 5);
                                    hero.setArmor(new bigArmor());
                                } else if (itemName.equals("Sword")) {
                                    if (hero.getWeapon().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        hero.setItems(hero.getWeapon().getName());
                                        beginningDamage=oDamage;
                                    }
                                    hero.setDamage(beginningDamage + 2);
                                    hero.setWeapon(new sword());
                                } else if (itemName.equals("Gun")) {
                                    if (hero.getWeapon().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        hero.setItems(hero.getWeapon().getName());
                                        beginningDamage=oDamage;
                                    }
                                    hero.setDamage(beginningDamage + 4);
                                    hero.setWeapon(new gun());
                                } else if (itemName.equals("Rifle")) {
                                    if (hero.getWeapon().getName().equals("0")) {
                                        System.out.println("");
                                    } else {
                                        hero.setItems(hero.getWeapon().getName());
                                        beginningDamage=oDamage;
                                    }
                                    hero.setDamage(beginningDamage + 7);
                                    hero.setWeapon(new rifle());
                                }
                                else if (itemName.equals("Apple")){
                                    hero.setHealth(hero.getHealth()+2);
                                }
                                else if (itemName.equals("Vodka")){
                                    hero.setHealth(hero.getHealth()+4);
                                    if (easterEgg==3){
                                        System.out.println("<3 <3 <3 <3 <3");
                                    }

                                }
                                else if (itemName.equals("Kebab")){
                                    hero.setHealth(hero.getHealth()+6);
                                }

                            }
                        }
                        else {
                            System.out.println("You dont have any item to wear!");
                        }

                    }
                    else if (useItem==2){
                        System.out.println("To wear your armor off press 1,to wear your weapon off press 2:");
                        int dropOff=scanner.nextInt();

                        if (dropOff==1){
                            if (hero.getArmor().getName().equals("0")){
                                System.out.println("You are not wearing any armor");
                            }
                            else{
                                if ((hero.getHealth()-hero.getArmor().getQualification()>0)){
                                    System.out.println("You wear off your "+hero.getArmor().getName());
                                    hero.setHealth(hero.getHealth()-hero.getArmor().getQualification());
                                    hero.setItems(hero.getArmor().getName());
                                    hero.setArmor(new items("0",0,0,0,0));
                                    hero.setItems(hero.getArmor().getName());
                                }
                                else{
                                    System.out.println("You cant wear off your armor because you dont have enough health!");
                                }
                            }
                        }
                        else if (dropOff==2){
                            if (hero.getWeapon().getName().equals("0")){
                                System.out.println("You are not wearing any weapon");
                            }
                            else{
                                System.out.println("You wear off your "+hero.getWeapon().getName());
                                hero.setItems(hero.getWeapon().getName());
                                hero.setArmor(new items("0",0,0,0,0));
                                hero.setDamage(oDamage);
                            }
                        }
                    }
                }
            }
        }
    }
}