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

    private static void testComplexCopy(Solution solution) {
        CNode n1 = new CNode(1);
        CNode n2 = new CNode(2);
        CNode n3 = new CNode(3);
        CNode n4 = new CNode(4);

        n1.random = n3; n2.random = n1; n3.random = n3;
        n1.next = n2; n2.next = n3; n3.next = n4;

        CNode result = solution.complexCopy(n1);

        System.out.println("成功");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        testComplexCopy(solution);
    }
}
