package java4.book4_1.jang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.ServiceLoader;

public class CaesarCipher implements Cipher {
    @Override
    public byte[] encrypt(byte[] source, byte[] key) {
        byte[] result = new byte[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = (byte) (source[i] + key[0]);
        }
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] source, byte[] key) {
        return encrypt(source, new byte[]{(byte) -key[0]});
    }

    @Override
    public int strength() {
        return 1;
    }

    public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);

    public static Cipher getCipher(int minStrength) {
        for (Cipher cipher : cipherLoader) // 암시적으로 cipherLoader의 iterator를 호출한다.
            if (cipher.strength() >= minStrength)
                return cipher;
        return null;
    }

    public static Optional<Cipher> getCipher2(int minStrength) {
        return cipherLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(c -> c.strength() >= minStrength)
                .findFirst();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Optional<Cipher> cipher = cipherLoader.findFirst();

        Class<?> cl = Class.forName("java4.book4_1.jang3.CaesarCipher");
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName() +
                        Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }


    }
}
