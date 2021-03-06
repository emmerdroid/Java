//Emmanuel Salcedo
//CPSC223 J Test 1

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java


echo Compile Test1Operation.java
javac Test1Operation.java

echo Compile Test1Frame.java
javac Test1Frame.java

echo Compile Test1Main.java
javac Test1Main.java

echo Execute the program
java Test1Main

echo End of execution. Thank you.
