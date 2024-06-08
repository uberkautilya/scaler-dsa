package references.streams_exception_handling.ad_an_act_of_desperation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Sample {
    public static String getNameOfAirport(String iata) throws IOException {
        var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

        try (var scanner = new Scanner(new URL(url).openStream())) {
            var response = scanner.nextLine();

            if (!response.contains("Name")) {
                throw new RuntimeException("Invalid airport code " + iata);
            }

            return response.split("\"")[3];
            //way too lazy to do the real work to get the data
        }
    }


    public static void main(String[] args) {
        List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

//        try {
//            iataCodes.stream()
//                    .map(iataCode -> getNameOfAirport(iataCode))
//                    .forEach(System.out::println);
//        } catch (Exception ex) { //act of desperation
//            System.out.println(ex);
//        }
    }
}

