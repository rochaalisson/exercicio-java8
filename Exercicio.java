package exercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Exercicio {

	public static void main(String[] args) {
		// Considerando a lista abaixo execute as seguintes operações usando as features
		// do Java 8+
		// não utilize: for/while/if

		List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
//		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("1 . imprima todos os itens da lista no console");
		numbers.forEach(System.out::println);

		System.out.println("==================================================");
		System.out.println("2 . imprima os números distintos em ordem crescente");
		numbers.stream()
			.distinct()
			.sorted()
			.forEach(System.out::println);

		System.out.println("==================================================");
		System.out.println("3 . imprima os números impares  e distintos em ordem decrescente");
		numbers.stream()
			.filter(n -> n % 2 == 1)
			.distinct()
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
		;

		System.out.println("==================================================");
		System.out.println("4. imprima a soma dos números ignorando os 3 primeiros");
		System.out.println(
				numbers.stream()
					.skip(3)
					.reduce((acc, cur) -> acc + cur)
					.orElse(0));

		System.out.println("==================================================");
		System.out.println("5. imprima cada número da lista multiplicado por 2");
		numbers.stream()
			.map(n -> n * 2)
			.forEach(System.out::println);

		System.out.println("==================================================");
		System.out.println("6. imprima de forma agrupada os números pares e impares distintos");
		numbers.stream()
			.distinct()
			.collect(Collectors.groupingBy(n -> n % 2))
			.forEach((n, v) -> System.out.println(v));

		System.out.println("==================================================");
		System.out.println(
				"7. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException");
		System.out.println(
				numbers.stream()
					.max(Comparator.naturalOrder())
					.orElseThrow());

		System.out.println("==================================================");
		System.out.println("8. imprima apenas os 3 primeiros números da lista");
		numbers.stream()
			.limit(3)
			.forEach(System.out::println);

		System.out.println("==================================================");
		System.out.println(
				"9. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN");
		System.out.println(
				numbers.stream()
					.mapToInt(n -> n)
					.average()
					.orElse(Double.NaN));

		System.out.println("==================================================");
		System.out.println(
				"10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo");
		System.out.println(numbers.size());
		System.out.println(numbers.stream().reduce((acc, cur) -> acc + cur));
		System.out.println(numbers.stream().mapToInt(n -> n).average());
		System.out.println(numbers.stream().max(Comparator.naturalOrder()));

		System.out.println("==================================================");
		System.out.println(
				"11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente");
		LocalDate hoje = LocalDate.now();
		numbers.forEach(n -> System.out.println(hoje.plusDays(n)));

	}

}
