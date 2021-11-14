FROM ninjamajewski/jdk-mvn-npm
EXPOSE 8087
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war devopsemployedihek.war
ENTRYPOINT ["java", "-war", "devopsemployedihek.war"]