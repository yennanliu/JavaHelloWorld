package dev;

import java.util.ArrayList;
import java.util.List;

public class ClassType {
  public static void main(String[] args) {

      /**
       * In Java, Class<?> is a wildcard type that represents a Class object that can hold references to any Java type. Here’s a breakdown of what Class<?> signifies:
       *
       * -> Understanding Class<?>
       *
       * 	1.	Class Object:
       * 	    •	Class<?> refers to an instance of the Class class in Java, which represents metadata about a Java class at runtime. This metadata includes information like the class name, fields, methods, and constructors of the class.
       * 	2.	Wildcard (<?>):
       * 	    •	The <?> wildcard notation indicates that the specific type of Class object isn’t known or doesn’t matter in a particular context. It can hold a reference to any type of Java class.
       * 	3.	Usage:
       * 	    •	Class<?> is often used in scenarios where you want to work with class metadata without specifying a specific type. For example:
       * 	    •	Reflection: When using reflection to dynamically examine classes, methods, or fields, Class<?> allows flexibility in handling different types.
       * 	    •	Generic Programming: In generic methods or classes, Class<?> can be used to accept or return any type of class object, offering more generic and reusable code.
       *
       *
       *
       *  -> Benefits of Class<?>
       *
       * 	•	Flexibility: Allows code to handle different types of Class objects without specifying them explicitly.
       * 	•	Generics Compatibility: Works seamlessly with Java’s generics, enabling type-safe operations where the specific type isn’t known beforehand.
       * 	•	Reflection: Facilitates reflection operations where you need to query or manipulate class metadata dynamically.
       *
       * Summary
       *
       *    -> Class<?> in Java is a versatile type that represents a Class object capable of referring to any Java class. It’s particularly useful in scenarios involving reflection, generics, and dynamic class handling where the exact type of class isn’t predetermined or doesn’t need to be specified statically.
       *
       *
       */

      Class<?> clazz = String.class; // clazz can refer to any class, not necessarily String
      String className = clazz.getName(); // Retrieves the name of the class (e.g., "java.lang.String")
      System.out.println(className);

      Class<?> clazz2 = Integer.class; // clazz can refer to any class, not necessarily String
      String className2 = clazz2.getName(); // Retrieves the name of the class (e.g., "java.lang.String")
      System.out.println(className2);

      List<Object> myList = new ArrayList<>();
      myList.add(new String("abc"));
      myList.add(123);
      System.out.println(myList);

  }

}
