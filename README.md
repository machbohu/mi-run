Semestral project for course MI-RUN on ČVUT FIT
LeMa language + virtual machine

Task:
-----
    Design and implement a programming language interpreter or compiler and a runtime for it.

Authors:
--------
    Martin Ledvinka (ledvima1)
    Bohuslav Mach (machbohu)

Solution:
---------
    1. Grammar
    2. ANTLR -> token tree
    4. AST interpreter

Features:
---------
    - Java-like syntax
    - primitive types: boolean, int, long, double
    - Built-in types: arrays (with overflow detection), string, File (for I/O)
    - Built in System class for console I/O
    - classes, inheritance
    - static methods and variables
    - final keyword for variable binding
    - 2 types of garbage collector - Copying (in lectures called Baker), Generational Scavenging (default)
            - configurable through application arguments
    - All basic language constructs: if-else, for, while
    - All basic operators: 
            - + (also for string concatenation), -, /, *, ++, -- (both prefix and postfix)
            - ==, !=, <, <=, >, >=, !

How to run:
-----------
    More inside run.sh
