# Quick array review

Arrays are collections of elements of the same type. The type of the array is
given by:

    <element type>[] // An "array of <element type>" or an "<element type> array"

For example:

    String[]  array1; // Array of String objects or a String array
    int[]     array2; // Array of ints or an int array
    double[]  array3; // Array of doubles
    Scanner[] array4; // Array of Scanners
    int[][]   array5; // Array of int arrays or an int array array
    int[][][] array6; // Array of arrays of int arrays
    int[][][][][][][] pleaseDoNotActuallyUseThis;
        // Array of arrays of arrays of arrays of arrays of arrays of int arrays

Arrays in Java are objects. They are declared like any other object:

    int[] numbers; // Declares a variable that holds arrays of integers

And they have three different "constructors". Two of them work the same way as
they do for other objects:

    numbers = new int[5];                // Creates an array with default values
    numbers = new int[] {1, 2, 3, 4, 5}; // Creates an array with the specified values

And the last one works only if you declare *and* create the array at the same
time:

    int[] special = {2, 3, 5, 7, 11};    // OK
    special = {0, 1, 1, 2, 3};           // Not OK

The element at index `i` can be accessed by typing the name of the array,
followed by the index surrounded by square brackets:

    System.out.println(special[3]); // Prints "7"

And you can assign the element at index `i` in a similar way:

    special[3] = 2; // Array is now {2, 3, 5, 2, 11}

One way of looking at indices is to imagine an array being a line of elements
sitting side-by-side, and the index `i` being the `i`th element after the first:

    int[] array = new int[5];

          ---------------------
          |   |   |   |   |   |
          ---------------------
    index:  0   1   2   3   4

Arrays can hold a limited number of objects. This is referred to as the array's
"size" or "length". An array's size is determined when the array is created,
and cannot be changed. An array's size can be accessed using its 'length' field:

    System.out.println(special.length); // Prints "5"

If you don't use braces to specify an array's elements when you create it, the
elements are set to their default values:

    int, short, byte --> 0
    char             --> '\u0000' // char equivalent of 0
    long             --> 0L
    float            --> 0.0f
    double           --> 0.0d
    boolean          --> false
    object           --> null

The various types of 0 can be treated more or less as the same thing. The main
gotcha is the last line. That is why the following bit of code won't work:

    String[] array = new String[5];
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i].length()); // NullPointerException!
    }

    int[][] matrix = new int[5][5];
    for (int i = 0; i < array.length; i++) {
        int[i][i] = i; // NullPointerException!
    }
