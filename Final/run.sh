echo remove old byte-code files if any exist
rm *.class
echo view list of source files
ls -l *.java

echo Interface.java
javac Interface.java
echo panelGraphics.java
javac panelGraphics.java
echo Compile Main.java
javac Main.java
echo Execute Main
java Main
echo End of the execution. Thank you.