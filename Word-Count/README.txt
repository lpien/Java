Word-Count is a binary search tree data structure (not the one using the one already build-in), and uses this data structure to store statistics about certain words read in from a text input file.  The output of this program is an alphabetically ordered list of words read from the file with their 
1. Frequencies (number of occurrences in the text)
2. Total number of words read in the text
3. Total number of unique words
4. Height of the tree
5. Average depth of a node

For example: If the phrase "this code is good code" was passed through the program, the output would list these 5 words in alphabetical order with "code" having a frequency of 2 (and the rest of the words have 1) and there would be 4 total unique words. 

In ArrayTree.java the class implements a data array of type Comparable.  This class includes several methods that are attributes of the data array such as the size, height, depth, insert, find, and a method that prints the array (or nodes) in order.  Word.java is a class for a word that is found - it is a place to store characteristics of the strings.  For example each Word() has a string and a count.  The printConsumer class has a method that counts the number of words.  
