package kr.pe.ihoney.java8.chap02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppleRedAndHeavyPredicateTest {

    @Test
    public void testRedAndHeavyPredicate() throws Exception {
        // given
        List<Apple> inventory = new ArrayList<>();
        Apple redHeavyApple = new Apple("red", 160);
        Apple greenHeavyApple = new Apple("gree", 170);
        inventory.add(redHeavyApple);
        inventory.add(greenHeavyApple);

        // when
        List<Apple> result = AppleFilter.filterApples(inventory, new AppleRedAndHeavyPredicate());

        // then
        assertThat(result.contains(redHeavyApple), is(true));
        assertThat(result.contains(greenHeavyApple), is(false));
    }

}
