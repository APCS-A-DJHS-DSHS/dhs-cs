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

## Iterating over 2D arrays

2D array iteration isn't much different than regular array iteration. It
involves more steps, but in the end it boils down to nested regular array
iteration.

Say you have an int matrix:

    int[][] matrix = new int[5][5];
    <do some math stuff>
    System.out.println(Arrays.deepToString(matrix));
    // outputs
    // [[23, 39, 44, 95, 81],
    //  [48, 80, 41, 74, 11],
    //  [88, 41, 94, 33, 21],
    //  [89, 41, 80,  3, 83],
    //  [ 3, 85, 26, 39, 67]]

And for whatever reason, you want to double the values of each element.
To do so, you need to write something about equivalent to:

    for (each element) {
        element *= 2;
    }

Now, how would the `for (each element)` part work?

Remember that multi-dimensional arrays are more or less nested arrays. So in
our case, we would have:

    ----------
    | matrix |------------
    ----------           |
                         |      ---------------------
                         -----> |   |   |   |   |   |
                                ---------------------
    --------------------------    |   |   |   |   |
    | 23 | 39 | 44 | 95 | 81 | <---   |   |   |   |
    --------------------------        |   |   |   |
    --------------------------        |   |   |   |
    | 48 | 80 | 41 | 74 | 11 | <-------   |   |   |
    --------------------------            |   |   |
    --------------------------            |   |   |
    | 88 | 41 | 94 | 33 | 21 | <-----------   |   |
    --------------------------                |   |
    --------------------------                |   |
    | 89 | 41 | 80 |  3 | 83 | <---------------   |
    --------------------------                    |
    --------------------------                    |
    |  3 | 85 | 26 | 39 | 67 | <-------------------
    --------------------------

Doubling each element is going to take a few steps:

  1. Iterate across the outer array, accessing each inner array in turn
  2. For each inner array, iterate across its elements
  3. For each element, double its value and store it back into the array.

Let's translate the above to code:

  1. For this step, we want to access each inner array. `matrix` is an int[][],
     so matrix[<num>] should get us one of the int[] inside. So we write a
     `for` loop that covers each index in `matrix` to access each of the inner
     arrays:

         for (int i = 0; i < matrix.length; i++) {

             // Something with matrix[i]

         }

  2. We now have a reference to an inner array -- `matrix[i]`. We want to
     iterate across each element in this array, which means another `for` loop.
     For a "regular" int array, the loop would look like:

         int[] array = new int[5];
         for (int j = 0; j < array.length; j++) {

             // Something with array[j]

         }

     So we just replace the reference to `array` with the array we're
     actually interested in -- `matrix[i]`:

         for (int j = 0; j < matrix[i].length; j++) {

             // Something with matrix[i][j]

         }

  3. We now have a reference to an element in the matrix -- `matrix[i][j]`.
     This can be manipulated like any other variable. In this case, we want to
     double its value, so we write something like:

         matrix[i][j] *= 2;

Now to put everything together:

    // accessing inner arrays
    for (int i = 0; i < matrix.length; i++) {

        // matrix[i] is an inner array
        // now accessing each element of matrix[i]
        for (int j = 0; j < matrix[i].length; j++) {

            // matrix[i][[j] is the element we want to alter
            matrix[i][j] *= 2;

        }

    }

So the final result looks like this:

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] *= 2;
        }
    }
