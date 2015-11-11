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

2D arrays are simply arrays of arrays. So 2D `int` array is an array of `int`
arrays:

    int[][] example = new int[5][5];

                                   index:  0   1   2   3   4
                                         ---------------------
                                         |   |   |   |   |   |
     index: 0   1   2   3   4            ---------------------
          ---------------------            |   |   |   |   |
          |   |   |   |   |   | <-----------   |   |   |   |
          ---------------------                |   |   |   |
          ---------------------                |   |   |   |
          |   |   |   |   |   | <---------------   |   |   |
          ---------------------                    |   |   |
          ---------------------                    |   |   |
          |   |   |   | x |   | <-------------------   |   |
          ---------------------                        |   |
          ---------------------                        |   |
          | y |   |   |   |   | <-----------------------   |
          ---------------------                            |
          ---------------------                            |
          |   |   |   |   |   | <---------------------------
          ---------------------

To access any particular element, you first select the array it's in, then
select the element in that array. For example, if you want to set the element
marked by `x` above to 1:

    // Third array is at index 2
    // Fourth element of third array is at index 3
    //
    // Third array is example[2]
    // Fourth element of third array is example[2][3]
    example[2][3] = 1;

A similar process can be used for `y`. Let's set `y` to `6`:

    // Fourth array is at index 3
    // First element of fourth array is at index 0
    //
    // Fourth array is example[3]
    // First element of fourth array is example[3][0]
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

The number in the first set of brackets usually refers to the row, while the
second refers to the column. Thus, the `x` would be at `example[2][3]` in this
case.

The inner arrays in 2D arrays do not have to be the same size. Here's code that
creates a "jagged" 2D array and a visualization of the result:

          int[][] example = new int[5][];
          example[0] = new int[2];
          example[1] = new int[3];
          example[2] = new int[5];                Index:  0   1   2   3   4
          example[3] = new int[7];                      ---------------------
          example[4] = new int[11];                     |   |   |   |   |   |
                                                        ---------------------
                                                          |   |   |   |   |
    index:  0   1   2   3   4   5   6   7   8   9   10    |   |   |   |   |
          ---------                                       |   |   |   |   |
          | z |   | <--------------------------------------   |   |   |   |
          ---------                                           |   |   |   |
          -------------                                       |   |   |   |
          |   |   |   | <--------------------------------------   |   |   |
          -------------                                           |   |   |
          ---------------------                                   |   |   |
          |   |   |   | y |   | <----------------------------------   |   |
          ---------------------                                       |   |
          -----------------------------                               |   |
          |   |   |   |   |   |   |   | <------------------------------   |
          -----------------------------                                   |
          ---------------------------------------------                   |
          |   |   |   |   |   |   |   |   | x |   |   | <------------------
          ---------------------------------------------

Here, `x` is at `example[4][8]`, `y` is at `example[2][3]`, and `z` is at `example[0][0]`

Unfortunately, there isn't an equivalent to `new int[5][5]` for uneven inner
arrays. You will have to create them manually.

## Iterating over 2D arrays

2D array iteration isn't much different than regular array iteration. It
involves more steps, but in the end it boils down to nested regular array
iteration.

Say you have an `int` matrix:

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

  1. For this step, we want to access each inner array. `matrix` is an
     `int[][]`, so `matrix[<num>]` should get us one of the `int[]` inside. So
     we write a `for` loop that covers each index in `matrix` to access each of
     the inner arrays:

         for (int i = 0; i < matrix.length; i++) {

             // Something with matrix[i]

         }

  2. We now have a reference to an inner array -- `matrix[i]`. We want to
     iterate across each element in this array, which means another `for` loop.
     For a "regular" `int` array, the loop would look like:

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
