# Polymorphism

"Polymorphism" describes the idea that something can take more than one form.
This general concept can describe two more specific types of polymorphism, each
of which can be further split. The two main types and their subtypes are
outlined below:

  - Universal polymorphism: A function works the same on different types that
    share some common structure.
    - Parametric polymorphism:
    - Inclusion polymorphism:
      - Subtyping polymorphism:
  - Ad-hoc polymorphism: One function appears to work on different types, but
    may do something different for every type
    - Overloading: The same symbol can be used for different code, e.g. the same
      method name can take different numbers and/or types of arguments.
    - Coercion: The argument is converted to the type expected by the function

## Universal polymorphism

### Parametric polymorphism

"Generics" are Java's version of parametric polymorphism

### Inclusion polymorphism

Interfaces? Including many types as opposed to a single type/state...

#### Subtyping polymorphism

Subtyping, extends, abstract, etc.

##### Liskov Substitution Principle

## Ad-hoc polymorphism

### Overloading

### Coercion

This doesn't get much attention in Java. If you hear about it, it's usually in
the context of "promotion" of primitive types, e.g. if you add a `double` and an
`int`, the `int` gets promoted/coerced to a `double`, after which the operation
continues.
