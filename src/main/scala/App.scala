import org.apache.spark.sql.SparkSession

object App {

  def process(spark: SparkSession) = {
    println("processing ...")
    import spark.implicits._
    val df = Seq(1, 2, 3).toDF
    df.show()
  }

  def convert(spark: SparkSession) = {
    println("converting ...")
    import spark.implicits._
    val df = Seq(1, 2, 3).toDF
    df.show()
  }

  def usage = println("cmd not recognized. usage:\ncmd process => process the data\ncmd convert => convert the data")

  def main(args: Array[String]) = {

    val spark = SparkSession.builder.appName("DSTI-Application").getOrCreate()

    args match {
      case Array("process") => process(spark)
      case Array("convert") => convert(spark)
      case _ => usage
    }

    spark.close()
  }
}