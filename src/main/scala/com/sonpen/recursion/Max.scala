package com.sonpen.recursion

import scala.annotation.tailrec

object Max extends App{

  val intList = List(1,10,100, 201, 200, 101, 11)

  def max1(intList: List[Int]): Int = {
    @tailrec
    def inner(intList: List[Int], maxValue: Int): Int = intList match {
      case Nil => maxValue
      case x :: tail => if (x > maxValue) inner(tail, x) else inner(tail, maxValue)
    }

    inner(intList, 0)
  }

  def max2(intList: List[Int]): Int = {
    @tailrec
    def inner(intList: List[Int], maxValue: Int) : Int = {
      if (intList.isEmpty) maxValue
      else {
        if (intList.head > maxValue)
          inner(intList.tail, intList.head)
        else
          inner(intList.tail, maxValue)
      }
    }
    inner(intList, 0)
  }

  println("max1 = " + max1(intList))
  println("max2 = " + max2(intList))
}
