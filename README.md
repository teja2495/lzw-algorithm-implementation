# lzw-algorithm-implementation
A Java program which implements Lempel–Ziv–Welch Algorithm for encoding and decoding.

PROGRAM DESIGN: 

Encoder:
Max hashmap (table) size is set according to the bit-length value specified by the user.
A hashmap is initialized with all the ASCII characters and values. (Characters -> Key, ASCII value -> Value)
The data in the given input .txt file is read and Encoder outputs the encoded data to a .lzw file in UTF-16BE encoding format.
The FileNotFound and IO Exceptions are handled using Try and Catch blocks.
The output file has the same name as the input file but with .lzw extension.

Decoder:
Max hashmap (table) size is set according to the bit-length value specified by the user.
A hashmap is initialized with all the ASCII characters and values. (Characters -> Key, ASCII value -> Value)
The output file of the encoder or any .lzw file (with encoded ASCII values in UTF-16BE encoding format) can be given as an input.
The method "getKey()" is written to get the "Key" from a hashmap using the "Value".
The FileNotFound and IO Exceptions are handled using Try and Catch blocks.
The output file is a .txt file with the decoded data.

BREAKDOWN OF THE UPLOADED FILES:

Encoder.java
Decoder.java
README.txt (This file)

HOW TO RUN:

Encoding: Any ASCII text file & bit length can be given as input to the encoder through the command line. 
The encoder encodes the data in the file and creates a .lzw file with UTF-16BE character encoding as an output.
NOTE: The first and second command line arguments are a .txt file and bit length respectively.
Example: java Encoder input1.txt 12
Output file name: input1.lzw

Decoding: A .lzw file with UTF-16BE character encoding & the bit length can be given as input to the decoder through the command line.
The decoder gives a .txt file with decoded data as an output.
NOTE: The first and second command line arguments are a .lzw file and bit length respectively. 
Example: java Decoder input1.lzw 12
Output file name: input1_decoded.txt 

CODE SUMMARY: The code is well tested and all test cases should work properly.

PROGRAMMING LANGUAGE: Java (Version: 9.0.4)

DATA STRUCTURE USED: Hashmap

COMPILER USED: IntelliJ IDEA (Version: 2017.3.4 x64)
