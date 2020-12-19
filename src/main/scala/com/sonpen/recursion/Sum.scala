package com.sonpen.recursion

import scala.annotation.tailrec

object Sum extends App {

  val intList : List[Int] = List.range(1, 101)

  // (1) yields a "java.lang.StackOverflowError" with large lists
  def sum1(intList: List[Int]) : Int = intList match {
    case Nil => 0
    case x :: tail => x + sum1(tail)
  }

  // (2) tail-recursive solution
  def sum2(intList: List[Int]) : Int = {
    @tailrec
    def sumAccumulator(intList: List[Int], accum: Int) : Int = intList match {
      case Nil => accum
      case x :: tail => sumAccumulator(tail, x + accum)
    }

    sumAccumulator(intList, 0)
  }

  def sum3(intList: List[Int]): Int = {
    intList.reduceLeft(_ + _)
  }

  println("sum1 = " + sum1(intList))
  println("sum2 = " + sum2(intList))
  println("sum3 = " + sum3(intList))

}
