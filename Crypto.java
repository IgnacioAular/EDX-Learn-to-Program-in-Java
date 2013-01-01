
package firstproject;

public class Crypto
{
    public static void main(String[] args)
    {
        System.out.println(encryptString("ILIKEZOOS", 1, 1));
        System.out.println(encryptString("ILIKEAPPLES", -1, 2));
        System.out.println(encryptString("This is some \"really\" great. (Text)!?", 1, 3));
    }

    private static String normalizeText(String text)
    {
        // Removes all the spaces from your text
        text = text.replaceAll("\\s+", "");

        // Remove any punctuation (. , : ; ’ ” ! ? ( ) )
        text = text.replaceAll("\\p{Punct}", "");

        // Turn all lower-case letters into upper-case letters and return the result
        return text.toUpperCase();
    }

    private static String obify(String normalizedText)
    {
        return normalizedText.replaceAll("([AEIOUY])", "OB$1");
    }

    private static String ceasarify(String normalizedText, int key)
    {
        StringBuilder ceasarifiedText = new StringBuilder();

        String shift = shiftAlphabet(key);

        for (int i = 0; i < normalizedText.length(); i++)
            ceasarifiedText.append(shift.charAt((int) normalizedText.charAt(i) - 65));

        return ceasarifiedText.toString();
    }

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

    private static String encryptString(String text, int shift, int groupSize)
    {
        String encryptedString = normalizeText(text);
        encryptedString = obify(encryptedString);
        encryptedString = ceasarify(encryptedString, shift);
        encryptedString = groupify(encryptedString, groupSize);

        return encryptedString;
    }

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
