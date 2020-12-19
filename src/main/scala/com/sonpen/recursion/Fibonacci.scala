package com.sonpen.recursion

import scala.annotation.tailrec

object Fibonacci extends App {

  /**
    * end 까지의 피보나치 수열 출력
    * @param end
    */
  def fibonacci1(end: Int) : Unit = {
    @tailrec
    def inner(prevPrev: Int, prev: Int): Unit = {
      if (prevPrev == 0 && prev == 1)
        print(s"$prevPrev $prev ")

      val cur = prevPrev + prev
      if (end >= cur) {
        print(s"$cur ")
        inner(prev, cur)
      }
    }
    inner(0, 1)
    println()
  }

  fibonacci1(100)

  /**
    * n 개의 피보나치 수열 출력
    * @param n
    */
  def fibonacci2(n: Int): Unit = {
    @tailrec
    def inner(x: Int, prevPrev: BigInt = 0, prev: BigInt = 1 ): BigInt = x match {
      case 0 => prevPrev
      case 1 => prev
      case _ => inner(x - 1, prev, prev + prevPrev)
    }

    (0 until n).foreach(x => print(inner(x) + " "))
    println()
  }

  fibonacci2(10)

  /**
    * n 개의 피보나치 수열 출력(단, 꼬리재귀가 아님)
    * @param n
    */
  def fibonacci3(n: Int): Unit = {
    def inner(x: Int): BigInt = x match {
      case 0 | 1 => x
      case _ => inner(x-1) + inner(x-2)
    }
    (0 until n).foreach(x => print(inner(x) + " "))
    println()
  }

  fibonacci3(10)
}
