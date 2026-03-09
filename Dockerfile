FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем JAR
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/messanger-1.0-SNAPSHOT.jar"]
