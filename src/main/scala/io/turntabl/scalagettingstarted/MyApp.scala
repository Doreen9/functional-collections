package io.turntabl.scalagettingstarted


case class Book (val authorSurname: String, val title: String, val year: Int, val category: String)


object MyApp extends App {
    val books = List(
      Book("Artwood", "The Handmaid's tale", 2019, "Fiction"),
      Book("Wilde", "The picture of Dorian Gray", 1856, "Fiction"),
      Book("Woods", "Stranger Things", 2015, "Sci-Fi"),
      Book("Eastwood", "Gone with the wind", 1996, "Romance"),
      Book("Robin", "The slave trade", 1890, "History"),
      Book("Dey", "With you", 2010, "Romance"),
      Book("Stine", "Monster Blood", 2009, "Sci-Fi"),
      Book("Johnson", "The art of war", 1932, "History"),
      Book("Poppins", "Friends", 1997, "comedy"),
      Book("Bliton", "Robin Hood", 2010, "comedy")
    )

    def publishedIn(year: Int, books: List[Book]) = {
        books filter (_.year == year)
        //books foreach(i => if (i.year == year) println(i))
    }

    val results = publishedIn(2015, books)
      print(results)

    //titles of books published after 1999
    books foreach (i => if (i.year > 1999) println(i.title))

    //books published from 1996 to 1997
    ((1996 to 1997) flatMap (year => publishedIn(year, books))) foreach (b => println(b.title))

  //counting the number of books whose author names start with a vowel
  val results = books.count(b => (b.authorSurname).toLowerCase.startsWith("a") | (b.authorSurname).toLowerCase.startsWith("e")
  | (b.authorSurname).toLowerCase.startsWith("i") | (b.authorSurname).toLowerCase.startsWith("o") | (b.authorSurname).toLowerCase.startsWith("u"))

  val results2 = books map (x => x.year -> books.count(_.year == x.year))

  val names = (books map (b => b.authorSurname)).foldRight("")((a, b)=>s"$a, $b")

  val vowelNames = books map (b => if((b.authorSurname).toLowerCase.startsWith("a") | (b.authorSurname).toLowerCase.startsWith("e")
    | (b.authorSurname).toLowerCase.startsWith("i") | (b.authorSurname).toLowerCase.startsWith("o") | (b.authorSurname).toLowerCase.startsWith("u")) b.authorSurname else "")

  val resultsVowelNames = vowelNames.foldRight("")((a, b)=>s"$a, $b")

  print(results2)

}
