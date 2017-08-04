import org.scalatest._

class LibbySpec extends FlatSpec with Matchers {
  "Libby" should "have a name" in {
    val libby = Libby("Baah")
    libby.name should be("Baah")
  }
}
