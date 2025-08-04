# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# copy all
COPY . .

# build
RUN ./gradlew build -x test

# Expose the port your application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["sh", "-c", "java -jar build/libs/*.jar", "--spring.datasource.url=jdbc:mysql://next-db.c74828wmikhx.ap-northeast-2.rds.amazonaws.com:3306/next?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8", "--spring.datasource.username=admin", "--spring.datasource.password=17Rwi[Cu*G[9*lGuXoWP)MFdyyVA"]


