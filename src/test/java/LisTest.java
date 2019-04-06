

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LisTest {

	int [] seq = new int [] {10, 20, 10, 30, 20, 50};
	
	private Lis lis;
	
	@Before
	public void setUp() {
		lis= new Lis();
	}
	
	@Test
	public void test() {
		
		int result= lis.dp(seq);
		
		assertThat(result, is(4));
	}

}
