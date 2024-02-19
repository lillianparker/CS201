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

P4-autocomplete: Java Programming (March/April 2023)
This project focuses on implementing efficient autocomplete algorithms using Java,
specifically leveraging comparators and binary search algorithms, along with HashMap
based approaches.

AutocompleteMain.java-
  Allows the user to interact with the autocomplete application with supporting data file.
  The default implementationg is BruteAutocomplete, with additional implementations of
  BinarySearchAutocomplete and HashListAutocomplete.

PrefixComparator.java-
  Defines a Comparator used in BinarySearchAutocomplete to compare terms based on a given prefix size.

BinarySearchLibrary.java-
  Contains utility methods for binary search functionality used in  BinarySearchAutocomplete.
  Implements methods for finding the first and last indices of terms matching a prefix.

BinarySearchAutocomplete.java-
  Completes implementation of topMatches method which returns highest weighted matches for given prefix. Relies on methods implemented in BinarySearchLibrary.

HashListAutocomplete.java-
  New autocomplete implementation using a HashMap based approach. Implementation provides O(1) performance for topMatches but consumes more memory. 



P5-Huffman: Java Programming (April 2023)
This project focuses on the implementation of Huffman Coding, a fundamental algorithm used in data compression. Huffman Coding is widely used in various applications, including compression algorithms like ZIP. The project introduces students to the concepts and implementation details of Huffman Coding which emphasizes its significance in reducing the size of data while maintaining integrity.

HuffMainDecompress.java-
  This file contains the main method for decompressing a file using the Huffman algorithm. It prompts the user to select a file for decompression, then calls the HuffProcessor.decompress method, and saves the decompressed file with a specific naming convention. 

HuffProcessor.java-
  This file contains the main logic for bothc ompression and decompression using the Huffman algorithm. It includes methods 'compress', 'decompress', getCounts', 'makeTree', 'makeEncodings', and 'writeTree,' responsible for determining frequencies, creating a Huffman tree, generating encodings, and writing compressed data to files.

HuffMainCompress.java-
  This file contains the main method for compressing a file using the Huffman algorithm. It prompts the user to select a file for compression, calls the 'HuffProcessor.compress' method, and saves the compressed file with a specific naming convention. The compression process involves determining character frequencies, creating Huffman trees, generation encodings, and writing compressed data.

HuffNode.java-
  This class represents a node in the Huffman tree. Each node contains information about the character value, its frequency, and references to left and right child nodes. The Huffman tree is constructed using instances of this class.

HuffException.java-
  This class defines a custom exception specific to errors encountered during the Huffman coding process. It provides additional error handling capabilities for dealing with exceptional conditions during compression and decompression.
  

