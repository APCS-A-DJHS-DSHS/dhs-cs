# Types

## What is a "type"?

The "type" of an entity describes attributes about that entity. Entities that
share those attributes are said to be the same "type". These attributes can
include:

  - What the entity means and how it's used
  - What values make a valid entity of that type
  - What operations can be performed on the entity
  - How the entity behaves
  - What other entites are related and how

For example, consider the string of digits:

    1000

If this is an integer type value, we can say:

  - This is a valid integer value, because integers are represented as strings
    of digits
  - This value represents the number 1000
  - Arithmetic operations such as `+` and `-` can be performed on it

We can also say that this is a binary number:

  - This is a valid binary number, because binary numbers are represented as
    strings of the digits `1` and `0`
  - This value represents the number 16 in base 10
  - Arithmetic operations such as `+` and `-` can be performed on it

We can also say that this is a string:

  - This is a valid string, because strings are... strings... of characters
  - This value represents the string "1000", which is the written form of the
    number 1000
  - Arithmetic operations such as `+` and `-` can*not* be performed on it
  - String operations like concatenations and substring can be performed on it

## Subtypes

Subtypes can be informally thought as a smaller part of a type.

To illustrate, let's say this box contains all possible numbers:

    -----------------------------
    |                           |
    |                           |
    |                           |
    |                           |
    |          NUMBERS          |
    |                           |
    |                           |
    |                           |
    |                           |
    -----------------------------

And let's gather the real numbers into a box of their own. This box should be
inside the outside box, because all real numbers are numbers. The box shouldn't
include the entire number box, though, because not all numbers are real numbers:

    -----------------------------
    |         ----------------- |
    | NUMBERS |      REAL     | |
    |         |     NUMBERS   | |
    |         |               | |
    |         |               | |
    |         |               | |
    |         |               | |
    |         |               | |
    |         ----------------- |
    -----------------------------

And let's do the same for integers. This box should go inside the real number
box, because all integers are real numbers. All integers are numbers, too, so
the integer box should be completely inside both the real number box and the
number box:

    -----------------------------
    |         ----------------- |
    | NUMBERS |      REAL     | |
    |         |     NUMBERS   | |
    |         |               | |
    |         |       ------- | |
    |         |       | Int | | |
    |         |       |     | | |
    |         |       ------- | |
    |         ----------------- |
    -----------------------------

Finally, let's box the irrational numbers. No number can be both an integer and
irrational, so the irrational number box can't contain anything in the integer
box. Irrational numbers are real, though, so this box should be inside the real
number box. Irrational numbers are also numbers, so this box shoulid be inside
the number box:

    -----------------------------
    |         ----------------- |
    | NUMBERS |      REAL     | |
    |         |     NUMBERS   | |
    |         |               | |
    |         | ------ ------ | |
    |         | |IRR | |INT | | |
    |         | |    | |    | | |
    |         | ------ ------ | |
    |         ----------------- |
    -----------------------------

And now we've described a subtype hierarchy. We can say:

  - Real numbers are a subtype of numbers
  - Irrational numbers are a subtype of real numbers
  - Irrational numbers are *also* a subtype of numbers
  - Integers are a subtype of real numbers
  - Integers are *also* a subtype of numbers
  - Integers are *not* a subtype of irrational numbers

These statements can be stated in a more succinct way like so:

    Real numbers       <:  Numbers
    Irrational numbers <:  Real numbers
    Irrational numbers <:  Numbers
    Integers           <:  Real numbers
    Integers           <:  Numbers
    Integers           </: Irrational numbers

Note that the subtyping relationship is transitive -- if `C <: B` and `B <: A`,
then `C <: A`. The relationship is reflexive, too (i.e. `T <: T` for all types
`T`).

The relationships between the various types of numbers can also be described by
a subtype hierarchy:

             numbers
                |
                |
           real numbers
            /      \
           /        \
          /          \
    integers     irrational numbers

In a hierarchy like this, lines connect types with subtyping relationships. This
particular hierarchy places subtypes below their parent type.
