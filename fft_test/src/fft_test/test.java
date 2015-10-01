package fft_test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Math;
public class test {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("data.csv","UTF-8");
		Complex[] c = new Complex[1024];
		for (int i = 0; i < 512; i++){
			c[i]=new Complex(Math.sin(i)+Math.cos(i*1.432));
		}
		Complex[] d = fft.fft(c);
		for (int i = 0; i < 512; i++){
			writer.print(""+d[i].abs()+",");
		}

	}

}
