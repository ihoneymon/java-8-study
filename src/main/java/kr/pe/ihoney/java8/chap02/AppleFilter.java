package kr.pe.ihoney.java8.chap02;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {

    /**
     * 첫번째 시도: 녹색사과 필터링
     * 
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 두번째 시도: 색을 파라미터로
     * 
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 세번째 시도: 모든 경우를 파라미터로
     * 
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 네번째 시도: 추상적 조건으로 필터링
     * 
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 다섯번째 시도: 익명 클래스 사용
     * 
     * @param inventory
     * @return
     */
    public static List<Apple> filterInnerRedApple(List<Apple> inventory) {
        return filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
    }

    /**
     * 여섯번쨰 시도: 람다 표현식 사용
     * 
     * @param inventory
     * @return
     */
    public static List<Apple> filterRedAppleByLamda(List<Apple> inventory) {
        return filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }

    /**
     * 일곱번째 시도: 리스트 형식으로 추상화
     * 
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterByPredicate(List<Apple> inventory, Predicate<Apple> predicate) {
        return Predicate.filter(inventory, predicate);
    }

}
