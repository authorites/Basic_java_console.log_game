package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Main {
 
 static int number = 0;
 static Scanner myObj = new Scanner(System.in);
 static String name, an, status;
 static double HP, Atk, Def, Cri, $, damage;
 static double HP_m, Atk_m, Def_m;
 static boolean choose, next, clear, hasKey, back, hasSword;
 static ArrayList<String> heroItems = new ArrayList<String>(); 
 
 static void input(int i) {
  choose = false;
  while(!choose) {
   number = myObj.nextInt();
   if(number < 1 || number > i) {
    System.out.println("[!]Please type 1 to " + i);
   } else {
    choose = true;
   }
  }
  System.out.println("==================================================");
 }
 
 public static void main(String[] args) {
  
  System.out.println("Enter your name:");
  name = myObj.nextLine();
  System.out.println("==================================================");
  HP = 1000; Atk = 100; Def = 50; Cri = 0.02; $ = 10000;
  ArrayList<String> items = new ArrayList<String>( Arrays.asList("Long Sword", "Dagger", "Axe", "Gun", "Recovery bottle","Next") );
  choose = false;
  next = false;
  while(!choose || !next) {
   System.out.println("------List items------");
   for(int i = 0; i < items.size(); i++) {
    System.out.println("[" + (i+1) + "]" + items.get(i));
   }
   System.out.println("Choose one item(type number):");
   number = myObj.nextInt();
   if(number >= 1 && number < items.size()) {
    heroItems.add(items.get(number-1));
    items.remove(number-1);
    choose = true;
   } else if (number == items.size() && choose) {
    next = true;
   } else if (number == items.size()) {
    System.out.println("[!]Please choose at least one item");
   }
   else {
    System.out.println("[!]Please type 1 to " + items.size());
   }
   System.out.println("==================================================");
  }
  System.out.println("!!!!! MAIN QUEST !!!!!");
  System.out.println("Eliminate the boss to");
  System.out.println("   clear the game");
  System.out.println("==================================================");
  clear = false;
  while(!clear) {
   System.out.println("--------Lobby--------");
   System.out.println("[1]Enter second floor");
   System.out.println("[2]Enter third floor");
   System.out.println("[3]Enter Dungeon");
   input(3);
   switch(number) {
    case 1:
     back = false;
     while(!back) {
      System.out.println("--------Second floor--------");
      System.out.println("[1]next");
      System.out.println("[2]return lobby");
      input(2);
      switch(number) {
       case 1:
        System.out.println("!!!! Monster appear !!!!");
        HP_m = 200; Atk_m = 20; Def_m = 50;
        status = "fighting";
        while(status == "fighting") {
         System.out.println("[1]Fight");
         System.out.println("[2]Escape");
         input(2);
         switch(number) {
          case 1:
           damage = Math.abs(Atk-Def_m);
           HP_m -= damage;
           System.out.println("[!]You attack");
           System.out.println("[!]hit " + damage + " damage!");
           if(HP_m <= 0) {
            status = "win";
            System.out.println("!!!!! YOU WIN !!!!!");
            break;
           }
           damage = Math.abs(Atk_m-Def);
           HP -= damage;
           System.out.println("[!]Monster attack");
           System.out.println("[!]hit " + damage + " damage!");
           if(HP <= 0) {
            clear = true;
            status = "lose";
            System.out.println("----- Game Over ------");
            break;
           }
           System.out.println("[!]your HP remain " + HP);
           System.out.println("[!]Monster HP remain " + HP_m);
           System.out.println("==================================================");
           break;
          case 2:
           status = "lose";
           break;
          default:
           System.out.println("[!]Something error in switch case");
         }
         if(status == "win") {
          System.out.println("[!]Get Key to Dungeon");
          heroItems.add("key");
          System.out.println("==================================================");
         }
          
        }

        break;
       case 2:
        back = true;
        break;
       default:
        System.out.println("[!]Something error in switch case");
      }
     }
     break;
    case 2:
     back = false;
     while(!back) {
      System.out.println("--------Third floor--------");
      System.out.println("[1]next");
      System.out.println("[2]return lobby");
      input(2);
      switch(number) {
       case 1:
        System.out.println("!!!! It's a trap !!!!");
        HP -= 10;
        System.out.println("[!]you got 10 damges");
        System.out.println("[!]your HP remain " + HP);
        System.out.println("==================================================");
        System.out.println("!!!! 100 Monsters appear !!!!");
        HP_m = 100; Atk_m = 10; Def_m = 85;
        status = "fighting";
        while(status == "fighting") {
         System.out.println("[1]Fight");
         System.out.println("[2]Escape");
         input(2);
         switch(number) {
          case 1:
           damage = Math.abs(Atk-Def_m);
           HP_m -= damage;
           System.out.println("[!]You attack");
           System.out.println("[!]hit " + damage + " damage!");
           if(HP_m <= 0) {
            status = "win";
            System.out.println("!!!!! YOU WIN !!!!!");
            break;
           }
           damage = Math.abs(Atk_m-Def);
           HP -= damage;
           System.out.println("[!]Monsters attack");
           System.out.println("[!]hit " + damage + " damage!");
           if(HP <= 0) {
            clear = true;
            status = "lose";
            System.out.println("----- Game Over ------");
            break;
           }
           System.out.println("[!]your HP remain " + HP);
           System.out.println("[!]Monster remain " + HP_m);
           System.out.println("==================================================");
           break;
          case 2:
           status = "lose";
           break;
          default:
           System.out.println("[!]Something error in switch case");
         }
         if(status == "win") {
          hasSword = false;
          for(int i = 0; i < heroItems.size(); i++) {
           if(heroItems.get(i) == "Black sword") {
            System.out.println("[!]already have Black sword");
            hasSword = true;
            break;
           }
          }
          if(!hasSword) {
           System.out.println("[!]Get Black sword");
           heroItems.add("Black sword");
           Atk += 10000;
           System.out.println("...   I feel the power!");
           System.out.println("[!]Attack gain 10000");
          }
          System.out.println("==================================================");
         }
          
        }
        break;
       case 2:
        back = true;
        break;
       default:
        System.out.println("[!]Something error in switch case");
      }
     }
     break;
    case 3:
     System.out.println("Meet Dungeon door(require the key)");
     hasKey = false;
     for(int i = 0; i < heroItems.size(); i++) {
      if(heroItems.get(i) == "key") {
       hasKey = true;
       System.out.println("[!]Yeah! door open!");
       break;
      }
      System.out.println("...");
     }
     if(!hasKey) {
      System.out.println("[!]You shall not passssss!");
      System.out.println("[!]return lobby");
      System.out.println("==================================================");
      break;
     }
     System.out.println("==================================================");
     System.out.println("--------Boss room--------");
     System.out.println("!!!!!! Boss appear !!!!!!");
     HP_m = 20000; Atk_m = 100; Def_m = 99;
     status = "fighting";
     while(status == "fighting") {
      System.out.println("[1]Fight");
      System.out.println("[2]Escape");
      input(2);
      switch(number) {
       case 1:
        damage = Math.abs(Atk-Def_m);
        HP_m -= damage;
        System.out.println("[!]You attack");
        System.out.println("[!]hit " + damage + " damage!");
        if(HP_m <= 0) {
         status = "win";
         System.out.println("!!!!! YOU WIN !!!!!");
         break;
        }
        damage = Math.abs(Atk_m-Def);
        HP -= damage;
        System.out.println("[!]Monster attack");
        System.out.println("[!]hit " + damage + " damage!");
        if(HP <= 0) {
         status = "lose";
         System.out.println("----- Game Over ------");
         break;
        }
        System.out.println("[!]your HP remain " + HP);
        System.out.println("[!]Monster HP remain " + HP_m);
        System.out.println("==================================================");
        break;
       case 2:
        status = "lose";
        break;
       default:
        System.out.println("[!]Something error in switch case");
      }
      if(status == "win") {
       clear = true;
       System.out.println("==================================================");
       System.out.println("**************************************************");
       System.out.println("*************** "+ name +" CLEAR THE GAME ***************");
       System.out.println("**************************************************");
       System.out.println("==================================================");
      }
     }
     break;
    default:
     System.out.println("[!]Something error in switch case");
   }
  }
 }
}