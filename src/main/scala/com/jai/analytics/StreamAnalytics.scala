package com.jai.analytics

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.execution.streaming.FileStreamSource.Timestamp


object StreamAnalytics {

  case class Record(timestamp:String, ip:String, url:String, user_id:String, city:String, country:String,
                    state:String)

  case class User(user_id:String, dob: String, gender: String)

  case class UserRecord(user_id:String, timestamp:String, ip:String, url:String, city:String, country:String,
                        state:String, dob:String, gender: String)

  def streamAnalyser(clickPath:String, userDefPath: String, categoryDefPath: String)(implicit spark:SparkSession): DataFrame = {
    import spark.implicits._
    import org.apache.spark.sql.types._

    val df = spark.read.csv(clickPath)
    val inputDf = df.select($"_c0".cast(StringType).as("timestamp"), $"_c1".cast(StringType).as("ip"),
                      $"_c2".cast(StringType).as("url"), $"_c3".cast(StringType).as("user_id"),
                    $"_c4".cast(StringType).as("city"), $"_c5".cast(StringType).as("country"),
                    $"_c6".cast(StringType).as("state")).as[Record]

    val userDf = spark.read.csv(userDefPath).select($"_c0".cast(StringType).as("user_id"),
                  $"_c1".cast(StringType).as("dob"), $"_c2".cast(StringType).as("gender")).as[User]

    // ToDo: address performances issue with join
    val userRecordDf = inputDf.join(userDf, Seq("user_id")).as[UserRecord]
    // ToDo: determine categories
    userRecordDf.toDF
  }
}
