# run script for LeMaVM project
# require Java 7

# run ant with build.xml to build project
ant build

# run ant with makejar.xml to make .jar file
ant -f makejar.xml

# run application
# java -jar jar/lemavm.jar

# alternative for Ubuntu 12.04 when Java 7 is not default
/usr/lib/jvm/java-7-openjdk-i386/jre/bin/java -jar jar/lemavm.jar ../example/knapsack.lema ../example/knap_04.inst.dat ../example/knap_04.inst.sol -lemaGcType copyingCollector