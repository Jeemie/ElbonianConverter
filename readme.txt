Description
This assignment requires you to practice pair programming and test driven development, reflect on the experience, summarize the reflection, and draw conclusions about whether the practice is one that supports your work style.

You will develop the program specified below with a pair-programming partner on your team. If your team has an odd number of members, then the lead engineer or assistant lead engineer will pair with that remaining person but will write different parts of the program the second time. During your programming session you will take notes about what you did, how much time you spent as the driver, how much as the navigator, how often you switched roles, and so on. Please read the attached Pair Programming Assessment document *before* you begin the assignment. After the programming assignment is done, the same code will be submitted by the partners but each person will submit their own version of the assessment form. If you are a lead engineer who does two pair programming sessions, fill out the assessment for just the first session and before you do the second one. Make sure you do not accidentally submit the same code with two different partners!

Program Specification
The Elbonians were conquered and made part of the Roman Empire. However, Roman emperors soon  realized that it was impossible to have Elbonians do anything right. Consequently, Elbonians were granted self-government so Roman bureaucrats would stop quitting their jobs.

You will create a program to convert the Elbonian numeral set (which was a confused version of the Roman numeral set) to Arabic numbers. You will also create comprehensive tests to catch malformed Elbonian numbers and illegal inputs, and ensure that the conversions are correct. 

The Elbonian numerals are represented by the following letters of the alphabet:
M = 1,000	
C = 100		D = 500	
X = 10		L = 50
I = 1		V = 5

Elbonian Numeral Rules
1.	The same letter that is a multiple of 10 (including 1) can be repeated in a row to represent a multiple of that value. However, a letter can only be repeated up to three times in a row.  MMM = 3000, XX = 20 
2.	Numbers are represented by the letters from the greatest value down to the lowest value. In other words, the letter I would never appear before the letters V, X, L, C, D, or M. The letter C would never appear before the letters D or M. The letters are summed together to determine the value.
3.	Since a letter cannot be repeated four times, a subtraction rule is used. Writing the same lowercase letter to the left of a matching uppercase letter represents subtraction. 
a.	For multiples of 10, a lowercase letter subtracts one-tenth of the succeeding matching letter. For example, mM = 900, cC = 90, and xX = 9.
b.	For multiples of 5, a lowercase letter subtracts one-fifth of the succeeding letter. For example, dD = 400, lL = 40, and vV = 4.
c.	If a lowercase letter precedes an uppercase letter, that uppercase letter may not be repeated. You cannot have the following numbers: cCC, MmMMM, DxXXV
4.	The letters D, L and V may appear only once in a number. You cannot have VvV or LL

The ElbonianArabicConverter constructor takes in a String that is a number in Elbonian or Arabic form. These strings may have leading or trailing whitespace, but no whitespace in between characters.  Any string that is not a valid Elbonian numeral or Arabic number should throw a MalformedNumberException. 

The ValueOutOfBoundsException is thrown when using the toElbonian () method if the value cannot be represented in Elbonian numerals.
