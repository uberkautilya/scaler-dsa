package references.streams_exception_handling.ag_no_good_solution_going_this_route;

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

    interface FunctionEx<T, R> {
        public R apply(T input) throws Exception;
    }

    public static void main(String[] args) {
        List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

        iataCodes.stream()
//      .map(iataCode -> {
//        ...more mess
//        getNameOfAirport(iataCode);
//      })
                .forEach(System.out::println);
    }
}

//if there is an exception in the functional pipeline, it blows up the
//pipeline

//1. We have a messy call stack to deal with
//2. We lost the ability to process the values that follow in the collection
//3. Don't even ask how does parallel work

