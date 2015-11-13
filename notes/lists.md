# Lists

## Whare are lists?

Lists are

They are similar to arrays in that they hold one type of element, and you access
those elements by index. Lists don't have a size limit, though, and elements are
contiguous.

## The List Interface

Lists in Java are defined by the `java.util.List` interface. Classes that
implement this interface


## List implementations

These are classes that create the illusion of an unbounded, resizable list
through different techniques

### Arraylist

`Arraylists` implement lists

    -----------------------------------------------------------------
    |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
    -----------------------------------------------------------------

### LinkedList

`Linkedlists` are a bit different. 

    ---------           ---------           ---------           ---------
    |   | x-|---------->|   | x-|---------->|   | x-|---------->|   | x-|-----
    ---------           ---------           ---------           ---------    |
                                                                             |
    ---------           ---------           ---------           ---------    |
    | x |   |<----------|-x |   |<----------|-x |   |<----------|-x |   |<----
    ---------           ---------           ---------           ---------
