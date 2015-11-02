# Intro to abstraction

Abstraction is one of the most important concepts in computer science. The basic
idea is that you separate *what* something does from *how* that something is
actually accomplished. This is incredibly powerful when done properly, as it
can make large, complex things simple by hiding most of the complexity.

A simple example might be filling up your car's tank at the gas station.
You know that once you have paid, the nozzle goes into the fuel inlet, you
pull the handle, and wait for the pump to stop on its own.

Another example could be saving a Word document. Once you have stuff in the
document, hitting "save" gives you a file that will give you the stuff back when
you "open" that file.

The first example shows "procedural abstraction" -- separating the promise of
"you will get fuel in your car if you follow these steps" from the details of
"use a rotary pump to move gas from the underground storage tank through a
meter into your car". This is sort of the equivalent of something like the
`length()` method in the String class, which promises to give you the length
of the String, but doesn't tell you exactly how it comes up with that number.

The second example shows "data abstraction" -- separating the promise of "if
you save, using open will restore the contents of what you saved" from the
contents of the file itself. This is sort of the equivalent of creating/printing
a String.
