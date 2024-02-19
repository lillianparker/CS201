Lillian Parker - CS201 
Taken: Freshman Spring Semester 2023 

Analysis, use, and design of data structures and algorithms using an object-oriented language like Java to solve computational problems. 
Emphasis on abstraction including interfaces and abstract data types for lists, trees, sets, tables/maps, and graphs. 
Implementation and evaluation of programming techniques including recursion. Intuitive and rigorous analysis of algorithms.

Project0: Java Programming (January 2023) 
Student Code Files: Person201.java, Person201Utilities.java, Person201Demo.java, Person201Finder.java

Person201.java-
  defines Person201 class, cantains instance variables to store data about each person
  includes sameFloor method to determine if individuals live on the same floor

Person201Utilities.java-
  file contains static utility methods that operate on arrays of Person201 objects
  includes methods for reading data from files and comparing Person201 objects

Person201Demo.java-
  file contains main method used to test and demonstrate functionality of Person201 class
  creates instances of Person201 objects

Person201Finder.java-
  file contains new class named Person201Finder with main method used to search for inviduals
  Does search on user based on data file people.txt
  Creates Person201 object representing the user

P1-nbody: Java Programming (January/February 2023) 
Student Code Files: CelestialBody.java, NBody.java

CelestialBody.Java-
  Defines celestial body such as planet or sun.
  Contains instance variables, constructor, and getter methods.
  Additional methods include calculating distance, force exerted by X and Y components, 
  net force exerted by X and Y components, updating position, drawing the body

NBody.java-
  drives simulation between celestial bodies
  reads data from a file specifying initial positions and masses of bodies
  runs the simulation over a set time period and animates the interactions between the bodies
  includes static metjhods fro reading radius, reading bodies, and the main simulation method

P2-markov: Java Programming (February 2023)
Concepts related to generative models, Markov processes, 
data structures like HashMaps, computational complexity analysis
Student Code Files: WordGram.java, Markov.java

WordGram.java-
  a WordGram represents a series of words, contains immutable sequences of strings
  defines methods for creating, accessing, and manipulating WordGrams
  implements methods such as wordAt(), length(), equals(), hashCode(), shiftAdd(), toString()

HashMarkov.java-
  implements a Markov model for generating random text using WordGrams and HashMaps
  Uses WordGrams of a given order to preduct the next word based on the training text
  Creates  HashMap that maps WordGrams to lists of words that follow the WordGram
  Utilizes hashing for efficient access to training data and text generation


P3-dna: Java Programming (February/March 2023)
Students tasked with implementing various DNA manipulation functionalities 
Main goal is develop a more efficient implementation  using linked list data structure
Student Code Files: LinkStrand.java, TestStrand.java, DNABenchmark.java

LinkStrand.java-
  File contains implementation of LinkStrand class, which implements IDnaStrand interface
  Implements constructors, methods for appending, reversing, accessing characters,
  converting the DNA sequence to String representation. Uses linked list object.

TestStrand.java-
  This file contains JUnit test cases for testing the functionality of the implemented
  LinkStrand class.

DNABenchmark.java-
  File contains the main method for benchmarking the performance of DNA manipulation methods.
  This file can be used to compare the efficiency of LinkStrand implementation against String and
  StringBuilder implementations.
