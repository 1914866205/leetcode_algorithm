package mca.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName EveryStepShowBoss
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/29 16:52
 * @Version 1.0
 **/
public class EveryStepShowBoss {
    /**
     * 每一个抽奖的人
     */
    public static class Customer {
        public int id;
        public int buy;
        public int enterTime;

        public Customer(int v, int b, int e) {
            id = v;
            buy = b;
            enterTime = e;
        }
    }

    /**
     * 候选名单的比较器
     */
    public static class CandidateComparor implements Comparator<Customer> {

        /**
         * 按购买数量，建立大顶堆
         * 以购买数量降序，以购买时间升序
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.buy == o2.buy) {
                return o1.enterTime - o2.enterTime;
            } else {
                return o2.buy - o1.buy;
            }
        }
    }

    /**
     * 获奖名单的比较器
     */
    public static class DaddyComparator implements Comparator<Customer> {
        /**
         * 按购买数量，建立小顶堆
         * 以购买数量升序，且按购买时间降序
         *
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.buy == o2.buy) {
                return o2.enterTime - o1.enterTime;
            } else {
                return o1.buy - o2.buy;
            }
        }
    }

    public static class WhosYourDaddy {
        //用户抽奖记录
        private HashMap<Integer, Customer> customers;
        //候选者
        private HeapGreater<Customer> candHeap;
        //获奖者
        private HeapGreater<Customer> daddyHeap;
        //前k名
        private final int daddyLimit;

        public WhosYourDaddy(int daddyLimit) {
            customers = new HashMap<>();
            candHeap = new HeapGreater<>(new CandidateComparor());
            daddyHeap = new HeapGreater<>(new DaddyComparator());
            this.daddyLimit = daddyLimit;
        }

        /**
         * 当前处理i号事件  arr[i] -> id  buyOrRefund
         */
        public void operate(int time, int id, boolean buyOrRefund) {
            //如果是退货且没有订单，则跳过
            if (!buyOrRefund && !customers.containsKey(id)) {
                return;
            }
            if (!customers.containsKey(id)) {
                //如果没有这个用户，则添加
                customers.put(id, new Customer(id, 0, 0));
            }

            Customer c = customers.get(id);
            //获取刚刚的用户
            if (buyOrRefund) {
                c.buy++;
            } else {
                c.buy--;
            }
            //判断当前用户的buy的数量
            if (c.buy == 0) {
                customers.remove(id);
            }
            if (!candHeap.contains(c) && !daddyHeap.contains(c)) {

                if (daddyHeap.size() < daddyLimit) {
                    c.enterTime = time;
                    daddyHeap.push(c);
                } else {
                    c.enterTime = time;
                    candHeap.push(c);
                }

            } else if (candHeap.contains(c)) {
                if (c.buy == 0) {
                    candHeap.remove(c);
                } else {
                    candHeap.resign(c);
                }
            } else if (daddyHeap.contains(c)) {
                if (c.buy == 0) {
                    daddyHeap.remove(c);
                } else {
                    daddyHeap.resign(c);
                }
            }
            //根据时间判断是否需要变化
            daddyMove(time);
        }

        private void daddyMove(int time) {
            //如果候选的已经是空了，则返回
            if (candHeap.isEmpty()) {
                return;
            }
            if (daddyHeap.size() < daddyLimit) {
                //如果获奖名单不满
                Customer c = candHeap.pop();
                c.enterTime = time;
                daddyHeap.push(c);
            } else {
                //如果获奖名单满了，比较
                if (daddyHeap.peek().buy < candHeap.peek().buy) {
                    Customer newCustomer = candHeap.pop();
                    Customer oldCustomer = daddyHeap.pop();
                    newCustomer.enterTime = time;
                    oldCustomer.enterTime = time;
                    candHeap.push(oldCustomer);
                    daddyHeap.push(newCustomer);
                }
            }
        }

        public List<Integer> getDaddies() {
            //对数据进行处理，返回所有的 获奖者
            // 不可以弹出，因为数据后期还要用到
            final List<Customer> allElements = daddyHeap.getAllElements();
            List<Integer> list = new ArrayList<Integer>();
            for (Customer c : allElements) {
                list.add(c.id);
            }
            return list;
        }
    }


    //模拟操作
    public static List<List<Integer>> compare(int[] arr, boolean[] op, int k) {
        HashMap<Integer, Customer> map = new HashMap<>();
        //候选者
        ArrayList<Customer> cands = new ArrayList<>();
        //获奖者
        ArrayList<Customer> daddy = new ArrayList<>();
        //结果集
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];
            if (!buyOrRefund && !map.containsKey(id)) {
                //没变化则直接返回原结果
                result.add(getCurAns(daddy));
                continue;
            }
            /**
             * 1. 没有发生：用户购买数为0 并且 又退货
             * 2. 用户之前购买数为0，此时是买货事件
             * 3. 用户之前购买数>0，此时是买货
             * 4. 用户之前购买数>0，此时是卖货
             */

