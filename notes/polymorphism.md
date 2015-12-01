# Polymorphism

"Polymorphism" describes the idea that something can take more than one form.
This general concept can describe two more specific types of polymorphism, each
of which can be further split. The two main types and their subtypes are
outlined below:

## Universal polymorphism

Universally polymorphic code works the same way for different types.
### Parametric polymorphism

Parametric polymorphism allows a symbol -- a "type parameter" -- to represent
any type that exhibits a certain characteristic.

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
