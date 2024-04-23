package 队列和栈.单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _901_股票价格跨度 {
    class StockSpanner {
        public Stack<Integer> stack;
        public Map<Integer, Integer> map;

        public StockSpanner() {
            stack = new Stack<>();
            map = new HashMap<>();
        }

        public int next(int price) {
            int gap = 1;
            //栈空
            if (stack.isEmpty() || price < stack.peek()) {
                map.put(price, gap);
                stack.push(price);
                return gap;
            }

            while (!stack.isEmpty() && price >= stack.peek()) {
                int top = stack.pop();
                gap += map.get(top);
                //map.remove(top);

            }
            map.put(price, gap);
            stack.push(price);
            return gap;
        }
    }
}