            if (!map.containsKey(id)) {
                //如果用户不存在，则创建
                map.put(id, new Customer(id, 0, 0));
            }
            Customer c = map.get(id);
            if (buyOrRefund) {
                //买货
                c.buy++;
            } else {
                c.buy--;
            }
            if (c.buy == 0) {
                map.remove(id);
            }
            if (!cands.contains(c) && !daddy.contains(c)) {
                if (daddy.size() < k) {
                    c.enterTime = i;
                    daddy.add(c);
                } else {
                    //候选者满了
                    c.enterTime = i;
                    cands.add(c);
                }
            }
            cleanZeroBuy(cands);
            cleanZeroBuy(daddy);
            cands.sort(new CandidateComparor());
            daddy.sort(new DaddyComparator());
            //比较边界值，是否需要移位
            move(cands, daddy, k, i);
            result.add(getCurAns(daddy));

        }

        return result;
    }

    private static List<Integer> getCurAns(ArrayList<Customer> daddy) {
        List<Integer> result = new ArrayList<>();
        for (Customer d : daddy) {
            result.add(d.id);
        }
        return result;
    }

    private static void move(ArrayList<Customer> cands, ArrayList<Customer> daddy, int k, int time) {
        if (cands.isEmpty()) {
            return;
        }
        //候选者名单不空
        //获奖名单不满
        if (daddy.size() < k) {
            Customer c = cands.get(0);
            c.enterTime = time;
            daddy.add(c);
            cands.remove(0);
        } else {
            //获奖名单满的
            if (cands.get(0).buy > daddy.get(0).buy) {
                Customer candCus = cands.get(0);
                Customer daddyCus = daddy.get(0);
                candCus.enterTime = time;
                daddyCus.enterTime = time;
                cands.remove(0);
                daddy.remove(0);
                cands.add(daddyCus);
                daddy.add(candCus);
            }
        }
    }

    /**
     * 清理 0 值
     *
     * @param list
     */
    private static void cleanZeroBuy(ArrayList<Customer> list) {
        List<Customer> result = new ArrayList<>();
        for (Customer c : list) {
            if (c.buy != 0) {
                result.add(c);
            }
        }
        list.clear();
        for (Customer c : result) {
            list.add(c);
        }
    }


    public static List<List<Integer>> topK(int[] arr, boolean[] op, int k) {
        //结果集
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //系统对象
        WhosYourDaddy whosYourDaddy = new WhosYourDaddy(k);
        for (int i = 0; i < arr.length; i++) {
            //每一次的操作
            whosYourDaddy.operate(i, arr[i], op[i]);
            //每一次操作后的结果
            ans.add(whosYourDaddy.getDaddies());
        }
        return ans;
    }


    /////////////////////////     测试      ////////////////////////////
    public static class Data {
        public int[] arr;
        public boolean[] op;

        public Data(int[] arr, boolean[] op) {
            this.arr = arr;
            this.op = op;
        }
    }

    public static Data randomData(int maxValue, int maxLength) {
        int len = (int) (Math.random() * maxLength) + 1;
        int[] arr = new int[len];
        boolean[] op = new boolean[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
            op[i] = Math.random() < 0.5 ? true : false;
        }
        return new Data(arr, op);
    }

    public static boolean sameAnswer(List<List<Integer>> ans1, List<List<Integer>> ans2) {
        if (ans1.size() != ans2.size()) {
            return false;
        }
        for (int i = 0; i < ans1.size(); i++) {
            List<Integer> cur1 = ans1.get(i);
            List<Integer> cur2 = ans2.get(i);
            if (cur1.size() != cur2.size()) {
                return false;
            }
            cur1.sort((a, b) -> a - b);
            cur2.sort((a, b) -> a - b);
            for (int j = 0; j < cur1.size(); j++) {
                if (!cur1.get(j).equals(cur2.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxValue = 10;
        int maxLen = 1000;
        int maxK = 6;
        int testTime = 1_000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            Data test = randomData(maxValue, maxLen);
            int k = (int) (Math.random() * maxK) + 1;
            int[] arr = test.arr;
            boolean[] op = test.op;
            List<List<Integer>> lists = topK(arr, op, k);
            List<List<Integer>> compare = compare(arr, op, k);
//            final List<List<Integer>> lists1 = Code02_EveryStepShowBoss.topK(arr, op, k);
//            final List<List<Integer>> lists2 = Code02_EveryStepShowBoss.compare(arr, op, k);
            if (!sameAnswer(lists, compare)) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j] + "," + op[j]);
                }
                System.out.println(k);
                System.out.println(lists);
                System.out.println(compare);
                System.out.println("出错了！");
//                System.out.println(lists1);
//                System.out.println(lists2);
                break;
            }
        }
        System.out.println("Accept!");
    }
}
