package com.apio.tfi.transform

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.transform.{ApplyRule5, AssignRisk}
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * Unit test for AssignRisk transformer
 */
class AssignRiskSuite extends FunSuite with Matchers {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)

  val tc11 = false
  val tc12 = false
  val tc13 = false
  val tc14 = false
  val tc15 = false

  val tc21 = true
  val tc22 = false
  val tc23 = false
  val tc24 = false
  val tc25 = false

  val tc31 = true
  val tc32 = true
  val tc33 = false
  val tc34 = false
  val tc35 = false

  val tc41 = true
  val tc42 = true
  val tc43 = true
  val tc44 = false
  val tc45 = false

  val tc51 = true
  val tc52 = true
  val tc53 = true
  val tc54 = true
  val tc55 = false

  val tc61 = true
  val tc62 = true
  val tc63 = true
  val tc64 = true
  val tc65 = true

  val expectedRTc1 = "Low_Risk"
  val expectedRTc2 = "Medium_Risk"
  val expectedRTc3 = "Medium_Risk"
  val expectedRTc4 = "High_Risk"
  val expectedRTc5 = "High_Risk"
  val expectedRTc6 = "High_Risk"

  val expectedATc1 = "Continue Driving the Truck"
  val expectedATc2 = "Consider a Service Check"
  val expectedATc3 = "Consider a Service Check"
  val expectedATc4 = "Consider Replacing the Truck"
  val expectedATc5 = "Consider Replacing the Truck"
  val expectedATc6 = "Consider Replacing the Truck"

  test("AssignRiskCategory Unit Test") {
    val res1 = AssignRisk(vConfig).assignRiskCategory(tc11, tc12, tc13, tc14, tc15)
    val res2 = AssignRisk(vConfig).assignRiskCategory(tc21, tc22, tc23, tc24, tc25)
    val res3 = AssignRisk(vConfig).assignRiskCategory(tc31, tc32, tc33, tc34, tc35)
    val res4 = AssignRisk(vConfig).assignRiskCategory(tc41, tc42, tc43, tc44, tc45)
    val res5 = AssignRisk(vConfig).assignRiskCategory(tc51, tc52, tc53, tc54, tc55)
    val res6 = AssignRisk(vConfig).assignRiskCategory(tc61, tc62, tc63, tc64, tc65)

    assertResult(expectedRTc1)(res1)
    assertResult(expectedRTc2)(res2)
    assertResult(expectedRTc3)(res3)
    assertResult(expectedRTc4)(res4)
    assertResult(expectedRTc5)(res5)
    assertResult(expectedRTc6)(res6)
  }

  test("AssignRiskAction Unit Test") {
    val res1 = AssignRisk(vConfig).assignRiskAction(tc11, tc12, tc13, tc14, tc15)
    val res2 = AssignRisk(vConfig).assignRiskAction(tc21, tc22, tc23, tc24, tc25)
    val res3 = AssignRisk(vConfig).assignRiskAction(tc31, tc32, tc33, tc34, tc35)
    val res4 = AssignRisk(vConfig).assignRiskAction(tc41, tc42, tc43, tc44, tc45)
    val res5 = AssignRisk(vConfig).assignRiskAction(tc51, tc52, tc53, tc54, tc55)
    val res6 = AssignRisk(vConfig).assignRiskAction(tc61, tc62, tc63, tc64, tc65)

    assertResult(expectedATc1)(res1)
    assertResult(expectedATc2)(res2)
    assertResult(expectedATc3)(res3)
    assertResult(expectedATc4)(res4)
    assertResult(expectedATc5)(res5)
    assertResult(expectedATc6)(res6)
  }
}