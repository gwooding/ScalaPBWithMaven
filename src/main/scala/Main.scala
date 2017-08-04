package test

import mvnexample.Anotherexample
import mvnexample.Example.Hello

object Main extends App {

  val nestedJava = Hello.newBuilder.setHello(37)

  val parentJava = Anotherexample.GoodBye.newBuilder().setHello(nestedJava).build

  val parentJavaModified = parentJava.toBuilder.setHello(nestedJava.setHello(38)).build

  val nested = mvnexample.example.Hello(hello = 37)

  val parent = mvnexample.anotherexample.GoodBye(Some(nested))

  val parentModified = parent.getHello.update(_.hello := 38)
}
