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
gotcha is the last line; you have to remember to initialize the objects in an
object array before you use them!

# 2D arrays

Creating square 2D arrays is fairly simple:

    int[][] board        = new int[9][9];       // Creates 9x9 int array
    ChessPiece[][] board = new ChessPiece[8][8] // Creates chessboard

How do you work with these? Remember what regular arrays look like:

    int[] array = new int[5];

          ---------------------
          |   |   |   |   |   |
          ---------------------
    index:  0   1   2   3   4

2D arrays are simply arrays of arrays. So 2D int array is an array of int
arrays:

    int[][] example = new int[5][5];

    index:  0   1   2   3   4
          ---------------------
          |   |   |   |   |   |
          ---------------------   0   1   2   3   4  : index
            |   |   |   |   |   ---------------------
            |   |   |   |   --> |   |   |   |   |   |
            |   |   |   |       ---------------------
            |   |   |   |       ---------------------
            |   |   |   ------> | y |   |   |   |   |
            |   |   |           ---------------------
            |   |   |           ---------------------
            |   |   ----------> |   |   |   | x |   |
            |   |               ---------------------
            |   |               ---------------------
            |   --------------> |   |   |   |   |   |
            |                   ---------------------
            |                   ---------------------
            ------------------> |   |   |   |   |   |
                                ---------------------

To access any particular element, you first select the array it's in, then
select the element in that array. For example, if you want to access the
element marked by `x` above:

    // Third array --> index 2
    // Fourth element --> index 3
    //
    // Third array is example[2]
    // Fourth element of third array is example[2][3]
    example[2][3] = 1;

Similarly for `y`:

    // y
    // Fourth array --> index 1
    // First element --> index 0
    //
    // Fourth array is example[3]
    // First element of second array is example[3][0]
    example[3][0] = 6;

You can also think of square 2D arrays as a matrix:

    int[][] example = new int[5][5];

    ---------------------
    |   |   |   |   |   |
    ---------------------
    |   |   |   |   |   |
    ---------------------
    |   |   |   | x |   |
    ---------------------
    |   |   |   |   |   |
    ---------------------
    |   |   |   |   |   |
    ---------------------

In this case, the number in the first set of brackets usually refers to the
row, while the second refers to the column. Thus, the `x` would be at
`example[2][3]` in this case.

You *can* switch what number represents rows and what number represents
columns; just be sure that if you're working with/doing something for other
people that you are using the convention they are expecting.

The inner arrays in 2D arrays do not have to be the same size:

    int[][] example = new int[5][];
    example[0] = new int[2];
    example[1] = new int[3];
    example[2] = new int[5];
    example[3] = new int[7];
    example[4] = new int[11];

    index:  0   1   2   3   4
          ---------------------
          |   |   |   |   |   |
          ---------------------   0   1   2   3   4   5   6   7   8   9   10 : index
            |   |   |   |   |   ---------------------------------------------
            |   |   |   |   --> |   |   |   |   |   |   |   |   | x |   |   |
            |   |   |   |       ---------------------------------------------
            |   |   |   |       -----------------------------
            |   |   |   ------> |   |   |   |   |   |   |   |
            |   |   |           -----------------------------
            |   |   |           ---------------------
            |   |   ----------> |   |   |   | y |   |
            |   |               ---------------------
            |   |               -------------
            |   --------------> |   |   |   |
            |                   -------------
            |                   ---------
            ------------------> | z |   |
                                ---------

Here, `x` is at `example[4][8]`, `y` is at `example[2][3]`, and `z` is at `example[0][0]`

Unfortunately, there isn't an equivalent to `new int[5][5]` for uneven inner
arrays. You will have to create them manually.
