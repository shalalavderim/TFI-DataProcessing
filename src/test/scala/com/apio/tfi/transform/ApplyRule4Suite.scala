package com.apio.tfi.transform

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.transform.ApplyRule4
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * Unit test for ApplyRule4 transformer
 */
class ApplyRule4Suite extends FunSuite with Matchers {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)

  val tc11 = null
  val tc12 = -1
  val tc21 = ""
  val tc22 = 500
  val tc31 = "BERLIN"
  val tc32 = 1000
  val tc41 = "Amsterdam"
  val tc42 = 3000
  val tc51 = "BERLIN"
  val tc52 = 3200
  val tc61 = " berlin"
  val tc62 = 3600

  val expectedTc1 = false
  val expectedTc2 = false
  val expectedTc3 = false
  val expectedTc4 = false
  val expectedTc5 = true
  val expectedTc6 = true

  test("ApplyRule4 Unit Test") {
    val res1 = ApplyRule4(vConfig).applyRule4(tc11, tc12)
    val res2 = ApplyRule4(vConfig).applyRule4(tc21, tc22)
    val res3 = ApplyRule4(vConfig).applyRule4(tc31, tc32)
    val res4 = ApplyRule4(vConfig).applyRule4(tc41, tc42)
    val res5 = ApplyRule4(vConfig).applyRule4(tc51, tc52)
    val res6 = ApplyRule4(vConfig).applyRule4(tc61, tc62)

    assertResult(expectedTc1)(res1)
    assertResult(expectedTc2)(res2)
    assertResult(expectedTc3)(res3)
    assertResult(expectedTc4)(res4)
    assertResult(expectedTc5)(res5)
    assertResult(expectedTc6)(res6)
  }
}