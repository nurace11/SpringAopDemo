FROM openjdk
COPY . /springAop
WORKDIR /springAop
RUN javac JavaDocker.java
CMD [ "java", "JavaDocker" ]
