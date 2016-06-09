package com.example;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Java 9 Streamに追加された3つの新機能 
 * http://qiita.com/k--kato/items/64967d2555f39aace608
 * 
 * Stream
 * java.util.stream.Stream
 * 
 * refs #888 eclipse jee-neon with jdk9 でimportが自動でなされなかったため、手動でimport追加
 * 
 * @author eithi2
 *
 */
public class SampleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleApp app = new SampleApp();
		app.dropWhileExecuteJava9();
		System.out.println();
		app.takeWhileExecuteJava9();
		System.out.println();
		app.ofNullableExecuteJava9();
	}

	/**
	 * JDK9 build b83 では使えるが、
	 * build 9-ea+121,　では使えないようだ。。。
	 * 
	 */
	private void ofNullableExecuteJava9() {
		// arrange
		List<String> list = Arrays.asList("Angular", "ES7", "React");
		@SuppressWarnings("serial")
		Map<String, Integer> map = new HashMap<String, Integer>() {

			{
		        put("Angular", 1);
		        put("ES2016", 2);
		        put("React", 3);
		    }
		};

		// act
		list.stream().flatMap(str -> Stream.ofNullable(map.get(str))).forEach(System.out::println);
		// 1
		// 3
		
		//java.util.stream.Stream
	}

	private void ofNullableExecuteJava8() {
		// arrange
		List<String> list = Arrays.asList("Angular", "ES7", "React");
		@SuppressWarnings("serial")
		Map<String, Integer> map = new HashMap<String, Integer>() {
		    {
		        put("Angular", 1);
		        put("ES2016", 2);
		        put("React", 3);
		    }
		};

		// act
		list.stream().flatMap(str -> {
		    Integer temp = map.get(str);
		    return (temp != null) ? Stream.of(temp) : Stream.empty();
		}).forEach(System.out::println);
		// 1
		// 3
	}

	/**
	 * Project Jigsaw Java 9 Stream 新機能 takeWhile Java 9 では，対象にしたいデータの条件を
	 * takeWhile に設定するだけで，必要なデータを簡単に処理できるようになりました
	 */
	private void takeWhileExecuteJava9() {
		// arrange
		List<Integer> list = Arrays.asList(0, 1, 2, -1, 2);

		// act
		list.stream().takeWhile(x -> x <= 1).forEach(System.out::println);
		// 0
		// 1
	}

	private void takeWhileExecuteJava8() {
		// arrange
		List<Integer> list = Arrays.asList(0, 1, 2, -1, 2);

		// act
		for (Integer x : list) {
			if (x <= 1)
				System.out.println(x);
			else
				break;
		}
		// 0
		// 1
	}

	/**
	 * Project Jigsaw Java 9 Stream 新機能 dropWhile 対象外にしたいデータの条件を dropWhile
	 * に設定するだけで，対象外にしたいデータを簡単にスキップすることができるようになりました
	 */
	private void dropWhileExecuteJava9() {
		// TODO Auto-generated method stub
		// arrange
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);

		// act
		list.stream().dropWhile(x -> x <= 2).forEach(System.out::println);
		// 2
		// -1
		// 2
	}

	private void dropWhileExecuteJava8() {
		// TODO Auto-generated method stub
		// arrange
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);// Arrays.asList(0, 1,
															// 2, -1, 2);

		// act
		Predicate<Integer> p = (x) -> x <= 2;

		boolean isDirty = false;
		for (Integer x : list) {
			if (!isDirty && p.negate().test(x))
				isDirty = true;
			if (isDirty)
				System.out.println(x);
		}
		// 2
		// -1
		// 2

		long skipIndex = list.indexOf(list.stream().filter(p.negate()).findFirst().get());
		list.stream().skip(skipIndex).forEach(System.out::println);
		// 2
		// -1
		// 2
	}

}
