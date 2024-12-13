FROM maven:3.8.4-openjdk-21-slim AS build
COPY . /home/app/Projeto_Agenda2024_back_end
RUN mvn -v
RUN mvn -f /home/app/Projeto_Agenda2024_back_end/pom.xml clean package

#Step 2 - Run appointment-backend
FROM openjdk:21-slim
COPY --from=build /home/app/Projeto_Agenda2024_back_end/target/*.jar /usr/local/lib/Projeto_Agenda2024_back_end.jar
VOLUME /tmp
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/Projeto_Agenda2024_back_end.jar"]