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
 * @Title: CeonData.java 
 * @Project: Ceon
 * @Package: xyz.haojun0823.ceon 
 * @author: HaoJun0823   
 * @date: Feb 13, 2020 1:30:52 AM 
 * @version: V1.0   
 */
package xyz.haojun0823.ceon;

import java.io.Serializable;

/**
 * @ClassName: CeonData
 * @Description: Used to store data.
 * @author: HaoJun0823
 * @date: Feb 13, 2020 1:30:52 AM
 */
public class CeonData implements Serializable {

	private static final long serialVersionUID = 7395216031479076505L;
	
	private Object data;

	public CeonData(CeonObject data) {

		this.data = data;

	}

	public CeonData(Boolean data) {

		this.data = data;

	}

	public CeonData(Double data) {

		this.data = data;

	}

	public CeonData(Long data) {

		this.data = data;

	}

	public CeonData(String data) {

		this.data = data;

	}

	public CeonData(CeonObject[] data) {

		this.data = data;

	}

	public CeonData(Boolean[] data) {

		this.data = data;

	}

	public CeonData(Double[] data) {

		this.data = data;

	}

	public CeonData(Long[] data) {

		this.data = data;

	}

	public CeonData(String[] data) {

		this.data = data;

	}

	public boolean isArray() {

		return this.data.getClass().isArray();

	}

	public CeonType getType() {

		if (this.data instanceof Long) {
			return CeonType.INTEGER;
		} else if (this.data instanceof Double) {
			return CeonType.FLOAT;
		} else if (this.data instanceof String) {
			return CeonType.STRING;
		} else if (this.data instanceof Boolean) {
			return CeonType.BOOL;
		} else if (this.data instanceof CeonObject) {
			return CeonType.OBJECT;
		}
		if (this.data instanceof Long[]) {
			return CeonType.INTEGER_ARRAY;
		} else if (this.data instanceof Double[]) {
			return CeonType.FLOAT_ARRAY;
		} else if (this.data instanceof String[]) {
			return CeonType.STRING_ARRAY;
		} else if (this.data instanceof Boolean[]) {
			return CeonType.BOOL_ARRAY;
		} else if (this.data instanceof CeonObject[]) {
			return CeonType.OBJECT_ARRAY;
		}

		else {
			return CeonType.UNKNOWN;
		}
	}

	public Object get() {
		return this.data;
	}

}