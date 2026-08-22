package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  Predicate<Car> yellowCarsOlderThan2000 = car->car.getColor().equalsIgnoreCase("Yellow")
                                                  && car.getYear() > 2000;

  @Test
  public void count() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Long yellowCars = cars.stream()
            .filter(yellowCarsOlderThan2000)
            .collect(Collectors.counting());
    System.out.println(yellowCars);
  }

  @Test
  public void min() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    int minAge = people.stream()
            .mapToInt(Person::getAge)
            .min().getAsInt();
    System.out.println(minAge);

  }

  @Test
  public void max() throws Exception {

  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    double averageCarPrice = cars.stream()
            .mapToDouble(Car::getPrice)
            .average().getAsDouble();

    System.out.println(averageCarPrice);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}