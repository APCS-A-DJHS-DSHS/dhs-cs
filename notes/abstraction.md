# Intro to abstraction

Abstraction is one of the most important concepts in computer science. The basic
idea is that you separate *what* something does from *how* that something is
actually accomplished. This is incredibly powerful when done properly, as it
allows you to condense large, complex systems into a simpler interface.

## Procedural abstraction

Procedural abstraction separates the "this action does <something>" from the
"this action does <something> by <steps>". In AP CS, this usually appears in the
APIs for various classes, which describe what methods in a particular class do
(usually) without saying how it's done.

A real-world example might be filling up your car's tank at the gas station.
You know that once you have paid, the nozzle goes into the fuel inlet, you
pull the handle, and wait for the pump to stop on its own. This hides the
actual mechanism -- for example, "use a rotary pump to move gas from the
underground storage tank through a meter into your car until the air outflow
suddenly increases at which point pumping will stop".

## Data abstraction

Data abstraction is the idea of treating a collection of things as a single
object that can be manipulated as a whole. In AP CS, this can be seen whenever
you use a String -- instead of managing individual characters, you treat them
as a single object and perform operations on the object as a whole.

A real-world example could be seen in digital pictures -- jpegs, pngs, etc.
Pictures are made up of pixels, which contain color and transparency
information. Most of the time, though, you think of pictures as a single
entity rather than a collection of pixels. You crop a picture, resize a photo,
apply a filter to a picture, etc., instead of removing the pixels in this area,
removing every other pixel, or lowering the RGB values of the pixels near the
edge for a vignette effect.
