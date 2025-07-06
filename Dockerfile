FROM openjdk:21

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY ./target/SpringAwsTest-0.0.1-SNAPSHOT.jar /app
# Expose the port your application runs on
EXPOSE 8080
# Set the entry point to run the JAR file
CMD ["java", "-jar", "SpringAwsTest-0.0.1-SNAPSHOT.jar"]
