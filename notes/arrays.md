# Intro to arrays

So far, we've been dealing with individual objects. This works fine when you're
dealing with a few things at once:

    public String interleave(String a, String b) { ... }
    public int gcd(int x, int y) { ... }
    public long max(long a, long b, long c) { ... }

But things can get interesting once you start working with a few more objects:

    public class Deck {
        private Card card1;
        private Card card2;
        private Card card3;
        private Card card4;
        private Card card5;
        private Card card6;
        private Card card7;
        private Card card8;
        private Card card9;
        private Card card10;
        private Card card11;
        private Card card12;
        private Card card13;
        private Card card14;
        private Card card15;
        private Card card16;
        private Card card17;
        private Card card18;
        private Card card19;
        private Card card20;
        private Card card21;
        private Card card22;
        private Card card23;
        private Card card24;
        private Card card25;
        private Card card26;
        private Card card27;
        private Card card28;
        private Card card29;
        private Card card30;
        private Card card31;
        private Card card32;
        private Card card33;
        private Card card34;
        private Card card35;
        private Card card36;
        private Card card37;
        private Card card38;
        private Card card39;
        private Card card40;
        private Card card41;
        private Card card42;
        private Card card43;
        private Card card44;
        private Card card45;
        private Card card46;
        private Card card47;
        private Card card48;
        private Card card49;
        private Card card50;
        private Card card51;
        private Card card52;

        public Deck() {
            card1 = new Card("Spade", 1);
            card2 = new Card("Spade", 2);
            card3 = new Card("Spade", 3);
            card4 = new Card("Spade", 4);
            card5 = new Card("Spade", 5);
            card6 = new Card("Spade", 6);
            card7 = new Card("Spade", 7);
            card8 = new Card("Spade", 8);
            card9 = new Card("Spade", 9);
            card10 = new Card("Spade", 10);
            card11 = new Card("Spade", 11);
            card12 = new Card("Spade", 12);
            card13 = new Card("Spade", 13);
            card14 = new Card("Heart", 1);
            card15 = new Card("Heart", 2);
            card16 = new Card("Heart", 3);
            card17 = new Card("Heart", 4);
            card18 = new Card("Heart", 5);
            card19 = new Card("Heart", 6);
            card20 = new Card("Heart", 7);
            card22 = new Card("Heart", 8);
            card22 = new Card("Heart", 9);
            card23 = new Card("Heart", 10);
            card24 = new Card("Heart", 11);
            card25 = new Card("Heart", 12);
            card26 = new Card("Heart", 13);
            card27 = new Card("Diamond", 1);
            card28 = new Card("Diamond", 2);
            card29 = new Card("Diamond", 3);
            card30 = new Card("Diamond", 4);
            card33 = new Card("Diamond", 5);
            card32 = new Card("Diamond", 6);
            card33 = new Card("Diamond", 7);
            card34 = new Card("Diamond", 8);
            card35 = new Card("Diamond", 9);
            card36 = new Card("Diamond", 10);
            card37 = new Card("Diamond", 11);
            card38 = new Card("Diamond", 12);
            card39 = new Card("Diamond", 13);
            card40 = new Card("Club", 1);
            card44 = new Card("Club", 2);
            card42 = new Card("Club", 3);
            card43 = new Card("Club", 4);
            card44 = new Card("Club", 5);
            card45 = new Card("Club", 6);
            card46 = new Card("Club", 7);
            card47 = new Card("Club", 8);
            card48 = new Card("Club", 9);
            card49 = new Card("Club", 10);
            card50 = new Card("Club", 11);
            card55 = new Card("Club", 12);
            card52 = new Card("Club", 13);
        }

It sure would be nice if those cards could be handled as a group of 52 `Cards`
instead of 52 individual `Cards`.

Luckily, Java has arrays, which are exactly what we need. Arrays are fixed-size
groups of things where all the things are the same type. When talking about
arrays, these things are typically called "elements".

## Declaring an array variable

Array variables/parameters/etc. are declared in the same way as any other
thing in Java -- the type of the element followed by the name of the variable.

In code, an array's type looks like the type of the elements followed by a set
of square brackets (`[` and ` ]`). For example:

    Scanner scanner; // Declares a Scanner
    String name;     // Declares a String
    Card[] cards;    // Declares a Card array
    int[] nums;      // Declares an int array

The type of an array can be read a few different ways:

    Letter[] englishAlphabet; // A Letter array
    Letter[] latinAlphabet;   // An array of Letters
    Letter[] greekAlphabet;   // A Letter[]

Each way is equally valid, although the last one is probably not too useful when
talking about arrays.

## Array properties

### Fields

Arrays have one publicly accessible field:

    public final int length;

As the name suggests, it holds the array's length, which is the number of
elements it can hold. An array's length is set when it is created, and once set
it cannot be changed -- hence the `final` modifier.

### Constructors

Array constructors look a bit different from other object constructors, but they
create an object just like any other constructor. One of them, however, has a
few strings attached.

#### Constructing empty arrays

The first one is only a little different:

    new int[4];    // Array of 4 ints
    new String[10] // Array of 10 Strings
    new byte[16]   // Array of 16 bytes
    new Card[52]   // Array of 52 cards

Arrays created this way have default values for all their elements, and are
sometimes called "empty arrays".

Default values for array elements are:

    boolean - false
    byte    - 0        // The byte way of writing 0 in Java 7 and up
    char    - '\u0000' // The char way of writing 0
    short   - 0
    int     - 0
    long    - 0L       // The long way of writing 0
    float   - 0f       // The float way of writing 0
    double  - 0d       // The double way of writing 0
    Object  - null

Thus, the above constructors would produce:

    new int[4]     // Array of 4 ints with value 0
    new String[10] // Array of 10 Strings, but each one is null
    new byte[16]   // Array of 16 bytes, each set to 0
    new Card[52]   // Array of 52 Cards, but each Card is null

#### Constructing arrays with contents

The second constructor looks like this:

    new int[] {1, 2, 3, 4}
    new String[] {"Hello", "world!"}
    new byte[] {0b0000, 0b0001, 0b0010, 0b0011, 0b0100, ... , 0b1111}
    new Card[] {new Card(SPADE, ONE), ... , new Card(DIAMOND, KING)}

This constructor creates an array of the type you specified, and fills it with
the elements you list between the braces. Thus:

  1. Creates an `int` array with length 4, holding the values `1`, `2`, `3`, and
     `4`
  2. Creates a `String` array with length 2, holding the `String`s `"Hello"` and
     `"world!"`
  3. Creates a `byte` array with length 16, holding the values `0b0000` through
     `0b1111`, or 0 through 15
  4. Creates a `Card` array with length 52 and 52 `Card` objects, one `Card` for
     each card in a regular deck

This is a nice way of getting an array with values ready to go, instead of
setting them one by one.

#### Constructing arrays with contents, but with less typing

The last constructor looks like this:

    int[] nums = {1, 2, 3, 4}
    String[] words = {"Hello", "world!"}
    byte[] testBits = {0b0000, ... , 0b1111}
    Card[] deck = {new Card(SPADE, ONE), ... , new Card(DIAMOND, KING)}

This works just like the second constructor, with one restriction: you can only
use this if you declare a variable variable **and** use the constructor to set
the variable's value at the same time:

    int[] nums = {1, 2, 3, 4};            // OK
    int[] moreNums;
    moreNums = {5, 6, 7, 8};              // Not OK

    int[] evenMoreNums = {9, 10, 11, 12}; // OK
    evenMoreNums = {13, 14, 15, 16};      // Not OK

#### Methods

The only methods that arrays have are the methods that all objects have:

  - `clone()`
  - `equals(Object)`
  - `finalize()`
  - `getClass()`
  - `hashCode()`
  - `notify()`
  - `notifyAll()`
  - `toString()`
  - `wait()`
  - `wait(long)`
  - `wait(long, int)`

In most cases, you won't have to worry about these. The main one to keep in
mind, though, is `toString()`. Arrays use the default implementations of their
methods, which means you can get some interesting results:

    int[] fibs = {0, 1, 1, 2, 3};
    String fibsString = fibs.toString();
    System.out.println(fibsString);

Instead of something nice like "{0, 1, 1, 2, 3}", you get something like this:


    [I@203ce91c

Well, that's not very useful. A better way to turn an array into a `String` is
by using the `Arrays.toString()` method:

    String goodResult = Arrays.toString(fibs);
    System.out.println(goodResult); // prints "[0, 1, 1, 2, 3]"

## Working with arrays

### What exactly are arrays?

The most common way to visualize the way that arrays group their elements is by
lining them up in a row:

          ---------------------
          |   |   |   |   |   |
          ---------------------

Each element has a number, called its "index". The first element is numbered
"0", the second element is numbered "1", and so on:

          ---------------------
          |   |   |   |   |   |
          ---------------------
    index:  0   1   2   3   4



### Accessing array elements

The element at index `i` can be accessed by typing the name of the array
followed by the element's index surrounded by square brackets:

    int[] primes = new int[] {2, 3, 5, 7, 11};
    System.out.println(primes[3]); // Prints "7"
    System,out.println(primes[0]);  // Prints "2"
    System.out.println(primes[4]);  // Prints "11"

And you can assign the element at index `i` in a similar way:

    primes[3] = 2;     // Array is now {2, 3, 5, 2, 11}
    primes[0] = 16384; // Array is now {16384, 3, 5, 2, 11}

Be careful not to use an invalid index, i.e. a negative index, or an index for
a nonexistant element. If you do so, the runtime will complain:

    int[] primes = new int[] {2, 3, 5, 7, 11};
    primes[-1]    // The runtime will throw an
    primes[5]     // ArrayIndexOutOfBoundsException
    primes[1294]  // in each of these cases

### Iterating over arrays

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

The number in the first set of brackets usually refers to the row, while the
second refers to the column. Thus, the `x` would be at `example[2][3]` in this
case.

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
