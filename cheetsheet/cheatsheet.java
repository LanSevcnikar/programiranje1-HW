package cheetsheet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * cheatsheet
 */

//example of a class


public class cheatsheet {
  public static void sayHelloName(String name){
    System.out.println("Hello " + name);
    return ;
  }

  //Numbers that like add up previous ones
  public static int recursion(int i){
    if(i < 2) return 1;
    return recursion(i-1) + recursion(i-2);
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");

    //int type1 = 2147483647;
    long type2 = 9223372036854775807L;
    //boolean type3 = true;
    //double type4 = 123.12355;

    System.out.println(Math.sqrt(type2));
    //Math holds importaint functions, 
    //  such as min, max, abs, pow, sqt, trig functions etc.

    //? Arrays
    //Pointers are quite importaint here because arrays really just point to memory registers, 2d is an array of pointers
    //Two diemnsional tables do not exist in java ampak so samo pointerji
    //No idea what he means with this, I feel as if they work just fine
    int[] array = new int[100];
    for (int i = 0; i < 100; i++) {
      array[i] = i * 3 - 2;
    }

    System.out.println(array[23]);
    System.out.print(array[24]); //print without new line
    System.out.print(array[25]);
    System.out.print(array[26]);

    for (int element : array) {
      System.out.println(element);; // For each works very well also
    }
    System.out.println(Arrays.toString(array));

    int[][] something2d = new int[10][10];
    something2d[2][5] = 5;
    something2d[3][2] = 8;

    System.out.println(something2d[2][5]);

    //another way to do this is as follows
    /*
    int[][] t = new int[10][];
    for (int i = 0; i < 10; i++) {
      t[i] = new int[i + 1];
    }
    */

    //String hello = "Something very cool";
    
    //? Random 
    Random random = new Random(123);
    System.out.println(random.nextInt(100));
    
    
    /*
    & Bitni in
    | Bitni ali
    ^ Bitni izkljuˇcujoˇci ali
    ~ Bitni ne
    << Bitni pomik v levo
    >> Bitni pomik v desno z razmnoževanjem skrajno levega bita
    >>> Bitni pomik v desno z razmnoževanjem niˇcle
    */
    
    sayHelloName("Lan");
    recursion(8);
  
    //!Pointers
    //Do not forget that array point so you cannot write array1 = array2 because they will point to the same memory register
    // Not really a thing here tho outside of tables

    //! CLASSES
    //Same as with arrays, a = b is actually done with pointers
    vector2D position = new vector2D(5,7);
    vector2D velocity = new vector2D(5,3);
    position.print();
    position.add(velocity);
    position.print();
    System.out.println(vector2D.mag(position));
    vector2D.setWritingStyle(true);
    position.print();


    vector3D pos3d = new vector3D(3, 4, 5);
    pos3d.print();
    pos3d.add(position);
    pos3d.print();

    //! PRIMER Z LIKI
    Lik lik = new Kvadrat(8);
    lik.print();
    System.out.println(lik.ploscina());

    Lik[] liki = {new Krog(6), new Pravokotnik(5, 7), new Kvadrat(4)};
    Lik.printLiki(liki);

    System.out.println(lik.equals(liki[0])); //The two are not of the same type
    System.out.println(lik.equals(liki[2])); //The two are of the same type

    //? interesting thing that we can do with the object type is:
    Object[] messyArray = {new vector3D(4, 5, 6), "Hello world", 14, new Krog(8)};
    for (Object ma : messyArray) {
      System.out.println(ma);
    }
    //The vector element does not have a to string function so it only shows the adress but the rest works

    //!DICT
    Dict dictionary = new Dict();
    dictionary.save("Lan", 19);
    dictionary.save("Ana", 18);
    dictionary.save("Tim", 16);

    System.out.println("Lan: " + dictionary.getValue("Lan"));
    System.out.println("Ana: " + dictionary.getValue("Ana"));
    System.out.println("Tim: " + dictionary.getValue("Tim"));

    dictionary.save("Lan", 21);

    System.out.println("Lan: " + dictionary.getValue("Lan"));
    System.out.println("Ana: " + dictionary.getValue("Ana"));
    System.out.println("Tim: " + dictionary.getValue("Tim"));

    // YOU have skipped the part about generic types / typecasting, this is fine as I see no use in it
    // You can revisit that and all

    //Samo as with the vemsniki, this is also in my opinion hardly relevaant and you can attend classes when 
    // you will see the need but as of now it is not needed

    //THis is just a quick recap of the types, what they do and how to implement them;
    /*
      Array (elements in table)
      Linked list (try writing it out youorself)
                  (each element is linked to the next, there is no above struture)

      Set (množica, not used, use hashset)
      Hashset (better than a normal set, just faster)
      Treeset (or sorted set)

      Map (dict you have written but ok)ž
      Hashmap
      Treemap
    */

    LinkedList<String> ll = new LinkedList<String>();
    ll.add("Someone");
    ll.add("HIm");
    Iterator<String> it = ll.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }
    //Using this one is a bit harsh and I mean, I would avoide it.
    //For fun, I think you could write it out yourself, it really is simple
    //You did it in prvi letnik, maybe you can still find it

    System.out.println("");

    HashSet<Integer> s0 = new HashSet<Integer>();
    s0.add(5);
    s0.add(9);
    s0.add(5);
    for (Integer i : s0) {
      System.out.println(i);
    }

    System.out.println("");

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("Lan", 19);
    map.put("Jure", 17);
    map.put("Ana", 18);
    System.out.println(map.get("Lan"));

    //?LAMBDE
    // see little to no reason to every even touch these in the way I have seen them here as you 
    // have to decleare a fair bt to be able to use them, unline in javascript

    //!Input
    System.out.println("Input two numbers here: ");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    System.out.println(a * b);
    System.out.printf("%d * %d = %d\n", a, b, a * b);
    sc.close();
  }
}


/*

Some random things that are mentioned and are not super trivial but I have no idea
if you need to know them or not

Binary search
Prime cieve
BFS / DFS (more the latter)
QUick sort
DP (????)

Fun task, write a vectoer (c++ type) that will be able to hold anything using the Object as the perimiter

*/