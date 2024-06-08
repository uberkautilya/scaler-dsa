package references.streams_exception_handling.ai_dealing_with_it;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Sample {
    public static String getNameOfAirport(String iata) throws IOException {
    var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

    try(var scanner = new Scanner(new URL(url).openStream())) {
      var response = scanner.nextLine();

      if(!response.contains("Name")) {
	throw new RuntimeException("Invalid airport code " + iata);
      }

      return response.split("\"")[3];
      //way too lazy to do the real work to get the data
    }
  }
	
  public static void main(String[] args) {
    List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

    iataCodes.stream()
      .map(iataCode -> Try.of(() -> getNameOfAirport(iataCode)))
      .map(nameTry -> nameTry.map(String::toUpperCase))
      .map(nameTry -> switch(nameTry) {
        case Success<String> success -> success.getResult();
	case Failure<String> err -> "Error: " + err.getError().getMessage();
      })
      .forEach(System.out::println);
  }
}
