FROM maven:3.8.4-jdk-8

# Copying src for the Framework
COPY src /home/SeleniumTestFramework/src

# Copying pom.xml for the Framework
COPY pom.xml /home/SeleniumTestFramework

# Running the actual command
RUN mvn -f home/SeleniumTestFramework/pom.xml clean test -Dbrowser=chrome -Dcucumber.options="--tags @TC1"