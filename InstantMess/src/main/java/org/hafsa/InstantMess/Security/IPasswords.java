package org.hafsa.InstantMess.Security;


public interface IPasswords {

    /**
     * Generates a random salt.
     *
     * @return a byte array with a 64 byte length salt.
     */
    String getSalt64();

    /**
     * Generates a random salt
     *
     * @return a byte array with a 32 byte length salt.
     */
    String getSalt32();

    /**
     * Generates a new salt, minimum must be 32 bytes long, 64 bytes even better.
     *
     * @param size the size of the salt
     * @return a random salt.
     */
    String getSalt(final int size);

    /**
     * Generates a new hashed password
     *
     * @param password to be hashed
     * @param salt the randomly generated salt
     * @return a hashed password
     */
    byte[] hash(final String password, final String salt);

    /**
     * Expected password
     *
     * @param password to be verified
     * @param salt the generated salt (coming from database)
     * @param hash the generated hash (coming from database)
     * @return true if password matches, false otherwise
     */
    boolean isExpectedPassword(final String password, final String salt, final byte[] hash);

    /**
     * Generates a random password
     *
     * @param length desired password length
     * @return a random password
     */
    String generateRandomPassword(final int length);
}