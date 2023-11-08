# 1st stage, build the app
FROM maven:3.8.4-openjdk-17-slim as build
#FROM openjdk:17

WORKDIR /GlobalMasterSvc

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD pom.xml .
ADD src src
#RUN mvn package
RUN --mount=type=cache,target=/root/.m2 mvn package -Dmaven.test.skip
# Do the Maven build!
# Incremental docker builds will resume here when you change sources
#RUN mvn package -DskipTests
RUN echo "done!"

# 2nd stage, build the runtime image
#FROM pcaifocnrd01.sdc.raj.gov.in:5000/openjdk:11.0.4-jre-slim
FROM openjdk:17
WORKDIR /GlobalMasterSvc

#ADD api.crt /usr/local/share/ca-certificates/api.crt
#RUN keytool -keystore /usr/local/openjdk-17/lib/security/cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias sewadwar -file /usr/local/share/ca-certificates/api.crt

# Copy the binary built in the 1st stage
COPY --from=build /GlobalMasterSvc/target/OTS.jar ./
COPY --from=build /GlobalMasterSvc/target/libs ./libs

CMD ["java", "-jar", "OTS.jar"]

EXPOSE 22004





#FROM maven:3.8.4-openjdk-17-slim as build
#WORKDIR /src
#
#ADD pom.xml .
#RUN mvn package -DskipTests
#
#ADD src src
#RUN mvn package -DskipTests
#RUN echo "done!"
#
#FROM openjdk:17-jdk-slim
#WORKDIR /helidon
#
#COPY --from=build /src/target/helidon-mp-tutorial.jar ./
#COPY --from=build /src/target/libs ./libs
#
#CMD ["java", "-jar", "helidon-mp-tutorial.jar"]
#EXPOSE 8080


