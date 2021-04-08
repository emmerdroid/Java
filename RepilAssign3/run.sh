#Program name: Bouncing Balls
#Author: Emmanuel Salcedo
#email: emsalcedo@csu.fullerton.edu
#file name: run.sh
#Preconditions:
#	1. All source files are in one directory
#	2. THis file, run.sh , is in the same directory
#	3. The shell is currently active is in the same directory
#How to execute: Enter "sh run.sh" without quotes in terminal

echo remove old byte-code files if any exist
rm *.class
echo view list of source files
ls -l *.java
echo BounceballInterface.java
javac BounceballInterface.java
echo BallGraphics.java
javac BallGraphics.java
echo Compile Main.java
javac Main.java
echo Execute main
java Main
echo End of Execution. Thank You.
