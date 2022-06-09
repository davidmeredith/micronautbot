# Sample CLI chatbot built using JAIF, Micronaut & GraalVM

David Meredith  24/05/22

This demo shows how to use JAIF, Micronaut and GraalVM to compile a chatbot to either an executable 
jar file or a platform dependent native binary. 
The demo is not intended to showcase the features of JAIF and dialogue modelling, but instead 
to show native compilation using GraalVM and Micronaut. 

## Prerequisites

* GraalVM v17+ (tested with GraalVM CE 22.1.0)
* GraalVM's native-image component installed into GraalVM, once GraalVM is installed use: `gu install native-image`
 
Check your JVM is a Graal JVM:

```shell
  [I] ➜ java --version
  openjdk 17.0.3 2022-04-19
  OpenJDK Runtime Environment GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06)
  OpenJDK 64-Bit Server VM GraalVM CE 22.1.0 (build 17.0.3+7-jvmci-22.1-b06, mixed mode, sharing)
```

## Compile and Run 

The CLI application can be compiled into either an executable jar file for running on a JVM, 
or a native platform-dependent binary using GraalVM's native-image compiler. Running on a JVM 
provides dynamic (code can change at runtime) and instrumentable code (see JFR - Java Flight Recorder). 
Compiling to a native image provides instantaneous startup and reduced memory footprint for running 
in a 'closed world' environment (i.e. not dynamic but no JVM needed). 
Linux native binaries are ideal for FaaS runtimes for scaling-to-zero. 

To compile and run an executable jar file: 

```shell
./mvnw package -DskipTests=true
./mvnw mn:run
```

To compile and run a platform dependent native binary:

```shell
./mvnw package -Dpackaging=native-image
./target/micronautguide -v
```



