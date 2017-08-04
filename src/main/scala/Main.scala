package test

import mvnexample.BikeOuterClass.Bike
import mvnexample.FrameOuterClass.Frame
import mvnexample.MetalOuterClass.Metal
import mvnexample.WheelOuterClass.Wheel
import mvnexample.bike
import mvnexample.frame
import mvnexample.metal
import mvnexample.wheel

object Main extends App {

  val metalBuilderJava = Metal.newBuilder.setMetalCode(1)
  val frameBuilderJava = Frame.newBuilder.setFrameType(1)
  val wheelBuilderJava = Wheel.newBuilder.setSpokes(1).setMetal(metalBuilderJava)
  val bikeJava = Bike.newBuilder.setFrame(frameBuilderJava).setWheel(wheelBuilderJava).build

  //Change metalType on wheel in a ridiculous fashion

  val modifiedBikeJava = bikeJava.toBuilder.setWheel(wheelBuilderJava.setMetal(metalBuilderJava.setMetalCode(2))).build

  //Or alternatively:

  val modifiedMetalBuilderJava = metalBuilderJava.setMetalCode(2)
  val modifiedWheelBuilderJava = wheelBuilderJava.setMetal(modifiedMetalBuilderJava)
  val modifiedBikeAlternativeJava = modifiedBikeJava.toBuilder.setWheel(modifiedWheelBuilderJava).build

  //now with Scala case classes:

  val metalScala = metal.Metal(metalCode = 1)
  val frameScala = frame.Frame(frameType = 1)
  val wheelScala = wheel.Wheel(metal = Some(metalScala), spokes = 5)
  val bikeScala = bike.Bike(frame = Some(frameScala), wheel = Some(wheelScala))

  //Change metalType on wheel the ScalaPB way

  val modifiedBikeScala = bikeScala.update(_.wheel.metal.metalCode := 2)
}
