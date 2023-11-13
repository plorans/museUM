# Usa la imagen base de Render.com para Java 20
FROM render/dev-java:20

# Configura la variable de entorno para especificar el entorno de producción
ENV SPRING_PROFILES_ACTIVE=production

# Copia el JAR construido por el plugin spring-boot:build-image
COPY target/mi-aplicacion.jar app.jar

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]
