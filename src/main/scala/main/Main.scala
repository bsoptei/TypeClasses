package main

import examples_basic._
import examples_simulacrum._

object Main {

  def main(args: Array[String]): Unit = {
    new Example1().testExample1()
    new Example2().testExample2()
    new Example3().testExample3()

    new SimulacrumExample().testSimulacrumExample()
  }

}
