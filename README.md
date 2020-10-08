# Number-Converter
Conversion of a number from base 10 to base 2, including its fractional part

How it works: the number is splitted into integer part (in front of decimal point) and fractional part (behind decimal point). 

#### Conversion of integer part
First take modulo 2 operation of the integer part and remember its result, then divido take divido 2 operation.  
Repeat this until the result of divido operation is zero.  
The base 2 version of input is obtained by writing the remembered results right to left. 

###### Example
n = 6  
 6 % 2 = 0  
 6 / 2 = 3  
n = 3  
 3 % 2 = 1  
 3 / 2 = 1  
n = 1  
 1 % 2 = 1  
 1 / 2 = 0  
--> 6 in base 2 is 110  

why it works:  
number = (number / divisor) * divisor + number % divisor  
n = 6  
 = 2 * 3 + 0  
 = 2 * (2 * 1 + 1) + 0  
 and by removing the brackets:   
 = 1 * 2^2 + 1 * 2^1 + 0 * 2^0  
