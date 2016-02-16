This assignment involves word processing and analysis of the keyboard layout.  The text used to test these programs is Alexis de Toqueville's "Democracy in America - Volume 1". 

Part 1 of the assingment has to do with counting the frequencies of occurring diads.  A diad in this instance is a sequence of two characters and the Shift key was not taken into account for simplicity.  
For example:
ab ab.
Has 7 characters total (the last one is ‘\n’), 6 diads total ("ab", "b ", " a", "ab", "b." and ".\n"), 5 distinct characters and 5 distinct diads.

Part 1, called Frequencies.java, uses a buffered reader to read the file.  While this file is being read, it takes each individual character and inputs it into a queue and simultaneously counts the total number of characters.  Afterwards, the code pulls each character from the queue and appends them to make a string.  Using this string, now a diad, it counts the distinct number of diads created and also adds them to an array list of strings containing the all the diads.  After the array list of total diads is created, I use a for-loop to retreive all of the distinct diads and create a new array list of type Diad containing all distinct diads and their number of occurrences.  The array list is then sorted by frequency and then the top 10 most occurring diads are printed out.    
The output of this is:
1. Total number of characters in the text
2. Number of distinct diads
3. 10 most common distinct diads with their frequencies
4. Time it took to process all diads

Part 2 of the project involves assessing the efficiency of keyboard layouts, because presumably typing with two hands is faster than one (so whichever keyboard allows for more diads to be typed with two hands than one is more efficient).  The two keyboards analyzed in class typeSpeed.java is the standard QWERTY keyboard and the Dvorak keyboard.  Again, the Shift key and backspace is not taken into account.  I first create four different array lists.  The QWERTY left hand and QWERTY right hand lists contain all of the characters on the keyboard for the left hand and right hand respectively, while a similar list is also created for the Dvorak left/right hand.  In this case the space bar is only assigned to the right hand.  The characters are then read from the file and put in a queue.  Characters are later pulled from the queue to create a diad string.
The diad is then compared to lists of QWERTY, Dvorak, and left and right hands and then sorted based on these parameters.  Hypothetical times are calculated based on the numbers given.  
	Two hand: 240char/min = 4char/sec = 2char/.5sec = 1diad/.5sec
	One hand: 120char/min = 2char/sec = 1diad/sec
This means that if a one handed diad is found the hypothetical time would increase by 1 second, and if a two handed diad is found the hypothetical time would increase by .5 seconds.
The output of this program is
1. Hypothetical time reqired to type the text input using the two keyboards
2. Actual time in seconds for program to compute times

Part 3 of the assignment which is newKeyboard.java was quite difficult and involved designing the "ideal" keyboard to create maximum efficiency in typing.
To go about doing this I first started by creating a queue of all the possible keys to press by the user.  Then, I from several tests of the two test documents, I sort keys into either a left or right hand array list.  In a perfect world, every single
diad we have to type would be two hand - that's obviously impossible - but the next best thing would to take the most frequently occurring diads and make those two handed.  From my test results some of the most common diads found were "e ", " t", "th", "he", and several others; this means I would make sure the "e"and space bar were separated (this method was only applied to a few of the most common diads).  After this process was done, I took similar steps to part 1, where I read the file and created a queue of all characters.  These characters were then compared to the queue of all the possible keys on a keyboard so that a left hand and right hand array lists will hold what character will be on what side of the keyboard.  This is done by essentially splitting up the diad so that for as many scenarios as possible the algorithm creates a two handed diad.  Like part 2, the hypothetical time is calculated the same way depending on what characters are read and what side of the new keyboard these characters reside.  
The output of this program is
1. The list of all the left hand keys
2. List of all the right hand keys
3. Hypothetical time it would take to type the document
4. Total runtime of the code.  
