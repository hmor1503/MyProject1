package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room[] rooms = new Room[19];
        setRooms(rooms);
        runGame(rooms);
    }
    //set rooms
    public static void setRooms(Room[] rooms) {
        //create rooms
        Room one = new Room("Starting room", "YOU AWAKE INSIDE A DUNGEON, IN A DIMLY LIT ROOM. \n" +
                "YOU SEE NOTHING HERE EXCEPT FOR A DOOR TO WALK THROUGH.");
        Room two = new Room("Skeleton room", "YOU SEE DEAD REMAINS OF SKELETONS AROUND YOU IN THIS ROOM. \n" +
                "MAYBE THEY WERE TRAVELLERS SENT TO THIS DUNGEON AND FAILED? \n" +
                "YOU SEE YET ANOTHER DOOR IN FRONT OF YOU AND THERE IS NO WAY BACK AS THE ROOM YOU HAVE AWOKEN IN HAS BEEN SEALED OFF BY A PRESSURE PLATE PLACED JUST A STEP OUTSIDE OF THE DOOR. \n" +
                "YOU NOTICE ONE SKELETON REMAIN IN PARTICULAR HAS A SWORD STUCK TO IT’S CHEST AND FOR SOME REASON, IT IS MISSING A FINGER.");
        Room three = new Room("Troll room", "AS YOU VENTURE IN THE THIRD ROOM, YOU ARE STOPPED BY A MENACING TROLL\n" +
                "Troll: “HALT! YOU DARE TO TRY TO ESCAPE THIS DUNGEON!? YOU MUST DIE.“");
        Room four = new Room("Jester room", "“Upon reaching the next room of the dungeon, you are greeted by an energetic Jester that appears excited by his new guest.”\n" +
                "Jester: “Very few adventurers have made it this far. You should go to this GOLDEN room behind me as there is a valuable treasure waiting for you!”");
        Room five = new Room("Golden room", "Ominous voice: “If you wish to escape, solve this riddle: ”");
        Room six = new Room("Jester room part2", "Jester: “Ack! How the hell did you escape my trap!?”\n" +
                "“You see the Jester brandish a small dagger, what will you do!?”\n");
        Room seven = new Room("Jester room key", "Upon examining his robes you notice a skeleton finger key that looks like it could open up a door.");
        Room eight = new Room("Split path room", "You enter a room that splits off into two directions. " +
                "One leads to a treacherous chasm with a door at the other end. " +
                "The other path leads to a large door decorated with the remains of skeletons.”");
        Room nine = new Room("Troll", "“Hey, let me out human! I am sick of being trapped here. If you set me free I will give you something in exchange!”");
        Room ten = new Room("Choices", "");
        Room eleven = new Room("Chasm", "");
        Room twelve = new Room("Chasm", "");
        Room thirteen = new Room("Skeleton Door", "");
        Room fourteen = new Room("Boss Room", "“You open the large skeleton door and enter a room not like the rest in the dungeon.\n" +
                " As you are scanning the room looking for a way out of the dungeon, the ground starts to rumble.\n" +
                " Then out from the middle of the ground a giant worm-like creature with a huge mouth containing countless teeth.\n" +
                " You tremble with fear as this monster stands before you but you have come this far so you decide to take action.”\n" +
                "Worm: “You have made it to the end of this dungeon. \n" +
                "For your efforts I will give you a chance to escape. \n" +
                "If you solve my riddle correctly you are free to leave.”");
        Room fifteen = new Room("Fight","");
        Room sixteen = new Room("Riddle","");
        Room seventeen = new Room("Secret Weapon","");
        Room win = new Room("Win", "Winner!");
        Room death = new Room("Death", "GAME OVER");

        //room one
        one.setOne("GO THROUGH DOOR","YOU PROCEED THROUGH THE DOOR TO THE NEXT ROOM. IT IS TIME TO BE READY FOR YOUR ADVENTURE TO ESCAPE THIS DUNGEON.",two);
        //room two
        two.setOne("PICKUP SWORD","YOU PULL THE SWORD FROM THE SKELETON’S CHEST. SURELY YOU NEED IT MORE THAN THEY DO. YOU PROCEED THROUGH THE DOOR TO THE NEXT ROOM.",three);
        two.setInv("Sword");
        two.setTwo("GO THROUGH DOOR","HEY! MAYBE IT’S A GOOD IDEA TO GET SOMETHING FOR SELF DEFENSE BEFORE WE PROCEED!",two);
        //room three
        three.setOne("PUT TROLL IN BAG","Troll: “HEY! WHAT THE HELL ARE YOU DOING! STOP THAT! THE TROLL YELLS”\n" +
                "“YOU WEREN’T SUPPOSED TO DO THAT. I DON’T KNOW HOW YOU GOT A TROLL IN YOUR BAG BUT LET’S ROLL WITH IT.”",four);
        three.setInv("Troll");
        three.setTwo("FIGHT TROLL","“YOU PIERCE YOUR SWORD RIGHT THROUGH THE TROLL’S HEART.”\n" +
                "Troll: “I REGRET NOTHING”\n" +
                "“THE TROLL PERISHES IN FRONT OF YOU. YOU MAY NOW PROCEED FORWARD!”",four);
        three.setThree("NEGOTIATE TROLL","Troll: “YOUR WORDS DO NOT SWAY ME, HUMAN. YOU WILL PERISH LIKE THE REST WHO TRY TO ESCAPE.”\n" +
                "“THE TROLL SWINGS HIS CLUB ONTO YOUR HEAD, CONCAVING YOUR SKULL KILLING YOU INSTANTLY.”",death);
        //room four
        four.setOne("GO TO GOLDEN ROOM","“You step foot into the golden room, you see treasure everywhere! Wait…  upon closer inspection this is FOOL’S GOLD! " +
                "The walls begin to close in as you hear the Jester laughing in the distance”",five);
        //room five
        Riddle gold = new Riddle("What is the result if I have two apples and I trade one apple for four coins, then I trade all four coins for two apples each, then I give a third of my apples to a peasant. How many apples do I have remaining?",2,
                "“You escape the room and back to the room where you have met the Jester”",six,
                "“The walls close in and squish you to death. " +
                        "What a horrific sight as you faintly hear the maniacal laughter of the evil Jester before you become flattened.”",death);
        five.setRid(gold);
        //room six
        six.setOne("FIGHT","“You behead the Jester for his foolery.”",seven);
        six.setTwo("DO NOTHING","“The Jester jumps forward and thrusts a dagger into your heart, you bleed out and perish.”",death);
        //room seven
        seven.setOne("PICK UP KEY","“You have acquired the skeleton finger key. You may now proceed to the next room.”",eight);
        seven.setInv("Skeleton Finger");
        seven.setTwo("LEAVE KEY WITH JESTER","“The key gives you an uneasy feeling so you leave the key alone. You may now proceed to the next room.”",eight);
        //room eight
        eight.checkInv("Troll",nine,ten);
        //room nine
        nine.setOne("RELEASE TROLL","“Wise choice. Here, I have no use for these. " +
                "Never come back to this dungeon.”\n" +
                "““You have obtained the winged sandals! They appear to have the power to grant its user enhanced jumping capabilities””",ten);
        nine.setInv("Winged Sandals");
        nine.setTwo("KEEP TROLL","“Damn you!“",ten);
        //room ten
        ten.setOne("Go back to the Jester's Lair","",seven);
        ten.setTwo("Jump chasm","",eleven);
        ten.setThree("Go through skeleton door","",thirteen);
        //room eleven
        eleven.checkInv("Bomb","“You have already seen what is beyond the chasm. No need to risk the jump again.”","",ten,twelve);
        //room twelve
        twelve.checkInv("Winged Sandals","Your winged sandals safely bring you to the other side of the chasm where you proceed through the door and are greeted by a chest. \n" +
                "Inside the chest there is a bomb that seems like it could be useful.”\n" +
                "“Bomb item is brought to player inventory.”","chasm is too far for a normal person to jump across. You fall to your death.",ten,death);
        twelve.setInv("Bomb");
        //room thirteen
        thirteen.checkInv("Skeleton Finger","“You use the skeleton finger as a key to unlock the skeleton door. \n" +
                "You proceed on your journey through the dungeon.”","“The giant door is locked and appears to have a keyhole shaped like a finger.”",fourteen,ten);
        //room fourteen
        fourteen.setOne("Fight the giant worm","",fifteen);
        fourteen.setTwo("Solve the puzzle","",sixteen);
        fourteen.setThree("Use your secret weapon","",seventeen);
        //room fifteen
        MechanicRNG boss = new MechanicRNG(25,"“You will not take any chances with riddles and use your trusty sword to guide you.\n" +
                " You lunge towards the giant worm and slice right down its body before it could fight back, killing it.\n" +
                " A door opens at the other side of the room leading to the exit.”",
                "“You will not take any chances with riddles and use your trusty sword to guide you. \n" +
                        "As you sprint towards the worm in an attempt to slay it.\n" +
                        " The giant worm sees through your plan and swallows you whole.”",win,death);
        fifteen.setRng(boss);
        //room sixteen
        Riddle puzzle =  new Riddle("Worm: “What is the result of 9 + 10 + 10 - 9 + 1?”",21,"Worm: “You have answered my riddle correctly and as a worm of my word I shall let you go.”\n" +
                "“A door opens on the other side of the room and you make your escape to freedom.”",win,"Worm: “You have answered my riddle correctly and as a worm of my word I shall let you go.”\n" +
                "“A door opens on the other side of the room and you make your escape to freedom.”",death);
        sixteen.setRid(puzzle);
        //room seventeen
        seventeen.checkInv("Bomb","Worm: “You have answered my riddle correctly and as a worm of my word I shall let you go.”\n" +
                "“A door opens on the other side of the room and you make your escape to freedom.”","“You reach into your bag and find nothing of use.\n" +
                " The Giant worm sees that you are not complying with its wishes so it decides to swallow you whole.”",win,death);

        //array of rooms
        rooms[0] = one;
        rooms[1] = two;
        rooms[2] = three;
        rooms[3] = four;
        rooms[4] = five;
        rooms[5] = six;
        rooms[6] = seven;
        rooms[7] = eight;
        rooms[8] = nine;
        rooms[9] = ten;
        rooms[10] = eleven;
        rooms[11] = twelve;
        rooms[12] = thirteen;
        rooms[13] = fourteen;
        rooms[14] = fifteen;
        rooms[15] = sixteen;
        rooms[16] = seventeen;
        rooms[17] = win;
        rooms[18] = death;
    }
    //run game
    public static void runGame(Room[] rooms){
        //Sword, Skeleton Finger, Troll, Winged Sandals, Bomb
        String [] inventory;
        inventory = new String[5];
        for(int i = 0; i < 5; i++){
            inventory[i] = "*";
        }
        Room next = rooms[0];
        while((next.name()!= "Win") && (next.name()!= "Death")){
            next = next.run(inventory);
        }
    }
}

