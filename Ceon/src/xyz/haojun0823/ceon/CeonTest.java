/**   
 * MIT License
 * 
 * Copyright (c) 2020 HaoJun Yang
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * 
 * @Title: CeonTest.java 
 * @Project: Ceon
 * @Package: xyz.haojun0823.ceon 
 * @author: HaoJun0823   
 * @date: Feb 13, 2020 6:00:44 AM 
 * @version: V1.0   
 */
package xyz.haojun0823.ceon;

import java.util.Arrays;

/** 
 * @ClassName: CeonTest 
 * @Description: Test class.
 * @author: HaoJun0823
 * @date: Feb 13, 2020 6:00:44 AM  
 */
public class CeonTest {

	public static void main(String[] args) throws CeonParseException {
		
		CeonObject data = new CeonObject();
		
		data.put("username", "admin");
		data.put("password", "12345678");
		CeonObject right = new CeonObject();	
		CeonObject left = new CeonObject();
		left.put("id", 0);
		left.put("x_data", "ajipu940rj10jr");
		right.put("id", 0);
		right.put("message", "abc");
		right.put("data", new Double[] {0.2,1.4,0.12983});
		CeonObject test = new CeonObject();
		test.put("test1", 213912);
		test.put("test2", new Double[]{209.2,1859.4,20391.2});
		test.put("test3", new CeonObject());
		right.put("testObject", test);
		data.put("X_OBJ", new CeonObject[]{right,left});
		
		
		CeonObject childData = new CeonObject();
		childData.put("id", 192388);
		childData.put("isMale", true);
		childData.put("country", "China");
		childData.put("age", 28);
		childData.put("x_data", 238128.239128309);
		childData.put("arr",new Integer[]{1,2,3,4,5,6,7});
		data.put("data", childData);
		CeonObject childData2 = new CeonObject();
		childData2.put("Message", "Hello,World!");
		childData.put("other", childData2);
		
		
		System.out.println(data.toString());
		
		System.out.println(Arrays.toString(CeonParser.parseArray(CeonType.STRING_ARRAY, "[\'test\',\'\\\'test\\\'\']")));
		//System.out.println(CeonObject.convert(data.toString()));
	}
	
}
