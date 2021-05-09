

public class CarListTest
{
   public static void main(String[] args){
    CopyOfCarList<String>  myList=new CopyOfCarList();
    myList.add("BMW");
    myList.add("Nissan");
    myList.add("Honda");
    myList.add("Toyota");
    for (String s: myList){
    System.out.println(s);
    }
    System.out.println("Size of the list is "+ myList.size());
    System.out.println("Ordered list after adding 2 more cars____________________");
    myList.add("Ford");
    myList.add("Mazda");
    for (String s: myList){
    System.out.println(s);
    }
    System.out.println("Size of the list is "+myList.size());
    System.out.println("Ordered list after removing Mexico from the list_____________");
    myList.remove("Honda");
    System.out.println("_____________________");
    for (String s: myList){
    System.out.println(s);
    }
    System.out.println("Size of the list is "+myList.size());
    System.out.println("_____________________");
    System.out.println("Removing Jeep from the list_____________________");
    myList.remove("Jeep");
    for (String s: myList){
    System.out.println(s);
    }
    System.out.println("Size of the list is "+myList.size());
}
}

