import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

public class maKhoaRSA {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("Nhap du lieu muon ma hoa va giai ma");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		RSA p = new RSA();
		RSA q = new RSA();
		p.init();
		q.init();
		BigInteger message = new BigInteger(string.getBytes());
		BigInteger cipher = p.encrypt(message, q.getN());
		BigInteger decrypted = q.decrypt(cipher);
		System.out.println("Code ma hoa");
		System.out.println(cipher);
		System.out.println("thong tin giai ma");
		String result = new String(decrypted.toByteArray());
		System.out.println(result);
		scanner.close();

		// BigInteger bigInteger1 = new
		// BigInteger("12345456546546678909876543214534534534");
		// BigInteger bigInteger2 = new BigInteger("214145124546546546345345124123112");
		// BigInteger add = bigInteger1.add(bigInteger2);
		// System.out.println("add :" + add);
		// BigInteger subtract = bigInteger1.subtract(bigInteger2);
		// System.out.println("subtract :" + subtract);
		// BigInteger multiply = bigInteger1.multiply(bigInteger2);
		// System.out.println("multiply :" + multiply);
		// BigInteger divide = bigInteger1.divide(bigInteger2);
		// System.out.println("divide :" + divide);
	}
}
