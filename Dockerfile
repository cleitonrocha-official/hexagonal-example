FROM adoptopenjdk:11-jre-hotspot as builder
COPY target/stoom-qualification-1.0.jar stoom-qualification.jar
RUN java -jar stoom-qualification.jar 

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]