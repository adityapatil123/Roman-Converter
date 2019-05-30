# Roman-Converter
Simple Roman Converter using Kotlin

## Prerequisites:
1. Java Runtime Environment
2. Kotlin
3. Intellij,Eclipse or Android Studio

## Basic Information:
This is simple program using Kotlin,where it performs conversion from Arabic to Roman Numerals and vice-versa
-First we will understand how Roman numbers are written compared to Arabic, and how to convert them logically.

| Arabic |  Roman |
|-------:|-------:|
|    1   |     I  |
|    2   |    II  |
|    3   |   III  |
|    4   |    IV  |
|    5   |     V  |
|    6   |    VI  |
|        |        |
|    9   |    IX  |
|   10   |     X  |
|        |        |
|   32   | XXXII  |
|        |        |
|   40   |    XL  |
|   49   |  XLIX  |
|   50   |     L  |

and much more...

- You must be saying why 4 is not 'IIII', well its not completely wrong, but its about efficiency.Hence after every digit its not neccessary that its making addition only.
- Notice 4,5  and 6, In 5, **'V'** is used. In 6,one digit 'I' is added which adds 1 to **'VI'**. But things changes for **'IV'** as small digit 'I' preceds big digit 'V',which is what changes from addition to subtraction.
- OK, so it is clear that big digit should preced small for addition, and opposite for subtraction.
- If you everthig is solved, still one thing remains.Look at 49, its not **'IL'** even if its most efficient.
- In case of these consider these simple rules of 4 and 9, it also applies for 40, 90, 400, 900 and so on. After these number shift happens till the next clear big digit
 E.g. 40-49 roman will be **'XL-XLIX'** till 50 comes as **L**
- Now we are ready to code.

## Approach:
- We will have two seperate parts, one converts Arabic to Roman and other does the reverse.
- We will ask the user for the choice.

### Arabic to Roman Converter:
- Ask the user for the number to be converted.
- Map the arabic to roman digits, additional 4's and 9's members, Also make an array of those arabic numbers in descending order.
  ```kotlin
   var num = arabicInput
        for (i in 0..arrayRoman.size - 1) {
            var count = num / arrayRoman[i]
            num = num % arrayRoman[i]
            while (count > 0) {
                romanOutput += arabicToRoman[arrayRoman[i]]
                count--
            }
        }
  ```
 Here, we are looping in the said array, where taking count from division and using **num** as remainder, which we will ne used in next iteraion.
 - E.g. for **64**, 
 ```
 #1st iteraion
 count = 64 / 100 = 0  //hence no while loop execution
 num = 64 / 100 = 64 
 ```
 Same will happen for #2nd iteration where **90** will be there instead of 100.
 ```
 #3rd iteraion
 count = 64 / 50 = 1  //hence while loop will execute once, romanOutput = "L"
 num = 64 / 50 = 14 
 ```
```
 #5th iteraion
 count = 14 / 10 = 1  //hence while loop will execute once, romanOutput = "LX"
 num = 14 / 10 = 4 
 ```
 ```
 #8th iteraion
 count = 4 / 4 = 1  //hence while loop will execute once, romanOutput = "LXIV"
 num = 4 / 4 = 0 
 ```
 - But first two steps are unnecessary, as number is below 90 and we are checking for 90 and 100
 - Hence we are checking input usinf If..Else and checking the starting counter of for loop.
 ```kotlin
 if (arabicInput > 90) { startCount = 1 }
        else if (arabicInput > 50) { startCount = 2 }
        else if (arabicInput > 40) { startCount = 3 }
        else if (arabicInput > 10) { startCount = 4 }
        else if (arabicInput > 5) { startCount = 5 }
        else if (arabicInput > 4) { startCount = 6 }
        else if (arabicInput > 1) { startCount = 7 }
 ```
 Also make change in for loop statment:
 ```kotlin
 for (i in startCount..arrayRoman.size - 1)
 ```
 As we are done with 1st part, let's move to second.
 
### Roman to Arabic Converter:
- Ask the user for the roman-numeral to be converted.
- Map the roman to arabic digits.Here, there is no need of 4's and 9's.As per discussed, we can go throw roman literal one by one digit unlike Arabic.
- Make the input string reversed for the sake of easy computations.
 ```kotlin
 for (i in 0..romanInputReversed.length -1)
    {
       val arabicNum:Int = romanToArabic[romanInputReversed[i].toString()]!!
        if(arabicNum < prevNum)
        {
            arabicOutput -= arabicNum
        }
        else{
            arabicOutput += arabicNum
        }
        prevNum = arabicNum
    }
 ```
 Here, we are looping through string one character at a time and also saving previous chracter's value in **prevNum**
 -Make checking at every iteration whether to add or subtract the value.
 -Finally, print the result as **arabicNum**
 -Check for different case and make the according changes.


