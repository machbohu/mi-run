MI-RUN Project LeMa langunage + virtual machine

Authors:
Martin Ledvinka (ledvima1)
Bohuslav Mach (machbohu)

Features:
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


TODO:
- building
- running

sample run command: java LeMaVM.jar example/knap04.inst.dat example/knap04.inst.sol [-lemaGcType generationalScavenging -lemaHeapSize 100 -lemaTenureAge 2]
