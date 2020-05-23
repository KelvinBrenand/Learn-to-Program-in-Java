# Project Description

### Module 2 Project - Odds or Evens

For this project you are going to program a game called "Odds and Evens". The game is similar to rock paper scissors. It is played between two players, in your version it will be you versus the computer. Each player will choose either "odds" or "evens", since you’re playing the computer you will get first pick. Once you have chosen your side, you each choose a number of fingers to play- 0 to 5. The winner is determined by whether the sum of your fingers is odd or even (depending on what you chose). Here's a clip of the game being played: https://youtu.be/4ZOLs03vILs?t=1m

For example, let’s say you choose "evens". That means the computer gets "odds". You choose to play 2 fingers and the computer plays 3. 2 + 3 = 5, which is odd so the computer wins.

#### Part 1 - Pick odds or evens

1. Create a new java file called "OddsAndEvens".
2. Add a println that produces the following output:

Let’s play a game called “Odds and Evens”

3. Ask the user for their name and then use a scanner to let them type their name into the consol.

What is your name?

4. Now greet the user and ask them to choose either odds or evens. Use a scanner to let them type in either "O" or "E".
Hi name, which do you choose? (O)dds or (E)vens?
**NOTE**: To compare Strings you can’t use ==, you must use .equals(). For example, your code might look like:

string1.equals(string2)

5. Using an if/else statement print out whether the user chose "odds" or "evens".

name has picked odds! The computer will be evens.

Or

name has picked evens! The computer will be odds.

6. Finally add a println that produces a bunch of "-" characters to separate this stage from the others in your output.
Here is an example of the output your stage one should produce:

![](/Images/1-part1Output.png)

#### Part 2 - Play the Game

Now you are going to be adding the actual game play to your game.

1. Ask the user how many "fingers" they are going to play, and let them enter in a number.

How many “fingers” do you put out?

2. Add the following code to your program to let the computer choose a random number to represent their fingers:

Random rand = new Random();
int computer = rand.nextInt(6);

**NOTE**: you must make 1 more change to your code to make this work. Random must be imported, but it is part of the same "package" as Scanner so just change your import statement at the top from

import java.util.Scanner to import java.util.*;

3. Add a println that tells the user how many fingers the computer played.
The computer plays number "fingers".
4. Add another line of "-" characters to separate this part of your output from the results.
5. Now you need to determine what the results are.
* Add the user’s number and the computer’s numbers together to get the sum.
* Add a println that will print out the math to show the user.

userNumber + computerNumber = sum

* Now you need to figure out if the sum is odd or even. You can use the % or "mod" operator to do so. The mod operator returns the reminder, any number % 2 with a remainder of 0 (meaning it is perfectly divisible by 2) is even, any number % 2 with a remainder of 1 is odd. Here is the code you can use:

boolean oddOrEven = sum % 2 == 0;

oddOrEven will be true if sum us even, it will be false if sum is odd.

* Now use an if/else statement to print out whether sum was odd or even.
6. Add another line of “-“ characters to end your program.
Here is an example of the output your stage two should produce:

![](/Images/2-part2Output.png)

#### Part 3 - Who won?
Now that we know the results, it’s time to decide who the winner is!

Inside your if/else statement that prints out odd or even you are going to add another set of if/else statements to tell who the winner is, based on what the player chose back in stage 1. Here is some "pseudo code" (notation resembling simplified code, not real code) that you can use to write the real code.

if (the sum was even) {
   print out even
   if (the user chose evens) {
      the user wins
   } else {
      the computer wins
} else {
   // inverse of above if statement
}
Here is an example of what the output of your stage three should produce:

![](/Images/3-part3Output.png)
