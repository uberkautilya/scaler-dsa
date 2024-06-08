package references.streams_exception_handling.al_exceptions_in_reactive_streams;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;

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
        var iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

        Flowable.fromIterable(iataCodes)
                .map(Sample::getNameOfAirport)
                .map(String::toUpperCase)
                .subscribe(
                        System.out::println, //Data channel
                        error -> System.out.println("ERROR: " + error), //error channel
                        () -> System.out.println("DONE")
                );
    }
}

/*
Stream                        CompletableFuture      Reactive Stream
0, 1, or more pieces of data  0 or 1                 0, 1, or more

Stream                       Reactive Stream
pipeline of functions        pipeline of functions
lazy evaluation              lazy evaluation

How do handle exceptions?
Good luck                    Treat error as data

One channel of data          3 channels
                             -----> data channel
                             -----> error channel
                             -----> complete channel

			     data flows through the data channel
			     if no more data, a signal may flow through
			       the complete channel and the data channel
			       is closed.

                             if there is an error, an error flows through
			       the error channel and the data channel
			       is closed.


map, filter, etc. can't call           The map, filter, etc. can have lambdas that may throw checked exception
lambdas that have checked exception
*/
