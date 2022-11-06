public class Main {

    static int nEndValue = 20;

    public static void main(String[] args) {

        // (1) sum of first n integer numbers
        //int n = nEndValue;
        int n = 10;
        int sum = 0;

        // (1.1), (1.2)
        if (n > 0) {
            // (1.1)
            System.out.println();
            System.out.printf("(1.1) Sum of all numbers from %d to 1: ", n);
            System.out.println();
            sum = sumRecursivelyNumbers(n);
            System.out.println("Sum = " + sum);

            // (1.2)
            System.out.println();
            System.out.printf("(1.2) Sum of all numbers from 1 to %d: ", n);
            System.out.println();
            sum = sumRecursivelyNumbersAscending(1, n);
            System.out.println("Sum = " + sum);
        } else {
            System.out.printf("Cannot compute sum, n is %d!", n);
            System.out.println();
        }

        // (1.3)
        System.out.println();
        if (nEndValue > 0) {
            System.out.printf("(1.3) Sum of all numbers from 1 to %d (using an end value): ", nEndValue);
            System.out.println();
            sum = sumRecursivelyNumbersAscendingUsingEndValue(1);
            System.out.println("Sum = " + sum);
        } else {
            System.out.printf("Cannot compute sum, the end value is %d!", nEndValue);
        }

        // (2) Sum of first n EVEN integers
        if (n > 0) {
            // (2.1) Test an even number
            n = 10;
            System.out.println();
            System.out.printf("(2.1) Sum of even numbers from %d to 1: ", n);
            System.out.println();
            sum = sumRecursivelyEvenNumbers(n);
            System.out.println("Sum = " + sum);

            // (2.2) Test an odd number
            n = 9;
            System.out.println();
            System.out.printf("(2.2) Sum of even numbers from %d to 1: ", n);
            System.out.println();
            sum = sumRecursivelyEvenNumbers(n);
            System.out.println("Sum = " + sum);
        } else {
            System.out.printf("Cannot compute sum, n is %d!", n);
            System.out.println();
        }

        // (2') Extra: Sum of first n ODD integers
        if (n > 0) {
            // (2'.1) Test an even number
            n = 10;
            System.out.println();
            System.out.printf("(2'.1) Sum of odd numbers from %d to 1: ", n);
            System.out.println();
            sum = sumRecursivelyOddNumbers(n);
            System.out.println("Sum = " + sum);

            // (2'.2) Test an odd number
            n = 9;
            System.out.println();
            System.out.printf("(2'.2) Sum of odd numbers from %d to 1: ", n);
            System.out.println();
            sum = sumRecursivelyOddNumbers(n);
            System.out.println("Sum = " + sum);
        } else {
            System.out.printf("Cannot compute sum, n is %d!", n);
            System.out.println();
        }

        // (3) Palindrome
        // (3.1) recursive string reverse
        System.out.println();
        System.out.println("(3.1) Check if a word is a palindrome using a recursive string reverse:");
        System.out.println();
        String[] words = {"aerisirea", "kayak", "detrarated", "Ana", "madam", "potop", "ABBA", "palindrome"};
        String reversedString = "";
        for (String myString : words) {
            myString = myString.trim().toLowerCase();
            reversedString = reverseString(myString);
            System.out.println("String: " + myString);
            System.out.println("Reversed string: " + reversedString);
            System.out.println("String '" + myString + "' is " + (myString.equals(reversedString) ? "" : "not ") + "a palindrome");
            System.out.println("");
        }

        // (3.2) recursive check of first and last letter
        System.out.println();
        System.out.println("(3.2) Check if a word is a palindrome using a recursive check of first and last letter:");
        for (String myString : words) {
            myString = myString.trim().toLowerCase();
            System.out.println("String '" + myString + "' is " + (isPalindrome(myString) ? "" : "not ") + "a palindrome");
        }

        // (4) Compute sum of the digits for a number
        System.out.println();
        System.out.println("(4) Compute sum of the digits for a number:");
        int[] numbers = {1234, 4321, 75285, 1234567, 5555, 100};
        for (int myNumber : numbers) {
            System.out.println("Sum of the digits for number " + myNumber + " is " + sumOfDigitsForANumber(myNumber));
        }

        // (5) Get the value for the n-th element from Fibonacci's sequence
        System.out.println();
        System.out.println("(5) Fibonacci sequence:");
        int[] fibArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 20, 25};
        for (int myNumber : fibArray) {
            System.out.println("Element #" + myNumber + " from the Fibonacci sequence is " + fibonacci(myNumber));
        }
    }

    private static int sumRecursivelyNumbers(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            System.out.println("Add 1");
            return 1;
        }

        System.out.println("Add " + n);
        System.out.println("Return Recursive(" + (n - 1) + ")");
        return (n + sumRecursivelyNumbers(n - 1));
    }

    private static int sumRecursivelyNumbersAscending(int nStart, int nEnd) {
        if (nStart <= 0) {
            return 0;
        }

        if (nStart == nEnd) {
            System.out.println("Add " + nEnd);
            return nEnd;
        }

        System.out.println("Add " + nStart);
        System.out.println("Return Recursive(" + (nStart + 1) + "," + nEnd + ")");
        return (nStart + sumRecursivelyNumbersAscending(nStart + 1, nEnd));
    }

    private static int sumRecursivelyNumbersAscendingUsingEndValue(int nStart) {
        if (nStart == nEndValue) {
            return nEndValue;
        }

        System.out.println("Add " + nStart);
        System.out.println("Return Recursive(" + (nStart + 1) + ")");
        return (nStart + sumRecursivelyNumbersAscendingUsingEndValue(nStart + 1));
    }

    private static int sumRecursivelyEvenNumbers(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n == 2) {
            System.out.println("Add 2");
            return 2;
        }

        if (n % 2 == 0) { // Even number: add it
            System.out.println("Add " + n);
            System.out.println("Return Recursive(" + (n - 2) + ")");
            return (n + sumRecursivelyEvenNumbers(n - 2));
        } else { // Odd number: skit it
            System.out.println("Skip " + n);
            System.out.println("Return Recursive(" + (n - 1) + ")");
            return sumRecursivelyEvenNumbers(n - 1);
        }
    }

    private static int sumRecursivelyOddNumbers(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            System.out.println("Add 1");
            return 1;
        }

        if (n % 2 != 0) { // Odd number: add it
            System.out.println("Add " + n);
            System.out.println("Return Recursive(" + (n - 2) + ")");
            return (n + sumRecursivelyOddNumbers(n - 2));
        } else { // Even number: skit it
            System.out.println("Skip " + n);
            System.out.println("Return Recursive(" + (n - 1) + ")");
            return sumRecursivelyOddNumbers(n - 1);
        }
    }

    public static boolean isPalindrome(String str) {
        if ((str == null) || (str.length() <= 1))
            return true;

        if (str.charAt(0) == str.charAt(str.length() - 1))
            return isPalindrome(str.substring(1, str.length() - 1));

        return false;
    }

    public static String reverseString(String str) {
        if ((str == null) || (str.length() <= 1))
            return str;

        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static int sumOfDigitsForANumber(int n)
    {
        if (n == 0)
            return 0;

        return ((n % 10) + sumOfDigitsForANumber(n / 10));
    }

    public static int fibonacci(int n)
    {
        if (n <= 1) // f(0) = 0; f(1) = 1
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}