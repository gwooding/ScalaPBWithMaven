package test

import mvnexample.Anotherexample
import mvnexample.Example
import mvnexample.anotherexample
import mvnexample.example

object Main extends App {

  val nestedJava = Example.Hello.newBuilder.setHello(37)
  val parentJava = Anotherexample.GoodBye.newBuilder().setHello(nestedJava).build

  val nestedScala = example.Hello(hello = 37)
  val parentScala = anotherexample.GoodBye(Some(nestedScala))

  val parentModifiedJava = parentJava.toBuilder.setHello(nestedJava.setHello(38)).build
  val parentModifiedScala = parentScala.getHello.update(_.hello := 38)
}
