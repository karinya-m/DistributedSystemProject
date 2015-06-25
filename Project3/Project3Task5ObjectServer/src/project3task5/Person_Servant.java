
package project3task5;

/**
 * This class represents implements Person. 
 * @author Karinya
 */
public class Person_Servant implements Person { 
 
  int id; 
  String name;  
  public Person_Servant(String n, int i) { 
    name = n; 
    id = i; 
  } 
 
  /**
   * This method gets ID of a person
   * @return ID of a person
   */
  public int getID() { 
    return id; 
  } 
  
  /**
   * This method gets name of a person.
   * @return name of a person
   */
  public String getName() { 
    return name; 
  }  
} 