import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
 */
public class DiffieHellman {

    private Random rand;

    public DiffieHellman() {
        try {
            rand = SecureRandom.getInstanceStrong(); // SecureRandom is preferred to Random
        } catch (NoSuchAlgorithmException e) {
            // No processing
        }
    }

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

    private int getRandomNumberInRange(int min, int max) {
        return rand.ints(min + 1, max)
                   .findFirst()
                   .getAsInt();
    }

}
