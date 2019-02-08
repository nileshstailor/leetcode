import javax.sound.midi.SysexMessage;
import java.util.List;

public class AddTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */

    public static void main(String[] args) {
        AddTwoNumbers.testAddTwoNumbers(342, 465);
    }


    public static void testAddTwoNumbers(int d1, int d2) {

        String num1 = Integer.toString(d1);
        String num2 = Integer.toString(d2);

        ListNode ln1 = null;
        for (int i = 0; i < num1.length(); i++) {
            int val = Character.getNumericValue(num1.charAt(i));
            ListNode temp = new ListNode(val);
            temp.next = ln1;
            ln1 = temp;
        }

        ListNode ln2 = null;
        for (int i = 0; i < num2.length(); i++) {
            int val = Character.getNumericValue(num2.charAt(i));
            ListNode temp = new ListNode(val);
            temp.next = ln2;
            ln2 = temp;
        }

        ListNode sum = addTwoNumbers(ln1, ln2);
        do {
            System.out.print(sum.val);
            sum = sum.next;
        } while (sum != null);
    }

    //4 + 6 = 10
    //sum - 9 = carry


    // sum = l1.val + l2.val
    // carry = sum - 9


    // add(LLNode l1, LLNode l2)
    // sum = l1.digit + l2.digit;
    // if (sum > 9) carry = sum - 9;
    //


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry = 0;
        int counter = 0;


        ListNode returnVal = null;
        do {
            int l1_digit = 0, l2_digit = 0;
            if (l1 != null) {
                l1_digit = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2_digit = l2.val;
                l2 = l2.next;
            }



            int sum_of_digits = l1_digit + l2_digit + carry;

            carry = sum_of_digits / 10;

            int sum = (sum_of_digits % 10);

            ListNode current = new ListNode(sum);

            // add elements in reverse order
            if (returnVal == null ) {
                returnVal = current;
            } else {
                // use pass by reference for advantage
                ListNode temp = returnVal;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = current;
            }

        } while (l1 != null || l2 != null || carry == 1);


        return returnVal;
    }



    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int digit) {
            val = digit;
        }
    }

}


