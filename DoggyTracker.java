import java.util.*;

public class DoggyTracker{
    static public DogDatabase doggyData = new DogDatabase();
    static public Scanner scan = new Scanner(System.in);
    static public void displayOptions(){
        System.out.println("Choose an option:");
        System.out.println("0 - print the list of options");
        System.out.println("1 - add a dog");
        System.out.println("2 - find by name");
        System.out.println("3 - find by license");
        System.out.println("4 - remove by name");
        System.out.println("5 - print by name");
        System.out.println("6 - print by license");
        System.out.println("7 - quit");
        System.out.println("Option: ");
   }
    
    static public void displayWork(int user){
       while(user < 7 && user >= 0){
        if(user == 0){
               DoggyTracker.displayOptions(); 
        }
        else if(user == 1){
                System.out.print("Enter name: ");
                String name = scan.next();
                System.out.println();
                System.out.print("Enter license number: ");
                int license = scan.nextInt();
                System.out.println();
                System.out.print("Enter breed: ");
                String breed = scan.next();
                System.out.println();
                System.out.print("Enter age: ");
                int age = scan.nextInt();
                System.out.println();
                Dog dog = new Dog(name, license, breed, age);
                doggyData.addDog(dog);
        }
        else if(user == 2){
                System.out.print("Enter name: ");
                String name = scan.next();
                doggyData.findByName(name);
        }
        else if(user == 3){
                System.out.print("Enter license: ");
                int license = scan.nextInt();
                doggyData.findByLicense(license);
        }
        else if(user == 4){
                System.out.print("Enter name: ");
                String name = scan.next();
                doggyData.delete(name);
        }
        else if(user == 5){
                System.out.print("Printing by name: ");
                doggyData.printByName();
           
        }
        else{
                System.out.print("Printing by license: ");
                doggyData.printByLicense(); 
              
        }
        if(user == 0){
         user = scan.nextInt();
        }
        else{
         DoggyTracker.displayOptions();
         user = scan.nextInt();
        }
    }
    if(user > 7 || user < 0){
         System.out.println("You may only enter one of the eight numbers listed above.");
         System.out.println("Option: ");
         user = scan.nextInt();
         DoggyTracker.displayWork(user);    
    }
   }   
    
   static public void main(String args[]){
       DoggyTracker.displayOptions();
       int user = scan.nextInt();
       DoggyTracker.displayWork(user);
       System.out.println("Goodbye.");
        // call other static methods to do work!!!!!
        
   }
}
