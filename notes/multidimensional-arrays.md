# Mulidimensional arrays

## What are multidimensional arrays?

Consider how locations are represented:

A particular location in n-dimensional space can be described using n numbers.
For example, on a number line, a single number is enough to identify a position:

    <----|----|---->
         0    4

Two-dimensional objects require two numbers to describe a location:


                          |
                          |
                          -       x
                          |         (1, 2)
    (-1.5, 1)             |
              x           -
                          |
                          |
      ----|-------|-------o-------|-------|----
                          |
                          |
                  x       -
          (-1, -1)        |
                          |
                          -
                          |
                          |

Three dimensional objects require three numbers:

       (0, 1, 1)            ^
                \          /
                 \        /
                  |      /
       Z axis  ^  |     /
               |  |    /
               |  x--------x (1, 1, 1)
               | /|  /    /|
               |/ | /    / |
    (0, 0, 1)  x---------  |
               |  /-----|--x (1, 1, 0)
               | /      | /
               |/       |/
               x--------x-------------------->
               (0, 0, 0) \                 X axis
                          \
                           \
                            (1, 0, 1)

And so on.

Multidimensional arrays are arrays that require more than one number to locate a
particular element, like how you need multiple numbers to define a location in
space.

"Regular" arrays are one-dimensional arrays, because a particular element can be
located with a single number:

           index: 0   1   2   3
                -----------------
                |   |   |   |   |
                -----------------
                  |   |   |   |          "Hello" is at array[0]
    "Hello" <------   |   |   |          "Lorem" is at array[2]
                      |   |   |
    "World" <----------   |   |
                          |   |
    "Lorem" <--------------   |
                              |
    "Ipsum" <------------------

Two-dimensional arrays require two numbers. Note that these drawings follow the
convention that the numbers on the *vertical* axis go fist, *then* the numbers
on the horizontal axis. The reason why is described in the next section:

        0   1   2
      -------------
    0 | o |   |   |      o is at (0, 0), or array[0][0]
      -------------      x is at (2, 0), or array[2][0]
    1 |   |   | y |      y is at (1, 2), or array[1][2]
      -------------
    2 | x |   |   |
      -------------

2D arrays don't have to be square or rectangular -- each row can have a
different number of valid indices:

        0   1   2   3   4   5
      ---------
    0 |   |   |         l
      -------------------------   // i is at (1, 1), or array[1][1]
    1 |   | i |   |   |   | j |   // j is at (1, 5), or array[1][5]
      -------------------------   // k is at (2, 0), or array[2][0]
    2 | k |   |   |   |           // l would be at (0, 4), but that is not a
      -----------------           // valid location

Three dimensional arrays require three numbers, and so on.

    // Sorry, no drawing yet :(

### How multidimensional arrays work in Java

In Java, multidimensional arrays are represented as nested sets of arrays. Each
nesting level corresponds to the dimension of the elements. For example:

    // TODO

## Declaring multidimensional arrays

    String [] array1;
    ^~~~~~ ^~ ^~~~~~
    |      |  |
    |      -----------An array...
    |         |
    -------------------------------- of Strings...
              |
              ------------------------------------------ called array1

    int[]   []    array2;
    ^~~~~   ^~    ^~~~~~
    |       |     |
    |       -------------- An array...
    |             |
    ------------------------------------- of int arrays...
                  |
                  ------------------------------------------ called array2

    int[][]   []    array3;
    ^~~~~~~   ^~    ^~~~~~
    |         |     |
    |         ------------ An array...
    |               |
    ------------------------------------- of arrays of int arrays...
                    |
                    ---------------------------------------- called array3

## Creating multidimensional arrays


    int[][] array2 = new int[][] {new int[2], new int[4],
                                  new int[1], new int[6]};

                                     index: 0   1   2   3
                                          -----------------
                                          |   |   |   |   |
                                          -----------------
    index: 0   1   2   3   4   5            |   |   |   |
         ---------                          |   |   |   |
         | 3 | 1 | <-------------------------   |   |   |
         ---------                              |   |   |
         -----------------                      |   |   |
         | 4 | 1 | 5 | 9 | <---------------------   |   |
         -----------------                          |   |
         -----                                      |   |
         | 2 | <-------------------------------------   |
         -----                                          |
         -------------------------                      |
         | 6 | 5 | 3 | 6 | 0 | 0 | <---------------------
         -------------------------

## Working with multidimensional arrays

To access any particular element, you first select the array it's in, then
select the element in that array. For example, if you want to set the element
marked by `x` above to 1:

    // x is in the third inner array, so it's somewhere in example[2]
    //
    // x is at index 3 of example[2], so it's at (example[2])[3]
    // Parentheses aren't necessary, so we end up with...
    example[2][3] = 1;

A similar process can be used for `y`. Let's set `y` to `6`:

    // y is in the fourth inner array, so somewhere in example[3]
    //
    // y is the first element, so it's at (example[3])[0]
    example[3][0] = 6;

You can also think of square 2D arrays as a matrix. The 2D array above, for
example, can also be visualized like this:

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

Here, `x` is at `example[4][8]`, `y` is at `example[2][3]`, and `z` is at
`example[0][0]`

Unfortunately, there isn't an equivalent to `new int[5][5]` for uneven inner
arrays. You will have to create them manually.

## Iterating over multidimensional arrays

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
