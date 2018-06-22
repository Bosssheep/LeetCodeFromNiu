package entity;

/**
 * each node contains an additional random pointer which could point to any node in the list or null.
 *
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }
}
