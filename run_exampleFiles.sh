echo "example1.txt"
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN" < example1.txt
echo "example2.txt"
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN" < example2.txt
echo "example3.txt"
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN" < example3.txt
echo "example4.txt"
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN" < example4.txt
