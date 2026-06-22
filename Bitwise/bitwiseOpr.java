package Bitwise;

public class bitwiseOpr {
    public static void main(String[] args) {
        
    }
    static void andOpr(){
        //And operator(&):-
        //gives truw  only when both are true(i.e 1)
        //And of any number n with 1 gives n only
    }
    static void orOpr(){
        //(|):-
        //gives true even if one is true(i.e combinations like 0|1 and 1|0 )
    }
    static void xorOpr(){
        //(^):-
        //give true if and only if one is true(not when both are 1 atleast one 0 and one 1)
        //a^1=compliment of a(i.e all the 1s and 0s will be interchanged in binary)
        //1^1=0
        //a^0=a
        //a^a=0
    }
    static void complimentOpr(){
        //(~):-
        //return compliment of the number
    } 
    static void lestShiftOpr(){
        //(<<):-
        //left shifts the digits of binary number
        //new digit on the right side will be zero.
        //a<<b=a*(2^b)
    }
    static void rightShiftOpr(){
        //(>>):-
        //right shifts the binary number.
        //a>>b=a/(2^b)
    }
}
