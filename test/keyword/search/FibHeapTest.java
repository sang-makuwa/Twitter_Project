package keyword.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibHeapTest {

	@Test
	public void testInsertExtract() {
		FibHeap tweetFH = new FibHeap();
		
		Tweet t1 = new Tweet(1, 5);
		Tweet t2 = new Tweet(2, 2);
		Tweet t3 = new Tweet(3, 1);
		Tweet t4 = new Tweet(4, 10);
		Tweet t5 = new Tweet(5, 6);
		Tweet t6 = new Tweet(6, 5);
		Tweet t7 = new Tweet(7, 16);
		Tweet t8 = new Tweet(8, 4);
		Tweet t9 = new Tweet(9, 3);
		Tweet t10 = new Tweet(10, 7);
		
		tweetFH.insertNode(t1);
		tweetFH.insertNode(t2);
		tweetFH.insertNode(t3);
		tweetFH.insertNode(t4);
		tweetFH.insertNode(t5);
		tweetFH.insertNode(t6);
		tweetFH.insertNode(t7);
		tweetFH.insertNode(t8);
		tweetFH.insertNode(t9);
		tweetFH.insertNode(t10);
		

		assertEquals("1", 10, tweetFH.size());
		assertEquals(t7, tweetFH.extractMax());
		
		assertEquals("2",9, tweetFH.size());
		assertEquals(t4, tweetFH.extractMax());
		
		assertEquals("3", 8, tweetFH.size());
		assertEquals(t10, tweetFH.extractMax());
		
		assertEquals("4", 7, tweetFH.size());
		assertEquals(t5, tweetFH.extractMax());
		
		assertEquals("5", 6, tweetFH.size());
		assertEquals(t6, tweetFH.extractMax());
		
		assertEquals("6", t1, tweetFH.extractMax());
		
		assertEquals("7", t8, tweetFH.extractMax());

		assertEquals("8", t9, tweetFH.extractMax());

		assertEquals("9", t2, tweetFH.extractMax());

		assertEquals("10", t3, tweetFH.extractMax());
		
		assertEquals(0, tweetFH.size());
		assertEquals(null, tweetFH.extractMax());
		assertEquals(0, tweetFH.size());
	}

}
