public class Solution {
    public CNode complexCopy(CNode head) {
        if (head == null) {
            return null;
        }
        CNode p1 = head;
        while (p1 != null) {
            CNode p2 = new CNode(p1.val);
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
        }

        p1 = head;
        while (p1 != null) {
            CNode p2 = p1.next;
            if (p1.random != null) {
                p2.random = p1.random.next;
            }

            p1 = p2.next;
        }

        p1 = head;
        CNode newHead = head.next;

        while (p1 != null) {
            CNode p2 = p1.next;

            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }

            p1 = p1.next;
        }

        return newHead;
    }
    
    /**
     * 1. 构建几组测试数据
     * 2. 进行测试
     * 3. 对测试结果进行打印
     * @return
     */
    private static void testComplexListCopy(Solution solution) {
        // 1. 构建测试数据
        CNode head = createComplexList1();
        // 2. 进行测试
        CNode resultHead = solution.copy(head);
        // 3. 对测试结果进行打印
        printCList(resultHead);
    }

    // CNode 必须实现一个 String toString() 方法
    private static void printCList(CNode head) {
        for (CNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur + " --> ");
        }
        System.out.println();
    }
    
    // CNode 必须有一个构造方法，形参是 int val
    // 并且，初始化后，next 和 random 都是 null
    private static CNode createComplexList1() {
        CNode n1 = new CNode(1);
        CNode n2 = new CNode(2);
        CNode n3 = new CNode(3);
        CNode n4 = new CNode(4);

        n1.random = n3; n2.random = n1; n3.random = n3;
        n1.next = n2; n2.next = n3; n3.next = n4;

        return n1;
    }
    
     /**
     * 测试面试题：
     * 1）复杂链表复制
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        testComplexListCopy(solution);
    }
}
