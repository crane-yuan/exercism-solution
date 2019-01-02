import java.math.BigInteger;
import java.util.Random;

/**
 * https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
 */
public class DiffieHellman {

    public BigInteger privateKey(BigInteger prime) {
        return BigInteger.valueOf(getRandomNumberInRange(1, prime.intValue()));
    }

    public BigInteger publicKey(BigInteger primeP, BigInteger primeG, BigInteger privateKey) {
        return primeG.pow(privateKey.intValue())
                     .mod(primeP);
    }

    public BigInteger secret(BigInteger primeP, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.pow(privateKey.intValue())
                        .mod(primeP);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min + 1, max)
                .findFirst()
                .getAsInt();
    }

}
