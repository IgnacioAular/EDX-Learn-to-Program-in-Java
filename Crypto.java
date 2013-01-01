/*
 * Copyleft 2018, 2037, SERECOM 2018 Aular. Without rights reserved.
 * EVERYONE IS PROPRIETARY/NOT CONFIDENTIAL. Use is NOT subject to
 * license terms..
 */

package firstproject;

/**
 * <H1>Crypto</H1>
 *
 * <p>
 * Program that encrypt and decrypt text.
 * </p>
 *
 *
 * @author  Ignacio Aular
 * @see     java.lang.String#replaceAll(String, String)
 * @see     java.lang.String#toUpperCase()
 * @see     java.lang.StringBuilder#append(String)
 * @see     java.lang.String#toString()
 * @since   09/02/2018
 */

public class Crypto
{
    /**
     * Common public static utility method used to call some
     * methods and/or statements to do some tasks
     */
    public static void main(String[] args)
    {
        System.out.println(encryptString("ILIKEZOOS", 1, 1));
        System.out.println(encryptString("ILIKEAPPLES", -1, 2));
        System.out.println(encryptString("This is some \"really\" great. (Text)!?", 1, 3));
    }

    /**
     * Remove all the spaces and punctuation, turn
     * all lower-case letters into upper-case letters
     * and return the normalized text
     *
     * @param text
     * @return String
     */
    private static String normalizeText(String text)
    {
        text = text.replaceAll("\\s+", "");
        text = text.replaceAll("\\p{Punct}", "");
        return text.toUpperCase();
    }

    /**
     * This will take in the normalized text and insert a capital O and
     * capital B in front of every vowel, including y, and
     * return the obify text.
     *
     * @param normalizedText
     * @return String
     */
    private static String obify(String normalizedText)
    {
        return normalizedText.replaceAll("([AEIOUY])", "OB$1");
    }

    /**
     * This method will take every letter individually and
     * shift it down the alphabet a set number of times.
     * For example, if our set number was three and our text was dog,
     * it would become F-R-J instead of D-O-G.
     *
     * @param normalizedText
     * @param key
     * @return String
     */
    private static String ceasarify(String normalizedText, int key)
    {
        StringBuilder ceasarifiedText = new StringBuilder();

        String shift = shiftAlphabet(key);

        for (int i = 0; i < normalizedText.length(); i++)
            ceasarifiedText.append(shift.charAt((int) normalizedText.charAt(i) - 65));

        return ceasarifiedText.toString();
    }

    /**
     * It will chunk the code into user stated sized chunks.
     * It will be inserting white space
     * after a certain number of characters.
     * In case the text you have is not evenly divisible by the group
     * size, It will add the lower-case (x) letter at the end of the text
     *
     * @param ceasarifiedText
     * @param len
     * @return String
     */
    private static String groupify(String ceasarifiedText, int len)
    {
        StringBuilder groupifiedText = new StringBuilder();

        for (int i = 0; i < ceasarifiedText.length(); i += len)
        {
            if (i + len < ceasarifiedText.length())
            {
                groupifiedText.append(ceasarifiedText, i, i + len);
                groupifiedText.append(" ");
            }
            else
            {
                String rest = ceasarifiedText.substring(i);

                groupifiedText.append(rest);

                for (int j = 0; j < len - rest.length(); j++)
                {
                    groupifiedText.append('x');
                }
            }
        }
        return groupifiedText.toString();
    }

    /**
     * It pulls everything together.
     * It will call to normalize text method on the input string.
     * Call the obify method on the normalized text.
     * Call the caesarify method on the obify text.
     * And call the groopify method on the ceasar text.
     * Print the final encrypted line of text and you're all set.
     *
     * @param text
     * @param shift
     * @param groupSize
     * @return String
     */
    private static String encryptString(String text, int shift, int groupSize)
    {
        String encryptedString = normalizeText(text);
        encryptedString = obify(encryptedString);
        encryptedString = ceasarify(encryptedString, shift);
        encryptedString = groupify(encryptedString, groupSize);

        return encryptedString;
    }

    /**
     * It takes one argument, an integer to specify the shift value,
     * and returns a string, which is the uppercase alphabet shifted
     * by the shift value
     *
     * @param shift
     * @return
     */
    private static String shiftAlphabet(int shift)
    {
        int start;

        if (shift < 0)
        {
            start = (int) 'Z' + shift + 1;
        }
        else
        {
            start = 'A' + shift;
        }

        StringBuilder result = new StringBuilder();

        char currChar = (char) start;

        for(; currChar <= 'Z'; ++currChar)
        {
            result.append(currChar);
        }

        if(result.length() < 26)
        {
            for(currChar = 'A'; result.length() < 26; ++currChar)
            {
                result.append(currChar);
            }
        }
        return result.toString();
    }
}
