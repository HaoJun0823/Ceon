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
 * @Title: CeonType.java 
 * @Project: Ceon
 * @Package: xyz.haojun0823.ceon 
 * @author: HaoJun0823   
 * @date: Feb 13, 2020 1:31:06 AM 
 * @version: V1.0   
 */
package xyz.haojun0823.ceon;

/**
 * @ClassName: CeonType
 * @Description: Used to determine the type of data.
 * @author: HaoJun0823
 * @date: Feb 13, 2020 1:31:06 AM
 */
public enum CeonType {

	INTEGER('i'), FLOAT('f'), BOOL('b'), OBJECT('o'), STRING('s'), UNKNOWN('u'), INTEGER_ARRAY('i'), FLOAT_ARRAY('f'),
	BOOL_ARRAY('b'), OBJECT_ARRAY('o'), STRING_ARRAY('s');

	private char token;

	CeonType(char c) {
		// TODO Auto-generated constructor stub
		this.token = c;
	}

	public char getToken() {
		return this.token;
	}

	public static CeonType getCeonType(char c) {

		switch (c) {
		case 'i':
			return CeonType.INTEGER;
		case 'f':
			return CeonType.FLOAT;
		case 'b':
			return CeonType.BOOL;
		case 'o':
			return CeonType.OBJECT;
		case 's':
			return CeonType.STRING;
		default:
			return CeonType.UNKNOWN;

		}

	}

	public boolean isBasicType() {

		return this.equals(CeonType.INTEGER) || this.equals(CeonType.FLOAT) || this.equals(CeonType.BOOL)
				|| this.equals(CeonType.STRING);

	}

	public static CeonType convertArray(CeonType original) {

		CeonType type = CeonType.UNKNOWN;

		if (type.equals(CeonType.INTEGER)) {
			type = CeonType.INTEGER_ARRAY;
		} else if (type.equals(CeonType.FLOAT)) {
			type = CeonType.FLOAT_ARRAY;
		} else if (type.equals(CeonType.BOOL_ARRAY)) {
			type = CeonType.BOOL_ARRAY;
		} else if (type.equals(CeonType.OBJECT)) {
			type = CeonType.OBJECT_ARRAY;
		}else if (type.equals(CeonType.STRING)) {
			type = CeonType.STRING_ARRAY;
		}

		return type;
	}

}
