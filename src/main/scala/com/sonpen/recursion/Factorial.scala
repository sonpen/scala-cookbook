package com.sonpen.recursion

import scala.annotation.tailrec

object Factorial extends App {

  def factorial1(x: Int): BigInt = {
    @tailrec
    def inner(x: Int, accum: BigInt): BigInt = x match {
      case 0 => accum
      case _ => inner(x-1, accum * x)
    }

    inner(x, 1)
  }

  println("factorial1 = " + factorial1(10))
}
