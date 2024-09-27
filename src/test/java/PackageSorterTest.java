import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.throughtfulai.sorter.DefaultPackageSorter;
import com.throughtfulai.sorter.PackageSorter;

public class PackageSorterTest {
	
	private PackageSorter packageSorter;

	@Before
	public void setUp() throws Exception {
		// Setup to test the default package sorter implementation
		packageSorter = new DefaultPackageSorter();
	}

	@Test
	public void testForStandardClassification() {
		// Blue sky test
		String classification = this.packageSorter.sort(2, 4, 6, 8);
		assertEquals(classification, PackageSorter.STANDARD);
		
		// Limits test
		classification = this.packageSorter.sort(100, 100, 99, 19);
		assertEquals(classification, PackageSorter.STANDARD);
	}
	
	@Test
	public void testForSpecialClassification() {
		// SPECIAL: packages that are either heavy or bulky can't be handled automatically.
		// Should be SPECIAL because of heavy mass (at edge case of 20)
		String classification = this.packageSorter.sort(2, 4, 6, 20);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Same here due to over 20
		classification = this.packageSorter.sort(2, 4, 6, 21);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of volume == 100000
		classification = this.packageSorter.sort(100, 100, 100, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of width == 150
		classification = this.packageSorter.sort(150, 10, 10, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of width > 150
		classification = this.packageSorter.sort(151, 10, 10, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of len == 150
		classification = this.packageSorter.sort(10, 150, 10, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of len > 150
		classification = this.packageSorter.sort(10, 151, 10, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of height == 150
		classification = this.packageSorter.sort(10, 10, 150, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
		
		// Should be SPECIAL because of height > 150
		classification = this.packageSorter.sort(10, 10, 150, 19);
		assertEquals(classification, PackageSorter.SPECIAL);
	}
	
	@Test
	public void testForRejectedClassification() {
		String classification = this.packageSorter.sort(100, 100, 100, 20);
		assertEquals(classification, PackageSorter.REJECTED);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArgs() {
		this.packageSorter.sort(0,0,0,-1);
	}

}
