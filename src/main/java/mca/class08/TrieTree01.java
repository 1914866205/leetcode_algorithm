package mca.class08;

import java.util.HashMap;

/**
 * @ClassName TrieTree01
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/2 11:50
 * @Version 1.0
 **/
public class TrieTree01 {
    //前缀树节点类型
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            /**
             * 1. 把一个word转成字符数组
             * 2. 每个结点有两个属性：经过本节点几次，当前结点是结束点
             *
             * 每次添加元素，从根结点开始找，如果存在下一个结点。就路程++，如果是end，就end++;
             */

            char[] chs = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                //从左往右找
                //本字符应该走的路径
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            //一个字符遍历完
            node.end++;
        }


        // 查看本单词出现多少次
        public int search(String word) {
            if (word == null || word.length() < 1) {
                return 0;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            Node1 node = root;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                node = node.nexts[index];
                if (node == null) {
                    return 0;
                }
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                int index = 0;
                Node1 node = root;
                node.pass--;
                for (int i = 0; i < chars.length - 1; i++) {
                    index = chars[i] - 'a';
                    node = node.nexts[index];
                    node.pass--;
                }
                //此时到了最后一个结点的前一个结点
                if (node.nexts[chars[chars.length - 1] - 'a'].pass == 1) {
                    //如果是最后一个，就直接删了
                    node.nexts[chars[chars.length - 1] - 'a'] = null;
                } else {
                    //否则就改路径
                    node = node.nexts[chars[chars.length - 1] - 'a'];
                    node.pass--;
                    node.end--;
                }
            }
        }

        //所有加入的字符串中，有多少是以pre开头的字符
        public int prefixNumber(String pre) {
            if (pre == null || pre.length() < 1) {
                return 0;
            }
            Node1 node = root;
            int index = 0;
            final char[] chars = pre.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                node = node.nexts[index];
                if (node == null) {
                    return 0;
                }
            }
            return node.pass;
        }
    }


    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            int index = 0;
            final char[] chars = word.toCharArray();
            Node2 node = root;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null || word.length() < 1) {
                return 0;
            }
            Node2 node = root;
            int index = 0;
            final char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts.containsKey(index)) {
                    node = node.nexts.get(index);
                } else {
                    return 0;
                }
            }
            return node.pass;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                Node2 node = root;
                int index = 0;
                final char[] chars = word.toCharArray();
                node.pass--;
                for (int i = 0; i < chars.length - 1; i++) {
                    index = chars[i] - 'a';
                    node = node.nexts.get(index);
                    node.pass--;
                }

                if (node.nexts.get(chars[chars.length - 1] - 'a').pass == 1) {
                    node.nexts.remove(chars[chars.length - 1] - 'a');
                } else {
                    node = node.nexts.get(chars[chars.length - 1] - 'a');
                    node.pass--;
                    node.end--;
                }
            }


        }

        // 所有加入的字符串中，有几个是以pre开头的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            Node2 node = root;
            int index = 0;
            final char[] chars = pre.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }

    }


    public static class Right {
        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (box.containsKey(word)) {
                return box.get(word);
            } else {
                return 0;
            }
        }
        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count++;
                }
            }
            return count;
        }
    }



    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            Code01_TrieTree.Trie1 trie1 = new Code01_TrieTree.Trie1();
            Code01_TrieTree.Trie2 trie2 = new Code01_TrieTree.Trie2();
            Code01_TrieTree.Right right = new Code01_TrieTree.Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans2 = trie2.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixNumber(arr[j]);
                    int ans2 = trie2.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}
