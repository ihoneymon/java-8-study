package kr.pe.ihoney.java8.chap02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class FilterByPredicateTest {

    @Test
    public void testFilterByPredicate_red필터링() throws Exception {
        // given
        List<Apple> inventory = new ArrayList<>();
        Apple redHeavyApple = new Apple("red", 160);
        Apple greenHeavyApple = new Apple("green", 170);
        inventory.add(redHeavyApple);
        inventory.add(greenHeavyApple);

        // when
        List<Apple> result = AppleFilter.filterByPredicate(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        // then
        assertThat(result.contains(redHeavyApple), is(true));
        assertThat(result.contains(greenHeavyApple), is(false));
    }

    @Test
    public void testFilterByPredicate_무게160이상필터링() throws Exception {
        // given
        List<Apple> inventory = new ArrayList<>();
        Apple redHeavyApple = new Apple("red", 160);
        Apple greenHeavyApple = new Apple("green", 170);
        inventory.add(redHeavyApple);
        inventory.add(greenHeavyApple);

        // when
        List<Apple> result = AppleFilter.filterByPredicate(inventory, (Apple apple) -> apple.getWeight() > 160);

        // then
        assertThat(result.contains(greenHeavyApple), is(true));
        assertThat(result.contains(redHeavyApple), is(false));

        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    @Test
    public void testRunnable블록실행하기() throws Exception {
        // 기본타입
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        }).run();

        // 람다 표현식
        new Thread(() -> System.out.println("Hello world")).run();
    }

}
