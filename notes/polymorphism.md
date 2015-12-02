# Polymorphism

"Polymorphism" describes the idea that something can take more than one form.
This general concept can describe two more specific types of polymorphism, each
of which can be further split. The two main types and their subtypes are
outlined below:

## Universal polymorphism

Universally polymorphic code works the same way for different types.
### Parametric polymorphism

Parametric polymorphism allows a symbol -- a "type parameter" -- to represent
any type that exhibits a certain characteristic. This allows for code that works
for multiple types without having to be rewritten.

"Generics" are Java's version of parametric polymorphism

### Inclusion polymorphism

Interfaces? Including many types as opposed to a single type/state...

Inclusion polymorphism permits an entity to appear as multiple types -- multiple
types are "included" into the entity.

#### Subtyping polymorphism

Subtyping, extends, abstract, etc.

Subtyping polymorphism is a special case of inclusion polymorphism.

Java implements subtyping polymorphism by allowing a class to `extend` another
class.

##### Liskov Substitution Principle

Informally, the Liskov Substitution Principle states that subtypes should not
break code that worked with the supertype.

## Ad-hoc polymorphism

### Overloading

In Java, the particular overloaded method to use is decided at compile time
using the static type of the object
In Java, method resolution is done at compile time using the static types of the
arguments.
Overloading is resolved at compile time using the stati

### Coercion

This doesn't get much attention in Java. If you hear about it, it's usually in
the context of "promotion" of primitive types, e.g. if you add a `double` and an
`int`, the `int` gets promoted/coerced to a `double`, after which the operation
continues.