//room
class Room{
    //variables to be filled in
    String name = "";
    String narration = "";
    String optionOne = "";
    String optionTwo = "";
    String optionThree = "";
    String oneNar = "";
    String twoNar = "";
    String threeNar = "";
    Room one;
    Room two;
    Room three;
    int options = 0;
    String inventory = "";
    boolean add = false;
    Riddle rid = new Riddle();
    boolean riddle = false;
    MechanicRNG rng = new MechanicRNG(0,"win","lose",one,two);
    boolean mechanic = false;
    String checkItem = "";
    String have = "";
    String not = "";
    boolean check = false;
    boolean nar = false;
    // constants
    String optionNar = "Your options are...";
    String enter = "Enter your choice";
    String error = "ACTION NOT POSSIBLE OR REQUIRED ITEM IS NOT IN INVENTORY";

    //set room name and narration
    public Room(){}
    public Room(String room, String nar){
        name = room;
        narration = nar;
    }
    //set option, option narration, and option output
    //one option
    public void setOne(String option, String opNar, Room room){
        optionOne = option;
        oneNar = opNar;
        one = room;
        options = 1;
    }
    //second option
    public void setTwo(String option, String opNar, Room room){
        optionTwo = option;
        twoNar = opNar;
        this.two = room;
        options = 2;
    }
    //third option
    public void setThree(String option, String opNar, Room room){
        optionThree = option;
        threeNar = opNar;
        this.three = room;
        options = 3;
    }
    //add inventory option
    public void setInv(String inv){
        inventory = inv;
        add = true;
    }
    //add riddle
    public void setRid(Riddle riddle){
        rid = riddle;
        this.riddle = true;
    }
    //add rng
    public void setRng(MechanicRNG r){
        rng = r;
        mechanic = true;
    }
    //check inventory
    public void checkInv(String item, Room one, Room two){
        checkItem = item;
        check = true;
        this.one = one;
        this.two = two;
    }
    public void checkInv(String item, String yes, String no, Room one, Room two){
        checkItem = item;
        check = true;
        have = yes;
        not = no;
        this.one = one;
        this.two = two;
        nar = true;
    }
    //getter
    //get name
    public String name(){
        return name;
    }
    //run room
    public Room run(String [] inv){
        int option = 0;
        Scanner scan = new Scanner(System.in);
        Room next = new Room("","");
        //print room name and narration
        System.out.println(name);
        System.out.println(narration);
        //options
        //if it is a riddle
        if(riddle){
            next = rid.run();
        }
        //if it is a rng
        else if(mechanic){
            next = rng.run();
        }
        // if it asks to check the inventory
        else if(check){
            boolean item = false;
            for(int i = 0; i < 5; i++){
                if(inv[i] == checkItem){
                    item = true;
                    break;
                }
            }
            if(nar){
                if(item){
                    System.out.println(have);
                    next = one;
                }
                else{
                    System.out.println(not);
                    next = two;
                }
            }
            else{
                if(item) next = one;
                else next = two;
            }
        }
        //all others
        else{
            System.out.println(optionNar);
            System.out.print("1. ");
            System.out.println(optionOne);
            if(options >= 2){
                System.out.print("2. ");
                System.out.println(optionTwo);
                if(options == 3){
                    System.out.print("3. ");
                    System.out.println(optionThree);
                }
            }
            System.out.println(enter);
            option = scan.nextInt();
            while(option == 0 || option > options){
                System.out.println(error);
                System.out.println(enter);
                option = scan.nextInt();
            }
            if(option == 1) next = one;
            else if(option == 2) next = two;
            else if(option == 3) next = three;
        }
        //check to see if there needs to be anything added to inventory
        if(next == one && add){
            for(int i = 0; i < 5; i++){
                if(inv[i] == "*"){
                    inv[i] = inventory;
                    break;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            System.out.println(inv[i]);
        }
        return next;
    }


}
//riddle
class Riddle {
    //variables
    String text = "";
    int answer = 0;
    String right = "";
    String wrong = "";
    Room one;
    Room two;
    Scanner scan = new Scanner(System.in);

    // constructor
    public Riddle(){};
    public Riddle(String str, int ans, String r, Room one, String w, Room two) {
        text = str;
        answer = ans;
        right = r;
        wrong = w;
        this.one = one;
        this.two = two;
    }
    //runs riddle
    public Room run() {
        Room next = new Room("next", "next");
        System.out.println(text);
        int in = scan.nextInt();
        if (in == answer) {
            System.out.println(right);
            next = one;
        } else {
            System.out.println(wrong);
            next = two;
        }
        return next;
    }
}
//rng
class MechanicRNG {
    int num;
    String win;
    String lose;
    Room one;
    Room two;
    //constructor
    public MechanicRNG(int suc, String w, String l,Room one,Room two){
        num = suc;
        win = w;
        lose = l;
        this.one = one;
        this.two = two;
    }
    //runs rng
    public Room run(){
        Room next = new Room();
        int number;
        number = (int) (Math.random() * 100);
        if (number < num) {
            System.out.println(win);
            next = one;
        } else {
            System.out.println(lose);
            next = two;
        }
        return next;
    }
}
