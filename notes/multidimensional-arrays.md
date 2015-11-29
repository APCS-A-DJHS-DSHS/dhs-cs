# Mulidimensional arrays

## What are multidimensional arrays?

Multidimensional arrays are arrays that require more than one index to locate an
element.

The "dimension" part of the name comes from the way identifying elements in a
multidimensional array resembles identifying a point in space.

Consider a number line:

    <----|----|----|----x----|----|---->
        -2   -1    0    1    2    3

The number line is a one-dimensional space -- only one number is required to
uniquely identify a location on the line. For example, if you were told to put
an "x" on the point marked "1", you know exactly what point is being named.
Likewise, a one-dimensional array requires only one number to uniquely identify
an element. The arrays described in arrays.md are one-dimensional arrays.

One number isn't enough to uniquely identify a point on the Cartesian coordinate
plane, though. Say you were supposed to mark the point at "1" with an "x":


                          |
                          |
                        2 -       x <------ Would this be considered "1" or "2"?
                          |
                          |
                        1 x <--- Should the x go at this "1"?
                          |
                          |
      ----|-------|-------o-------x-------|----
         -2      -1       |       1       2
                          |       ^
                       -1 -       |
                          |       |
                          |       Or this "1"?
                       -2 -
                          |
                          |

Two numbers are needed to uniquely identify a point, which means the Cartesian
coordinate plane is a two-dimensional space:

                          |
                          |
                        2 -       x
                          |         (1, 2)
    (-1.5, 1)             |
              x         1 -
                          |
                          |
      ----|-------|-------o-------|-------|----
         -2      -1       |       1       2
                          |
                  x    -1 -
          (-1, -1)        |
                          |
                       -2 -
                          |
                          |
Two-dimensional arrays, then, require two numbers to uniquely name an element.

    // This is a two-dimensional array. Placing an "x" at element "1" is
    // ambiguous, but placing an "x" at element "1, 1" is not

        0   1   2
      -------------
    0 |   |   |   |
      -------------
    1 |   | x |   |
      -------------

The same extends to three dimensions and above. Points in three-dimensional
space require three numbers:

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

And a three-dimensional array would require 3 numbers to uniquely identify an
element.

    // No diagram yet :(

## Multidimensional arrays in Java

Java does not have "true" multidimensional arrays; instead, multidimensional
arrays are represented as nested one-dimensional arrays, where each level of
nesting corresponds to a dimension, i.e.  two-dimensional arrays are arrays of
arrays, four-dimensional arrays are arrays of arrays of arrays of arrays, etc.

This is an important thing to keep in mind; this explains most of the behavior
of multidimensional arrays.

### Declaring and working with multidimensional arrays

Declaring and creating multidimensional arrays is fairly straightforward, as
long as you remember that "multidimensional" really means "nested
one-dimensional" in Java.

One-dimensional array declarations are nothing new:

    String[] oneDimensionalArray;

    String [] oneDimensionalArray;
    ^~~~~~ ^~ ^~~~~~~~~~~~~~~~~~~
    |      |  |
    |      -----------An array...
    |         |
    -------------------------------- of Strings...
              |
              ---------------------------------- called oneDimensionalArray


Two dimensions means two levels of nesting, so two-dimensional arrays are arrays
of arrays:

    int[][] twoDimensionalArray;

    int[]   []    twoDimensionalArray;
    ^~~~~   ^~    ^~~~~~~~~~~~~~~~~~~
    |       |     |
    |       -------------- An array...
    |             |
    ------------------------------------- of int arrays...
                  |
                  ------------------------------ called twoDimensionalArray

For example, take this matrix you might see in a math class:

    -------------
    | x | 0 | 0 |
    -------------
    | 0 | 0 | y |
    -------------
    | z | 0 | 0 |
    -------------

You can represent it like this in Java (don't worry about how this is created;
that will be covered later):

                            0   1   2
                          -------------
                          |   |   |   |
                          -------------
        0   1   2           |   |   |
      -------------         |   |   |
      | x |   |   | <--------   |   |
      -------------             |   |
      -------------             |   |
      |   |   | y | <------------   |
      -------------                 |
      -------------                 |
      | z |   |   | <----------------
      -------------

Based on this, figuring out how to access elements is fairly straightforward.
Say we want to square `x` and store the result as the element following `x`. To
access `x`, we need to access the array `x` is in. `x` is in the first inner
array, so that array could be identified as:

    int[] inner = array[0];

