# Usa la imagen base de AdoptOpenJDK 20
FROM adoptopenjdk:20-jre-hotspot

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido en el paso anterior al contenedor en el directorio /app
COPY target/tu-aplicacion.jar /app/tu-aplicacion.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicia el contenedor
CMD ["java", "-jar", "tu-aplicacion.jar"]
