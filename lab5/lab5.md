# __Week 3 Lab Report__
*Due on Monday, November 28*

## Here's my grade.sh code
```
# Create your grading script here
CPATH=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"

set -e

# 1) Clone the repository of the student submission to a well-known directory name
rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

# 2) Check that the student code has the correct file submitted. If they didn’t, detect and give helpful feedback about it.
cd student-submission
if [[ -f ListExamples.java ]]
then
	echo "SUCCESS: Correct file name detected"
else
	echo "SCORE 0: Make sure to include your file name as ListExamples.java"
	exit 1
fi

# 3) Somehow get the student code and your test .java file into the same directory
cp ../TestListExamples.java TestListExamples.java

# 4) Compile your tests and the student’s code from the appropriate directory with the appropriate classpath commands. If the compilation fails, detect and give helpful feedback about it.
set +e
javac -cp $CPATH *.java 2> cerror.txt
if [[ $? -ne 0 ]]
then
	echo "SCORE 0: ListExamples.java didn't compile and exited with code `echo $?`; try again"
	EXIT 1
fi

echo "SUCCESS: Compilation went through" 
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > output.txt

# 5) Run the tests and report the grade based on the JUnit output
PASSED=$(((6-`grep -w E output.txt | grep -o 'E' | grep -c .`)))
echo "_-_ RESULTS _-_"
echo "Tests passed: $PASSED out of 6"
if [[ $PASSED -ge 3 ]]
then
	echo "Passed, nice job!"
else
	echo "Failed, try even improving your code!"
fi
if [[ $PASSED -eq 6 ]]
then
	echo "No errors, even nicer job!!"
else
	echo "Here's a copy of your errors."
	cat output.txt
fi

exit 0
```

## And here's some screenshots
![Image1](good.png)

![Image2](bad.png)

![Image3](miss.png)