`x` is the first element in that inner array, so:

    int before = inner[0];

We can simplify this by substituting `array[0]` for `inner`:

    int before = inner[0][0];

It might help to think of this as

    int before = (inner[0])[0];

Now we can do our computation:

    int square = x * x;

Storing the result works in a similar fashion to reading `x`:

    int[] inner = array[0];
    inner[1] = square;

This would also work:

    inner[0][1] = square;

Because Java's multidimensional arrays are nested one-dimensional arrays,
though, you can do some things that you don't typically see with matrices, like
having rows of different sizes. For example, the following would be a valid
array:

                                0   1   2
                              -------------
                              |   |   |   |
                              -------------
      0   1   2   3   4   5     |   |   |
    ---------                   |   |   |
    |   |   | <------------------   |   |
    ---------                       |   |
    -------------------------       |   |
    |   | i |   |   |   | j | <------   |
    -------------------------           |
    -----------------                   |
    | k |   |   |   | <------------------
    -----------------

Accessing elements still works in the same way, though. `i` is at `array[1][1]`,
and `j` is at `array[1][5]`.

Higher-dimensional arrays work more or less the same way. Three dimensions means
three levels of nesting, so three-dimensional arrays are arrays of arrays of
arrays:

    int[][][] threeDimensionalArray;

    int[][]   []    threeDimensionalArray;
    ^~~~~~~   ^~    ^~~~~~~~~~~~~~~~~~~~~
    |         |     |
    |         ------------ An array...
    |               |
    ------------------------------------- of arrays of int arrays...
                    |
                    ---------------------------- called threeDimensionalArray

And accessing elements would be done by accessing the proper two-dimensional
array, then the proper one-dimensional array in the two-dimensional array, then
the element in the one-dimensional array.

This nesting makes figuring out an array's dimension fairly easy -- just count
the number of square bracket pairs. The number of bracket pairs corresponds to
the nesting level and the array's dimension.

### Creating multidimensional arrays

Creating multidimensional arrays isn't much different than creating a
one-dimensional array, because you technically *are* working with
one-dimensional arrays.

For example, this array:

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

Is an array of `int` arrays.

We know one-dimensional arrays can be created like this:

    int[] array = new int[] {3, 1};
    String[] array = new String[] {"Hello", "world!"};

So creating an array of `int` arrays should look something like:

    int[][] array = new int[][] { <int array>,
                                  <int array>,
                                  <int array>,
                                  ...,
                                  <int array>};

A more concrete example could be:

    int[][] array = new int[][] {new int[] {1, 6},
                                 new int[] {1, 8, 5, 3},
                                 new int[] {3},
                                 new int[] {9, 8, 8, 7, 5}};

The short array constructor you can use when declaring and creating an array at
the same time also works in a similar way:

    int[] array = {3, 1};
    String[] array = {"Hello", "world!"};

    int[][] array = {{3, 1, 4},
                     {1, 5, 9},
                     {2, 6, 5},
                     {3, 5, 9}};

Creating an empty multidimensional array is a bit different, though. You might
expect that an array of `int` arrays, (a `int[] []`) would look like:

    int[][] array = new int[][4]; // This actually doesn't work

or that an array of arrays of `int` arrays (a `int[][] []`) would look like:

    int[][][] array = new int[][][MAX_SIZE]; // This doesn't work either

The actual syntax, though, has the numbers on the *inside*.

    int[][] array = new int[4][];
    int[][][] array = new int[MAX_SIZE][][];

This is because this allows you to create multiple dimensions at once. For
example,

    int[][] array = new int[4][];

creates an array of 4 `int` arrays. Adding another number like this, though:

    int[][] array = new int[4][5];

creates an array of 4 `int` arrays, each of which holds 5 `int`s. Similarly,

    int[][][] array = new int[MAX_SIZE][][];

creates an array of `MAX_SIZE` two-dimensional arrays,

    int[][][] array = new int[MAX_SIZE][MAX_SIZE][];

creates an array of `MAX_SIZE` two-dimensional arrays, each of which holds
`MAX_SIZE` `int` arrays, and

    int[][][] array = new int[MAX_SIZE][MAX_SIZE][MAX_SIZE];

creates an array of two-dimensional arrays, each of which holds `MAX_SIZE` `int`
arrays which each hold `MAX_SIZE` `int`s.

## Iterating over multidimensional arrays

Multidimensional array iteration isn't much different than regular array
iteration. It involves more steps, but in the end it boils down to nested
regular array iteration.

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
