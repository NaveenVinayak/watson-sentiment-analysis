import org.apache.spark.sql.SparkSession
import org.apache.spark._
import org.apache.spark.sql.DataFrame
import Simpletest._


object analyze {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .master("local")
      .appName("watson-app")
      .getOrCreate()
    sparkSession.sparkContext.setLogLevel("ERROR")

    val productData = sparkSession.read.option("header","true").csv("C:\\Users\\NaveenR\\Desktop\\My Documents\\Dataset\\1429_1.csv")
   // productData.show()
    var positive = 0;
    var negative = 0;
    var nuetral = 0;

    import sparkSession.implicits._
    val data:DataFrame = productData.select($"categories",$"reviews text")
    val dt = data.rdd.map(x => (x(0),x(1)))
    //dt.take(10).foreach(println)
    val a = new Simpletest;

  var Count=0;
   dt.take(100).foreach(x =>{
     var b = x._2.toString
     Count+=1;
     var c = a.analyze(Count, b)
     if(c=="positive"){
      positive +=1;
     }else if(c=="negative"){
      negative+=1;
     }else{
       nuetral+=1;
     }
   })

    Count=0;
    val values = dt.take(100).filter(x => {
      var b = x._2.toString
      Count+=1
      var c = a.analyze(Count, b)
      c=="negative"
    })
    println("\n\n\n\n")
    values.map(x => x._2).foreach(x => {
      println("Negative Comments: "+ x)
    })

    println("\n\n\n POSITIVE : " + positive+"%"+"\n NEGATIVE : "+negative+"%"+"\n NUETRAL : "+nuetral+"%")
  }
}
