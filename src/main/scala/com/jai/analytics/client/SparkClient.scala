package com.jai.analytics.client

/**
  * Created by Jai Prakash
  */

import org.apache.spark.sql.SparkSession
import org.rogach.scallop.ScallopConf
import com.jai.analytics.StreamAnalytics

class Conf(args:Seq[String]) extends ScallopConf(args) {
  val clickStreamPath = opt[String](required = true)
  val userDefinitionFile = opt[String](required = true)
  val categoryDefinitionFile = opt[String](required = true)
  val outputPath = opt[String](required = true)
  verify()
}

object SparkClient {

  def main(args:Array[String]): Unit = {
    val conf = new Conf(args)
    val clickStreamPath = conf.clickStreamPath.getOrElse("src/test/resources/click_stream/data.csv")
    val userDefinitionFile = conf.userDefinitionFile.getOrElse("src/test/resources/users.csv")
    val categoryDefinitionFile = conf.categoryDefinitionFile.getOrElse("src/test/resources/categories.csv")
    val outputPath = conf.outputPath.getOrElse("/tmp/click-stream-output")

    implicit val spark:SparkSession = SparkSession.
      builder().
      master("local[*]").
      appName("ClickStream").
      getOrCreate()

   val df = StreamAnalytics.streamAnalyser(clickStreamPath, userDefinitionFile, categoryDefinitionFile)
    df.coalesce(1).write.mode("overwrite").json(outputPath)
  }
}
